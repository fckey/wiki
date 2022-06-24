package com.fangshaolei.wiki.controller;

import com.fangshaolei.wiki.req.UserLoginReq;
import com.fangshaolei.wiki.req.UserQueryReq;
import com.fangshaolei.wiki.req.UserResetPasswordReq;
import com.fangshaolei.wiki.req.UserSaveReq;
import com.fangshaolei.wiki.resp.CommonResp;
import com.fangshaolei.wiki.resp.PageResp;
import com.fangshaolei.wiki.resp.UserLoginResp;
import com.fangshaolei.wiki.resp.UserQueryResp;
import com.fangshaolei.wiki.service.UserService;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author fongshaolei
 * @version 1.0.0
 * @ClassName UserController
 * @Description
 * @createTime 2022/06/23 21:40
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/list")
    public CommonResp list(@Valid UserQueryReq req) {
        CommonResp<PageResp<UserQueryResp>> resp = new CommonResp<>();
        PageResp<UserQueryResp> list = userService.list(req);
        resp.setContent(list);
        return resp;
    }

    @PostMapping("/save")
    public CommonResp save(@Valid @RequestBody UserSaveReq req) {
        req.setPassword(DigestUtils.md5DigestAsHex(req.getPassword().getBytes()));
        CommonResp resp = new CommonResp<>();
        userService.save(req);
        return resp;
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp delete(@PathVariable Long id) {
        CommonResp resp = new CommonResp<>();
        userService.delete(id);
        return resp;
    }

    @PostMapping("/reset-password")
    public CommonResp resetPassword(@Valid @RequestBody UserResetPasswordReq req) {
        req.setPassword(DigestUtils.md5DigestAsHex(req.getPassword().getBytes()));
        CommonResp resp = new CommonResp<>();
        userService.resetPassword(req);
        return resp;
    }
    /**
      * @author: fangshaolei
      * @description: 
      * @Date: 2022/6/24 9:06
      * @params: 
      * @return: 
      **/
    @PostMapping("/login")
    public CommonResp login(@Valid @RequestBody UserLoginReq req) {
        req.setPassword(DigestUtils.md5DigestAsHex(req.getPassword().getBytes()));
        CommonResp<UserLoginResp> resp = new CommonResp<>();
        UserLoginResp userLoginResp = userService.login(req);
        resp.setContent(userLoginResp);
        return resp;
    }
}