package com.example.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author zuo_h
 * @Date 14:01 2021/4/15
 */
@RestController
@Slf4j
public class ZkController {
    public static final String PAYMENT_URL = "http://cloud-provider-payment";
    @Resource
    RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/zk")
    public String paymentInfo() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/zk", String.class);
    }
}
