/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package au.edu.unsw.infs2605.donationsystem;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author w_yy
 */
public class EditController {
     @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField idField;

    @FXML
    private TextField donorCentreField;

    @FXML
    private TextField donationTimeField;

    @FXML
    private TextField donationDateField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private TextField emailAddressField;

    @FXML
    private TextField notesField;

    @FXML
    private ComboBox<String> donationTypeField;

    @FXML
    private ComboBox<String> donationStatusField;
    
    @FXML
    Label pageLabel;
    
    AppointmentInfo selected;

    @FXML
    public void initialize() {
        pageLabel.setText("Add New Appointment");
        donationTypeField.getItems().addAll("Blood", "Plasma", "Blood and Plasma");
        donationStatusField.getItems().addAll("approved", "completed");
        donationTypeField.getSelectionModel().select(0);
        donationStatusField.getSelectionModel().select(0);
        Platform.runLater(() -> {
            Scene scene = idField.getScene();
            if (scene.getUserData() != null) {
                pageLabel.setText("Edit Appointment Information");
                selected = (AppointmentInfo) scene.getUserData();
                idField.setText(selected.getID() + "");
                firstNameField.setText(selected.getFirstName());
                lastNameField.setText(selected.getLastName());
                donorCentreField.setText(selected.getDonorCentre());
                donationTimeField.setText(selected.getDonationTime());
                donationDateField.setText(selected.getDonationDate());
                phoneNumberField.setText(selected.getPhoneNumber());
                emailAddressField.setText(selected.getEmailAddress());
                notesField.setText(selected.getNotes());
                donationTypeField.getSelectionModel().select(selected.getDonationType());
                donationStatusField.getSelectionModel().select(selected.getDonationStatus());
            }
        });
    }

    @FXML
    private void save() {
        String firstNameFieldText = firstNameField.getText();
        String lastNameFieldText = lastNameField.getText();
        String donorCentreFieldText = donorCentreField.getText();
        String donationTimeFieldText = donationTimeField.getText();
        String donationDateFieldText = donationDateField.getText();
        String phoneNumberFieldText = phoneNumberField.getText();
        String emailAddressFieldText = emailAddressField.getText();
        String notesFieldText = notesField.getText();
        String donationType = donationTypeField.getSelectionModel().getSelectedItem();
        String donationStatus = donationStatusField.getSelectionModel().getSelectedItem();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        try {
            sdf.parse(donationDateFieldText);
        } catch (ParseException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).showAndWait();
            return;
        }
        if (selected == null) {
            Database.getInstance().addAppointmentInfo(new AppointmentInfo(0, firstNameFieldText, lastNameFieldText, donorCentreFieldText,
                    donationTimeFieldText, donationDateFieldText, emailAddressFieldText,
                    phoneNumberFieldText, donationType, donationStatus, notesFieldText));
        } else {
            selected.setID(Integer.parseInt(idField.getText()));
            selected.setFirstName(firstNameFieldText);
            selected.setLastName(lastNameFieldText);
            selected.setDonorCentre(donorCentreFieldText);
            selected.setDonationTime(donationTimeFieldText);
            selected.setPhoneNumber(phoneNumberFieldText);
            selected.setEmailAddress(emailAddressFieldText);
            selected.setDonationType(donationType);
            selected.setDonationStatus(donationStatus);
            Database.getInstance().UpdateAppointmentInfo(selected);
        }
        ((Stage) idField.getScene().getWindow()).close();
    }
        
}
