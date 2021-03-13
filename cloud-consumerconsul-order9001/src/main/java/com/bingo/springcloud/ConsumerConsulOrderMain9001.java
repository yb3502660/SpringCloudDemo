package com.bingo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author:yaobin
 * @date:2021/3/14,1:38
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerConsulOrderMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerConsulOrderMain9001.class, args); 
    }
}
