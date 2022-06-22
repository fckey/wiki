package com.fangshaolei.wiki.controller;

import com.fangshaolei.wiki.req.DocQueryReq;
import com.fangshaolei.wiki.req.DocSaveReq;
import com.fangshaolei.wiki.resp.DocQueryResp;
import com.fangshaolei.wiki.resp.CommonResp;
import com.fangshaolei.wiki.resp.PageResp;
import com.fangshaolei.wiki.service.DocService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

/**
 * @author fangshaolei
 * @version 1.0.0
 * @ClassName DocController
 * @Description
 * @createTime 2022/06/07 22:34
 **/
@RestController
@RequestMapping("/doc")
public class DocController {
    @Resource
    private DocService docService;
    /**
      * @author: fangshaolei
      * @description: 返回当前所有的数据没有分页条件
      * @Date: 2022/6/20 9:37
      * @params:
      * @return:
      **/
    @GetMapping("/all")
    public CommonResp<List<DocQueryResp>> all(){
        CommonResp<List<DocQueryResp>> resp = new CommonResp<>();
        // 封装数据
        List<DocQueryResp> list = docService.all();
        resp.setContent(list);
        return resp;
    }
    /**
      * @author: fangshaolei
      * @description: 查询电子书列表
      * @Date: 2022/6/7 22:50
      * @params: 
      * @return: 
      **/
    @GetMapping("/list")
    public CommonResp<PageResp<DocQueryResp>> list(@Valid DocQueryReq req){
        CommonResp<PageResp<DocQueryResp>> resp = new CommonResp<>();
        // 封装数据
        PageResp<DocQueryResp> list = docService.list(req);
        resp.setContent(list);
        return resp;
    }
    
    /**
      * @author: fangshaolei
      * @description: 
      * @Date: 2022/6/10 10:41
      * @params: 
      * @return: 
      **/
    @PostMapping("/save")
    public CommonResp save(@Valid @RequestBody DocSaveReq req){
        CommonResp resp = new CommonResp();
        docService.save(req);
        return resp;
    }
    /**
      * @author: fangshaolei
      * @description: 批量的删除多个id的值
      * @Date: 2022/6/12 16:06
      * @params:
      * @return:
      **/
    @DeleteMapping("/delete/{idsStr}")
    public CommonResp delete(@PathVariable String idsStr) {
        CommonResp resp = new CommonResp<>();
        List<String> list = Arrays.asList(idsStr.split(","));
        docService.delete(list);
        return resp;
    }
    
    /**
      * @author: fangshaolei
      * @description: 
      * @Date: 2022/6/22 20:34
      * @params: 
      * @return: 
      **/

    @GetMapping("/find-content/{id}")
    public CommonResp findContent(@Valid Long id){
        CommonResp<String> resp = new CommonResp<>();
        String content = docService.findContent(id);
        resp.setContent(content);
        // 封装数据
        return resp;
    }
}
