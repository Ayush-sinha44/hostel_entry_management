package com.hostel.entrysystem.service;

import com.hostel.entrysystem.dto.CheckOutRequest;
import com.hostel.entrysystem.entity.Entry;
import com.hostel.entrysystem.entity.User;
import com.hostel.entrysystem.repository.EntryRepository;
import com.hostel.entrysystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class EntryService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EntryRepository entryRepository;

    // Logic for creating a new check-out record
    public Entry logCheckOut(CheckOutRequest request) {
        // Find the user or throw an exception
        User user = userRepository.findByRollNo(request.getRollNo())
                .orElseThrow(() -> new RuntimeException("User not found with roll number: " + request.getRollNo()));
        
        // Check if user already has an open entry (prevents double check-out)
        if (entryRepository.findFirstByUserAndInTimeIsNullOrderByOutTimeDesc(user).isPresent()) {
            throw new RuntimeException("User already has an open check-out record.");
        }

        Entry newEntry = new Entry();
        newEntry.setUser(user);
        newEntry.setPurpose(request.getPurpose());
        newEntry.setContactNumber(request.getContactNumber());
        newEntry.setOutTime(LocalDateTime.now()); 
        // inTime is left null (default), indicating an open entry

        return entryRepository.save(newEntry);
    }

    // Logic for updating the most recent open record (Check-in)
    public Entry logCheckIn(String rollNo) {
        // Find the user
        User user = userRepository.findByRollNo(rollNo)
                .orElseThrow(() -> new RuntimeException("User not found with roll number: " + rollNo));

        // Find the single open entry for the user
        Entry openEntry = entryRepository.findFirstByUserAndInTimeIsNullOrderByOutTimeDesc(user)
                .orElseThrow(() -> new RuntimeException("No open check-out record found for roll number: " + rollNo));

        // Update the entry
        openEntry.setInTime(LocalDateTime.now());

        return entryRepository.save(openEntry);
    }
}