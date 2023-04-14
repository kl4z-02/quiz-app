package com.quizapp.quizapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quizapp.quizapp.models.User;

public interface UserRepository extends JpaRepository<User, Long>{
    List<User> findByUsernameOrderByUID(String username);

}
