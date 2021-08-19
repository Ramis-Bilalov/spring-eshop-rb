package com.bilalov.springeshoprb.service;

import com.bilalov.springeshoprb.domain.User;
import com.bilalov.springeshoprb.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService { // security

    boolean save(UserDTO userDTO);
    void save(User user);
    List<UserDTO> getAll();

    User findByName(String name);
    void updateProfile(UserDTO userDTO);
}
