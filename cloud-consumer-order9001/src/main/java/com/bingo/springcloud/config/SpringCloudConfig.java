package com.bingo.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author:yaobin
 * @date:2021/3/9,11:56
 */

@Configuration
public class SpringCloudConfig {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
