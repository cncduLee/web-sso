package com.bitium10.sso.dao.api;

import com.bitium10.sso.domain.User;
import com.bitium10.sso.service.SystemService;
import com.google.gson.Gson;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created with IntelliJ IDEA.
 * User:  lpm【百墨】 shouli1990@gmail.com
 * Date: 14-6-14
 * Time: 上午9:37
 * To change this template use File | Settings | File Templates.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class UserDaoTest {

    @Autowired
    private SystemService systemService;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testFindByLoginName() throws Exception {
        String loginName =  "admin";
        User user = systemService.getUserByLoginName(loginName);
        Assert.assertNotNull(user);
        Assert.assertEquals(loginName, user.getLoginName());
        System.out.println(new Gson().toJson(user));
    }

    @Test
    public void testFindOne() throws Exception {

    }

    @Test
    public void testDeleteById() throws Exception {

    }

    @Test
    public void testUpdatePasswordById() throws Exception {

    }

    @Test
    public void testUpdateLoginInfo() throws Exception {

    }
}
