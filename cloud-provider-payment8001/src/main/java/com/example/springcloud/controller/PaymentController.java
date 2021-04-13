package com.example.springcloud.controller;

import com.example.springcloud.entities.CommonResult;
import com.example.springcloud.entities.Payment;
import com.example.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author zuo_h
 * @Date 23:06 2021/4/11
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    /**
     * 注册后的一些基本信息
     */
    @Resource
    private DiscoveryClient discoveryClient;

    /**
     * 新增
     * @param payment
     * @return
     */
    @PostMapping(value = "/payment/create")
    public CommonResult create(Payment payment) {
        int i = paymentService.create(payment);
        log.info("**********插入结果：" + i);
        if (i > 0) {
            return new CommonResult(200, "插入成功！" + serverPort);
        } else {
            return new CommonResult(444, null);
        }
    }

    /**
     * 查询
     * @param id
     * @return
     */
    @GetMapping(value = "/payment/getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("**********查询结果：" + payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功！" + serverPort, payment);
        } else {
            return new CommonResult(444, "没有对应记录，查询id为：" + id + serverPort);
        }
    }

    /**
     * 利用discoveryClient查看服务信息
     * @return
     */
    @GetMapping(value = "/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String str : services) {
            log.info("**********element:" + str);
        }
        //获取一个微服务下的所有实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("id:" + instance.getServiceId() + "\thost:" + instance.getHost() + "\tport:" + instance.getPort() + "\turi:" + instance.getUri());
        }
        return this.discoveryClient;
    }
}
