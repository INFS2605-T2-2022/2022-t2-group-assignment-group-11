/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package au.edu.unsw.infs2605.donationsystem;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author khanhlinh0907
 */
public class appointmentController {
    /*
    Eligibility Check before making a donation appointment
    */
    @FXML
    CheckBox condition1;
    @FXML
    CheckBox condition2;
    @FXML
    CheckBox condition3;
    @FXML
    CheckBox condition4;  
    @FXML
    CheckBox condition5;
    @FXML
    CheckBox condition6;
    @FXML
    CheckBox condition7;
    @FXML
    CheckBox condition8;
    @FXML
    CheckBox condition9;
    @FXML
    CheckBox condition10;
    @FXML
    CheckBox condition11;
    @FXML
    CheckBox condition12;
    @FXML
    CheckBox none;
    
    @FXML
    Label notEligible;
    
    @FXML
    ChoiceBox<String> ageCheck;
    
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
    TextField postcode;
    
    @FXML
    ChoiceBox gender;
    
    @FXML 
    DatePicker dateOfBirth;
    
    @FXML
    DatePicker bookingDate;
    
    public void initialize(URL url, ResourceBundle rb) {
        //Create Age Eligibility choicebox
        if (ageCheck.getItems().isEmpty()) {
            ageCheck.getItems().add("Yes");
            ageCheck.getItems().add("No");
        }
        //Create Gender choicebox
        if (gender.getItems().isEmpty()) {
            gender.getItems().add("Male");
            gender.getItems().add("Female");
            gender.getItems().add("Other");  
        }
    }
    
    public void eligibilityCheck(ActionEvent event) throws IOException {
        /*Eligibility Check
        Must not answer 'Yes' to any conditions listed
        Must be 18-75 years old
        */
        
        if (condition1.isSelected() || condition2.isSelected() || 
                condition3.isSelected() || condition4.isSelected() ||
                condition5.isSelected() || condition6.isSelected() ||
                condition7.isSelected() || condition8.isSelected() ||
                condition9.isSelected() || condition10.isSelected() ||
                condition11.isSelected() || condition12.isSelected() ||
                getChoice(ageCheck).equals("No")) {
            notEligible.setVisible(true);
        } else {
            App.setRoot("bookAppointment");
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
    public void newAppointment() {
        Donor newDonor = new Donor();
        newDonor.setFirstName(firstName.getText());
        newDonor.setLastName(lastName.getText());
        newDonor.setEmail(email.getText());
        newDonor.setDOB(dateOfBirth.getValue().toString());
        newDonor.setMobileNumber(mobile.getText());
        newDonor.setAddress(address.getText());
        newDonor.setGender(getChoice(gender));
        //newDonor.setBloodType(getChoice(bloodType));   
    }
    
    
    
    
    
}
