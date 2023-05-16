/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contral;

import Modle.DB;
import View.ViewManger;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    private void login(ActionEvent event) {
        try {

           Connection c = DB.getinstend().getConntectin();
            Statement statement = c.createStatement();
            String email = emailTF.getText();
            String password = PasswordTF.getText();
            ResultSet r = statement.executeQuery("Select email,passwrod From users where role='Admin'");
            boolean state = false;
            while (r.next()) {
                String emailDB = r.getString("email");
                String passwordDB = r.getString("passwrod");
                if (email.equals(emailDB) && password.equals(passwordDB)) {
                    emailTF.clear();
                    PasswordTF.clear();
                    loginState.setText(" ");
                    ViewManger.opendashBorad();
                    ViewManger.dashBorad.changeSceneToDashBord();
                    state = true;
                    break;
                } else {
                    state = false;
                }

            }
            
            if(!state){loginState.setText("Not Found Account");}else{loginState.setText(" ");}
            
        } catch (SQLException ex) {
            Logger.getLogger(PatientLoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AdminLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
