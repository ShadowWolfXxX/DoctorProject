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
    private void login(ActionEvent event) throws IOException {
        try {

            Connection c = DB.getinstend().getConntectin();
            Statement statement = c.createStatement();
            String email = emailTF.getText();
            String password = passwordTF.getText();
            ResultSet r = statement.executeQuery("Select id,email,passwrod From users where role='patient'");
            boolean state = false;
            while (r.next()) {
                String emailDB = r.getString("email");
                String passwordDB = r.getString("passwrod");
                if (email.equals(emailDB) && password.equals(passwordDB)) {
                    emailTF.clear();
                    passwordTF.clear();
                    loginState.setText(" ");
                    FreeAppointmentController fa = new FreeAppointmentController();
                    fa.setUserId(r.getInt("id"));
                    MyBookedAppointmentController ma = new MyBookedAppointmentController();
                    ma.setUserId(r.getInt("id"));
                    ViewManger.openpatient();
                    state = true;
                } else {
                    state = false;
                }

            }

            if (!state) {
                loginState.setText("Not Found Account");
            }

        } catch (SQLException ex) {
            Logger.getLogger(PatientLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void signin(ActionEvent event) {
        try {
            ViewManger.getInstance().changeSceneToPatientRegister();
        } catch (IOException ex) {
            Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void adminLogin(ActionEvent event) {
        try {
            ViewManger.getInstance().changeSceneToAdminLogin();
        } catch (IOException ex) {
            Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
