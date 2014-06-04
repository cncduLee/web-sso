package com.bitium10.sso.utils;

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
}
