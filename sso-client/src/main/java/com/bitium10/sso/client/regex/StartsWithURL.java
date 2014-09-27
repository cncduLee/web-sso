package com.bitium10.sso.client.regex;

/**
 * <b>项目名</b>： web-sso <br>
 * <b>包名称</b>： com.bitium10.sso.client.regex <br>
 * <b>类名称</b>： StartsWithURL <br>
 * <b>类描述</b>： <br>
 * <b>创建人</b>： <a href="mailto:wylipengming@chinabank.com.cn">李朋明</a> <br>
 * <b>修改人</b>： <br>
 * <b>创建时间</b>：2014/9/27 18:36
 * <b>修改时间</b>： <br>
 * <b>修改备注</b>： <br>
 *
 * @version 1.0.0 <br>
 */
public class StartsWithURL {
    private String url;

    public StartsWithURL(String url) {
        this.url = url;
    }

    public int hashCode() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        StartsWithURL other = (StartsWithURL) obj;
        if (this.url.startsWith(other.url)) return true;
        return false;
    }
}
