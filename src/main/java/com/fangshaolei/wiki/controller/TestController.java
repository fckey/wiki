package com.fangshaolei.wiki.controller;

import com.fangshaolei.wiki.domain.Test;
import com.fangshaolei.wiki.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author fangshaolei
 * @version 1.0.0
 * @ClassName TestController
 * @Description
 * @createTime 2022/06/07 20:19
 **/
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    public String hello(){
        return "hello world";
    }

    @PostMapping("/hello/post")
    public String helloPost(String name){
        return "hello world ! post" + name;
    }

    @GetMapping("/test/list")
    public List<Test> list(){
        return testService.list();
    }
}
