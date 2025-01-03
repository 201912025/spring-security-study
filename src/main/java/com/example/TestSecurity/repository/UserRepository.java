package com.example.TestSecurity.repository;

import com.example.TestSecurity.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    boolean existsByusername(String userName);

    UserEntity findByusername(String username);
}
