package com.hostel.entrysystem.dto;

public class CheckOutRequest {
    private String rollNo;
    private String purpose;
    private String contactNumber;

    // Standard Getters and Setters for all three fields
    public String getRollNo() { return rollNo; }
    public void setRollNo(String rollNo) { this.rollNo = rollNo; }
    public String getPurpose() { return purpose; }
    public void setPurpose(String purpose) { this.purpose = purpose; }
    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }
}