package com.bingo.springcloud;

import com.bingo.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author:yaobin
 * @date:2021/3/9,11:59
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class)
public class ConsumerOrderMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderMain9001.class, args);
    }
}
