package com.bitium10.sso.dao;

import com.bitium10.sso.dao.api.UserDao;
import com.bitium10.sso.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: wylipengming
 * Date: 14-6-13
 * Time: 下午1:37
 * To change this template use File | Settings | File Templates.
 */

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public User findByLoginName(String loginName) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public User findOne(Long id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int deleteById(Long id) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int updatePasswordById(String newPassword, Long id) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int updateLoginInfo(String loginIp, Date loginDate, Long id) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
