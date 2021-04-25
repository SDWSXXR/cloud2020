package com.atguigu.cloud.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xxr
 * @Description
 * @date 2021/4/21 10:58
 */
@RestController
public class UserController {
    @RequestMapping("/login/{id}")
    public String login1(@PathVariable int id){





        return "secc";
    }
}
