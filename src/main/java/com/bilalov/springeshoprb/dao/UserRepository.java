package com.bilalov.springeshoprb.dao;

import com.bilalov.springeshoprb.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findFirstByName(String name);


}
