package com.bitium10.sso.client.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;

/**
 * <b>项目名</b>： web-sso <br>
 * <b>包名称</b>： com.bitium10.sso.client.utils <br>
 * <b>类名称</b>： HttpUtils <br>
 * <b>类描述</b>： <br>
 * <b>创建人</b>： <a href="mailto:shouli1990@gmail.com">李朋明</a> <br>
 * <b>修改人</b>： <br>
 * <b>创建时间</b>：2014/9/27 18:24
 * <b>修改时间</b>： <br>
 * <b>修改备注</b>： <br>
 *
 * @version 1.0.0 <br>
 */
public class HttpUtils {
    private static final String URL_PARAM_CONNECT_FLAG = "&";
    private static Logger log = LoggerFactory.getLogger(HttpUtils.class);

    public static List URLGet(String strUrl, Map map)
            throws IOException
    {
        String strtTotalURL = "";
        List result = new ArrayList();
        if (strUrl.indexOf("?") == -1)
            strtTotalURL = strUrl + "?" + getUrl(map, "GBK");
        else {
            strtTotalURL = strUrl + "&" + getUrl(map, "GBK");
        }

        URL url = new URL(strtTotalURL);
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setUseCaches(false);
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        while (true)
        {
            String line = in.readLine();
            if (line == null) {
                break;
            }
            result.add(line);
        }

        in.close();
        return result;
    }

    public static List URLGet(String strUrl, Map map, String encodeType)
            throws IOException
    {
        String strtTotalURL = "";
        List result = new ArrayList();
        if (strUrl.indexOf("?") == -1)
            strtTotalURL = strUrl + "?" + getUrl(map, encodeType);
        else {
            strtTotalURL = strUrl + "&" + getUrl(map, encodeType);
        }
        log.info("strtTotalURL:" + strtTotalURL);
        URL url = new URL(strtTotalURL);
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setConnectTimeout(30000);
        con.setReadTimeout(30000);
        con.setUseCaches(false);
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        while (true)
        {
            String line = in.readLine();
            if (line == null) {
                break;
            }
            result.add(line);
        }

        in.close();
        return result;
    }

    public static String URLGet(String strUrl)
            throws IOException
    {
        URL url = new URL(strUrl);
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setUseCaches(false);
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

        StringBuffer content = new StringBuffer();
        while (true) {
            String line = in.readLine();
            if (line == null) {
                break;
            }
            content.append(line);
        }

        in.close();
        return content.toString();
    }

    public static List URLPost(String strUrl, Map map)
            throws IOException
    {
        String content = "";
        content = getUrl(map, "GBK");

        URL url = new URL(strUrl);
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setDoInput(true);
        con.setDoOutput(true);
        con.setAllowUserInteraction(false);
        con.setUseCaches(false);
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=GBK");

        BufferedWriter bout = new BufferedWriter(new OutputStreamWriter(con.getOutputStream()));

        bout.write(content);
        bout.flush();
        bout.close();
        BufferedReader bin = new BufferedReader(new InputStreamReader(con.getInputStream()));

        List result = new ArrayList();
        while (true) {
            String line = bin.readLine();
            if (line == null) {
                break;
            }
            result.add(line);
        }

        bin.close();
        return result;
    }

    public static List URLPost(String strUrl, Map map, String encodeType)
            throws IOException
    {
        String content = "";
        content = getUrl(map, encodeType);

        URL url = new URL(strUrl);
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setDoInput(true);
        con.setDoOutput(true);
        con.setAllowUserInteraction(false);
        con.setUseCaches(false);
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=GBK");

        BufferedWriter bout = new BufferedWriter(new OutputStreamWriter(con.getOutputStream()));

        bout.write(content);
        bout.flush();
        bout.close();
        BufferedReader bin = new BufferedReader(new InputStreamReader(con.getInputStream()));

        List result = new ArrayList();
        while (true) {
            String line = bin.readLine();
            if (line == null) {
                break;
            }
            result.add(line);
        }

        bin.close();
        return result;
    }

    public static List URLPost(String strUrl, String content, String encodeType)
            throws IOException
    {
        URL url = new URL(strUrl);
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setDoInput(true);
        con.setDoOutput(true);
        con.setAllowUserInteraction(false);
        con.setUseCaches(false);
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");

        BufferedWriter bout = new BufferedWriter(new OutputStreamWriter(con.getOutputStream()));

        bout.write(content);
        bout.flush();
        bout.close();
        BufferedReader bin = new BufferedReader(new InputStreamReader(con.getInputStream()));

        List result = new ArrayList();
        while (true) {
            String line = bin.readLine();
            if (line == null) {
                break;
            }
            result.add(line);
        }

        bin.close();
        return result;
    }

    private static String getUrl(Map map, String encodeType)
    {
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
                if ((encodeType != null) && (encodeType.length() > 0)) {
                    try {
                        str = URLEncoder.encode(str, encodeType);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
                url.append(key).append("=").append(str).append("&");
            }
        }

        String strURL = "";
        strURL = url.toString();
        if ("&".equals("" + strURL.charAt(strURL.length() - 1)))
        {
            strURL = strURL.substring(0, strURL.length() - 1);
        }
        return strURL;
    }

    public static Map<String, Object> getUrlParams(String param)
    {
        Map map = new HashMap(0);
        String[] params = param.split("&");
        for (int i = 0; i < params.length; i++) {
            String[] p = params[i].split("=");
            if (p.length == 2) {
                map.put(p[0], p[1]);
            }
        }
        return map;
    }
}
