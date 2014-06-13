package com.bitium10.sso.domain;

/**
 * Created with IntelliJ IDEA.
 * User: wylipengming
 * Date: 14-6-13
 * Time: 上午9:41
 * 模块子系统
 */
public class Module extends BaseEntity{
    private static final long serialVersionUID = 1L;

    private Long id;		// 编号
    private String name; 	// 模块名称
    private String remarks; // 备注
    private String delFlag; // 删除标记（0：正常；1：删除）
    private AuthenticateType type;//认证类型

    public Module() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public AuthenticateType getType() {
        return type;
    }

    public void setType(AuthenticateType type) {
        this.type = type;
    }
}
