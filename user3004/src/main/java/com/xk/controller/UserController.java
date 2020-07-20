package com.xk.controller;

import com.xk.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    private static  final String power = "http://SERVER-POWER";

    @RequestMapping("/getUser.do")
    public String getUser(){
        return ResultUtil.success("获取3004端口上的用户");
    }

    @RequestMapping("/getPowerByUser.do")
    public Object getPowerByUser(){
        return restTemplate.getForObject(power + "/getPower.do",Object.class);
    }

}
