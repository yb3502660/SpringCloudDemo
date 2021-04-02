package com.bingo.springcloud.service;

import com.bingo.springcloud.config.GreetingsStreams;
import com.bingo.springcloud.entities.kafka.Greetings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

/**
 * @author:yaobin
 * @date:2021/3/23,23:47
 */

@Service
@Slf4j
public class GreetingsService {
    
    private final GreetingsStreams greetingsStreams;
    
    public GreetingsService(GreetingsStreams greetingsStreams) {
        this.greetingsStreams = greetingsStreams;
    }
    
    public void sendGreetings(final Greetings greetings){
        log.info("Sending greetings {}",greetings);
        MessageChannel messageChannel = greetingsStreams.outboundGreetings();
        messageChannel
                .send(MessageBuilder.withPayload(greetings)
                        .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                        .build());
    }
}
