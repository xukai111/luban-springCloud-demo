package com.xk.controller;

import com.xk.util.ResultUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PowerController {

    @RequestMapping("getPower.do")
    public String getPower(){
        return ResultUtil.success("获取3006端口的power");
    }

}
