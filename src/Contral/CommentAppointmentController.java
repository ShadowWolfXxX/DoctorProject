/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contral;

import static Contral.UpdatePatientController.AddorUpdate;
import Modle.BookedAppointments;
import Modle.User;
import View.ViewManger;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class CommentAppointmentController implements Initializable {

    @FXML
    private Button showPaBTN;
    @FXML
    private Button showApBTN;
    @FXML
    private Button bookedApBTN;
    @FXML
    private Button logoutBTN;
    @FXML
    private Button saveBTN;
    @FXML
    private TextArea commentTA;

    static BookedAppointments ba;

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
        ViewManger.dashBorad.changeSceneToBookedAppointment();

    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
        ViewManger.closedashBorad();

    }

    @FXML
    private void save(ActionEvent event) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url1 = "jdbc:mysql://127.0.0.1:3306/clinic_appointment?serverTimezone=UTC";
            String usernameD = "root";
            String passwordD = "";
            Connection connection = DriverManager.getConnection(url1, usernameD, passwordD);
            Statement statement = connection.createStatement();

            String comment = commentTA.getText();
            if (!(comment.equals(""))) {
                String Query = "UPDATE booked_appointments SET doctor_commnet='" + comment + "' , status='finished' where id="+this.ba.getId();
                int excut = statement.executeUpdate(Query);
                if (excut > -1) {
                    commentTA.clear();
                    ViewManger.dashBorad.changeSceneToBookedAppointment();
                } else {

                }
                statement.close();
                connection.close();
            } else {

            }

        } catch (Exception ex) {
            ex.getStackTrace();
        }
    }

    public static void save(BookedAppointments ba2) {
        ba = ba2;
    }

    @FXML
    private void mycomment(MouseEvent event) {
    }

}
