package com.bitium10.sso.common;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User:  lpm【百墨】 shouli1990@gmail.com
 * Date: 14-6-4
 * Time: 下午6:31
 * To change this template use File | Settings | File Templates.
 */
public final class Result<T> implements Serializable {
    /**
     * 操作结果代码
     */
    protected String code;

    /**
     * 描述
     */
    protected String msg;

    /**
     * 操作结果数据，如果本身返回boolean值，也写在这
     */
    protected T data;

    /**
     *  成功，EnumCode等于Success
     * @param data
     */
    public Result(T data) {
       this(CommonCode.SUCCESS,data);
    }

    /**
     * 失败
     * @param enumCode
     * @param data
     */
    public Result(EnumCode enumCode, T data) {
        if(enumCode==null){
            throw new IllegalArgumentException("EnumCode is null");
        }
        this.code = enumCode.getCode();
        this.msg = enumCode.getMsg();
        this.data = data;
    }

    /**
     * 失败
     * @param ex
     */
    public Result(Exception ex) {
        if(ex==null){
            throw new IllegalArgumentException("EnumCode is null");
        }
        this.code = CommonCode.EXCEPTION.getCode();
        this.msg = ex.getMessage();
    }

    /**
     * 判断是否业务成功，处理没有抛出异常，并且code为SUCCESS_CODE
     *
     * @return
     */
    public boolean isCodeSuccess() {
        return CommonCode.SUCCESS.getCode().equals(this.getCode());
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
