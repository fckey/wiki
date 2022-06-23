package com.fangshaolei.wiki.exception;

/**
 * @author fangshaolei
 * @version 1.0.0
 * @ClassName BusinessExceptionCode
 * @Description
 * @createTime 2022/06/23 22:14
 **/
public enum BusinessExceptionCode {

    USER_LOGIN_NAME_EXIST("登录名已存在"),
    ;

    private String desc;

    BusinessExceptionCode(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
