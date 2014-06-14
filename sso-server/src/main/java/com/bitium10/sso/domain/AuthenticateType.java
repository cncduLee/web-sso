package com.bitium10.sso.domain;

/**
 * Created with IntelliJ IDEA.
 * User: wylipengming
 * Date: 14-6-13
 * Time: 上午9:49
 * 认证类型
 */
public enum AuthenticateType {
    Password(0,"口令"),Certificate(1,"证书"),Other(2,"其他");

    private Integer code;
    private String name;
    private AuthenticateType(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
}
