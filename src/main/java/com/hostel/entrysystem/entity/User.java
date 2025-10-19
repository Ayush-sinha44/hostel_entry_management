package com.hostel.entrysystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String rollNo;
    private String email;
    private String roomNo;
    private String hostelBlock;

    // NEW FIELD: User Category
    @Enumerated(EnumType.STRING)
    private UserType userType; 

    // Constructors
    public User() {}

    // Updated constructor with default role
    public User(String name, String rollNo, String email, String roomNo, String hostelBlock) {
        this.name = name;
        this.rollNo = rollNo;
        this.email = email;
        this.roomNo = roomNo;
        this.hostelBlock = hostelBlock;
        this.userType = UserType.STUDENT; // Default role
    }
    
    // New constructor to allow specifying the role
    public User(String name, String rollNo, String email, String roomNo, String hostelBlock, UserType userType) {
        this.name = name;
        this.rollNo = rollNo;
        this.email = email;
        this.roomNo = roomNo;
        this.hostelBlock = hostelBlock;
        this.userType = userType;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRollNo() { return rollNo; }
    public void setRollNo(String rollNo) { this.rollNo = rollNo; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getRoomNo() { return roomNo; }
    public void setRoomNo(String roomNo) { this.roomNo = roomNo; }

    public String getHostelBlock() { return hostelBlock; }
    public void setHostelBlock(String hostelBlock) { this.hostelBlock = hostelBlock; }

    // NEW Getter and Setter for UserType
    public UserType getUserType() { return userType; }
    public void setUserType(UserType userType) { this.userType = userType; }
}