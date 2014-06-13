package com.bitium10.sso.domain;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: wylipengming
 * Date: 14-6-13
 * Time: 上午9:32
 * To change this template use File | Settings | File Templates.
 */
public class BaseEntity implements Serializable{
    private static final long serialVersionUID = 1L;

    // 删除标记（0：正常；1：删除）
    public static final String DEL_FLAG_NORMAL = "0";
    public static final String DEL_FLAG_DELETE = "1";
    // 显示/隐藏
    public static final String SHOW = "1";
    public static final String HIDE = "0";

    // 是/否
    public static final String YES = "1";
    public static final String NO = "0";



}
