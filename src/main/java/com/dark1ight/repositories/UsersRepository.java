package com.dark1ight.repositories;

import com.dark1ight.entities.Users;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<Users, Long> {
    Users findByLogin(String login);
}
