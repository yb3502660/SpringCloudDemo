package com.bingo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author:yaobin
 * @date:2021/3/14,1:29
 */

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentConsualMain8006 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentConsualMain8006.class, args);
    }
}
