package com.example.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author zuo_h
 * @Date 0:02 2021/4/12
 */
@RestController
@Slf4j
public class Order80Controller {
    /**
    public static final String PAYMENT_URL = "http://127.0.0.1:8001";
     */
    public static final String PAYMENT_URL = "http://consul-provider-payment";
    @Resource
    RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/consul")
    public String creat() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/consul", String.class);
    }

}
