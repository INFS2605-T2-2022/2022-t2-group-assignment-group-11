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
import javafx.scene.control.cell.PropertyValueFactory;



public class DonorCentreMainController {
//    public static List<DonorCentre> centreList = new ArrayList<>();
    /*
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
    }  */
    
        @FXML
        private ListView<DonorCentre> centreListView;
                
        @FXML
        private Label centreNameLabel;
        
        @FXML
        private Label addressLabel;
        
        @FXML
        private Label phoneNumberLabel;
        
        @FXML
        private Label donationTypeLabel;
        
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
        
        @FXML
        private TableView<Appointment> appointmentTbl;
    
        @FXML
        TableColumn<Appointment, String> donorNameCol;
        
        @FXML
        TableColumn<Appointment, String> dateCol;
        
        @FXML
        TableColumn<Appointment, String> timeCol;
    
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
        //System.out.println(selected.getName());
        pst.setString(1, selectedCentre);
        ObservableList<Appointment> appointmentList = FXCollections.observableArrayList();
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            appointmentList.add(new Appointment(rs.getString(2), rs.getString(3), rs.getString(5), rs.getString(6)));
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
        //get value for checkbox
        
    }
    
    @FXML
    public void createNewDonationType() {

    }
    
    @FXML
    public void addNewCentre() throws IOException {
        App.setRoot("Add new centre");
    }
    
    @FXML
    public void deleteCentre() {
        
    }
    
    @FXML
    public void scheduleAppointment() throws IOException {
        App.setRoot("appointment");
    }
    
}
