package com.notetakingplus.law.common.repository;

import com.notetakingplus.law.common.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUserName(String userName);

    User findByUserNameAndPassword(String userName, String password);
}
