package com.bitium10.sso.client.service;

import com.bitium10.sso.client.common.exception.SSOException;
import com.bitium10.sso.client.model.Configuration;
import com.bitium10.sso.client.model.User;
import com.bitium10.sso.client.utils.Base64;
import com.bitium10.sso.client.utils.HttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * <b>项目名</b>： web-sso <br>
 * <b>包名称</b>： com.bitium10.sso.client.service <br>
 * <b>类名称</b>： LoginService <br>
 * <b>类描述</b>： <br>
 * <b>创建人</b>： <a href="mailto:wylipengming@chinabank.com.cn">李朋明</a> <br>
 * <b>修改人</b>： <br>
 * <b>创建时间</b>：2014/9/27 20:59
 * <b>修改时间</b>： <br>
 * <b>修改备注</b>： <br>
 *
 * @version 1.0.0 <br>
 */
public class LoginService {
    private static Logger logger = LoggerFactory.getLogger(LoginService.class);

    public static User getUserinfo(Map params) throws SSOException {
        try {
            HttpClient client = new HttpClient();
            String result = client.URLPost(Configuration.userinfoUrl, params, Configuration.encoding);
            result = new String(Base64.decode(result), "utf-8");
            logger.info("[LoginService get userinfo result : " + result + "]");
            return new User(result);
        } catch (Exception e) {
            throw new SSOException("100002", e.getMessage());
        }
    }

    public static String buildLoginUrl(HttpServletRequest request, String sessionId) throws UnsupportedEncodingException {
        StringBuffer jumpUrl = new StringBuffer(Configuration.loginUrl);
        String url = "";

        if ("1".equals(Configuration.forceToIndex)) {
            url = Configuration.clientIndexUrl;
        } else {
            String query = "?" + request.getQueryString();
            url = request.getRequestURL().toString() + query;
        }

        jumpUrl.append("?url=").append(URLEncoder.encode(url, Configuration.encoding)).append("&sessionId=").append(URLEncoder.encode(sessionId, Configuration.encoding)).append("&serverId=").append(URLEncoder.encode(Configuration.serviceName, Configuration.encoding));

        return jumpUrl.toString();
    }

    public static String buildErrUrl(String err) throws UnsupportedEncodingException {
        StringBuffer jumpUrl = new StringBuffer(Configuration.error);
        jumpUrl.append("?err=").append(URLEncoder.encode(err, Configuration.encoding));
        return jumpUrl.toString();
    }
}
