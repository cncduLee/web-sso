package com.bitium10.sso.client.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <b>项目名</b>： web-sso <br>
 * <b>包名称</b>： com.bitium10.sso.client.utils <br>
 * <b>类名称</b>： HttpClient <br>
 * <b>类描述</b>： <br>
 * <b>创建人</b>： <a href="mailto:wylipengming@chinabank.com.cn">李朋明</a> <br>
 * <b>修改人</b>： <br>
 * <b>创建时间</b>：2014/9/27 18:19
 * <b>修改时间</b>： <br>
 * <b>修改备注</b>： <br>
 *
 * @version 1.0.0 <br>
 */
public class HttpClient {
    private Logger log = LoggerFactory.getLogger(getClass().getName());

    public String URLGet(String strUrl, Map map, String encodeType) throws Exception
    {
        StringBuffer result = new StringBuffer();
        if ("https".equalsIgnoreCase(strUrl.substring(0, 5))) {
            TrustSSL mytrustssl = new TrustSSL();
            try {
                result.append(mytrustssl.getHttpsURL(strUrl, map, encodeType));
            } catch (Exception e) {
                log.error("error happened!",e);
            }
        } else {
            List list = new ArrayList();
            try {
                list = HttpUtils.URLGet(strUrl, map, encodeType);
            } catch (IOException e) {
                log.error("error happened!",e);
            }
            int i = 0;
            for (i = 0; i < list.size(); i++) {
                result.append(list.get(i).toString());
            }
        }
        return result.toString();
    }

    public String URLPost(String strUrl, Map map, String encodeType) throws Exception
    {
        StringBuffer result = new StringBuffer();
        if ("https".equalsIgnoreCase(strUrl.substring(0, 5))) {
            TrustSSL mytrustssl = new TrustSSL();
            try {
                result.append(mytrustssl.getHttpsURL(strUrl, map, encodeType));
            } catch (Exception e) {
                log.error("error happened!",e);
            }
        } else {
            List list = new ArrayList();
            try {
                list = HttpUtils.URLPost(strUrl, map, encodeType);
            } catch (IOException e) {
                log.error("error happened!",e);
            }
            int i = 0;
            for (i = 0; i < list.size(); i++) {
                result.append(list.get(i).toString());
            }
        }
        return result.toString();
    }
}
