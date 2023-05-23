/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contral;

import Modle.User;
import View.ViewManger;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class PatientRegisterController implements Initializable {

    @FXML
    private RadioButton genderMaleRB;
    @FXML
    private ToggleGroup Gender;
    @FXML
    private RadioButton genderFemaleRB;
    @FXML
    private Button signBTN;
    @FXML
    private Button goBackBTN;
    @FXML
    private TextField usernameTF;
    @FXML
    private TextField emailTF;
    @FXML
    private TextField passwordTF;
    @FXML
    private TextField lastNameTF;
    @FXML
    private TextField firstNameTF;
    @FXML
    private TextField ageTF;
    @FXML
    private TextField phoneTF;

    @FXML
    private Label stateInsert;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void signin(ActionEvent event) throws SQLException, IOException {
ArrayList<User> ul = User.getAllForAdmin();
if(ul.isEmpty()){
        String username = usernameTF.getText();
        String email = emailTF.getText();
        String password = passwordTF.getText();
        String Fname = firstNameTF.getText();
        String Lname = lastNameTF.getText();
        String Age = ageTF.getText();
        String Phone = phoneTF.getText();
        String gender = ((RadioButton) Gender.getSelectedToggle()).getText();
        User user = new User(username, Fname, Lname, email, password, Age, Phone, gender, "Admin");
        int excut = user.save();

        if (excut > 0) {
            usernameTF.clear();
            emailTF.clear();
            passwordTF.clear();
            firstNameTF.clear();
            lastNameTF.clear();
            ageTF.clear();
            phoneTF.clear();
            Alert alret = new Alert(Alert.AlertType.CONFIRMATION);
            alret.setContentText("User have been add it");
            alret.showAndWait();
            ViewManger.getInstance().changeSceneToPatientLogin();
        }
}else{
    String username = usernameTF.getText();
        String email = emailTF.getText();
        String password = passwordTF.getText();
        String Fname = firstNameTF.getText();
        String Lname = lastNameTF.getText();
        String Age = ageTF.getText();
        String Phone = phoneTF.getText();
        String gender = ((RadioButton) Gender.getSelectedToggle()).getText();
        User user = new User(username, Fname, Lname, email, password, Age, Phone, gender, "patient");
        int excut = user.save();

        if (excut > 0) {
            usernameTF.clear();
            emailTF.clear();
            passwordTF.clear();
            firstNameTF.clear();
            lastNameTF.clear();
            ageTF.clear();
            phoneTF.clear();
            Alert alret = new Alert(Alert.AlertType.CONFIRMATION);
            alret.setContentText("User have been add it");
            alret.showAndWait();
            ViewManger.getInstance().changeSceneToPatientLogin();
        }
}
    }

    @FXML
    private void goback(ActionEvent event) {
        try {
            ViewManger.getInstance().changeSceneToPatientLogin();
        } catch (IOException ex) {
            Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
