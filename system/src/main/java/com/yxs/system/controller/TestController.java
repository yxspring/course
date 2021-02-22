package com.yxs.system.controller;

import com.yxs.system.domain.Test;
import com.yxs.system.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TestController {

    @Resource
    private TestService testService;
    @RequestMapping("/test")
    public String test(){
        return "success";
    }
    @RequestMapping("/list")
    public List<Test> list(){
        return testService.list();
    }
}
