package com.notetakingplus.law.mobile;

import com.notetakingplus.law.common.entity.Role;
import com.notetakingplus.law.mobile.dao.RoleDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MobileApplicationTests {

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
