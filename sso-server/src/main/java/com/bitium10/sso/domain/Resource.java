package com.bitium10.sso.domain;

/**
 * Created with IntelliJ IDEA.
 * User:  lpm【百墨】 shouli1990@gmail.com
 * Date: 14-6-5
 * Time: 下午3:30
 * To change this template use File | Settings | File Templates.
 */
public class Resource extends BaseEntity{
    private static final long serialVersionUID = 1L;

    private Long id;		// 编号
    private Long moduleId;  // 所属模块（系统）
    private Long parent;    // 父级菜单
    private String parentIds;// 所有父级编号
    private String type;    //类型
    private String name; 	// 名称
    private String href; 	// 链接
    private String target; 	// 目标（ mainFrame、_blank、_self、_parent、_top）
    private String icon; 	// 图标
    private Integer sort; 	// 排序
    private String isShow; 	// 是否在菜单中显示（1：显示；0：不显示）
    private String permission; // 权限标识
    private String delFlag; // 删除标记（0：正常；1：删除）

    public Resource() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getShow() {
        return isShow;
    }

    public void setShow(String show) {
        isShow = show;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}
