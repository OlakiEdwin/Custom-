package com.olakiedwin.CustomLogin.entity;

import com.olakiedwin.CustomLogin.entity.User;
import com.olakiedwin.CustomLogin.repository.UserRepo;
import com.olakiedwin.CustomLogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserCommandLineRunner implements CommandLineRunner {

    private final UserRepo userRepository;

    private final UserService userService;
    @Autowired
    public UserCommandLineRunner(UserRepo userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {

        String username = "Olaki21";
        String password = "olaki2001";

        Optional<User> existingUser = userRepository.findByUsername(username);

        if (existingUser.isPresent()) {
            User user = existingUser.get();
            userService.changePassword(password, user);
            System.out.println("User password changed successfully.");
        } else {
            User newUser = new User();
            newUser.setUsername(username);
            newUser.setPassword(password);
            userRepository.save(newUser);
            System.out.println("New user created successfully.");
        }
    }
}
