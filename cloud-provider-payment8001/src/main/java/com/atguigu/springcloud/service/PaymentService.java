package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;

public interface PaymentService {
    Payment getPaymentById(Long id);
    void creatPayment(Payment payment);
}
