package com.bitium10.sso.client.listener;

import com.bitium10.sso.client.model.Configuration;
import com.bitium10.sso.client.utils.HttpClient;
import com.sun.javafx.collections.MappingChange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <b>项目名</b>： web-sso <br>
 * <b>包名称</b>： com.bitium10.sso.client.listener <br>
 * <b>类名称</b>： SsoSessionListener <br>
 * <b>类描述</b>： <br>
 * <b>创建人</b>： <a href="mailto:shouli1990@gmail.com">李朋明</a> <br>
 * <b>修改人</b>： <br>
 * <b>创建时间</b>：2014/9/27 21:06
 * <b>修改时间</b>： <br>
 * <b>修改备注</b>： <br>
 *
 * @version 1.0.0 <br>
 */
public class SsoSessionListener implements HttpSessionListener{
    private static final Logger logger = LoggerFactory.getLogger(SsoSessionListener.class);
    public static Map sessionContextMap = new ConcurrentHashMap();


    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        logger.info("[session created!]");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        String sessionId = session.getId();

        if (logger.isDebugEnabled()) {
            logger.debug("[SsoSessionListener>destroye session for sessionId: " + sessionId + "]");
        }

        if (null == sessionContextMap.get(sessionId)) {
            return;
        }

        sessionContextMap.remove(sessionId);

        HttpClient client = new HttpClient();
        Map params = new HashMap();
        params.put("sessionId", sessionId);
        params.put("serverId", Configuration.serviceName);
        try {
            String result = client.URLPost(Configuration.timeOutUrl, params, Configuration.encoding);
            logger.info("[SsoSessionListener>timeout for session : " + sessionId + ",result : " + result + "]");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.invalidate();
        }
    }
}
