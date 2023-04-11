package com.quizapp.quizapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quizapp.quizapp.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
}
