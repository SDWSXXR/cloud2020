package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author xxr
 * @Description
 * @date 2021/3/12 17:54
 */
@SpringBootApplication
@EnableEurekaServer
public class EurkaMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurkaMain7001.class,args);
    }
}
