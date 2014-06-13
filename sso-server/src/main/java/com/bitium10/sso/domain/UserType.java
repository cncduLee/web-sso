package com.bitium10.sso.domain;

/**
 * Created with IntelliJ IDEA.
 * User: wylipengming
 * Date: 14-6-13
 * Time: 下午12:38
 * To change this template use File | Settings | File Templates.
 */
public enum UserType {
    COMMON("一般用户");
    private String type;

    private UserType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
