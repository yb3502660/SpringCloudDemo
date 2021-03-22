package com.bingo.springcloud.controller;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author:yaobin
 * @date:2021/3/14,0:28
 */

@RestController
@Slf4j
public class OrderZkController {

    public static final String INVOKE_URL = "http://cloud-provider-payment";


    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private RestTemplate restTemplate;
    
    
    @GetMapping(value = "/consumer/payment/consul")
    public String paymentInfo(){
        System.out.println("consumer payment consul is run...");
        String result = restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
        return result;
    }


    @GetMapping(value = "/consumer/payment/zk")
    public String paymentInfo1(){
        List<String> services = discoveryClient.getServices();
        System.out.println("services:"+ JSONUtil.toJsonStr(services));

        System.out.println("consumer payment consul is run...");
        String result = restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
        return result;
    }
}
