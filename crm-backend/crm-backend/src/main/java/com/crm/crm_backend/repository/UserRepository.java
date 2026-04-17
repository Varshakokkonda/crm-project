package com.crm.crm_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crm.crm_backend.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}