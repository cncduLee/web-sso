package com.bitium10.sso.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User:  lpm【百墨】 shouli1990@gmail.com
 * Date: 14-6-4
 * Time: 下午7:18
 * To change this template use File | Settings | File Templates.
 */
public class ParamWrapperFactory {

    public static ParamWrapper getQueryParamWrapper(HttpServletRequest request, HttpServletResponse response, Object data) {
        return getModifyOrDeleteParamWrapper(request, response, data, null);
    }

    public static ParamWrapper getModifyOrDeleteParamWrapper(HttpServletRequest request, HttpServletResponse response, Object data, String businessNo) {
        BusinessLogParam logParam = AccountUtils.getInstance().getBusinessLogParam(businessNo, request, response);
        ParamWrapper paramWrapper = new ParamWrapper(logParam, data);
        return paramWrapper;
    }
}
