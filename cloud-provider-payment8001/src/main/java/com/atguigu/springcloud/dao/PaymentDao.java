package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author:yaobin
 * @date:2021/3/9,0:29
 */

@Mapper
public interface PaymentDao {
    public int insert(Payment payment);

    public Payment getPaymentById(@Param("id")Long id);
}
