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

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ShowMyDoctorCommentController implements Initializable {

    @FXML
    private Button FreeAppBTN;
    @FXML
    private Button BookedAppBTN;
    @FXML
    private Button logoutBTN;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void FreeAppointment(ActionEvent event) {
    }

    @FXML
    private void MyBookedAppointment(ActionEvent event) {
    }

    @FXML
    private void Logout(ActionEvent event) {
    }
    
}
