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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ShowPatientController implements Initializable {

    @FXML
    private Button showPaBTN;
    @FXML
    private Button showApBTN;
    @FXML
    private Button bookedApBTN;
    @FXML
    private Button logoutBTN;
    @FXML
    private TableView<?> tableView;
    @FXML
    private Button createP;
    @FXML
    private Button updateInfo;
    @FXML
    private Button deleteP;
    @FXML
    private TableColumn<?, ?> idCol;
    @FXML
    private TableColumn<?, ?> userNameCol;
    @FXML
    private TableColumn<?, ?> firstNameCol;
    @FXML
    private TableColumn<?, ?> lastNameCol;
    @FXML
    private TableColumn<?, ?> ageCol;
    @FXML
    private TableColumn<?, ?> genderCol;
    @FXML
    private Button searchBTN;
    @FXML
    private TextField searchTF;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ShowPatient(ActionEvent event) {
        //it here already
    }

    @FXML
    private void ShowAppointment(ActionEvent event) {
        ViewManger.dashBorad.changeSceneToShowAppointment();
    }

    @FXML
    private void BookedAppointment(ActionEvent event) {
        ViewManger.dashBorad.changeSceneToBookedAppointment();
    }

    @FXML
    private void logout(ActionEvent event) {
        ViewManger.closedashBorad();
    }
    

    @FXML
    private void caretePatient(ActionEvent event) {
    }

    @FXML
    private void UpdatePatient(ActionEvent event) {
    }

    @FXML
    private void deletePatient(ActionEvent event) {
    }

    @FXML
    private void search(ActionEvent event) {
    }
    
}
