package com.notetakingplus.law.mobile.dao.impl;

import com.notetakingplus.law.common.entity.Role;
import com.notetakingplus.law.mobile.dao.RoleDao;
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
