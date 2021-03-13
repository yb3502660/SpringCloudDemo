package com.bingo.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author:yaobin
 * @date:2021/3/14,0:28
 */

@RestController
@Slf4j
public class OrderZkController {

    public static final String INVOKE_URL = "http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;
    
    
    @GetMapping(value = "/consumer/payment/consul")
    public String paymentInfo(){
        System.out.println("consumer payment consul is run...");
        String result = restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
        return result;
    }
}
