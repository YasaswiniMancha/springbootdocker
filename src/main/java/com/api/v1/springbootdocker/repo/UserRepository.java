// src/main/java/com/example/dockerspringdemo/repository/UserRepository.java
package com.api.v1.springbootdocker.repo;

import com.api.v1.springbootdocker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}