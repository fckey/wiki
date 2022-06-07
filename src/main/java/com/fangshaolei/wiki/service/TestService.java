package com.fangshaolei.wiki.service;

import com.fangshaolei.wiki.domain.Test;
import com.fangshaolei.wiki.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fangshaolei
 * @version 1.0.0
 * @ClassName TestService
 * @Description
 * @createTime 2022/06/07 21:39
 **/
@Service
public class TestService {
    @Autowired
    private TestMapper testMapper;

    public List<Test> list(){
        return testMapper.list();
    }
}
