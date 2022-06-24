package com.fangshaolei.wiki.service;

import com.fangshaolei.wiki.mapper.EbookSnapshotMapperCust;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author fongshaolei
 * @version 1.0.0
 * @ClassName EbookSnapshotService
 * @Description
 * @createTime 2022/06/24 16:54
 **/
@Service
public class EbookSnapshotService {
    @Resource
    private EbookSnapshotMapperCust ebookSnapshotMapperCust;

           public void genSnapshot() {
               ebookSnapshotMapperCust.genSnapshot();
           }
}
