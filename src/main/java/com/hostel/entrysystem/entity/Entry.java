package com.hostel.entrysystem.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "entries")
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime outTime;
    private LocalDateTime inTime;
    private String purpose;
    private String contactNumber;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Constructors
    public Entry() {}

    public Entry(LocalDateTime outTime, LocalDateTime inTime, String purpose, String contactNumber, User user) {
        this.outTime = outTime;
        this.inTime = inTime;
        this.purpose = purpose;
        this.contactNumber = contactNumber;
        this.user = user;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getOutTime() { return outTime; }
    public void setOutTime(LocalDateTime outTime) { this.outTime = outTime; }

    public LocalDateTime getInTime() { return inTime; }
    public void setInTime(LocalDateTime inTime) { this.inTime = inTime; }

    public String getPurpose() { return purpose; }
    public void setPurpose(String purpose) { this.purpose = purpose; }

    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
