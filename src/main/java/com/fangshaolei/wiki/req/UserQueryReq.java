package com.fangshaolei.wiki.req;

import com.fangshaolei.wiki.resp.PageResp;

/**
 * @author fongshaolei
 * @version 1.0.0
 * @ClassName UserQueryReq
 * @Description
 * @createTime 2022/06/23 21:42
 **/
public class UserQueryReq extends PageReq {
    private String loginName;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @Override
    public String toString() {
        return "UserQueryReq{" +
                "loginName='" + loginName + '\'' +
                "} " + super.toString();
    }
}
