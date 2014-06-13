package com.bitium10.sso.domain;

/**
 * Created with IntelliJ IDEA.
 * User:  lpm【百墨】 shouli1990@gmail.com
 * Date: 14-6-5
 * Time: 下午3:29
 * 部门
 */
public class Department extends BaseEntity{
    private static final long serialVersionUID = 1L;

    private Long id;		// 编号
    private Long parent;	// 父级编号
    private String parentIds; // 所有父级编号
    private String code; 	// 区域编码
    private String name; 	// 区域名称
    private String remarks; // 备注
    private String delFlag; // 删除标记（0：正常；1：删除）

    public Department() {
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
