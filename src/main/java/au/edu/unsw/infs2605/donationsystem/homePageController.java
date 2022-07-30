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
    @FXML
    ImageView logo;
    
    @FXML
    ImageView homePageImage;
//    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image logoImage = new Image(App.class.getResourceAsStream("img/logo.png"));
        logo.setImage(logoImage);
        
        Image homePage = new Image(App.class.getResourceAsStream("img/blood donation.jpeg"));
        homePageImage.setImage(homePage);
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
