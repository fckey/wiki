package com.fangshaolei.wiki.controller;

import com.fangshaolei.wiki.req.CategoryQueryReq;
import com.fangshaolei.wiki.req.CategorySaveReq;
import com.fangshaolei.wiki.resp.CommonResp;
import com.fangshaolei.wiki.resp.CategoryQueryResp;
import com.fangshaolei.wiki.resp.PageResp;
import com.fangshaolei.wiki.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @author fangshaolei
 * @version 1.0.0
 * @ClassName CategoryController
 * @Description
 * @createTime 2022/06/07 22:34
 **/
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Resource
    private CategoryService categoryService;
    /**
      * @author: fangshaolei
      * @description: 返回当前所有的数据没有分页条件
      * @Date: 2022/6/20 9:37
      * @params:
      * @return:
      **/
    @GetMapping("/all")
    public CommonResp<List<CategoryQueryResp>> all(){
        CommonResp<List<CategoryQueryResp>> resp = new CommonResp<>();
        // 封装数据
        List<CategoryQueryResp> list = categoryService.all();
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
    public CommonResp<PageResp<CategoryQueryResp>> list(@Valid CategoryQueryReq req){
        CommonResp<PageResp<CategoryQueryResp>> resp = new CommonResp<>();
        // 封装数据
        PageResp<CategoryQueryResp> list = categoryService.list(req);
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
    public CommonResp save(@Valid @RequestBody CategorySaveReq req){
        CommonResp resp = new CommonResp();
        categoryService.save(req);
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
        categoryService.delete(id);
        return resp;
    }

}
