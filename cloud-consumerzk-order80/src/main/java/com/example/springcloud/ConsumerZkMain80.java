package com.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author zuo_h
 * @Date 13:55 2021/4/15
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerZkMain80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerZkMain80.class,args);
    }
}
