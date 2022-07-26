package au.edu.unsw.infs2605.donationsystem;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddNewCentreController {
    public class newCentre {
        private String centreName;
        private String address;
        private String phoneNumber;
        
        public newCentre() {
            this.centreName = "";
            this.address = "";
            this.phoneNumber = "";
        }
        
        public newCentre (String centreName, String address, String phoneNumber) {
            this.centreName = centreName;
            this.address = address;
            this.phoneNumber = phoneNumber;
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
    }
    
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
        
    public void intialize() {

    } 
    
    @FXML
    private void saveChanges() {
        
    }
    
    @FXML
    private void backToMainScreen() {
        
    }
}
