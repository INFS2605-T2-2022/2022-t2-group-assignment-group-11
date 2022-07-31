/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package au.edu.unsw.infs2605.donationsystem;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author khanhlinh0907
 */
public class createReceipt implements Initializable {
    
    @FXML
    Label donorCentre;
    
    @FXML
    Label firstName;
    
    @FXML
    Label lastName;
    
    @FXML
    Label phone;
    
    @FXML
    Label donationType;
    
    @FXML
    Label donationTime;
    
    @FXML
    Label donationDate;
    
    @FXML
    Label donationStatus;
    
    @FXML
    Label ID;
    
    @FXML
    Label dateCreated;
    
    @FXML
    ImageView logo;
    
    @FXML
    ImageView home;
    
    @Override
    public void initialize(URL url, ResourceBundle rb)  {
       
        //Add images
        Image logoImage = new Image(App.class.getResourceAsStream("img/logo.png"));
        logo.setImage(logoImage);
        
        Image homeIcon = new Image(App.class.getResourceAsStream("img/home.png"));
        home.setImage(homeIcon);
        
        //Set date created
        LocalDate today = LocalDate.now();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d;
        try {
            d = sdf.parse(today.toString());
            sdf.applyPattern("dd/MM/yyyy");
            dateCreated.setText(sdf.format(d));
        } catch (ParseException ex) {
            Logger.getLogger(createReceipt.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        //Import information from selected appointment
        AppointmentInfo selected = App.getSelectedAppointment();
        
        ID.setText(String.valueOf(selected.getID()));
        firstName.setText(selected.getFirstName());
        lastName.setText(selected.getLastName());
        donorCentre.setText(selected.getDonorCentre());
        phone.setText(selected.getPhoneNumber());
        donationType.setText(selected.getDonationType());
        donationTime.setText(selected.getDonationTime());
        donationDate.setText(selected.getDonationDate());
        donationStatus.setText(selected.getDonationStatus());
    }
    
    public void backToHomePage() throws IOException {
        App.setRoot("homePage");
    }
}
