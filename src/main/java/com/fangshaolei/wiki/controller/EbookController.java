package com.fangshaolei.wiki.controller;

import com.fangshaolei.wiki.req.EbookReq;
import com.fangshaolei.wiki.resp.CommonResp;
import com.fangshaolei.wiki.resp.EbookResp;
import com.fangshaolei.wiki.service.EbookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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
      * @description:
      * @Date: 2022/6/7 22:50
      * @params: 
      * @return: 
      **/
    @GetMapping("/list")
    public CommonResp<List<EbookResp>> list(EbookReq req){
        CommonResp<List<EbookResp>> resp = new CommonResp<>();
        // 封装数据
        List<EbookResp> list = ebookService.list(req);
        resp.setContent(list);
        return resp;
    }
}
