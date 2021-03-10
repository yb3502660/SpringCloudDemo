package com.bingo.springcloud.service.impl;

import com.bingo.springcloud.dao.PaymentDao;
import com.bingo.springcloud.entities.Payment;
import com.bingo.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author:yaobin
 * @date:2021/3/9,0:41
 */

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.insert(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
