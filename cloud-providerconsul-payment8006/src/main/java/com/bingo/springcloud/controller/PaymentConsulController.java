package com.bingo.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author:yaobin
 * @date:2021/3/14,1:30
 */

@RestController
@Slf4j
public class PaymentConsulController {

    @Value("${server.port}")
    private String serverPort;
//
//    @Resource
//    private DiscoveryClient discoveryClient;


    @GetMapping("/payment/consul")
    public String paymentzk(){
        return "springcloud with zookeeper: " +serverPort+"\t"+ UUID.randomUUID().toString();

    }
}
