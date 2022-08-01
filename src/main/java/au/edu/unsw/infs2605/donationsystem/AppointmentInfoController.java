/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package au.edu.unsw.infs2605.donationsystem;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 *
 * @author w_yy
 */
public class AppointmentInfoController {
    @FXML
    private TableView<AppointmentInfo> AppointmentTable;

    @FXML
    private TableColumn<AppointmentInfo, String> ID;

    @FXML
    private TableColumn<AppointmentInfo, String> donationType;

    @FXML
    private TableColumn<AppointmentInfo, String> donorCentre;

    @FXML
    private TableColumn<AppointmentInfo, String> Date;

    @FXML
    private TableColumn<AppointmentInfo, String> Time;

    @FXML
    private TextField idField;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField donorCentreField;

    @FXML
    private TextField donationDateField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private TextField emailAddressField;

    @FXML
    private TextField donationTimeField;

    @FXML
    private TextField donationStatusField;

    @FXML
    private TextField donationTypeField;

    @FXML
    private TextField notesFiled;

    @FXML
    private TextField keywordSearch;
    
    @FXML
    private ComboBox<String> filterField;
    
    @FXML
    ImageView logo;
    
    @FXML
    ImageView home;


    public void initialize() {
        ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        donationType.setCellValueFactory(new PropertyValueFactory<>("donationType"));
        donorCentre.setCellValueFactory(new PropertyValueFactory<>("donorCentre"));
        Date.setCellValueFactory(new PropertyValueFactory<>("donationDate"));
        Time.setCellValueFactory(new PropertyValueFactory<>("donationTime"));

        keywordSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.length() > 0) {
                String selectedItem = filterField.getSelectionModel().getSelectedItem();
               
                AppointmentTable.setItems(Database.getInstance().getAppointmentInfo(" where "+selectedItem + " like '%"+newValue+"%'"));
            } else {
                AppointmentTable.setItems(Database.getInstance().getAppointmentInfo(""));
            }
        });

       
        filterField.getItems().addAll("Donation Type", "Donor Centre");
        filterField.getSelectionModel().select(0);
        Platform.runLater(() -> {
            AppointmentTable.getScene().getWindow().focusedProperty()
                    .addListener((observableValue, aBoolean, newValue) -> {
                        if (newValue) {
                            AppointmentTable.requestFocus();
                            int selectedIndex = AppointmentTable.getSelectionModel().getSelectedIndex();
                            AppointmentTable.getSelectionModel().clearSelection();
                            AppointmentTable.getSelectionModel().select(selectedIndex);
                            AppointmentTable.setItems(Database.getInstance().getAppointmentInfo(""));
                        }
                    });
        });
        AppointmentTable.getSelectionModel().selectedItemProperty().addListener((observableValue, appointmentInfo, newValue) -> {
            if (newValue != null) {
                ClickSidebar(newValue);
            }
        });

        AppointmentTable.setItems(Database.getInstance().getAppointmentInfo(""));
        
        //Set default
        AppointmentTable.getSelectionModel().select(0);
        
        //Add images
        Image logoImage = new Image(App.class.getResourceAsStream("img/logo.png"));
        logo.setImage(logoImage);
        
        Image homeIcon = new Image(App.class.getResourceAsStream("img/home.png"));
        home.setImage(homeIcon);
    }

    @FXML
    private void ClickSidebar(AppointmentInfo selected) {
        idField.setText(selected.getID() + "");
        firstNameField.setText(selected.getFirstName());
        lastNameField.setText(selected.getLastName());
        donorCentreField.setText(selected.getDonorCentre());
        donationTimeField.setText(selected.getDonationTime());
        donationDateField.setText(selected.getDonationDate());
        phoneNumberField.setText(selected.getPhoneNumber());
        emailAddressField.setText(selected.getEmailAddress());
        donationStatusField.setText(selected.getDonationStatus());
        donationTypeField.setText(selected.getDonationType());
        notesFiled.setText(selected.getNotes());


    }

    @FXML
    private void Add() {
        showEdit(null, "Edit.fxml");
    }

    @FXML
    private void Edit() {
        AppointmentInfo selected = AppointmentTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            return;
        }
        showEdit(selected, "Edit.fxml");
        
    }

    @FXML
    private void Delete() {
        AppointmentInfo selected = AppointmentTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            return;
        }
        Database.getInstance().deleteAppointmentInfo(selected);
        AppointmentTable.setItems(Database.getInstance().getAppointmentInfo(""));
        new Alert(Alert.AlertType.INFORMATION, "success").showAndWait();

    }

    private void showEdit(AppointmentInfo appointmentInfo, String fxml) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource(fxml));
            Scene scene = new Scene(root);
            scene.setUserData(appointmentInfo);
            stage.setScene(scene);
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void backToHomePage() throws IOException {
        App.setRoot("homePage");
    }
    
    public void createReceipt() throws IOException {
        AppointmentInfo selected = AppointmentTable.getSelectionModel().getSelectedItem();
        App.setSelectedAppointment(selected);
        App.setRoot("createReceipt");
        
    }
}
