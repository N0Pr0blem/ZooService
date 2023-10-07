package com.service.zoo.api.repo;

import com.service.zoo.api.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
