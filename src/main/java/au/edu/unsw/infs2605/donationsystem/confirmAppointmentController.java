/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package au.edu.unsw.infs2605.donationsystem;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author khanhlinh0907
 */
public class confirmAppointmentController implements Initializable{
    //Confirm Appointment
    @FXML
    Label firstNameConf;
    
    @FXML
    Label lastNameConf;
    
    @FXML
    Label mobileConf;
    
    @FXML
    Label donationTypeConf;
    
    @FXML
    Label donorCentreConf;
    
    @FXML
    Label timeConf;
    
    @FXML
    Label dateConf;
    
    //Print confirmation information
    Appointment newAppointment = App.getAppointment();
    
    @Override
    public void initialize(URL url, ResourceBundle rb)  {
        firstNameConf.setText(newAppointment.getFirstName());
        lastNameConf.setText(newAppointment.getLastName());
        mobileConf.setText(newAppointment.getMobile());
        donationTypeConf.setText(newAppointment.getDonationType());
        donorCentreConf.setText(newAppointment.getDonorCentre());
        timeConf.setText(newAppointment.getBookingTime());
        dateConf.setText(newAppointment.getBookingDate());
    }
    
    public void cancelButton() throws IOException {
        App.setRoot("bookAppointment");
    }

            
}
