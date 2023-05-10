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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class UpdatePatientController implements Initializable {

    @FXML
    private Button showPaBTN;
    @FXML
    private Button showApBTN;
    @FXML
    private Button bookedApBTN;
    @FXML
    private Button logoutBTN;
    @FXML
    private RadioButton genderMaleRB;
    @FXML
    private ToggleGroup Gender;
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
    static User use;

    @FXML
    private Button submitBTN;
    @FXML
    private Button backBTN;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public static void save(String AddorUpdate2, User use2) {
        AddorUpdate = AddorUpdate2;
        use = use2;
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
    private void logout(ActionEvent event) {
        ViewManger.closedashBorad();
    }

    @FXML
    private void signin(ActionEvent event) {
        System.out.println(AddorUpdate +"  "+use);
        if (AddorUpdate.equals("Create")) {
            // make insert user
        } else if (AddorUpdate.equals("Update")) {
            // make update querry on the selectd user
        } else {
            //error here
        }
    }

    @FXML
    private void goback(ActionEvent event) {
        ViewManger.dashBorad.changeSceneToShowPation();
    }

}
