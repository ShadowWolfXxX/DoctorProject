/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contral;

import Modle.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class UpdatePatientController implements Initializable {

    @FXML
    private Button showPaBTN;
    @FXML
    private Button showApBTN;
    @FXML
    private Button bookedApBTN;
    @FXML
    private Button logoutBTN;
    @FXML
    private RadioButton genderMaleRB;
    @FXML
    private ToggleGroup Gender;
    @FXML
    private RadioButton genderFemaleRB;
    @FXML
    private Button signBTN;
    @FXML
    private TextField usernameTF;
    @FXML
    private TextField emailTF;
    @FXML
    private TextField lastNameTF;
    @FXML
    private TextField firstNameTF;
    @FXML
    private TextField ageTF;
    @FXML
    private TextField phoneTF;
    @FXML
    private PasswordField passwordTF;
    
    String AddorUpdate;
    User use;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
    
    public void save(String AddorUpdate , User use){
    this.AddorUpdate = AddorUpdate;
    this.use = use;
     };
    
    @FXML
    private void ShowPatient(ActionEvent event) {
    }

    @FXML
    private void ShowAppointment(ActionEvent event) {
    }

    @FXML
    private void BookedAppointment(ActionEvent event) {
    }

    @FXML
    private void logout(ActionEvent event) {
    }

    @FXML
    private void signin(ActionEvent event) {
    }
    
}
