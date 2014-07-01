package com.bitium10.sso.utils;

import com.google.gson.Gson;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 * User: lpm【百墨】 shouli1990@gmail.com
 * Date: 14-6-4
 * Time: 下午5:57
 * To change this template use File | Settings | File Templates.
 */
public class StringTransition {
    private static final Logger logger = LoggerFactory.getLogger(StringTransition.class);

    public static Integer stringToInt(String str) {
        try {
            Integer result = Integer.parseInt(str);
            return result;
        } catch (NumberFormatException e) {
            logger.error("字符串转换错误 | error:{}" , e.getMessage(), e);
        }
        return null;
    }

    public static Long stringToLong(String str) {
        try {
            Long result = Long.parseLong(str);
            return result;
        } catch (NumberFormatException e) {
            logger.error("字符串转换错误 | error:{}" , e.getMessage(), e);
            return null;
        }
    }

    public static String toJson(Object obj){
        return new Gson().toJson(obj);
    }

    public static String trim(String src){
        if(null == src || "".equals(src.trim())){
            return null;
        }
        int sz = src.length();
        if(sz != 15 && sz != 18) return null;

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < sz; i++) {
            if (Character.isDigit(src.charAt(i)) == false) {
                return null; //非法字符，直接返回
            }
            if(i == 0 || i == (sz-1)){
                sb.append(src.charAt(i));
            }else{
                sb.append("*");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        Long s = System.currentTimeMillis();
        System.out.println(trim("511002198707127014"));
        System.out.println(System.currentTimeMillis() - s);
    }
}
