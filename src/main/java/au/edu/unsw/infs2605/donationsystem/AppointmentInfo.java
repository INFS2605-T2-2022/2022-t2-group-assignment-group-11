/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package au.edu.unsw.infs2605.donationsystem;

/**
 *
 * @author w_yy
 */
public class AppointmentInfo {
     private int id;
    private String firstName;
    private String lastName;
    private String donorCentre;
    private String donationTime;
    private String donationDate;
    private String emailAddress;
    private String phoneNumber;
    private String donationType;
    private String donationStatus;
    private String notes;


    public AppointmentInfo(int id, String firstName, String lastName, String donorCentre,
                           String donationTime, String donationDate, String emailAddress, String phoneNumber,
                           String donationType, String donationStatus, String notes) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.donorCentre = donorCentre;
        this.donationDate = donationDate;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.donationType = donationType;
        this.donationStatus = donationStatus;
        this.donationTime = donationTime;
        this.notes = notes;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDonorCentre() {
        return donorCentre;
    }

    public void setDonorCentre(String donorCentre) {
        this.donorCentre = donorCentre;
    }

    public String getDonationTime() {
        return donationTime;
    }

    public void setDonationTime(String donationTime) {
        this.donationTime = donationTime;
    }

    public String getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(String donationDate) {
        this.donationDate = donationDate;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDonationType() {
        return donationType;
    }

    public void setDonationType(String donationType) {
        this.donationType = donationType;
    }

    public String getDonationStatus() {
        return donationStatus;
    }

    public void setDonationStatus(String donationStatus) {
        this.donationStatus = donationStatus;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}
