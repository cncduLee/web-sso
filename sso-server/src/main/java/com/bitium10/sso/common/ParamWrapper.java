package com.bitium10.sso.common;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User:  lpm【百墨】 shouli1990@gmail.com
 * Date: 14-6-4
 * Time: 下午6:20
 * 请求参数封装
 */
public class ParamWrapper<T> implements Serializable{
    // 业务操作日志相关数据
    private BusinessLogParam logParam;
    // 请求数据
    private T data;

    public ParamWrapper(BusinessLogParam logParam, T data) {
        this.logParam = logParam;
        this.data = data;
    }

    public BusinessLogParam getLogParam() {
        return logParam;
    }

    public T getData() {
        return data;
    }
}
