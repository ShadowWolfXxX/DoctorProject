/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contral;

import View.ViewManger;
import java.net.URL;
import java.util.ResourceBundle;
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
public class FreeAppointmentController implements Initializable {

    @FXML
    private Button FreeAppBTN;
    @FXML
    private Button BookedAppBTN;
    @FXML
    private Button logoutBTN;
    @FXML
    private TableView<?> viewTable;
    @FXML
    private TableColumn<?, ?> appointmentDate;
    @FXML
    private TableColumn<?, ?> appointmentDay;
    @FXML
    private TableColumn<?, ?> appointmentTime;
    @FXML
    private TableColumn<?, ?> status;
    @FXML
    private Button bookedABTN;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void FreeAppointment(ActionEvent event) {
        //here already
    }

    @FXML
    private void MyBookedAppointment(ActionEvent event) {
        ViewManger.patient.changeSceneToMyBookedAppointment();
    }

    @FXML
    private void Logout(ActionEvent event) {
                ViewManger.closepatient();

    }

    @FXML
    private void BookedAppointment(ActionEvent event) {
    }
    
}
