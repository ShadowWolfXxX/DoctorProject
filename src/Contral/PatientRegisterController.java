/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contral;

import View.ViewManger;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    private RadioButton adminRB;
    @FXML
    private ToggleGroup Role;
    @FXML
    private RadioButton patientRB;
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
    private void signin(ActionEvent event) {
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url1 = "jdbc:mysql://127.0.0.1:3306/clinic_appointment?serverTimezone=UTC";
            String usernameD = "root";
            String passwordD = "";
            Connection connection = DriverManager.getConnection(url1, usernameD, passwordD);
            Statement statement = connection.createStatement();
            String username = usernameTF.getText();
            String email = emailTF.getText();
            String password = passwordTF.getText();
            String Fname = firstNameTF.getText();
            String Lname = lastNameTF.getText();
            String Age = ageTF.getText();
            String Phone = phoneTF.getText();
            RadioButton selectedGender = (RadioButton) Gender.getSelectedToggle();
            String genderName = selectedGender.getText();
            String gender = genderName;
            RadioButton selectedRole = (RadioButton) Role.getSelectedToggle();
            String roleName = selectedRole.getText();
            String role = roleName;
           if(!(username.equals("")||email.equals("")||password.equals("")||Fname.equals("")||Lname.equals("")||Age.equals("")||Phone.equals(""))){
            String Query = "insert into users (username, passwrod, firstname, lastname, age, email, phone, gender, role)"
                    + "VALUES('" + username + "','" + password + "','" + Fname + "','"
                    + Lname + "','" + Age + "','" + email + "','" + Phone + "','" + gender + "','" + role + "')";
            int excut = statement.executeUpdate(Query);
            if (excut>-1) {
                stateInsert.setStyle("-fx-text-fill: green;");
                stateInsert.setText("Add Succesfully");
            }else{
                stateInsert.setStyle("-fx-text-fill: red;");
                stateInsert.setText("Add Falied");
            }
            statement.close();
            connection.close();
            }else{
                 stateInsert.setStyle("-fx-text-fill: red;");
                stateInsert.setText("Add Falied");
            }
            
        } catch (Exception ex) {
            ex.getStackTrace();
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
