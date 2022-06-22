package com.fangshaolei.wiki.service;

import com.fangshaolei.wiki.domain.Content;
import com.fangshaolei.wiki.domain.Doc;
import com.fangshaolei.wiki.domain.DocExample;
import com.fangshaolei.wiki.mapper.ContentMapper;
import com.fangshaolei.wiki.mapper.DocMapper;
import com.fangshaolei.wiki.req.DocQueryReq;
import com.fangshaolei.wiki.req.DocSaveReq;
import com.fangshaolei.wiki.resp.DocQueryResp;
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
 * @ClassName DocService
 * @Description
 * @createTime 2022/06/07 22:32
 **/
@Service
public class DocService {

    @Resource
    private DocMapper docMapper;
    @Resource
    private SnowFlake snowFlake;
    @Resource
    private ContentMapper contentMapper;

    /**
     * @author: fangshaolei
     * @description:
     * @Date: 2022/6/20 9:35
     * @params:
     * @return:
     **/

    public List<DocQueryResp> all() {
        ;
        DocExample example = new DocExample();
        example.setOrderByClause("sort asc");
        // 分页插件
        List<Doc> docList = docMapper.selectByExample(example);
        // 获取其他信息
        // 进行转换
        List<DocQueryResp> respList = CopyUtil.copyList(docList, DocQueryResp.class);
        return respList;
    }

    /**
     * @author: fangshaolei
     * @description:
     * @Date: 2022/6/7 22:54
     * @params:
     * @return:
     **/
    public PageResp<DocQueryResp> list(DocQueryReq req) {
        ;
        DocExample example = new DocExample();
        example.setOrderByClause("sort asc");
        // 书写where条件
        DocExample.Criteria criteria = example.createCriteria();
        // 分页插件
        PageHelper.startPage(req.getPage(), req.getSize());
        List<Doc> docList = docMapper.selectByExample(example);
        // 获取其他信息
        PageInfo<Doc> pageInfo = new PageInfo(docList);

        // 进行转换
        List<DocQueryResp> respList = CopyUtil.copyList(docList, DocQueryResp.class);
        // 插件对象封装
        PageResp<DocQueryResp> pageResp = new PageResp<>();
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
    public void save(DocSaveReq req) {
        Doc doc = CopyUtil.copy(req, Doc.class);
        Content content = CopyUtil.copy(req, Content.class);
        // 判断当前的id是否是存在的，如果不存在则直接新增
        if (ObjectUtils.isEmpty(req.getId())) {
            doc.setId(snowFlake.nextId());
            // 新增 doc
            doc.setId(snowFlake.nextId());
            docMapper.insert(doc);
            // 新增content
            content.setId(doc.getId());
            contentMapper.insert(content);
        } else {
            // 更新
            docMapper.updateByPrimaryKey(doc);
            int count = contentMapper.updateByPrimaryKeyWithBLOBs(content);
            if (count == 0) {
                contentMapper.insert(content);
            }
        }
    }

    /**
     * @author: fangshaolei
     * @description: 删除电子书记录
     * @Date: 2022/6/12 16:10
     * @params:
     * @return:
     **/
    public void delete(List<String> ids) {
        DocExample docExample = new DocExample();
        DocExample.Criteria criteria = docExample.createCriteria();
        criteria.andIdIn(ids);
        docMapper.deleteByExample(docExample);
    }
    
    /**
      * @author: fangshaolei
      * @description: 
      * @Date: 2022/6/22 20:39
      * @params: 
      * @return: 
      **/
    public String findContent(Long id) {
        Content content = contentMapper.selectByPrimaryKey(id);
        if(content != null) return content.getContent();
        else return "";
    }
}
