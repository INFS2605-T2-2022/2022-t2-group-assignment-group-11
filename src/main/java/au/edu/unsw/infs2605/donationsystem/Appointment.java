/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package au.edu.unsw.infs2605.donationsystem;

/**
 *
 * @author khanhlinh0907
 */
public class Appointment {
    private String firstName;
    private String lastName;
    private String gender;
    private String emailAddress;
    private String dateOfBirth;
    private String mobile;
    private String address;
    private String bookingDate;
    private String bookingTime;
    private String donorCentre;
    private String donationType;
    private String donationStatus; 
    private String name;
   
    //Constructor
    public Appointment() {
        
    }
    
    public Appointment(String firstName, String lastName, String bookingDate, 
            String bookingTime) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.name = firstName + " " + lastName;
    }
    
    public Appointment(String firstName, String lastName, String bookingDate, 
            String bookingTime, String donorCentre, String donationType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.donorCentre = donorCentre;
        this.donationType = donationType;
    }
    
    //Getter and Setter methods
    public String getName() {    
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //firstName
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    //lastName
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    //bookingDate
    public String getBookingDate() {
        return bookingDate;
    }
    
    public void setBookingDate(String bookingDate) {
            this.bookingDate = bookingDate;
    }
    
    //bookingTime
    public String getBookingTime() {
        return bookingTime;
    }
    
    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }
    
    //donorCentre
    public String getDonorCentre() {
        return donorCentre;
    }
    
    public void setDonorCentre(String donorCentre) {
        this.donorCentre = donorCentre;
    }   
    
    //donationType
    public String getDonationType() {
        return donationType;
    }
    
    public void setDonationType(String donationType) {
        this.donationType = donationType;
    }     
    
    //donationStatus
    public String getDonationStatus() {
        return donationStatus;
    }
    
    public void setDonationStatus(String donationStatus) {
        this.donationStatus = donationStatus;
    }
    
    //email
    public String getEmail() {
        return emailAddress;
    }
    
    public void setEmail(String email) {
        this.emailAddress = email;
    }
    
    //dob
    public String getDOB() {
        return dateOfBirth;
    }
    
    public void setDOB(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    //mobile
    public String getMobile() {
        return mobile;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    //address
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    //gender
    public String getGender() {
        return gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    } 
}
