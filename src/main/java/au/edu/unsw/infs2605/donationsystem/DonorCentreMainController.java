package au.edu.unsw.infs2605.donationsystem;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;



public class DonorCentreMainController {    
    @FXML
    public ListView<DonorCentre> centreListView;
                
    @FXML
    private TextField centreNameTextField;
        
    @FXML
    private TextField addressTextField;
        
    @FXML
    private TextField phoneNumberTextField;
        
    @FXML
    private TextField donationTypeTextField;
    
    @FXML
    private Label centreNameLabel;
    
    @FXML
    private Label addressLabel;
    
    @FXML
    private Label phoneNumberLabel;
    
    @FXML
    private Label donationTypeLabel;
    
    //ObservableList<String> checkBoxList = FXCollections.observableArrayList();

    @FXML 
    private Button addNewCentreButton;
        
    @FXML
    private Button deleteCentreButton;
    
    @FXML
    private Button updateDetailsButton;
        
    @FXML
    private Button scheduleAppointmentButton;
        
    @FXML
    private TableView<Appointment> appointmentTbl;
    
    @FXML
    TableColumn<Appointment, String> donorNameCol;
        
    @FXML
    TableColumn<Appointment, String> dateCol;
        
    @FXML
    TableColumn<Appointment, String> timeCol;
    
    private boolean isEditing = false;
    
    //@Override
    public void initialize() throws SQLException {
        
        List<DonorCentre> centreList = new ArrayList<>();
        //DonorCentre selected = centreListView.getSelectionModel().getSelectedItem();
        final String database = "jdbc:sqlite:DonorDatabase.db";
        Connection conn = DriverManager.getConnection(database);

        Statement st = conn.createStatement();
        //get data from database
//        String query = "SELECT name FROM donorcentre";
        String query = "SELECT * FROM donorcentre";
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            centreList.add(new DonorCentre(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
        }
        //createAppointmentTableView();
        /*
        String query2 = "SELECT * FROM appointment WHERE donorcentre = ?";
        PreparedStatement pst = conn.prepareStatement(
                "SELECT * FROM appointment WHERE donorcentre = ?"
        );
        //String selectedCentre = selected.getName();
        System.out.println(selected.getName());
        //pst.setString(1, selectedCentre);
        ObservableList<Appointment> appointmentList = FXCollections.observableArrayList();
        
        while (rs.next()) {
            appointmentList.add(new Appointment(rs.getString(2), rs.getString(3), rs.getString(5), rs.getString(6)));
        }
        
        appointmentTbl.setItems(appointmentList);
        
        donorNameCol.setCellFactory(new PropertyValueFactory("firstname" + " " + "lastname"));
        dateCol.setCellFactory(new PropertyValueFactory("date"));
        timeCol.setCellFactory(new PropertyValueFactory("time"));
        */
        
        //List<Centre> centreList = FXCollections.observableArrayList();
        
        for (DonorCentre centre : centreList) {
            centreListView.getItems().add(centre);
        }
        
        centreNameLabel.setVisible(false);
        addressLabel.setVisible(false);
        phoneNumberLabel.setVisible(false);
        donationTypeLabel.setVisible(false);
    }
    
    @FXML
    public void createAppointmentTableView(DonorCentre selected) throws SQLException {
       
        
        final String database = "jdbc:sqlite:DonorDatabase.db";
        Connection conn = DriverManager.getConnection(database);
        Statement st = conn.createStatement();
        
        String query2 = "SELECT * FROM appointment WHERE donorcentre = ?";
        PreparedStatement pst = conn.prepareStatement(
                "SELECT * FROM appointment WHERE donorcentre = ?"
        );
        String selectedCentre = selected.getName();
        pst.setString(1, selectedCentre);
        ObservableList<Appointment> appointmentList = FXCollections.observableArrayList();
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            appointmentList.add(new Appointment(rs.getString(2), rs.getString(3), rs.getString(6), rs.getString(5)));
        }
        
        appointmentTbl.setItems(appointmentList);
        
        donorNameCol.setCellValueFactory(new PropertyValueFactory("name"));
        dateCol.setCellValueFactory(new PropertyValueFactory("bookingDate"));
        timeCol.setCellValueFactory(new PropertyValueFactory("bookingTime"));
    }
    
