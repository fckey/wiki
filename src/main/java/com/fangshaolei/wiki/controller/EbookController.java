package com.fangshaolei.wiki.controller;

import com.fangshaolei.wiki.req.EbookQueryReq;
import com.fangshaolei.wiki.resp.CommonResp;
import com.fangshaolei.wiki.resp.EbookQueryResp;
import com.fangshaolei.wiki.req.EbookSaveReq;
import com.fangshaolei.wiki.resp.PageResp;
import com.fangshaolei.wiki.service.EbookService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author fangshaolei
 * @version 1.0.0
 * @ClassName EbookController
 * @Description
 * @createTime 2022/06/07 22:34
 **/
@RestController
@RequestMapping("/ebook")
public class EbookController {
    @Resource
    private EbookService ebookService;
    /**
      * @author: fangshaolei
      * @description: 查询电子书列表
      * @Date: 2022/6/7 22:50
      * @params: 
      * @return: 
      **/
    @GetMapping("/list")
    public CommonResp<PageResp<EbookQueryResp>> list(@Valid EbookQueryReq req){
        CommonResp<PageResp<EbookQueryResp>> resp = new CommonResp<>();
        // 封装数据
        PageResp<EbookQueryResp> list = ebookService.list(req);
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
    public CommonResp save(@Valid @RequestBody EbookSaveReq req){
        CommonResp resp = new CommonResp();
        ebookService.save(req);
        return resp;
    }
    /**
      * @author: fangshaolei
      * @description:
      * @Date: 2022/6/12 16:06
      * @params:
      * @return:
      **/
    @DeleteMapping("/delete/{id}")
    public CommonResp delete(@PathVariable Long id){
        CommonResp resp = new CommonResp();
        ebookService.delete(id);
        return resp;
    }

}
