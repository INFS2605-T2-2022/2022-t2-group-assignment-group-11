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
    private String bookingDate;
    private String bookingTime;
    private String donorCentre;
    private String donationType;
    private String donationStatus; 
   
    //Constructor
    public Appointment() {
        
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
}
