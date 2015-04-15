package com.bitium10.sso.client.common.exception;

/**
 * <b>项目名</b>： web-sso <br>
 * <b>包名称</b>： com.bitium10.sso.client.common.exception <br>
 * <b>类名称</b>： SSOException <br>
 * <b>类描述</b>： <br>
 * <b>创建人</b>： <a href="mailto:shouli1990@gmail.com">李朋明</a> <br>
 * <b>修改人</b>： <br>
 * <b>创建时间</b>：2014/9/27 18:11
 * <b>修改时间</b>： <br>
 * <b>修改备注</b>： <br>
 *
 * @version 1.0.0 <br>
 */
public class SSOException extends RuntimeException {

    private String code = "9999";

    public SSOException() {
    }
    public SSOException(String code) {
        this.code = code;
    }
    public SSOException(String code, String message) {
        super(message);
        this.code = code;
    }
    public String getCode() {
        return this.code;
    }

}
