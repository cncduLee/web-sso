package com.bitium10.sso.client.regex;

/**
 * <b>项目名</b>： web-sso <br>
 * <b>包名称</b>： com.bitium10.sso.client.regex <br>
 * <b>类名称</b>： RegexURL <br>
 * <b>类描述</b>： <br>
 * <b>创建人</b>： <a href="mailto:wylipengming@chinabank.com.cn">李朋明</a> <br>
 * <b>修改人</b>： <br>
 * <b>创建时间</b>：2014/9/27 18:36
 * <b>修改时间</b>： <br>
 * <b>修改备注</b>： <br>
 *
 * @version 1.0.0 <br>
 */
public class RegexURL {
    private UrlType urlType;
    private String urlValue;

    public RegexURL(UrlType urlType, String urlValue) {
        this.urlType = urlType;
        this.urlValue = urlValue;
    }

    public UrlType getUrlType() {
        return this.urlType;
    }

    public void setUrlType(UrlType urlType) {
        this.urlType = urlType;
    }

    public String getUrlValue() {
        return this.urlValue;
    }

    public void setUrlValue(String urlValue) {
        this.urlValue = urlValue;
    }

    public String toString() {
        return "RegexURL [urlType=" + this.urlType + ", urlValue=" + this.urlValue + "]";
    }

    public static enum UrlType {
        REGEX,
        URL,
        StartsWith;
    }
}
