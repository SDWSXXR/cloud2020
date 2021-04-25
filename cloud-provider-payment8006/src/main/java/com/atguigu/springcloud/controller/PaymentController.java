package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xxr
 * @Description
 * @date 2021/3/17 14:29
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String port;

    @GetMapping("payment/consul")
    public String paymentConsul(){
        return "consul port:"+port;
    }
}
