package com.bingo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author:yaobin
 * @date:2021/3/23,23:13
 */

@SpringBootApplication
@EnableEurekaClient
public class ProviderKafkaMain {
    public static void main(String[] args) {
        SpringApplication.run(ProviderKafkaMain.class, args);
    }
}
