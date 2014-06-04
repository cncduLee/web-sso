package com.bitium10.sso.common;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User:  lpm【百墨】 shouli1990@gmail.com
 * Date: 14-6-4
 * Time: 下午6:21
 * 业务日志参数
 */
public class BusinessLogParam implements Serializable{
    // 访问机器IP
    private String ip;

    // 访问计算机名
    private String computerName;

    // 操作人ID,(一般为登录名)
    private String operatorId;

    // 操作人
    private String operator;

    // 操作时间
    private Date operateTime;

    // 请求接口
    private String interfacePath;

    // 业务记录编号
    private String businessNo;

    // 模块编号
    private String moduleNo;

    // 模块名称
    private String moduleName;

    // 模块描述
    private String moduleDesc;

    // 是否成功
    private String result;

    // 操作结果
    private String status;

    // 操作结果描述
    private String statusDesc;

    public BusinessLogParam(String ip, String computerName, String operatorId, String operator, String businessNo) {
        this.ip = ip;
        this.computerName = computerName;
        this.operatorId = operatorId;
        this.operator = operator;
        this.businessNo = businessNo;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public String getInterfacePath() {
        return interfacePath;
    }

    public void setInterfacePath(String interfacePath) {
        this.interfacePath = interfacePath;
    }

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }

    public String getModuleNo() {
        return moduleNo;
    }

    public void setModuleNo(String moduleNo) {
        this.moduleNo = moduleNo;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleDesc() {
        return moduleDesc;
    }

    public void setModuleDesc(String moduleDesc) {
        this.moduleDesc = moduleDesc;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }
}
