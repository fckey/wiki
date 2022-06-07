package com.fangshaolei.wiki.resp;

import lombok.Data;

/**
 * @author fangshaolei
 * @version 1.0.0
 * @ClassName CommonResp
 * @Description 通用返回类
 * @createTime 2022/06/07 22:40
 **/
@Data
public class CommonResp<T>{

    /**
     * 业务上的成功或失败
     */
    private boolean success = true;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 返回泛型数据，自定义类型
     */
    private T content;

    public CommonResp() {
    }

    public CommonResp(boolean success, String message, T content) {
        this.success = success;
        this.message = message;
        this.content = content;
    }

    public CommonResp(String message, T content) {
        this.message = message;
        this.content = content;
    }

    public CommonResp(T content) {
        this.content = content;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ResponseDto{");
        sb.append("success=").append(success);
        sb.append(", message='").append(message).append('\'');
        sb.append(", content=").append(content);
        sb.append('}');
        return sb.toString();
    }
}
