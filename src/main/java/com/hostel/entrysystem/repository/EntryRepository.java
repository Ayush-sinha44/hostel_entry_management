package com.hostel.entrysystem.repository;

import com.hostel.entrysystem.entity.Entry;
import com.hostel.entrysystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional; // <--- Import this

@Repository
public interface EntryRepository extends JpaRepository<Entry, Long> {
    
    // 2. Find the most recent open entry for a specific user
    Optional<Entry> findFirstByUserAndInTimeIsNullOrderByOutTimeDesc(User user); 
}