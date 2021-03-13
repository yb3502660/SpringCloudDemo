package com.bingo.springcloud;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author:yaobin
 * @date:2021/3/14,0:20
 */

@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerOrderMain11111 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderMain11111.class, args);
                
    }
}
