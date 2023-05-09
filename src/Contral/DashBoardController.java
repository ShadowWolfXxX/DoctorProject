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

/**
 * FXML Controller class
 *
 * @author HP
 */
public class DashBoardController implements Initializable {

    @FXML
    private Button showPaBTN;
    @FXML
    private Button createPaBTN;
    @FXML
    private Button showApBTN;
    @FXML
    private Button createApBTN;
    @FXML
    private Button bookedApBTN;
    @FXML
    private Button logoutBTN;
    
    ViewManger vm;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ShowPatient(ActionEvent event) {
    }

    @FXML
    private void CreatePatient(ActionEvent event) {
    }

    @FXML
    private void ShowAppointment(ActionEvent event) {
    }

    @FXML
    private void CreateAppointment(ActionEvent event) {
    }

    @FXML
    private void BookedAppointment(ActionEvent event) {
    }

    @FXML
    private void logout(ActionEvent event) {
        try {
             vm = ViewManger.getInstance();
        } catch (IOException ex) {
            Logger.getLogger(PatientLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
                vm.changeSceneToPatientLogin();
    }
    
}
