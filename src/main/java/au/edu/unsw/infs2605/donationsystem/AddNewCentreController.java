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
import javafx.scene.control.TextField;

public class AddNewCentreController implements Initializable {

    @FXML
    private TextField centreNameTextField;
        
    @FXML
    private TextField addressTextField;
        
    @FXML
    private TextField phoneNumberTextField;
        
    @FXML
    private Button saveChangesButton;
        
    @FXML
    private Button backToMainScreenButton;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    } 
    
    @FXML
    private void saveChanges() throws IOException, SQLException {  
        
        //Take user input
        DonorCentre newCentre = new DonorCentre();
        newCentre.setName(centreNameTextField.getText());
        newCentre.setAddress(addressTextField.getText());
        newCentre.setPhone(phoneNumberTextField.getText());
        
        //Store new donor centre to App screen
        App.setDonorCentre(newCentre);
        String database = "jdbc:sqlite:DonorDatabase.db";
        Connection conn = DriverManager.getConnection(database);
        PreparedStatement pSt = conn.prepareStatement("INSERT INTO donorcentre (name, address, phone) "
                + "VALUES (?,?,?)");
        pSt.setString(1, centreNameTextField.getText());
        pSt.setString(2, addressTextField.getText());
        pSt.setString(3, phoneNumberTextField.getText());
        pSt.executeUpdate();
        conn.close();
        App.setRoot("Donor Centre Main");
    }
    
    @FXML
    private void backToMainScreen() throws IOException {
        App.setRoot("Donor Centre Main");
    }
}
