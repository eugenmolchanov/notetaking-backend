package com.notetakingplus.law.common.repository;

import com.notetakingplus.law.common.entity.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Integer> {

    Optional<Role> findByName(String name);
}
