package com.example.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author zuo_h
 * @Date 14:34 2021/4/15
 */
@RestController
@Slf4j
public class ConsulController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/consul")
    public String getConsulInfo(){
       return "spring-cloud with consul"+"\t"+serverPort+"\t"+ UUID.randomUUID().toString();
    }
}
