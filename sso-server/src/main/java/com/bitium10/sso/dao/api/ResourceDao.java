package com.bitium10.sso.dao.api;

import com.bitium10.sso.domain.Resource;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wylipengming
 * Date: 14-6-13
 * Time: 下午1:40
 * To change this template use File | Settings | File Templates.
 */
public interface ResourceDao {
    public int deleteById(Long id, String likeParentIds);
    public List<Resource> findByParentIdsLike(String parentIds);
    public List<Resource> findAllList();
    public List<Resource> findByUserId(Long userId);
}
