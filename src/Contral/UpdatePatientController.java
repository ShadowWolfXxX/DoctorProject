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
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class UpdatePatientController implements Initializable {

    @FXML
    private RadioButton genderMaleRB;
    @FXML
    private RadioButton genderFemaleRB;
    @FXML
    private TextField usernameTF;
    @FXML
    private TextField emailTF;
    @FXML
    private TextField lastNameTF;
    @FXML
    private TextField firstNameTF;
    @FXML
    private TextField ageTF;
    @FXML
    private TextField phoneTF;
    @FXML
    private PasswordField passwordTF;
    @FXML
    private Button submitBTN;
    @FXML
    private Button backBTN;
    @FXML
    private ToggleGroup ge;

    private User oldUser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (ShowPatientController.statie.equals("update")) {
            this.oldUser = ShowPatientController.use;
            usernameTF.setText(oldUser.getUsername());
            emailTF.setText(oldUser.getEmail());
            passwordTF.setText(oldUser.getPasswrod());
            firstNameTF.setText(oldUser.getFirstname());
            lastNameTF.setText(oldUser.getLastname());
            phoneTF.setText(oldUser.getPhone());
            ageTF.setText(oldUser.getAge());
            if (oldUser.getGender().equals("Female")) {
                ge.selectToggle(genderFemaleRB);
            }else{
                ge.selectToggle(genderMaleRB);
            }

        } else {

        }
    }

 

    @FXML
    private void signin(ActionEvent event) throws SQLException, IOException {
        if (ShowPatientController.statie.equals("create")) {
            String username = usernameTF.getText();
            String email = emailTF.getText();
            String password = passwordTF.getText();
            String Fname = firstNameTF.getText();
            String Lname = lastNameTF.getText();
            String Age = ageTF.getText();
            String Phone = phoneTF.getText();
            RadioButton genderrd = (RadioButton) ge.getSelectedToggle();
            String gender = genderrd.getText();
            String role = "patient";
            User user = new User(username, Fname, Lname, email, password, Age, Phone, gender, role);
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
                ShowPatientController.updateCrate.close();
            }
        } else if (ShowPatientController.statie.equals("update")) {
            String username = usernameTF.getText();
            String email = emailTF.getText();
            String password = passwordTF.getText();
            String Fname = firstNameTF.getText();
            String Lname = lastNameTF.getText();
            String Age = ageTF.getText();
            String Phone = phoneTF.getText();
            RadioButton genderrd = (RadioButton) ge.getSelectedToggle();
            String gender = genderrd.getText();
            String role = "patient";
            User user = new User(username, Fname, Lname, email, password, Age, Phone, gender, role);
            user.setId(this.oldUser.getId());
            int excut = user.update();

            if (excut > 0) {
                usernameTF.clear();
                emailTF.clear();
                passwordTF.clear();
                firstNameTF.clear();
                lastNameTF.clear();
                ageTF.clear();
                phoneTF.clear();
                Alert alret = new Alert(Alert.AlertType.CONFIRMATION);
                alret.setContentText("User have been Updating it");
                alret.showAndWait();
                ShowPatientController.updateCrate.close();
            } else {
                //error here
            }
        }
    }

    @FXML
    private void goback(ActionEvent event) {
        usernameTF.clear();
        emailTF.clear();
        passwordTF.clear();
        firstNameTF.clear();
        lastNameTF.clear();
        ageTF.clear();
        phoneTF.clear();
        ShowPatientController.updateCrate.close();

    }

}
