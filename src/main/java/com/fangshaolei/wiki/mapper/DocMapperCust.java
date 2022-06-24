package com.fangshaolei.wiki.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * @author fongshaolei
 * @version 1.0.0
 * @ClassName DocMapperCust
 * @Description
 * @createTime 2022/06/24 11:35
 **/
public interface DocMapperCust {
    public void increaseViewCount(@Param("id") Long id);
}
