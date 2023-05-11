/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contral;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class UpdateAppointmentController implements Initializable {

    @FXML
    private Button showPaBTN;
    @FXML
    private Button showApBTN;
    @FXML
    private Button bookedApBTN;
    @FXML
    private Button logoutBTN;
    @FXML
    private Button submitBTN;
    @FXML
    private Button backBTN;
    @FXML
    private Button oldDate;
    @FXML
    private DatePicker appDate;
    @FXML
    private DatePicker appDay;
    @FXML
    private DatePicker appTime;

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

    @FXML
    private void goback(ActionEvent event) {
    }

    @FXML
    private void showOldData(ActionEvent event) {
    }

    @FXML
    private void MakeDate(ActionEvent event) {
    }

    @FXML
    private void MakeDay(ActionEvent event) {
    }

    @FXML
    private void MakeTime(ActionEvent event) {
    }
    
}
