package com.fangshaolei.wiki.service;

import com.fangshaolei.wiki.mapper.EbookSnapshotMapperCust;
import com.fangshaolei.wiki.resp.StatisticResp;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    /**
     * 获取首页数值数据：总阅读数、总点赞数、今日阅读数、今日点赞数、今日预计阅读数、今日预计阅读增长
     */
    public List<StatisticResp> getStatistic() {
        return ebookSnapshotMapperCust.getStatistic();
    }
}
