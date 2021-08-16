package com.bilalov.springeshoprb.service;

import com.bilalov.springeshoprb.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService { // security

    boolean save (UserDTO userDTO);
}
