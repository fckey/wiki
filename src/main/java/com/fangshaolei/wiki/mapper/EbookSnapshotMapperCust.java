package com.fangshaolei.wiki.mapper;

import com.fangshaolei.wiki.resp.StatisticResp;

import java.util.List;

/**
 * @author fongshaolei
 * @version 1.0.0
 * @ClassName EbookSnapshotMapperCust
 * @Description
 * @createTime 2022/06/24 16:54
 **/
public interface EbookSnapshotMapperCust {
    public void genSnapshot();
    List<StatisticResp> getStatistic();
}
