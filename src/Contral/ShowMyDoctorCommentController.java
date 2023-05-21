/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contral;

import Modle.BookedAppointments;
import View.ViewManger;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ShowMyDoctorCommentController implements Initializable {

    @FXML
    private Button showComBTN;
    @FXML
    private Label commentShow;
    @FXML
    private Button backBTN;
    
        private static int appId;



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private void FreeAppointment(ActionEvent event) {
        ViewManger.patient.changeSceneToFreeAppointment();

    }

    private void MyBookedAppointment(ActionEvent event) {
        ViewManger.patient.changeSceneToMyBookedAppointment();

    }

    private void Logout(ActionEvent event) throws IOException {
        ViewManger.closepatient();

    }

    @FXML
    private void showComment(ActionEvent event) throws SQLException {
       commentShow.setText(BookedAppointments.getComment(appId));
    }

    @FXML
    private void goBack(ActionEvent event) {
        commentShow.setText("");
        ViewManger.patient.changeSceneToMyBookedAppointment();
    }


    public static void setAppId(int aAppId) {
        appId = aAppId;
    }

}
