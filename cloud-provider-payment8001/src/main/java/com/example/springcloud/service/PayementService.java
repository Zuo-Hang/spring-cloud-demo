package com.example.springcloud.service;

import com.example.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author zuo_h
 * @Date 22:33 2021/4/11
 */
public interface PayementService {
    public int create(Payment payment);

    public Payment getPaymentById(Long id);
}
