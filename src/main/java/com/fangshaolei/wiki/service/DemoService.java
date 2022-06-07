package com.fangshaolei.wiki.service;

import com.fangshaolei.wiki.domain.Demo;
import com.fangshaolei.wiki.mapper.DemoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author fangshaolei
 * @version 1.0.0
 * @ClassName DemoService
 * @Description
 * @createTime 2022/06/07 22:20
 **/
@Service
public class DemoService {

    @Resource
    private DemoMapper demoMapper;

    public List<Demo> list(){
        return demoMapper.selectByExample(null);
    }
}
