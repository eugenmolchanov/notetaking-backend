package com.notetakingplus.law.mobile.dao;


import com.notetakingplus.law.common.entity.Role;

public interface RoleDao {

    Role getById(int id);

    int save(Role role);
}
