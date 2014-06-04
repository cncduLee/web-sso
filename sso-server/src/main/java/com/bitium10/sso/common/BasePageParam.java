package com.bitium10.sso.common;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User:  lpm【百墨】 shouli1990@gmail.com
 * Date: 14-6-4
 * Time: 下午6:23
 * To change this template use File | Settings | File Templates.
 */
public class BasePageParam implements Serializable{
    /**
     * 默认分页大小
     */
    public static final int DEFAULT_PAGE_SIZE = 20;

    /**
     * 默认页码
     */
    public static final int DEFAULT_PAGE_NUM = 1;

    private Integer pageSize = DEFAULT_PAGE_SIZE;

    private Integer pageNo = DEFAULT_PAGE_NUM;

    public BasePageParam() {
    }

    public BasePageParam(Integer pageSize, Integer pageNo) {
        super();
        this.pageSize = pageSize;
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }
}
