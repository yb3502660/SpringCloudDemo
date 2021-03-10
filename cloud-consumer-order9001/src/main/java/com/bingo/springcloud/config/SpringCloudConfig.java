package com.bingo.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
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
    @LoadBalanced //服务集群部署时,需要负载均衡,否则会找不到目的主机
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
