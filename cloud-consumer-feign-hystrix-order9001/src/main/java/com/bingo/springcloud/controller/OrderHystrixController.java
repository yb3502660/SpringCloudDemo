package com.bingo.springcloud.controller;

import com.bingo.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author:yaobin
 * @date:2021/3/22,22:56
 */

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

//    @HystrixCommand
    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
//        int a = 10 / 0;
        String result = paymentHystrixService.paymentInfo_OK(id);
        log.info("==result:" + result);
        return result;
    }

        @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentTimeoutFallbackMethod",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "111111111")
    })
    public String paymentInfo_timeout(@PathVariable("id") Integer id) {
        int a = 10/0;
        String result = paymentHystrixService.paymentInfo_timeout(id);
        log.info("==result:" + result);
        return result;
    }

    
    public String paymentTimeoutFallbackMethod(@PathVariable("id") Integer id ){
        return "我是消费者9001,对方支付系统繁忙,请10秒种后再试;或者自己运行出错,请检查自己";
    }


    public String payment_Global_FallbackMethod(){
        return "Global异常处理信息,请稍后再试,0.0";
    }
}
