package com.bitium10.sso.domain;

/**
 * Created with IntelliJ IDEA.
 * User:  lpm【百墨】 shouli1990@gmail.com
 * Date: 14-6-5
 * Time: 下午3:29
 * To change this template use File | Settings | File Templates.
 */
public class Role extends BaseEntity{
    private static final long serialVersionUID = 1L;

    private Long id;	   // 编号
    private Long module; //所属模块Id
    private String name;   // 角色名称
    private String status; //是否可用
    private String delFlag;// 删除标记（0：正常；1：删除）


}
