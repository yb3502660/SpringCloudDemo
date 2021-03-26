package com.bingo.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author:yaobin
 * @date:2021/3/26,23:31
 */

@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "--------------paymentFallbackService fall back---------xxx";
    }

    @Override
    public String paymentInfo_timeout(Integer id) {
        return "--------------paymentFallbackService fall back---------xxxaaa";
    }
}
