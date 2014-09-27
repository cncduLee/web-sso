package com.bitium10.sso.client.regex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>项目名</b>： web-sso <br>
 * <b>包名称</b>： com.bitium10.sso.client.regex <br>
 * <b>类名称</b>： URLCollections <br>
 * <b>类描述</b>： <br>
 * <b>创建人</b>： <a href="mailto:wylipengming@chinabank.com.cn">李朋明</a> <br>
 * <b>修改人</b>： <br>
 * <b>创建时间</b>：2014/9/27 18:38
 * <b>修改时间</b>： <br>
 * <b>修改备注</b>： <br>
 *
 * @version 1.0.0 <br>
 */
public class URLCollections {
    private static final Logger logger = LoggerFactory.getLogger(URLCollections.class);
    public static final boolean DEBUG = false;

    public Map<String, RegexURL> pureURLs = new HashMap();
    public Map<JavaRegexURL, RegexURL> regexURLs = new HashMap();
    public Map<StartsWithURL, RegexURL> startsWithURLs = new HashMap();

    public void newAction(RegexURL.UrlType urlType, String urlValue) {
        newAction(new RegexURL(urlType, urlValue));
    }

    public void newAction(RegexURL url) {
        switch (url.getUrlType()){
            case REGEX:
                this.pureURLs.put(url.getUrlValue(), url);
                break;
            case URL:
                this.regexURLs.put(new JavaRegexURL(url.getUrlValue(), true), url);
                break;
            case StartsWith:
                this.startsWithURLs.put(new StartsWithURL(url.getUrlValue()), url);
                break;
        }
    }

    public boolean invoke(String url) {
        if (!url.startsWith("/")) {
            url = "/" + url;
        }

        RegexURL o = null;

        o = (RegexURL) this.pureURLs.get(url);
        if (null != o) {
            logger.debug("Match:" + url + "\t With:" + o);
            return true;
        }

        StartsWithURL requestStartsWith = new StartsWithURL(url);
        o = (RegexURL) this.startsWithURLs.get(requestStartsWith);
        if (null != o) {
            logger.debug("Match:" + url + "\t With:" + o);
            return true;
        }

        JavaRegexURL requestRegex = new JavaRegexURL(url, false);
        o = (RegexURL) this.regexURLs.get(requestRegex);
        if (null != o) {
            logger.debug("Match:" + url + "\t With:" + o);
            return true;
        }
        logger.info("Audit:" + url + " cannot passed!!!");

        return false;
    }
}
