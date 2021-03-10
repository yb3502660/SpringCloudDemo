package com.bingo.springcloud.controller;

import com.bingo.springcloud.entities.CommonResult;
import com.bingo.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author:yaobin
 * @date:2021/3/9,12:01
 */
@RestController("")
@Slf4j
public class OrderController {
//    private final static String URI = "http://localhost:8001";
    private final static String URI = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create( Payment payment) {
        log.info("consumer create is run ...");
        return restTemplate.postForObject(URI + "/payment/create", payment, CommonResult.class);
    }

    
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Integer id){
        System.out.println("test1 is run ...");
//        return
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);

        CommonResult forObject = restTemplate.getForObject(URI+"/payment/get/{id}", CommonResult.class, map);
        
        return forObject;
    }
}
