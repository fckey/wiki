package com.fangshaolei.wiki.service;

import com.fangshaolei.wiki.domain.Category;
import com.fangshaolei.wiki.domain.CategoryExample;
import com.fangshaolei.wiki.mapper.CategoryMapper;
import com.fangshaolei.wiki.req.CategoryQueryReq;
import com.fangshaolei.wiki.req.CategorySaveReq;
import com.fangshaolei.wiki.resp.CategoryQueryResp;
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
 * @ClassName CategoryService
 * @Description
 * @createTime 2022/06/07 22:32
 **/
@Service
public class CategoryService {

    @Resource
    private CategoryMapper categoryMapper;
    @Resource
    private SnowFlake snowFlake;
    /**
      * @author: fangshaolei
      * @description: 
      * @Date: 2022/6/7 22:54
      * @params: 
      * @return: 
      **/
    public PageResp<CategoryQueryResp> list(CategoryQueryReq req){
;
        CategoryExample example = new CategoryExample();
        CategoryExample.Criteria criteria = example.createCriteria();
        // 分页插件
        PageHelper.startPage(req.getPage(), req.getSize());
        List<Category> categoryList = categoryMapper.selectByExample(example);
        // 获取其他信息
        PageInfo<Category> pageInfo = new PageInfo(categoryList);

        // 进行转换
        List<CategoryQueryResp> respList = CopyUtil.copyList(categoryList, CategoryQueryResp.class);
        // 插件对象封装
        PageResp<CategoryQueryResp> pageResp = new PageResp<>();
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
    public void save(CategorySaveReq req){
        Category category = CopyUtil.copy(req, Category.class);
        // 判断当前的id是否是存在的，如果不存在则直接新增
        if(ObjectUtils.isEmpty(req.getId())){
            category.setId(snowFlake.nextId());
            // 新增
            categoryMapper.insert(category);
        } else{
            // 更新
            categoryMapper.updateByPrimaryKey(category);
        }
    }
    /**
      * @author: fangshaolei
      * @description: 删除电子书记录
      * @Date: 2022/6/12 16:10
      * @params: 
      * @return: 
      **/
    public void delete(Long id) {
        // 通过id进行删除
        categoryMapper.deleteByPrimaryKey(id);
    }
}
