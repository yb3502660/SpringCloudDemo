package com.bingo.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author:yaobin
 * @date:2021/3/16,23:50
 */

@Service
public class PaymentService {
    /**
     * 正常访问,肯定OK
     *
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + "  PaymentInfo_OK,id:  " + id + "O(∩_∩)O哈哈~";
    }

    
    @HystrixCommand(fallbackMethod = "paymentInfo_timeoutHandler" ,commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfo_timeout(Integer id) {
        int timeNumber = 3;
//        int age =10/0;

        try {
            TimeUnit.SECONDS.sleep(3);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "线程池:" + Thread.currentThread().getName() + "  PaymentInfo_Timeout,id:  " + id + "O(∩_∩)O哈哈~ 耗时"+timeNumber+"秒种";

    }
    
    public String paymentInfo_timeoutHandler(Integer id){
        return "线程池:" + Thread.currentThread().getName() + "  系统繁忙或运行报错,id:  " + id + "\t"+"┭┮﹏┭┮";

    }
    
    
    
}
