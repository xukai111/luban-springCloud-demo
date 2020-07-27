package com.xk.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("SERVER-POWER")
public interface PowerClientService {

    @RequestMapping("getPower.do")
    String power();

    @RequestMapping("getPowerByFeign.do")
    String getPowerByFeign(@RequestParam String name);
}
