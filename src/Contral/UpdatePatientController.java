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

    static String AddorUpdate;

    @FXML
    private Button submitBTN;
    @FXML
    private Button backBTN;
    @FXML
    private ToggleGroup ge;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        User use = ShowPatientController.use;
//        usernameTF.setText(use.getUsername());
//
//        if (use.getGender().equals("famela")) {
//
//        }
    }

    public static void save(String AddorUpdate2, User use2) {
        AddorUpdate = AddorUpdate2;
    }

  

    @FXML
    private void signin(ActionEvent event) throws SQLException, IOException {
        if (AddorUpdate.equals("Create")) {
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
                ViewManger.dashBorad.changeSceneToShowPation();
            }
        } else if (AddorUpdate.equals("Update")) {
            String username = usernameTF.getText();
            String email = emailTF.getText();
            String password = passwordTF.getText();
            String Fname = firstNameTF.getText();
            String Lname = lastNameTF.getText();
            String Age = ageTF.getText();
            String Phone = phoneTF.getText();
            RadioButton genderrd = (RadioButton) ge.getSelectedToggle();
            String gender = genderrd.getText();
            //id
            String role = "patient";
            User user = new User(username, Fname, Lname, email, password, Age, Phone, gender, role);
            int excut = user.save();

            if (excut > 0) {
                ShowPatientController.updateCrate.close();
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
                ViewManger.dashBorad.changeSceneToShowPation();
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
        ViewManger.dashBorad.changeSceneToShowPation();
    }

   
    

}
