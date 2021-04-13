package com.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author zuo_h
 * @Date 13:26 2021/4/13
 */
@SpringBootApplication
@EnableEurekaServer//代表是eureka的服务注册中心
public class CloudEurekaMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaMain7001.class,args);
    }
}
