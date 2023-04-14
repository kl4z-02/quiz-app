package com.quizapp.quizapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.quizapp.quizapp.models.User;
import com.quizapp.quizapp.repositories.UserRepository;
import com.quizapp.quizapp.services.UserService;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UserRepositoryTest{
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private UserService userService;

    @Test
    public void givenUserSaveThenReturn(){
        User user = User.builder().username("abc").password("null").build();
        User saved = userRepository.save(user);
        Assertions.assertNotNull(saved);
        Assertions.assertEquals(saved.getUsername(), "abc");
    }

    @Test
    public void givenUserIdFindById(){
        User user = User.builder().username("abc").password("null").build();
        userRepository.save(user);
        User t = userRepository.findById(user.getUID()).get();
        Assertions.assertNotNull(t);
    }

    @Test
    public void givenUserLogin(){
        User user = User.builder().username("abc").password("null").build();
        User s = userRepository.save(user);
        User user1 = User.builder().username("abc").password("null").build();
        User user2 = User.builder().username("abc").password("1null").build();
        // Assertions.assertEquals(userRepository.findByUsername("abc").get(1), user);
        // Assertions.assertEquals(userRepository.findByUsername("abc").get(1).getPassword(), user1.getPassword());
        Assertions.assertEquals(s.getPassword(), user1.getPassword());
        Assertions.assertFalse(userService.validate(user2));
        Assertions.assertTrue(userService.validate(user1));
    }

}
