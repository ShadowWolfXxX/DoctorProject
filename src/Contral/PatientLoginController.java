/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contral;

import Modle.DB;
import Modle.User;
import View.ViewManger;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    @FXML
    private Label loginState;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void login(ActionEvent event) throws IOException, SQLException {
        ArrayList<User> ar = User.getAll();
        String email = emailTF.getText();
        String password = passwordTF.getText();
        boolean state = false;

        for (User user : ar) {
            if (email.equals(user.getEmail()) && password.equals(user.getPasswrod())) {
                emailTF.clear();
                passwordTF.clear();
                loginState.setText(" ");
                FreeAppointmentController fa = new FreeAppointmentController();
                fa.setUserId(user.getId());
                MyBookedAppointmentController ma = new MyBookedAppointmentController();
                ma.setUserId(user.getId());
                ViewManger.openpatient();
                state = true;
                break;
            } else {
                state = false;
            }
        }
        if (!state) {
            loginState.setText("Not Found Account");
        } else {
            loginState.setText(" ");
        }

    }

    @FXML
    private void signin(ActionEvent event
    ) {
        try {
            ViewManger.getInstance().changeSceneToPatientRegister();
        } catch (IOException ex) {
            Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void adminLogin(ActionEvent event
    ) {
        try {
            ViewManger.getInstance().changeSceneToAdminLogin();
        } catch (IOException ex) {
            Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
