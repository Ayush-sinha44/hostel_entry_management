package com.hostel.entrysystem.repository;

import com.hostel.entrysystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional; // <--- Import this

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    // 1. Find a User by their Roll Number
    Optional<User> findByRollNo(String rollNo); 
}