package com.bingo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author:yaobin
 * @date:2021/3/16,21:47
 */

@SpringBootApplication
@EnableFeignClients
public class ConsumerFeignOrderMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeignOrderMain9001.class, args);
    }
}
