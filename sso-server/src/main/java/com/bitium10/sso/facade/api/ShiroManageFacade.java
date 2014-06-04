package com.bitium10.sso.facade.api;

import com.bitium10.sso.common.ParamWrapper;
import com.bitium10.sso.common.Result;
import com.bitium10.sso.domain.UserLoginResult;

/**
 * Created with IntelliJ IDEA.
 * User:  lpm【百墨】 shouli1990@gmail.com
 * Date: 14-6-4
 * Time: 下午6:07
 * To change this template use File | Settings | File Templates.
 */
public interface ShiroManageFacade {

    /**
     * 登录
     * @param param
     * @return
     */
    public Result<UserLoginResult> login(ParamWrapper<String> param);

    /**
     * 增加账户错误点击次数
     * @param userName
     */
    public Result<String> increasePasswordWrongCount(ParamWrapper<String> userName);

}
