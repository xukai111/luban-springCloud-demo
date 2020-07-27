package com.xk.controller;

import com.xk.util.ResultUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PowerController {

    @RequestMapping("getPower.do")
    public String getPower(){
        return ResultUtil.success("获取3006端口的power");
    }

    @RequestMapping("getPowerByFeign.do")
    public String getPowerByFeign(@RequestParam String name) throws Exception {
        Thread.sleep(3000);
        if(name == null){
            throw new Exception();
        }
        return ResultUtil.success("获取3006端口 power" + name);
    };

}
