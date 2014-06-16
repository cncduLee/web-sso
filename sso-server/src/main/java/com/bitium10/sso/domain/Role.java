package com.bitium10.sso.domain;

import com.google.common.collect.Lists;

import java.util.List;

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
    private String delFlag;// 删除标记（0：正常；1：删除）
    private List<Resource> menuList = Lists.newArrayList(); // 拥有菜单列表

    public Role() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getModule() {
        return module;
    }

    public void setModule(Long module) {
        this.module = module;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public List<Resource> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Resource> menuList) {
        this.menuList = menuList;
    }

    public static List<Long> getRoleIds(List<Role> roles){
        List<Long> roleIds = Lists.newArrayList();
        if(roles != null && !roles.isEmpty()){
            for(Role role : roles){
                roleIds.add(role.getId());
            }
        }
        return roleIds;
    }
}
