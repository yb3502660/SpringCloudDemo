package com.bingo.springcloud.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;

/**
 * @author:yaobin
 * @date:2021/3/23,23:39
 */

@EnableBinding(GreetingsStreams.class)
//@EnableBinding(Source.class)
public class StreamConfig {
}
