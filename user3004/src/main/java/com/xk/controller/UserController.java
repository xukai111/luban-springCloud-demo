package com.xk.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xk.service.PowerClientService;
import com.xk.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PowerClientService powerClientService;

    private static  final String power = "http://SERVER-POWER";

    @RequestMapping("/getUser.do")
    public String getUser(){
        return ResultUtil.success("获取3004端口上的用户");
    }

    @RequestMapping("/getPowerByUser.do")
    public Object getPowerByUser(){
        return restTemplate.getForObject(power + "/getPower.do",Object.class);
    }

    @RequestMapping("/getPowerByFeign.do")
    public String getPowerByFeign(){
        return powerClientService.power();
    }

    @RequestMapping("/forPowerByFeign")
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public String forPowerByFeign(String name){
        return powerClientService.getPowerByFeign(name);
    }

    private String fallbackMethod(){
        return ResultUtil.success("进入降级方法");
    }
}
