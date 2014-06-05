package com.bitium10.sso.facade;

import com.bitium10.sso.common.ParamWrapper;
import com.bitium10.sso.common.Result;
import com.bitium10.sso.domain.UserLoginResult;
import com.bitium10.sso.facade.api.ShiroManageFacade;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User:  lpm【百墨】 shouli1990@gmail.com
 * Date: 14-6-4
 * Time: 下午6:07
 * To change this template use File | Settings | File Templates.
 */

@Service("shiroManageFacade")
public class ShiroManageFacadeImpl implements ShiroManageFacade {


    @Override
    public Result<UserLoginResult> login(ParamWrapper<String> param) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Result<String> increasePasswordWrongCount(ParamWrapper<String> userName) {
        return null;//To change body of implemented methods use File | Settings | File Templates.
    }
}
