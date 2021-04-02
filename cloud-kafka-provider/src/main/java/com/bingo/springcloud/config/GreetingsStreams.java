package com.bingo.springcloud.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author:yaobin
 * @date:2021/3/23,23:35
 */

public interface GreetingsStreams {
    String INPUT = "greetings-in";
    String OUTPUT = "greetings-out";
    @Input(INPUT)
    SubscribableChannel inboundGreetings();
    @Output(OUTPUT)
    MessageChannel outboundGreetings();
}
