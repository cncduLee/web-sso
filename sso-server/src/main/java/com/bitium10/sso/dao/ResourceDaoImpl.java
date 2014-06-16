package com.bitium10.sso.dao;

import com.bitium10.sso.dao.api.ResourceDao;
import com.bitium10.sso.domain.Resource;
import com.bitium10.sso.domain.Role;
import com.google.common.collect.Lists;
import com.mchange.v1.util.ArrayUtils;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wylipengming
 * Date: 14-6-13
 * Time: 下午4:53
 * To change this template use File | Settings | File Templates.
 */
@Repository("resourceDao")
public class ResourceDaoImpl implements ResourceDao {
    private static Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Autowired
    private SuperDao superDao;

    @Override
    public int deleteById(Long id, String likeParentIds) {
        return 0;
    }

    @Override
    public List<Resource> findByParentIdsLike(String parentIds) {
        return null;
    }

    @Override
    public List<Resource> findAllList() {
        return superDao.getSqlSession().selectList("Resource.findAll");
    }

    @Override
    public List<Resource> findByUserId(Long userId) {
        List<Role> roles =  superDao.getSqlSession().selectList("Role.findByUserId",userId);
        return superDao.getSqlSession().selectList("Resource.findByUserId",Role.getRoleIds(roles));
    }
}
