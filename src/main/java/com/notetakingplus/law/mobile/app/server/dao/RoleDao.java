package com.notetakingplus.law.mobile.app.server.dao;

import com.notetakingplus.law.mobile.app.server.entity.Role;

public interface RoleDao {

    Role getById(int id);

    int save(Role role);
}
