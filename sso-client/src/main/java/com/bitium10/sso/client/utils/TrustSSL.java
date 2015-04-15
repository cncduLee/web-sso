package com.bitium10.sso.client.utils;

import javax.net.ssl.*;
import java.io.*;
import java.net.ConnectException;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * <b>项目名</b>： web-sso <br>
 * <b>包名称</b>： com.bitium10.sso.client.utils <br>
 * <b>类名称</b>： TrustSSL <br>
 * <b>类描述</b>： <br>
 * <b>创建人</b>： <a href="mailto:shouli1990@gmail.com">李朋明</a> <br>
 * <b>修改人</b>： <br>
 * <b>创建时间</b>：2014/9/27 18:20
 * <b>修改时间</b>： <br>
 * <b>修改备注</b>： <br>
 *
 * @version 1.0.0 <br>
 */
public class TrustSSL {
    private static final String URL_PARAM_CONNECT_FLAG = "&";

    public String getHttpsURL(String url) throws Exception {
        String str_return = "";
        InputStream is = null;
        DataInputStream indata = null;
        BufferedReader bf = null;
        HttpsURLConnection conn = null;
        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, new TrustManager[]{new TrustAnyTrustManager()}, new SecureRandom());

            URL console = new URL(url);
            conn = (HttpsURLConnection) console.openConnection();
            conn.setSSLSocketFactory(sc.getSocketFactory());
            conn.setHostnameVerifier(new TrustAnyHostnameVerifier());
            conn.connect();
            conn.setConnectTimeout(30000);
            conn.setReadTimeout(30000);
            is = conn.getInputStream();
            indata = new DataInputStream(is);
            bf = new BufferedReader(new InputStreamReader(indata));
            String ret = "";

            while (ret != null) {
                ret = bf.readLine();
                if ((ret != null) && (!ret.trim().equals("")))
                    if (str_return.length() == 0)
                        str_return = ret;
                    else
                        str_return = str_return + "\n" + ret;
            }
        } catch (ConnectException e) {
            throw e;
        } catch (IOException e) {
            throw e;
        } finally {
            if (is != null)
                is.close();
            if (indata != null)
                indata.close();
            if (bf != null)
                bf.close();
            if (conn != null) {
                conn.disconnect();
            }
        }
        return str_return;
    }

    public String getHttpsURL(String url, Map map, String encodeType) throws Exception {
        String str_return = "";
        String strtTotalURL = "";
        InputStream is = null;
        DataInputStream indata = null;
        BufferedReader bf = null;
        HttpsURLConnection conn = null;
        if (url.indexOf("?") == -1)
            strtTotalURL = url + "?" + getUrl(map, encodeType);
        else {
            strtTotalURL = url + "&" + getUrl(map, encodeType);
        }
        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, new TrustManager[]{new TrustAnyTrustManager()}, new SecureRandom());

            URL console = new URL(strtTotalURL);
            conn = (HttpsURLConnection) console.openConnection();
            conn.setConnectTimeout(30000);
            conn.setReadTimeout(30000);
            conn.setUseCaches(false);
            conn.setSSLSocketFactory(sc.getSocketFactory());
            conn.setHostnameVerifier(new TrustAnyHostnameVerifier());
            conn.connect();
            is = conn.getInputStream();
            indata = new DataInputStream(is);
            bf = new BufferedReader(new InputStreamReader(indata));
            String ret = "";

            while (ret != null) {
                ret = bf.readLine();
                if ((ret != null) && (!ret.trim().equals("")))
                    if (str_return.length() == 0)
                        str_return = ret;
                    else
                        str_return = str_return + "\n" + ret;
            }
        } catch (ConnectException e) {
            throw e;
        } catch (IOException e) {
            throw e;
        } finally {
            if (is != null)
                is.close();
            if (indata != null)
                indata.close();
            if (bf != null)
                bf.close();
            if (conn != null)
                conn.disconnect();
        }
        return str_return;
    }

    private static String getUrl(Map map, String encodeType) {
        if ((null == map) || (map.keySet().size() == 0)) {
            return "";
        }
        StringBuffer url = new StringBuffer();
        Set keys = map.keySet();
        for (Iterator i = keys.iterator(); i.hasNext(); ) {
            String key = String.valueOf(i.next());
            if (map.containsKey(key)) {
                Object val = map.get(key);
                String str = val != null ? val.toString() : "";

                url.append(key).append("=").append(str).append("&");
            }
        }

        String strURL = "";
        strURL = url.toString();
        if ("&".equals("" + strURL.charAt(strURL.length() - 1))) {
            strURL = strURL.substring(0, strURL.length() - 1);
        }
        return strURL;
    }

    private static class TrustAnyHostnameVerifier implements HostnameVerifier {
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }

    private static class TrustAnyTrustManager implements X509TrustManager {
        public void checkClientTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }
}
