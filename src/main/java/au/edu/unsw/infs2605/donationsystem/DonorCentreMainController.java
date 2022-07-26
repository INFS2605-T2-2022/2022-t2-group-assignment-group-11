package au.edu.unsw.infs2605.donationsystem;

import java.sql.Connection;
import java.sql.DriverManager;
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
import javafx.collections.FXCollections;



public class DonorCentreMainController {
    public class Centre {
        private String centreName;
        private String address;
        private String phoneNumber;
        private String donationType;
        
        public Centre() {
            this.centreName = "";
            this.address = "";
            this.phoneNumber = "";
            this.donationType = "";
        }
        public Centre(String centreName) {
            this.centreName = centreName;
        }
        
        public Centre (String centreName, String address, String phoneNumber, String donationType) {
            this.centreName = centreName;
            this.address = address;
            this.phoneNumber = phoneNumber;
            this.donationType = donationType;
        }
        
        public String getCentreName() {
            return this.centreName;
        }
        
        public void setCentreName(String centreName) {
            this.centreName = centreName;
        }
        
        public String getAddress() {
            return this.address;
        }
        
        public void setAddress(String address) {
            this.address = address;
        }
        
        public String getPhoneNumber() {
            return this.phoneNumber;
        }
        
        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
        
        public String getDonationType() {
            return this.donationType;
        }
        
        public void setDonationType(String donationType) {
            this.donationType = donationType;
        }
        
        @Override
        public String toString() {
            return this.centreName;
        }
    }  
    
        @FXML
        private ListView<Centre> centreListView;
                
        @FXML
        private Label centreNameLabel;
        
        @FXML
        private Label addressLabel;
        
        @FXML
        private Label phoneNumberLabel;
        
        @FXML 
        private CheckBox bloodCheckBox;
        
        @FXML
        private CheckBox plasmaCheckBox;
        
        @FXML 
        private Button addNewCentreButton;
        
        @FXML
        private Button deleteCentreButton;
        
        @FXML
        private Button createNewDonationTypeButton;
        
        @FXML
        private Button scheduleAppointmentButton;
    
    public void initialize() throws SQLException {
        
        final String database = "jdbc:sqlite:DonorDatabase.db";
        Connection conn = DriverManager.getConnection(database);
        Statement st = conn.createStatement();
        //get data from database
        String query = "SELECT name FROM donorcentre";
        ResultSet rs = st.executeQuery(query);
        
        List<Centre> centreList = FXCollections.observableArrayList();
        
        while (rs.next()) {
            centreList.add(new Centre(rs.getString(1)));
        }
        for (Centre centre : centreList) {
            centreListView.getItems().add(centre);
        }
    }
    
    @FXML
    private void selectCentre() {
//        Centre selected = centreListView.getSelectionModel().getSelectedItem();
//        
//        centreNameLabel.setText(selected.getCentreName());
//        addressLabel.setText(selected.getAddress());
//        phoneNumberLabel.setText(selected.getPhoneNumber());
//        
        //get value for checkbox
        
    }
    
    @FXML
    private void createNewDonationType() {

    }
    
    @FXML
    private void addNewCentre(ActionEvent event) {
        //App.setRoot("AddNewCentreController");
    }
    
    @FXML
    private void deleteCentre() {
        
    }
    
    @FXML
    private void scheduleAppointment() {
//        App.setRoot("appointment");
    }
    
}
