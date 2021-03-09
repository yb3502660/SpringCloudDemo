package com.bingo.springcloud.service;

import com.bingo.springcloud.entities.Payment;

/**
 * @author:yaobin
 * @date:2021/3/9,0:40
 */

public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(Long id);
}
