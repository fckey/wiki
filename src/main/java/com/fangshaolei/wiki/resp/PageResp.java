package com.fangshaolei.wiki.resp;

import lombok.Data;

import java.util.List;

/**
 * @author fangshaolei
 * @version 1.0.0
 * @ClassName PageResp
 * @Description
 * @createTime 2022/06/10 9:41
 **/
@Data
public class PageResp<T> {
    private long total;
    private List<T> list;

    @Override
    public String toString() {
        return "PageResp{" +
                "total=" + total +
                ", list=" + list +
                '}';
    }
}
