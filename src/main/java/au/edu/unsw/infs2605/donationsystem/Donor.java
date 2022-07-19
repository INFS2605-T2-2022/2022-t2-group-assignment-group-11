/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package au.edu.unsw.infs2605.donationsystem;

/**
 *
 * @author khanhlinh0907
 */
public class Donor {
    //donor attributes
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String gender;
    private String bloodType;
    private String emailAddress;
    private String mobileNumber;
    private String address;
    private int bloodDonationCount;
    private int plasmaDonationCount;
    private String lastTimeUpdated;
    
    //Constructor
    public Donor() {

    }
    
    public Donor(String firstName, String lastName, String dateOfBirth, 
            String gender, String bloodType, String emailAddress,
            String mobileNumber, String address, int bloodDonationCount, 
            int plasmaDonationCount, String lastUpdatedTime) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.bloodType = bloodType;
        this.emailAddress = emailAddress;
        this.mobileNumber = mobileNumber;
        this.address = address;
        this.bloodDonationCount = bloodDonationCount;
        this.plasmaDonationCount = plasmaDonationCount;
        this.lastTimeUpdated = lastTimeUpdated;
        
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
    
    //dateOfBirth
    public String getDOB() {
        return dateOfBirth;
    }
    
    public void setDOB(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    //gender
    public String getGender() {
        return gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    //bloodType
    public String getBloodType() {
        return bloodType;
    }
    
    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }
    
    //emailAddress
    public String getEmail() {
        return emailAddress;
    }
    
    public void setEmail(String email) {
        this.emailAddress = email;
    }
    
    //mobileNumber
    public String getMobileNumber() {
        return mobileNumber;
    }
    
    public void setMobileNumber(String mobile) {
        this.mobileNumber = mobile;
    }
    
    //address
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    //bloodDonationCount
    public int getBloodDonationCount() {
        return bloodDonationCount;
    }
    
    public void setBloodDonationCount(int bloodDonationCount) {
        this.bloodDonationCount = bloodDonationCount;
    }  
    
    //plasmaDonationCount
    public int getPlasmaDonationCount() {
        return plasmaDonationCount;
    }
    
    public void setPlasmaDonationCount(int plasmaDonationCount) {
        this.plasmaDonationCount = plasmaDonationCount;
    }     

    public String getLastTimeUpdated() {
        return lastTimeUpdated;
    }
    
    public void setLastTimeUpdated(String lastTimeUpdated) {
        this.lastTimeUpdated = lastTimeUpdated;
    }
    
    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }
}
