package com.bitium10.sso.client.regex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <b>项目名</b>： web-sso <br>
 * <b>包名称</b>： com.bitium10.sso.client.regex <br>
 * <b>类名称</b>： JavaRegexURL <br>
 * <b>类描述</b>： <br>
 * <b>创建人</b>： <a href="mailto:wylipengming@chinabank.com.cn">李朋明</a> <br>
 * <b>修改人</b>： <br>
 * <b>创建时间</b>：2014/9/27 18:34
 * <b>修改时间</b>： <br>
 * <b>修改备注</b>： <br>
 *
 * @version 1.0.0 <br>
 */
public class JavaRegexURL {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private String url;
    private Pattern pattern;
    private boolean isValidPattern = true;

    public JavaRegexURL(String url, boolean buildRegex) {
        this.url = url;

        if (buildRegex)
            try {
                this.pattern = Pattern.compile(this.url);
            } catch (Exception ex) {
                this.isValidPattern = false;
                this.logger.error(ex.getMessage());
            }
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass()) {
            return false;
        }
        JavaRegexURL other = (JavaRegexURL) obj;
        if (!other.isValidPattern) return false;

        Matcher matcher = other.pattern.matcher(this.url);
        if (matcher.find()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }
}
