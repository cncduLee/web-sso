package com.bitium10.sso.client.servlet;

import com.bitium10.sso.client.common.exception.SSOException;
import com.bitium10.sso.client.listener.SsoSessionListener;
import com.bitium10.sso.client.model.Configuration;
import com.bitium10.sso.client.utils.Validations;
import com.sun.javafx.collections.MappingChange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * <b>项目名</b>： web-sso <br>
 * <b>包名称</b>： com.bitium10.sso.client.servlet <br>
 * <b>类名称</b>： LogoutInvokeServlet <br>
 * <b>类描述</b>： <br>
 * <b>创建人</b>： <a href="mailto:wylipengming@chinabank.com.cn">李朋明</a> <br>
 * <b>修改人</b>： <br>
 * <b>创建时间</b>：2014/9/27 21:45
 * <b>修改时间</b>： <br>
 * <b>修改备注</b>： <br>
 *
 * @version 1.0.0 <br>
 */
public class LogoutInvokeServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(LogoutInvokeServlet.class);

    public void init()
            throws ServletException {
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

        String sessionId = request.getParameter("jSessionId");
        logger.info("[LogoutInvokeServlet>logout invoke use sessionId :" + sessionId + "]");
        if (!Validations.checkSafe(sessionId)) {
            throw new SSOException("100005", "输入信息不合法");
        }

        Map map = SsoSessionListener.sessionContextMap;
        HttpSession session = (HttpSession) map.get(sessionId);

        if (null != session) {
            map.remove(sessionId);
            session.invalidate();
        }

        response.getWriter().write("OK");
    }

    public void destroy() {
        super.destroy();
    }
}
