package com.fangshaolei.wiki.resp;

import lombok.Data;

/**
 * @author fangshaolei
 * @version 1.0.0
 * @ClassName EbookResp
 * @Description
 * @createTime 2022/06/07 22:54
 **/
@Data
public class EbookResp {
    private Long id;

    private String name;

    private Long category1Id;

    private Long category2Id;

    private String description;

    private String cover;

    private Integer docCount;

    private Integer viewCount;

    private Integer voteCount;

    @Override
    public String toString() {
        return "EbookResp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category1Id=" + category1Id +
                ", category2Id=" + category2Id +
                ", description='" + description + '\'' +
                ", cover='" + cover + '\'' +
                ", docCount=" + docCount +
                ", viewCount=" + viewCount +
                ", voteCount=" + voteCount +
                '}';
    }
}
