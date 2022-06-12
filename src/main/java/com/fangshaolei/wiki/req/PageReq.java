package com.fangshaolei.wiki.req;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * @author fangshaolei
 * @version 1.0.0
 * @ClassName PageReq
 * @Description
 * @createTime 2022/06/10 9:35
 **/
@Data
public class PageReq {
    @NotNull(message = "【页码不能为空】")
    private int page;

    @NotNull(message = "【每页条数不能为空】")
    @Max(value = 1000, message = "【每页条数】不能超过1000")
    private int size;

    @Override
    public String toString() {
        return "PageReq{" +
                "page=" + page +
                ", name='" + size + '\'' +
                '}';
    }
}
