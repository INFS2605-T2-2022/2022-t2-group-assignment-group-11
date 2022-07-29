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
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author khanhlinh0907
 */
public class eligibilityController implements Initializable{
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
    Label error;
    
    @Override
    public void initialize(URL url, ResourceBundle rb)  {
        clearOption();
    }
    
    @FXML
    public void eligibilityCheck() throws IOException {       
        if (condition1.isSelected() && condition2.isSelected() && 
                condition3.isSelected() && condition4.isSelected() &&
                condition5.isSelected() && condition6.isSelected() &&
                condition7.isSelected() && condition8.isSelected() &&
                condition9.isSelected() && condition10.isSelected() &&
                condition11.isSelected() && condition12.isSelected()) {
            App.setRoot("bookAppointment");
            error.setVisible(false);
        } else {
            error.setVisible(true);
        }
    }
    
    @FXML
    public void clearOption() {
        condition1.setSelected(false);
        condition2.setSelected(false);
        condition3.setSelected(false);
        condition4.setSelected(false);
        condition5.setSelected(false);
        condition6.setSelected(false);
        condition7.setSelected(false);
        condition8.setSelected(false);
        condition9.setSelected(false);
        condition10.setSelected(false);
        condition11.setSelected(false);
        condition12.setSelected(false);
    }
    
    public void backToHomePage() throws IOException {
        App.setRoot("homePage");
    }
}
