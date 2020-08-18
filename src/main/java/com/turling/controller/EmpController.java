package com.turling.controller;

import com.turling.entity.Emp;
import com.turling.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 分控制器
 */
@Controller
public class EmpController {
    @Autowired
    private EmpService empService;

    @RequestMapping("/checkUserName")
    @ResponseBody
    public String checkUserName(String uname){
        boolean flag = empService.checkUserName(uname);
        return flag?"true":"false";
    }

    @RequestMapping(value="/getAllEmp",method= RequestMethod.GET)
    @ResponseBody
    public List<Emp> getAllEmp(){
        return empService.findAll();
    }

}
