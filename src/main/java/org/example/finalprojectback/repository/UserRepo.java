package org.example.finalprojectback.repository;

import org.example.finalprojectback.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<User, Long> {
}
