package org.geeksforgeeks;

import org.geeksforgeeks.dao.UserRepository;
import org.geeksforgeeks.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Override
    public void run(String... strings) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String password = "vishal_root";
        String encoded_password = encoder.encode(password);

        User user = new User("vishal321", "Vishal", encoded_password, "website_get:website_create", true);

        userRepository.save(user);

        password = "piyush_root";
        encoded_password = encoder.encode(password);

        user = new User("piyush5807", "Piyush", encoded_password, "website_get:website_create:website_delete", true);

        userRepository.save(user);

        password = "robert_root";
        encoded_password = encoder.encode(password);
        user = new User("robert456", "Robert", encoded_password, "website_get", true);

        userRepository.save(user);
    }
}
