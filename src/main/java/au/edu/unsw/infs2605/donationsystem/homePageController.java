/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package au.edu.unsw.infs2605.donationsystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author khanhlinh0907
 */
public class homePageController implements Initializable {
//    @FXML
//    ImageView logo = new ImageView("/C:/khanhlinh0907/Desktop/blood donation.jpeg");
//    
//    @FXML
//    ImageView homePageImage = new ImageView("blood donation.jpeg");
//    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        //Image logoImage = new Image(getClass().getResourceAsStream("/images/logo.png"));
//        Image logoImage = new Image(getClass().getResourceAsStream("logo.png"));
//        logo = new ImageView(logoImage);
//        Image homePage = new Image(getClass().getResourceAsStream("/images/blood donation.jpeg"));
//        homePageImage.setImage(homePage);
    }
        
    public void toHomePage() throws IOException {
        App.setRoot("homePage");
    }
    
    public void toAppointment() throws IOException {
        App.setRoot("AppointmentList");
    }
    
    public void toDonorCentre() throws IOException {
        App.setRoot("Donor Centre Main");
    }
    
    public void toBookAppointment() throws IOException {
        App.setRoot("appointment");
    }


}
