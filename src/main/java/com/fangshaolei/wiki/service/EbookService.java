package com.fangshaolei.wiki.service;

import com.fangshaolei.wiki.domain.Ebook;
import com.fangshaolei.wiki.mapper.EbookMapper;
import org.springframework.stereotype.Service;

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

    public List<Ebook> list(){
        return ebookMapper.selectByExample(null);
    }
}
