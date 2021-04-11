package com.example.springcloud.service;

import com.example.springcloud.dao.PaymentDao;
import com.example.springcloud.entities.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author zuo_h
 * @Date 22:37 2021/4/11
 */
@Service
public class PayementServiceImpl implements PayementService {
    @Resource
    PaymentDao paymentDao;


    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
