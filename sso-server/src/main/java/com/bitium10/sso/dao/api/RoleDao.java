package com.bitium10.sso.dao.api;

import com.bitium10.sso.domain.Role;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wylipengming
 * Date: 14-6-13
 * Time: 下午1:42
 * To change this template use File | Settings | File Templates.
 */
public interface RoleDao {
    public Role findByName(String name);
    public int deleteById(Long id);
    public List<Role> findAllList();
    public List<Role> findByUserId(Long userId);
}
