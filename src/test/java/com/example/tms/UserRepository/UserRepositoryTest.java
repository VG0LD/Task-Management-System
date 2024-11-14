package com.example.tms.UserRepository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.example.tms.dto.exception.entity.User;
import com.example.tms.dto.exception.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindUserById() {
        User user = userRepository.findById(1L).orElse(null);
        assertNotNull(user);
    }
}
