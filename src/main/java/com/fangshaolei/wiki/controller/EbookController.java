package com.fangshaolei.wiki.controller;

import com.fangshaolei.wiki.domain.Ebook;
import com.fangshaolei.wiki.resp.CommonResp;
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

    @GetMapping("/list")
    public CommonResp<List<Ebook>> list(){
        CommonResp<List<Ebook>> resp = new CommonResp<>();
        List<Ebook> list = ebookService.list();
        resp.setContent(list);
        return resp;
    }
}
