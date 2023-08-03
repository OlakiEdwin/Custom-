package com.olakiedwin.CustomLogin.service;

import com.olakiedwin.CustomLogin.entity.CustomUserDetails;
import com.olakiedwin.CustomLogin.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        var user = userRepo.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("User unavailable")
        );
        return new CustomUserDetails(user);
    }
}
