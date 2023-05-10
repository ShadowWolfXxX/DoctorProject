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
public class BookedAppointmentController implements Initializable {

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
    private TableColumn<?, ?> idCol;
    @FXML
    private TableColumn<?, ?> appointment_id;
    @FXML
    private TableColumn<?, ?> user_id;
    @FXML
    private TableColumn<?, ?> status;
    @FXML
    private TableColumn<?, ?> doctor_commnet;
    @FXML
    private Button createBP;
    @FXML
    private Button searchBTN;
    @FXML
    private TextField searchTF;
    @FXML
    private Button doneBTN;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ShowPatient(ActionEvent event) {
        ViewManger.dashBorad.changeSceneToShowPation();
    }

    @FXML
    private void ShowAppointment(ActionEvent event) {
        ViewManger.dashBorad.changeSceneToShowAppointment();
    }

    @FXML
    private void BookedAppointment(ActionEvent event) {
                //it here already
    }

    @FXML
    private void logout(ActionEvent event) {
        ViewManger.closedashBorad();
    }


    @FXML
    private void search(ActionEvent event) {
    }

    @FXML
    private void careteBookedAppointment(ActionEvent event) {
    }
    
}
