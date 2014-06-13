package com.bitium10.sso.dao;

import com.bitium10.sso.dao.api.ResourceDao;
import com.bitium10.sso.domain.Resource;
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
    @Override
    public int deleteById(Long id, String likeParentIds) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Resource> findByParentIdsLike(String parentIds) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Resource> findAllList() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Resource> findByUserId(Long userId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
