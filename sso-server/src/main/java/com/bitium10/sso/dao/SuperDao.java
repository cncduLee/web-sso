package com.bitium10.sso.dao;

import com.bitium10.sso.common.BasePageParam;
import com.bitium10.sso.common.Page;
import com.bitium10.sso.dao.api.ISuperDao;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: wylipengming
 * Date: 14-6-13
 * Time: 上午10:33
 * To change this template use File | Settings | File Templates.
 */
@Repository("superDao")
public class SuperDao extends SqlSessionDaoSupport implements ISuperDao {
    private static Logger logger = LoggerFactory.getLogger(SuperDao.class);

    @Override
    public Integer update(String statementName, Object parameterObject) {
        return this.getSqlSession().update(statementName, parameterObject);
    }

    @Override
    public Integer delete(String statementName, Object parameterObject) {
        return this.getSqlSession().delete(statementName, parameterObject);
    }

    @Override
    public int insert(String statementName, Object param) {
        return this.getSqlSession().insert(statementName, param);
    }

    @Override
    public <T> List<T> getList(String statementName, Object parameterObject) {
        return this.getSqlSession().selectList(statementName,parameterObject);
    }

    @Override
    public <T, V> Map<T, V> getMap(String statementName, Object parameterObject, String key) {
        return this.getSqlSession().selectMap(statementName, parameterObject, key);
    }

    @Override
    public <T> T getObject(String statementName, Object parameterObject) {
        return (T)this.getSqlSession().selectOne(statementName,parameterObject);
    }

    @Override
    public Page queryPagination(String statementName, BasePageParam param) {
        if(param.getPageNo() == null || param.getPageNo().intValue() < 1) {
            param.setPageNo(BasePageParam.DEFAULT_PAGE_NUM);
        }
        if(param.getPageSize() == null || param.getPageSize().intValue()<1) {
            param.setPageSize(BasePageParam.DEFAULT_PAGE_SIZE);
        }
        //get count
        int totalCount = (Integer)this.getSqlSession().selectOne(statementName + "--count",param);

        if(param.getPageSize() < 1){
            //小于1时直接查询全部记录
            param.setStartIdx(0);
            param.setEndIdx(totalCount);

        }else {
            // 计算记录起始值和结束值
            param.setEndIdx(param.getPageSize() * param.getPageNo());
            param.setStartIdx(param.getPageSize() * (param.getPageNo()- 1));
        }
        //query
        List data = this.getSqlSession().selectList(statementName, param);
        //set values
        Page page = new Page();
        page.setPageSize(param.getPageSize());
        page.setPageNo(param.getPageNo());
        page.setTotalCount(totalCount);
        page.setData(data);
        //return
        return page;
    }
}
