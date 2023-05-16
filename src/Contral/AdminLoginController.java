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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AdminLoginController implements Initializable {

    @FXML
    private Button gobackBTN;
    @FXML
    private Button loginBTN;
    @FXML
    private TextField emailTF;
    @FXML
    private PasswordField PasswordTF;
    
    @FXML
    private Label loginState;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void goback(ActionEvent event) {
        try {
            ViewManger.getInstance().changeSceneToPatientLogin();
        } catch (IOException ex) {
            Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void login(ActionEvent event) throws IOException, SQLException {
        ArrayList<User> ar = User.getAllForAdmin();
        String email = emailTF.getText();
        String password = PasswordTF.getText();
        boolean state = false;

        for (User user : ar) {
            if (email.equals(user.getEmail()) && password.equals(user.getPasswrod())) {
                emailTF.clear();
                PasswordTF.clear();
                loginState.setText(" ");
                FreeAppointmentController fa = new FreeAppointmentController();
                fa.setUserId(user.getId());
                MyBookedAppointmentController ma = new MyBookedAppointmentController();
                ma.setUserId(user.getId());
                ViewManger.opendashBorad();
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
            
           
            
       
    }
    

