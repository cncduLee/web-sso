package com.bitium10.sso.client.servlet;

import com.bitium10.sso.client.common.exception.SSOException;
import com.bitium10.sso.client.json.JSONObject;
import com.bitium10.sso.client.listener.SsoSessionListener;
import com.bitium10.sso.client.model.Configuration;
import com.bitium10.sso.client.utils.HttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * <b>项目名</b>： web-sso <br>
 * <b>包名称</b>： com.bitium10.sso.client.servlet <br>
 * <b>类名称</b>： LogoutServlet <br>
 * <b>类描述</b>： <br>
 * <b>创建人</b>： <a href="mailto:wylipengming@chinabank.com.cn">李朋明</a> <br>
 * <b>修改人</b>： <br>
 * <b>创建时间</b>：2014/9/27 21:42
 * <b>修改时间</b>： <br>
 * <b>修改备注</b>： <br>
 *
 * @version 1.0.0 <br>
 */
public class LogoutServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(LogoutServlet.class);

    public void init() throws ServletException {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding(Configuration.encoding);
        response.setCharacterEncoding(Configuration.encoding);
        response.setContentType("text/html");

        HttpSession session = request.getSession();
        String sessionId = session.getId();

        logger.info("[LogoutServlet>logou out use sessionId : " + sessionId + ",appName : " + Configuration.serviceName + "]");

        Map map = SsoSessionListener.sessionContextMap;
        map.remove(sessionId);
        session.invalidate();

        String logoutUrl = buildUrl(sessionId);
        if (logger.isDebugEnabled()) {
            logger.debug("[LogoutServlet>logout url : " + logoutUrl + "]");
        }
        boolean isValid = false;
        HttpClient client = new HttpClient();
        try {
            String result = client.URLGet(logoutUrl, null, Configuration.encoding);
            logger.info("[LogoutServlet>logout message from ssoServer : " + result + "]");

            isValid = validateResult(result);

            if (isValid) {
                response.sendRedirect(Configuration.clientIndexUrl);
            } else {
                throw new SSOException("100005", "logout failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean validateResult(String result)
            throws Exception {
        if ((null == result) || ("".equals(result))) {
            throw new SSOException("100005", "invoke logout,get null from ssoServer");
        }
        JSONObject obj = new JSONObject(result);
        String errorCode = obj.getString("errorCode");
        if (!"00000".equals(errorCode)) {
            throw new SSOException("100005", errorCode);
        }
        return true;
    }

    private String buildUrl(String sessionId) throws UnsupportedEncodingException {
        StringBuffer jumpUrl = new StringBuffer(Configuration.logoutUrl);

        jumpUrl.append("?serverId=").append(URLEncoder.encode(Configuration.serviceName, Configuration.encoding)).append("&sessionId=").append(URLEncoder.encode(sessionId, Configuration.encoding));

        return jumpUrl.toString();
    }

    public void destroy() {
        super.destroy();
    }
}
