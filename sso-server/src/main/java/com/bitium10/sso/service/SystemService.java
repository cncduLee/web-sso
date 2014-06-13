package com.bitium10.sso.service;

import com.bitium10.sso.dao.api.ResourceDao;
import com.bitium10.sso.dao.api.RoleDao;
import com.bitium10.sso.dao.api.UserDao;
import com.bitium10.sso.domain.Resource;
import com.bitium10.sso.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wylipengming
 * Date: 14-6-13
 * Time: 下午12:42
 * To change this template use File | Settings | File Templates.
 */
@Service("systemService")
public class SystemService {

    @Autowired
    private static UserDao userDao;
    @Autowired
    private static ResourceDao resourceDao;
    @Autowired
    private static RoleDao roleDao;

    public static final String HASH_ALGORITHM = "SHA-1";
    public static final int HASH_INTERATIONS = 1024;

    public User getUser(Long id) {
        return userDao.findOne(id);
    }

    public User getUserByLoginName(String loginName){
        return userDao.findByLoginName(loginName);
    }

    public List<Resource> findAllResources(){
        return UserService.getResourceList();
    }

}
