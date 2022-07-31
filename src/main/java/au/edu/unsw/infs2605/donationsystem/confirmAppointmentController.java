/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package au.edu.unsw.infs2605.donationsystem;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    
    @FXML
    Label confirmLabel;
    
    @FXML
    Button cancel;
    
    @FXML
    Button confirm;
    
    @FXML
    Button backToAppointment;
    
    //Print confirmation information
    Appointment newAppointment = App.getAppointment();
    
    @Override
    public void initialize(URL url, ResourceBundle rb)  {
        confirmLabel.setText("Ready to confirm this appointment?");
        confirm.setVisible(true);
        cancel.setVisible(true);
        
        firstNameConf.setText(newAppointment.getFirstName());
        lastNameConf.setText(newAppointment.getLastName());
        mobileConf.setText(newAppointment.getMobile());
        donationTypeConf.setText(newAppointment.getDonationType());
        donorCentreConf.setText(newAppointment.getDonorCentre());
        timeConf.setText(newAppointment.getBookingTime());
        dateConf.setText(newAppointment.getBookingDate());
    }
    
    public void confirmButton() throws SQLException, IOException {
        confirmLabel.setText("Thank you! "
                + "Your appointment is confirmed as following");
        
        String database = "jdbc:sqlite:DonorDatabase.db";
        Connection conn = DriverManager.getConnection(database);
        PreparedStatement pSt = conn.prepareStatement
                ("INSERT INTO appointment (firstName, lastName, phoneNo, "
                + "donType, donorCentre, time, date) "
                + "VALUES (?,?,?,?,?,?,?)");
        pSt.setString(1, newAppointment.getFirstName());
        pSt.setString(2, newAppointment.getLastName());
        pSt.setString(3, newAppointment.getMobile());
        pSt.setString(4, newAppointment.getDonationType());
        pSt.setString(5, newAppointment.getDonorCentre());
        pSt.setString(6, newAppointment.getBookingTime());
        pSt.setString(7, newAppointment.getBookingDate());
        
        confirm.setVisible(false);
        cancel.setVisible(false);
        backToAppointment.setVisible(true);
        pSt.executeUpdate();
        conn.close();
        App.setRoot("homePage");
    }
    
    public void cancelButton() throws IOException {
        App.setRoot("bookAppointment");
    }

    public void backToHomePage() throws IOException {
        App.setRoot("homePage");
    }
            
}
