package com.fangshaolei.wiki.service;

import com.fangshaolei.wiki.domain.Ebook;
import com.fangshaolei.wiki.domain.EbookExample;
import com.fangshaolei.wiki.mapper.EbookMapper;
import com.fangshaolei.wiki.req.EbookQueryReq;
import com.fangshaolei.wiki.resp.EbookQueryResp;
import com.fangshaolei.wiki.resp.EbookSaveReq;
import com.fangshaolei.wiki.resp.PageResp;
import com.fangshaolei.wiki.util.CopyUtil;
import com.fangshaolei.wiki.util.SnowFlake;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author fangshaolei
 * @version 1.0.0
 * @ClassName EbookService
 * @Description
 * @createTime 2022/06/07 22:32
 **/
@Service
public class EbookService {

    @Resource
    private EbookMapper ebookMapper;
    @Resource
    private SnowFlake snowFlake;
    /**
      * @author: fangshaolei
      * @description: 
      * @Date: 2022/6/7 22:54
      * @params: 
      * @return: 
      **/
    public PageResp<EbookQueryResp> list(EbookQueryReq req){
;
        EbookExample example = new EbookExample();
        EbookExample.Criteria criteria = example.createCriteria();
        if(!ObjectUtils.isEmpty(req.getName())) {
            criteria.andNameLike("%" + req.getName() + "%");
        }
        // 分页插件
        PageHelper.startPage(req.getPage(), req.getSize());
        List<Ebook> ebookList = ebookMapper.selectByExample(example);
        // 获取其他信息
        PageInfo<Ebook> pageInfo = new PageInfo(ebookList);

        // 进行转换
        List<EbookQueryResp> respList = CopyUtil.copyList(ebookList, EbookQueryResp.class);
        // 插件对象封装
        PageResp<EbookQueryResp> pageResp = new PageResp<>();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(respList);

        return pageResp;
    }
    /**
      * @author: fangshaolei
      * @description: 保存
      * @Date: 2022/6/10 10:46
      * @params: 
      * @return: 
      **/
    public void save(EbookSaveReq req){
        Ebook ebook = CopyUtil.copy(req, Ebook.class);
        // 判断当前的id是否是存在的，如果不存在则直接新增
        if(ObjectUtils.isEmpty(req.getId())){
            ebook.setId(snowFlake.nextId());
            // 新增
            ebookMapper.insert(ebook);
        } else{
            // 更新
            ebookMapper.updateByPrimaryKey(ebook);
        }
    }
}
