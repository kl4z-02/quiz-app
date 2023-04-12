package com.quizapp.quizapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quizapp.quizapp.models.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
