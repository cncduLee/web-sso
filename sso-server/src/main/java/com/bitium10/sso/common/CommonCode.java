package com.bitium10.sso.common;

/**
 * Created with IntelliJ IDEA.
 * User:  lpm【百墨】 shouli1990@gmail.com
 * Date: 14-6-4
 * Time: 下午6:34
 * To change this template use File | Settings | File Templates.
 */
public enum CommonCode implements EnumCode{
    SUCCESS("成功"),
    FAILURE("失败"),
    INVALID_PARAM("参数错误"),
    EXCEPTION("异常");

    private String msg;

    private CommonCode(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return this.name();
    }

    public String getMsg() {
        return this.msg;
    }
}
