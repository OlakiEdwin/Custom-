package com.olakiedwin.CustomLogin.service;

import com.olakiedwin.CustomLogin.entity.User;
import com.olakiedwin.CustomLogin.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepo userRepo;
    public void changePassword(String newPassword, User user){
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepo.save(user);
    }
}
