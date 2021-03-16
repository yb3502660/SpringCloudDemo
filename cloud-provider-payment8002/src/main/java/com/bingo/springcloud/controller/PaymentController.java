package com.bingo.springcloud.controller;

import cn.hutool.json.JSONUtil;
import com.bingo.springcloud.entities.CommonResult;
import com.bingo.springcloud.entities.Payment;
import com.bingo.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author:yaobin
 * @date:2021/3/9,0:44
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;


    @PostMapping(value = "/payment/create")
    public CommonResult create(Payment payment){
        int num = paymentService.create(payment);
        log.info("******插入结果:"+num);
        if(num>0){
            return new CommonResult(200, "插入数据库成功["+serverPort+"]", num);
        }else {
            return new CommonResult(444, "插入数据库失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("******查询结果:"+payment);
        if(payment!=null){
            return new CommonResult(200, "查询成功["+serverPort+"]", payment);
        }else {
            return new CommonResult(444, "没有对应记录,查询ID:"+id, null);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        System.out.println("services:"+ JSONUtil.toJsonStr(services));
        System.out.println("instances:"+JSONUtil.toJsonStr(instances));
        return services;

    }
    
    @GetMapping("/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }
}
