package com.fangshaolei.wiki.req;

import lombok.Data;

/**
 * @author fangshaolei
 * @version 1.0.0
 * @ClassName PageReq
 * @Description
 * @createTime 2022/06/10 9:35
 **/
@Data
public class PageReq {
    private int page;
    private int size;

    @Override
    public String toString() {
        return "PageReq{" +
                "page=" + page +
                ", name='" + size + '\'' +
                '}';
    }
}
