package com.bitium10.sso.service;

import com.bitium10.sso.common.Encodes;
import com.bitium10.sso.dao.api.ResourceDao;
import com.bitium10.sso.dao.api.RoleDao;
import com.bitium10.sso.dao.api.UserDao;
import com.bitium10.sso.domain.Resource;
import com.bitium10.sso.domain.User;
import com.bitium10.sso.shiro.Digests;
import com.bitium10.sso.shiro.ShiroDBRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wylipengming
 * Date: 14-6-13
 * Time: 下午12:42
 * To change this template use File | Settings | File Templates.
 */
@Component
@Transactional(readOnly = true)
public class SystemService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private ResourceDao resourceDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private ShiroDBRealm shiroDBRealm;

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
    /**
     * 验证密码
     * @param plainPassword 明文密码
     * @param password 密文密码
     * @return 验证成功返回true
     */
    public static boolean validatePassword(String plainPassword, String password) {
        byte[] salt = Encodes.decodeHex(password.substring(0, 16));
        byte[] hashPassword = Digests.sha1(plainPassword.getBytes(), salt, HASH_INTERATIONS);
        return password.equals(Encodes.encodeHex(salt) + Encodes.encodeHex(hashPassword));
    }

}
