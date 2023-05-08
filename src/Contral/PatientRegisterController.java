/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contral;

import View.ViewManger;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class PatientRegisterController implements Initializable {

    @FXML
    private RadioButton genderMaleRB;
    @FXML
    private ToggleGroup Gender;
    @FXML
    private RadioButton adminRB;
    @FXML
    private ToggleGroup Role;
    @FXML
    private RadioButton patientRB;
    @FXML
    private RadioButton genderFemaleRB;
    @FXML
    private Button signBTN;
    @FXML
    private Button goBackBTN;
    @FXML
    private TextField usernameTF;
    @FXML
    private TextField emailTF;
    @FXML
    private TextField passwordTF;
    @FXML
    private TextField lastNameTF;
    @FXML
    private TextField firstNameTF;
    @FXML
    private TextField ageTF;
    @FXML
    private TextField phoneTF;

    ViewManger vm;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void signin(ActionEvent event) {
    }

    @FXML
    private void goback(ActionEvent event) {
         try {
             vm = ViewManger.getInstance();
        } catch (IOException ex) {
            Logger.getLogger(PatientLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        vm.changeSceneToPatientLogin();
    }
    
}
