package com.service.zoo.api.repo;

import com.service.zoo.api.Entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByLogin(String name);
}
