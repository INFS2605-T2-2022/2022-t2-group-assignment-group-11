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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AddNewCentreController implements Initializable {

    @FXML
    private TextField centreNameTextField;
        
    @FXML
    private TextField addressTextField;
        
    @FXML
    private TextField phoneNumberTextField;
    
    @FXML
    private TextField donationTypeTextField;
        
    @FXML
    private Button saveChangesButton;
        
    @FXML
    private Button backToMainScreenButton;
    
    @FXML
    private ImageView donorCentreImageView;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image donorCentreImage = new Image(App.class.getResourceAsStream("img\\donor centre.jpg"));
        donorCentreImageView.setImage(donorCentreImage);
    } 
    
    @FXML
    private void saveChanges() throws IOException, SQLException {  
        
        //Take user input
        DonorCentre newCentre = new DonorCentre();
        newCentre.setName(centreNameTextField.getText());
        newCentre.setAddress(addressTextField.getText());
        newCentre.setPhone(phoneNumberTextField.getText());
        newCentre.setDontype(donationTypeTextField.getText());
        
        //Store new donor centre to App screen
        App.setDonorCentre(newCentre);
        String database = "jdbc:sqlite:DonorDatabase.db";
        Connection conn = DriverManager.getConnection(database);
        PreparedStatement pSt = conn.prepareStatement("INSERT INTO donorcentre (name, address, phone, dontype) "
                + "VALUES (?,?,?,?)");
        pSt.setString(1, centreNameTextField.getText());
        pSt.setString(2, addressTextField.getText());
        pSt.setString(3, phoneNumberTextField.getText());
        pSt.setString(4, donationTypeTextField.getText());
        
        pSt.executeUpdate();
        conn.close();
        App.setRoot("Donor Centre Main");
    }
    
    @FXML
    private void backToMainScreen() throws IOException {
        App.setRoot("Donor Centre Main");
    }
}
