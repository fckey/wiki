package com.fangshaolei.wiki.req;

import lombok.Data;

/**
 * @author fangshaolei
 * @version 1.0.0
 * @ClassName EbookQueryReq
 * @Description 返回类型的参数
 * @createTime 2022/06/07 22:49
 **/

@Data
public class CategoryQueryReq extends PageReq {
    @Override
    public String toString() {
        return "CategoryQueryReq{}";
    }
}
