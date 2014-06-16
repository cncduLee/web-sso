package com.bitium10.sso.dao;

import com.bitium10.sso.dao.api.RoleDao;
import com.bitium10.sso.domain.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wylipengming
 * Date: 14-6-13
 * Time: 下午4:54
 * To change this template use File | Settings | File Templates.
 */
@Repository("roleDao")
public class RoleDaoImpl implements RoleDao {
    private static Logger logger = LoggerFactory.getLogger(RoleDaoImpl.class);

    @Autowired
    private SuperDao superDao;

    @Override
    public Role findByName(String name) {
        return superDao.getSqlSession().selectOne("Role.findByName",name);
    }

    @Override
    public int deleteById(Long id) {
        return 0;
    }

    @Override
    public List<Role> findAllList() {
        return superDao.getSqlSession().selectList("Role.findAll");
    }

    @Override
    public List<Role> findByUserId(Long userId) {
        return superDao.getSqlSession().selectList("Role.findByUserId",userId);
    }
}
