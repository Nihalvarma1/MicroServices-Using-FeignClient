package com.ust.user_service.repository;

import com.ust.user_service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User,Long> {
    User findByUserid(Long userid);
}
