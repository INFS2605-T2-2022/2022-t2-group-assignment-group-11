/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package au.edu.unsw.infs2605.donationsystem;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
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
    RadioButton bloodDonation;
    
    @FXML
    RadioButton plasmaDonation;
    
    @FXML
    DatePicker bookingDate;
    
    @FXML
    ChoiceBox timeSlot;
    
    @FXML
    ChoiceBox donorCentre;
    
    //Missing required information error
    @FXML
    Label firstNameError;
    
    @FXML
    Label lastNameError;
    
    @FXML
    Label genderError;
    
    @FXML
    Label mobileError;
    
    @FXML
    Label donationTypeError;
    
    @FXML
    Label donorCentreError;
    
    @FXML
    Label bookingTimeError;
    
    @FXML
    Label dateError;
    
    @FXML
    Label dobError;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            createChoiceBox();
        } catch (SQLException ex) {
            Logger.getLogger(appointmentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void createChoiceBox() throws SQLException {
        //Create Gender choicebox
        //gender.getItems().clear();
        if (gender.getItems().isEmpty()) {
            gender.getItems().add("Male");
            gender.getItems().add("Female");
            gender.getItems().add("Other");  
        }
        
        //Retrieve donor centre list from database
        ArrayList<String> centreNameList = new ArrayList<>();
        final String database = "jdbc:sqlite:DonorDatabase.db";
        Connection conn = DriverManager.getConnection(database);
        Statement st = conn.createStatement();
        String query = "SELECT name FROM donorcentre";
        ResultSet rs = st.executeQuery(query);
        while(rs.next()) {
            centreNameList.add(rs.getString(1));
        }
        
        //Create DonorCentre choicebox
        donorCentre.getItems().clear(); //avoid duplicates
        donorCentre.getItems().addAll(centreNameList);
        
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
    @FXML
    public void newAppointment() throws IOException, ParseException {
        Appointment newAppointment = new Appointment();
        
        newAppointment.setEmail(email.getText());
        newAppointment.setAddress(address.getText());
        
        /* 
        Check requirements
        */
        
        //First name must be filled
        if (firstName.getText().isBlank()) {
            firstNameError.setVisible(true);
        }
        else {
            firstNameError.setVisible(false);
            newAppointment.setFirstName(firstName.getText());
        }
        
        //Last name must be filled
        if (lastName.getText().isBlank()) {
            lastNameError.setVisible(true);
        }
        else {
            lastNameError.setVisible(false);
            newAppointment.setLastName(lastName.getText());
        }
        
        //Donors must be 18-75 years old
        LocalDate today = LocalDate.now();
        
        if (dateOfBirth.getValue() != null) {
            dobError.setVisible(false);
            if (ageCheck() == true) {
                dateError.setVisible(false);
                newAppointment.setDOB(dateOfBirth.getValue().toString());
            } else {
                dateError.setVisible(true);
                dateError.setText("Donor must be 18-75 years old.");
            }
        } else {
            dobError.setVisible(true);
        }
        
        //Blood donation must be chosen
        if (bloodDonation.isSelected()) {
            newAppointment.setDonationType("Blood");
            donationTypeError.setVisible(false);
        }
        else if (plasmaDonation.isSelected()) {
            newAppointment.setDonationType("Plasma");
            donationTypeError.setVisible(false);
        }
        else {
            donationTypeError.setVisible(true);
        }

        //Gender must be filled
        if (gender.getSelectionModel().isEmpty()) {
            genderError.setVisible(true);
        }
        else {
            genderError.setVisible(false);
            newAppointment.setGender(getChoice(gender)); 
        }
        
        //Mobile must be filled
        if (mobile.getText().isBlank()) {
            mobileError.setVisible(true);
        }
        else {
            mobileError.setVisible(false);
            newAppointment.setMobile(mobile.getText());
        }
        
        //Donor Centre must be chosen
        if (donorCentre.getSelectionModel().isEmpty()) {
            donorCentreError.setVisible(true);
        }
        else {
            donorCentreError.setVisible(false);
            newAppointment.setDonorCentre(getChoice(donorCentre));
        }
        
        //Booking Date has to be in the future
        if (bookingDate.getValue() != null) {
            bookingTimeError.setVisible(false);
            if (bookingDate.getValue().isAfter(today)){
                dateError.setVisible(false);
                newAppointment.setBookingDate(bookingDate.getValue().toString());
            } else {
                dateError.setVisible(true);
                dateError.setText("Booking date must be in the future.");
            }
        } else {
            bookingTimeError.setVisible(true);
        }  
        
        if (timeSlot.getSelectionModel().isEmpty()) {
            bookingTimeError.setVisible(true);
        }
        else {
            bookingTimeError.setVisible(false);
            newAppointment.setBookingTime(getChoice(timeSlot));
        }
        
        // If all required information is provided, confirm the appointment
        if (firstNameError.isVisible() == false 
                && lastNameError.isVisible() == false 
                && dobError.isVisible() == false 
                && genderError.isVisible() == false
                && mobileError.isVisible() == false
                && donationTypeError.isVisible() == false
                && donorCentreError.isVisible() == false
                && bookingTimeError.isVisible() == false
                && dateError.isVisible() == false) {
            appointmentList.add(newAppointment);
            App.setAppointment(newAppointment);
            App.setRoot("confirmAppointment");
   
        }
    }
    public boolean ageCheck() throws ParseException {
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        int year = dateOfBirth.getValue().getYear();
        int month = dateOfBirth.getValue().getMonthValue();
        int date = dateOfBirth.getValue().getDayOfMonth();
        //Date dobFormatted = sdf.parse(dateOfBirth.getValue().toString());
        LocalDate today = LocalDate.now();
        LocalDate birthDate = LocalDate.of(year, month, date);
        int age = Period.between(birthDate, today).getYears();
        if (age >= 18 && age <= 75) {
            return true;
        }
        else {
            return false;
        }
    }
    public void cancelButton() throws IOException {
        App.setRoot("appointment");
        
    }
    
    public void backToHomePage() throws IOException {
        App.setRoot("homePage");
    }
    
    

    
}
