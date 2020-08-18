package com.turling.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 分控制器
 */
@Controller
public class CarController {
    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "hello ssm";
    }
}
