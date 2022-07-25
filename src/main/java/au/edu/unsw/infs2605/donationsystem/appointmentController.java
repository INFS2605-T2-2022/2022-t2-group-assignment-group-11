/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package au.edu.unsw.infs2605.donationsystem;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author khanhlinh0907
 */
public class appointmentController implements Initializable {
    
    public static List<Appointment> appointmentList = new ArrayList<>();
    
    @FXML
    TextField firstName;
    
    @FXML
    TextField lastName;
    
    @FXML
    TextField mobile;
    
    @FXML
    TextField email;
    
    @FXML
    TextField address;
    
    @FXML
    ChoiceBox gender;
    
    @FXML 
    DatePicker dateOfBirth;
    
    @FXML
    DatePicker bookingDate;
    
    @FXML
    ChoiceBox timeSlot;
    
    @FXML
    ChoiceBox donorCentre;
    
    @FXML
    Label firstNameError;
    
    @FXML
    Label lastNameError;
    
    @FXML
    Label dobOrGenderError;
    
    @FXML
    Label mobileError;
    
    @FXML
    Label donationTypeError;
    
    @FXML
    Label donorCentreError;
    
    @FXML
    Label bookingTimeError;
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        createChoiceBox();
    }
    
    public void createChoiceBox() {
        //Create Gender choicebox
        gender.getItems().clear();
        if (gender.getItems().isEmpty()) {
            gender.getItems().add("Male");
            gender.getItems().add("Female");
            gender.getItems().add("Other");  
        }
        
        //Create DonorCentre choicebox
        donorCentre.getItems().clear();
        if (donorCentre.getItems().isEmpty()) {
            donorCentre.getItems().add("Town Hall Donor Centre");
            donorCentre.getItems().add("Chatswood Donor Centre");
            donorCentre.getItems().add("The Shire Donor Centre");
        }
        
        //Create Time choiceBox
        timeSlot.getItems().clear();
        if (timeSlot.getItems().isEmpty()) {
            timeSlot.getItems().add("09:00 AM");
            timeSlot.getItems().add("09:30 AM");
            timeSlot.getItems().add("10:00 AM");
            timeSlot.getItems().add("10:30 AM");
            timeSlot.getItems().add("11:00 AM");
            timeSlot.getItems().add("11:30 AM");
            timeSlot.getItems().add("12:00 PM");
            timeSlot.getItems().add("12:30 PM");
            timeSlot.getItems().add("01:00 PM");
            timeSlot.getItems().add("01:30 PM");
            timeSlot.getItems().add("02:00 PM");
            timeSlot.getItems().add("02:30 PM");
            timeSlot.getItems().add("03:00 PM");
            timeSlot.getItems().add("03:30 PM");
            timeSlot.getItems().add("04:00 PM");
            timeSlot.getItems().add("04:30 PM");
            timeSlot.getItems().add("05:00 PM");
        }
    }
    
    public String getChoice(ChoiceBox<String> choiceBox) {
        String choice = choiceBox.getValue();
        return choice;
    }
    
    /*
    Book a new appointment
    */
    
    //Input personal information
    public void newAppointment() throws IOException {
        Appointment newAppointment = new Appointment();
        newAppointment.setFirstName(firstName.getText());
        newAppointment.setLastName(lastName.getText());
        newAppointment.setEmail(email.getText());
        newAppointment.setDOB(dateOfBirth.getValue().toString());
        newAppointment.setMobile(mobile.getText());
        newAppointment.setAddress(address.getText());
        newAppointment.setGender(getChoice(gender)); 
        
        /* 
        Check whether compulsory information has been filled
        */
        
        if (newAppointment.getFirstName().isBlank()) {
            firstNameError.setVisible(true);
        }
        else {
            firstNameError.setVisible(false);
        }
        
        if (newAppointment.getLastName().isBlank()) {
            lastNameError.setVisible(true);
        }
        else {
            lastNameError.setVisible(false);
        }
        
        if (newAppointment.getDOB().isBlank() || 
                newAppointment.getGender().isBlank()) {
            dobOrGenderError.setVisible(true);
        }
        else {
            dobOrGenderError.setVisible(false);
        }
        
        if (newAppointment.getMobile().isBlank()) {
            mobileError.setVisible(true);
        }
        else {
            mobileError.setVisible(false);
        }
        
        if (newAppointment.getDonationType().isBlank()) {
            donationTypeError.setVisible(true);
        }
        else {
            donationTypeError.setVisible(false);
        }
        
        if (newAppointment.getDonorCentre().isBlank()) {
            donorCentreError.setVisible(true);
        }
        else {
            donorCentreError.setVisible(false);
        }
        
        if (newAppointment.getBookingDate().isBlank()
                || newAppointment.getBookingTime().isBlank()) {
            bookingTimeError.setVisible(true);
        }
        else {
            bookingTimeError.setVisible(false);
        }    
        // If all required information is provided, confirm the appointment
        if (firstNameError.isVisible() == false 
                && lastNameError.isVisible() == false 
                && dobOrGenderError.isVisible() == false 
                && mobileError.isVisible() == false
                && donationTypeError.isVisible() == false
                && donorCentreError.isVisible() == false
                && bookingTimeError.isVisible() == false) {
            appointmentList.add(newAppointment);
            App.setRoot("confirmAppointment");
            
            //Set label of the new screen here!!!
            
        }
    }
    
    

    
}
