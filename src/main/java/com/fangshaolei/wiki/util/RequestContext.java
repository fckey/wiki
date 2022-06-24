package com.fangshaolei.wiki.util;

import java.io.Serializable;

/**
 * @author fongshaolei
 * @version 1.0.0
 * @ClassName RequestContext
 * @Description
 * @createTime 2022/06/24 12:01
 **/
public class RequestContext implements Serializable {
    private static ThreadLocal<String> remoteAddr = new ThreadLocal<>();

    public static String getRemoteAddr() {
        return remoteAddr.get();
    }

    public static void setRemoteAddr(String remoteAddr) {
        RequestContext.remoteAddr.set(remoteAddr);
    }
}
