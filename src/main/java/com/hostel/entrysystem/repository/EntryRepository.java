package com.hostel.entrysystem.repository;

import com.hostel.entrysystem.entity.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntryRepository extends JpaRepository<Entry, Long> {
    // You can add custom queries later if needed
}
