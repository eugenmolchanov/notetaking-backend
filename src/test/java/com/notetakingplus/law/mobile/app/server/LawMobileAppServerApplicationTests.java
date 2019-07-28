package com.notetakingplus.law.mobile.app.server;

import com.notetakingplus.law.mobile.app.server.dao.RoleDao;
import com.notetakingplus.law.mobile.app.server.entity.Role;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class LawMobileAppServerApplicationTests {

    @Autowired
    private RoleDao roleDao;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test() {
        Role role = new Role();
        role.setName("admin");

        int id = roleDao.save(role);

        Assert.assertEquals(id, roleDao.getById(id).getId().intValue());
    }
}
