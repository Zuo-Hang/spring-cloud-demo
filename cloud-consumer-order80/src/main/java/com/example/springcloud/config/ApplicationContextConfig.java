package com.example.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author zuo_h
 * @Date 0:04 2021/4/12
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced//负载均衡
    public RestTemplate getRestTemplate() {
//        RestTemplate:
        return new RestTemplate();
    }
}
