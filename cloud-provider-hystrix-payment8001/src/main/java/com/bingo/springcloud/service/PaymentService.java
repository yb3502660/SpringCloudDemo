package com.bingo.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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


    @HystrixCommand(fallbackMethod = "paymentInfo_timeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfo_timeout(Integer id) {
        int timeNumber = 3;
//        int age =10/0;

        try {
            TimeUnit.SECONDS.sleep(3);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "线程池:" + Thread.currentThread().getName() + "  PaymentInfo_Timeout,id:  " + id + "O(∩_∩)O哈哈~ 耗时" + timeNumber + "秒种";

    }

    //服务降级

    public String paymentInfo_timeoutHandler(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + "  系统繁忙或运行报错,id:  " + id + "\t" + "┭┮﹏┭┮";

    }


    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
        @HystrixProperty(name = "circuitBreaker.enabled",value = "true"), //是否开启断路器
        @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
        @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期  ??失败后要重试睡眠多久??? 短路多久后开始尝试恢复,默认5秒
        @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60")//失败率达到多少后跳闸
    })
//    HystrixCommandProperties   HystrixProperty的属性
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("id 不能符数....");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功,流水号:" + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "id 不能负数,请稍后再试0.0";
    }


}
