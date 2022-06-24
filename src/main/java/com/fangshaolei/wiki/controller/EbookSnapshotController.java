package com.fangshaolei.wiki.controller;

import com.fangshaolei.wiki.resp.CommonResp;
import com.fangshaolei.wiki.resp.StatisticResp;
import com.fangshaolei.wiki.service.EbookSnapshotService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author fongshaolei
 * @version 1.0.0
 * @ClassName EbookSnapshotController
 * @Description
 * @createTime 2022/06/24 17:43
 **/
@RestController
@RequestMapping("/ebook-snapshot")
public class EbookSnapshotController {
    @Resource
    private EbookSnapshotService ebookSnapshotService;

    @GetMapping("/get-statistic")
    public CommonResp getStatistic() {
        List<StatisticResp> statisticResp = ebookSnapshotService.getStatistic();
        CommonResp<List<StatisticResp>> commonResp = new CommonResp<>();
        commonResp.setContent(statisticResp);
        return commonResp;
    }
}
