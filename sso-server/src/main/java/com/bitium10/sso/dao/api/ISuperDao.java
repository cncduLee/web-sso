package com.bitium10.sso.dao.api;

import com.bitium10.sso.common.BasePageParam;
import com.bitium10.sso.common.Page;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: wylipengming
 * Date: 14-6-13
 * Time: 上午10:33
 * To change this template use File | Settings | File Templates.
 */
public interface ISuperDao {
    /**
     * Update or Insert into tables
     *
     * @param statementName   the input parameter
     * @param parameterObject the input parameter
     * @return the return update counts
     *         <p/>
     *         if business logic throws Exception
     */
    public Integer update(String statementName, Object parameterObject);


    /**
     * delete from the tables
     *
     * @param statementName   the input parameter
     * @param parameterObject the input parameter
     * @return the return value
     *         if business logic throws Exception
     */
    public Integer delete(String statementName, Object parameterObject);


    /**
     * Insert into tables
     *
     * @param statementName   the input parameter
     * @param param the input parameter
     * @return to return the object key
     *         if business logic throws Exception
     */
    public int insert(String statementName, Object param);


    /**
     * Gets the list of objects
     *
     * @param statementName   the sqlmap stateent name
     * @param parameterObject the input parameters object
     * @return The list of objects
     *         if business logic throws Exception
     */
    public <T> List<T> getList(String statementName, Object parameterObject);

    /**
     * Gets the result as a map
     *
     * @param statementName   the sqlmap stateent name
     * @param parameterObject the input parameters object
     * @param key             the key
     * @return The results as map
     *         if business logic throws Exception
     */
    public <T, V> Map<T, V> getMap(String statementName, Object parameterObject, String key);


    /**
     * Gets as an object
     *
     * @param statementName   the sqlmap stateent name
     * @param parameterObject the input parameters object
     * @return The object
     *         if business logic throws Exception
     */
    public <T> T getObject(String statementName, Object parameterObject);

    /**
     * get pagination list
     *
     * @param statementName
     * @param param
     * @return
     */

    public <T extends BasePageParam, R extends Page> R queryPagination(String statementName, T param);
}
