package com.bitium10.sso.dao.api;

import com.bitium10.sso.domain.User;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: wylipengming
 * Date: 14-6-13
 * Time: 下午1:38
 * To change this template use File | Settings | File Templates.
 */
public interface UserDao {
    public User findByLoginName(String loginName);
    public User findOne(Long id);
    public int deleteById(Long id);
    public int updatePasswordById(String newPassword, Long id);
    public int updateLoginInfo(String loginIp, Date loginDate, Long id);

}
