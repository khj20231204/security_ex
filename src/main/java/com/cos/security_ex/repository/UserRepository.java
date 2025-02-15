package com.cos.security_ex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cos.security_ex.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
   
}
