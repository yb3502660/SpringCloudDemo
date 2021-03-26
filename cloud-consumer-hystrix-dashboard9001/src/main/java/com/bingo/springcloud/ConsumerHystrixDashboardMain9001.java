package com.bingo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author:yaobin
 * @date:2021/3/27,0:51
 */


@SpringBootApplication
@EnableHystrixDashboard
public class ConsumerHystrixDashboardMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerHystrixDashboardMain9001.class, args);
    }
}
