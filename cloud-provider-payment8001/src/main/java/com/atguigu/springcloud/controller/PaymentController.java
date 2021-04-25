package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class PaymentController<disc> {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;
    @Autowired
    private DiscoveryClient discoveryClient;


    @PostMapping(value="/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int create = paymentService.creatPayment(payment);
        log.info("*******插入结果："+create);
        if(create>0){
            return new CommonResult(200,"插入结果成功，端口："+serverPort,create);
        }else{
            return new CommonResult(444,"插入数据失败，端口："+serverPort,null);
        }
    }


    @GetMapping(value="/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        if(payment!=null){
            return new CommonResult(200,"查询成功，端口："+serverPort,payment);
        }else{
            return new CommonResult(444,"查询数据失败,id:"+id+",端口："+serverPort,null);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("**************service:"+service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("**************instance:"+instance);
        }
        return this.discoveryClient;
    }

}
