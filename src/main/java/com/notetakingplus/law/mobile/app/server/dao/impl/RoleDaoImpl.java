package com.notetakingplus.law.mobile.app.server.dao.impl;

import com.notetakingplus.law.mobile.app.server.dao.RoleDao;
import com.notetakingplus.law.mobile.app.server.entity.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Role getById(int id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public int save(Role role) {
        entityManager.persist(role);
        return role.getId();
    }
}
