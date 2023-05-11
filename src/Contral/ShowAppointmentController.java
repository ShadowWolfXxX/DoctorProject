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

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ShowAppointmentController implements Initializable {

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
    private Button updateInfo;
    @FXML
    private TableColumn<?, ?> appointment_date;
    @FXML
    private TableColumn<?, ?> appointment_day;
    @FXML
    private TableColumn<?, ?> appointment_time;
    @FXML
    private TableColumn<?, ?> status;
    @FXML
    private Button createA;
    @FXML
    private Button deleteA;
    @FXML
    private Button showBTN;

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
                //it here already
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
    private void careteAppointment(ActionEvent event) {
                ViewManger.dashBorad.changeSceneToUpdateAppointment();

    }

    @FXML
    private void UpdateAppointment(ActionEvent event) {
                ViewManger.dashBorad.changeSceneToUpdateAppointment();

    }

    @FXML
    private void deleteAppointment(ActionEvent event) {
    }

    @FXML
    private void ShowAppointmentRelsut(ActionEvent event) {
    }
    
}
