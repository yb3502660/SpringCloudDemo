package com.bingo.springcloud.listener;

import com.bingo.springcloud.config.GreetingsStreams;
import com.bingo.springcloud.entities.kafka.Greetings;
import com.bingo.springcloud.service.GreetingsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @author:yaobin
 * @date:2021/3/24,0:04
 */

@Component
@Slf4j
public class GreetingsListener {
    @StreamListener(GreetingsStreams.INPUT)
    public void handleGreetings(@Payload Greetings greetings){
        log.info("Receive greetings {}",greetings);
    }
}
