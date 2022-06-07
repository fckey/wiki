package com.fangshaolei.wiki.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fangshaolei
 * @version 1.0.0
 * @ClassName TestController
 * @Description
 * @createTime 2022/06/07 20:19
 **/
@RestController
public class TestController {

    @Value("${hello.name:hahahahah}")
    private String name;

    @RequestMapping("/hello")
    public String hello(){
        return "hello world" + name;
    }

    @PostMapping("/hello/post")
    public String helloPost(String name){
        return "hello world ! post" + name;
    }
}
