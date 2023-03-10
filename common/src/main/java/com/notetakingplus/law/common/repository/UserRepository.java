package com.notetakingplus.law.common.repository;

import com.notetakingplus.law.common.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findByEmailAddress(String emailAddress);
}
