package com.bingo.springcloud.controller;

import cn.hutool.json.JSONUtil;
import com.bingo.springcloud.entities.CommonResult;
import com.bingo.springcloud.entities.Payment;
import com.bingo.springcloud.lb.LoadBalancer;
import com.bingo.springcloud.lb.MyLB;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:yaobin
 * @date:2021/3/9,12:01
 */
@RestController()
@Slf4j
public class OrderController {
    //    private final static String URI = "http://localhost:8001";
    private final static String URI = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private MyLB myLB;

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;
    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        log.info("consumer create is run ...");
        return restTemplate.postForObject(URI + "/payment/create", payment, CommonResult.class);
    }


    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Integer id) {
        System.out.println("test1 is run ...");
//        return
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);

        CommonResult forObject = restTemplate.getForObject(URI + "/payment/get/{id}", CommonResult.class, map);

        return forObject;
    }

    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id") Integer id) {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(URI + "/payment/get/" + id, CommonResult.class);
        HttpHeaders headers = entity.getHeaders();
        List<String> list = headers.get("content-type");
        System.out.println("xxx:"+ JSONUtil.toJsonStr(list));
        for (Map.Entry<String, List<String>> stringListEntry : headers.entrySet()) {
            System.out.println("key:"+stringListEntry.getKey()+",value:"+stringListEntry.getValue());
        }

        if (entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else {
            return new CommonResult<>(444, "操作失败");
        }

    }
    
    @GetMapping("/consumer/payment/lb")
    public String getPaymentLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(instances == null || instances.size()==0){
            return null;
        }
        ServiceInstance instance = loadBalancer.instances(instances);  
        System.out.println();
        java.net.URI uri = instance.getUri();

        return restTemplate.getForObject(uri + "/payment/lb", String.class);

    }


}