    @FXML
    public void selectCentre() throws SQLException {
        DonorCentre selected = centreListView.getSelectionModel().getSelectedItem();
        
        centreNameLabel.setText(selected.getName());
        addressLabel.setText(selected.getAddress());
        phoneNumberLabel.setText(selected.getPhone());
        donationTypeLabel.setText(selected.getDonType());
        
        createAppointmentTableView(selected); 
        
        //reset screen
        isEditing = false;
        centreNameTextField.setVisible(false);
        addressTextField.setVisible(false);
        phoneNumberTextField.setVisible(false);
        donationTypeTextField.setVisible(false);
        
        centreNameLabel.setVisible(true);
        addressLabel.setVisible(true);
        phoneNumberLabel.setVisible(true);
        donationTypeLabel.setVisible(true);
        
        updateDetailsButton.setText("Update details");
        addNewCentreButton.setText("Add new");
    }
    
//    @FXML
//    public void createNewDonationType() throws SQLException, IOException {
//       
//        if (!isEditing) {
//            createNewDonationTypeButton.setText("Save changes");
//            
//            DonorCentre selected = centreListView.getSelectionModel().getSelectedItem(); 
//            donationTypeTextField.setVisible(false);
//            bloodCheckBox.setVisible(true);
//            plasmaCheckBox.setVisible(true);
//            
//            selected.setDontype(bloodCheckBox.getText());
//            
//            // Update new donation type to App screen
//            App.setDonorCentre(selected);
//            String database = "jdbc:sqlite:DonorDatabase.db";
//            Connection conn = DriverManager.getConnection(database);
//            PreparedStatement pSt = conn.prepareStatement("UPDATE donorcentre SET dontype = ? WHERE name = ?");
//        }
//        else {
//            createNewDonationTypeButton.setText("Add new donation type");
//            donationTypeTextField.setVisible(true);
//            bloodCheckBox.setVisible(false);
//            plasmaCheckBox.setVisible(false);
//        }
//    }  
    
    @FXML
    public void updateDetails() throws SQLException {
        DonorCentre selected = centreListView.getSelectionModel().getSelectedItem();
        if (!isEditing) {
            updateDetailsButton.setText("Save changes");
            
            centreNameLabel.setVisible(false);
            addressLabel.setVisible(false);
            phoneNumberLabel.setVisible(false);
            donationTypeLabel.setVisible(false);
            
            centreNameTextField.setVisible(true);
            addressTextField.setVisible(true);
            phoneNumberTextField.setVisible(true);
            donationTypeTextField.setVisible(true);
            
            // Get text from label and set in textfields
            centreNameTextField.setText((centreNameLabel.getText()));
            addressTextField.setText(addressLabel.getText());
            phoneNumberTextField.setText(phoneNumberLabel.getText());
            donationTypeTextField.setText(donationTypeLabel.getText());
            
            // Get information from Text Fields
            selected.setName(centreNameTextField.getText());
            selected.setAddress(addressTextField.getText());
            selected.setPhone(phoneNumberTextField.getText());
            selected.setDontype(donationTypeTextField.getText());
            
            //Display updated information in Labels
            centreNameLabel.setText(selected.getName());
            addressLabel.setText(selected.getAddress());
            phoneNumberLabel.setText(selected.getPhone());
            donationTypeLabel.setText(selected.getDonType());
            
            centreListView.refresh();
            
            //Update new donation type to App screen
            
        }
        else {
            updateDetailsButton.setText("Update details");
        
            App.setDonorCentre(selected);
            String database = "jdbc:sqlite:DonorDatabase.db";
            Connection conn = DriverManager.getConnection(database);
            PreparedStatement pSt = conn.prepareStatement("UPDATE donorcentre SET address = ?, phone = ?, dontype = ? WHERE name = ?");
            pSt.setString(1, addressTextField.getText());
            pSt.setString(2, phoneNumberTextField.getText());
            pSt.setString(3, donationTypeTextField.getText());
            pSt.setString(4, centreNameLabel.getText());
            
            pSt.execute();
            conn.close();
            
            centreNameLabel.setVisible(true);
            addressLabel.setVisible(true);
            phoneNumberLabel.setVisible(true);
            donationTypeLabel.setVisible(true);

            centreNameTextField.setVisible(false);
            addressTextField.setVisible(false);
            phoneNumberTextField.setVisible(false);
            donationTypeTextField.setVisible(false);
            
            // set data into object selected
            selected.setAddress(addressTextField.getText());
            selected.setPhone(phoneNumberTextField.getText());
            selected.setDontype(donationTypeTextField.getText());
            
            addressLabel.setText(selected.getAddress());
            phoneNumberLabel.setText(selected.getPhone());
            donationTypeLabel.setText(selected.getDonType());
            
        }
        isEditing = !isEditing;
    }
    
    @FXML
    public void addNewCentre() throws IOException, SQLException {
        App.setRoot("Add new centre");
    }
    
    @FXML
    public void deleteCentre() throws IOException, SQLException {
        DonorCentre selected = centreListView.getSelectionModel().getSelectedItem();
        centreListView.getItems().remove(selected);
       
       // update database
        App.setDonorCentre(selected);
        String database = "jdbc:sqlite:DonorDatabase.db";
        Connection conn = DriverManager.getConnection(database);
        PreparedStatement pSt = conn.prepareStatement("DELETE FROM donorcentre WHERE name = ?");
        pSt.setString(1, centreNameLabel.getText());
        pSt.executeUpdate();
        
        PreparedStatement pSt1 = conn.prepareStatement("DELETE FROM appointment WHERE donorcentre = ?");
        pSt.setString(1, centreNameLabel.getText());
        pSt.executeUpdate();
        conn.close();
        
        centreListView.getSelectionModel().select(0);
        selectCentre();
    }
    
    @FXML
    public void scheduleAppointment() throws IOException {
        App.setRoot("appointment");
    }
    
}
