package com.bitium10.sso.dao;

import com.bitium10.sso.dao.api.RoleDao;
import com.bitium10.sso.domain.Role;
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
    @Override
    public Role findByName(String name) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int deleteById(Long id) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Role> findAllList() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Role> findByUserId(Long userId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
