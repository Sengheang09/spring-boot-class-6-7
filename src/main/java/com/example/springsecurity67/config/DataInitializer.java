package com.example.springsecurity67.config;

import com.example.springsecurity67.entity.User;
import com.example.springsecurity67.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    private UserRepository userRepository;

    public DataInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if(userRepository.findByUsername("admin").isEmpty()) {
            User admin = new User();

            admin.setUsername("admin");
            admin.setPassword("{noop}1234");
            admin.setRole("ROLE_ADMIN");
            admin.setEnabled(true);

            userRepository.save(admin);

        }

        if(userRepository.findByUsername("student").isEmpty()) {
            User student = new User();

            student.setUsername("student");
            student.setPassword("{noop}1234");
            student.setRole("ROLE_STUDENT");
            student.setEnabled(true);

            userRepository.save(student);
        }

    }
}








