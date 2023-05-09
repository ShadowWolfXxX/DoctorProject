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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class PatientLoginController implements Initializable {

    @FXML
    private Button loginBTN;
    @FXML
    private TextField emailTF;
    @FXML
    private TextField passwordTF;
    @FXML
    private Button signBTN;
    @FXML
    private Button adminBTN;
    
    ViewManger vm;
            
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void login(ActionEvent event) {
        try {
             vm = ViewManger.getInstance();
        } catch (IOException ex) {
            Logger.getLogger(PatientLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
                vm.changeSceneToDashBoard();
    }

    @FXML
    private void signin(ActionEvent event) {
        try {
             vm = ViewManger.getInstance();
        } catch (IOException ex) {
            Logger.getLogger(PatientLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        vm.changeSceneToPatientRegister();
    }

    @FXML
    private void adminLogin(ActionEvent event) {
        try {
             vm = ViewManger.getInstance();
        } catch (IOException ex) {
            Logger.getLogger(PatientLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
                vm.changeSceneToAdminLogin();

    }
    
}
