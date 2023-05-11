/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contral;

import static Contral.UpdatePatientController.AddorUpdate;
import Modle.Appointment;
import View.ViewManger;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class UpdateAppointmentController implements Initializable {

    @FXML
    private Button showPaBTN;
    @FXML
    private Button showApBTN;
    @FXML
    private Button bookedApBTN;
    @FXML
    private Button logoutBTN;
    @FXML
    private Button submitBTN;
    @FXML
    private Button backBTN;
    @FXML
    private Button oldDate;
    @FXML
    private DatePicker appDate;
    @FXML
    private DatePicker appDay;
    @FXML
    private DatePicker appTime;

    static String AddorUpdate;
    static Appointment app;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public static void save(String AddorUpdate2, Appointment app2) {
        AddorUpdate = AddorUpdate2;
        app = app2;
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
//        if (AddorUpdate.equals("Create")) {
//            try {
//                Class.forName("com.mysql.cj.jdbc.Driver");
//                String url1 = "jdbc:mysql://127.0.0.1:3306/clinic_appointment?serverTimezone=UTC";
//                String usernameD = "root";
//                String passwordD = "";
//                Connection connection = DriverManager.getConnection(url1, usernameD, passwordD);
//                Statement statement = connection.createStatement();
//                String username = usernameTF.getText();
//                String email = emailTF.getText();
//                String password = passwordTF.getText();
//                String Fname = firstNameTF.getText();
//                String Lname = lastNameTF.getText();
//                String Age = ageTF.getText();
//                String Phone = phoneTF.getText();
//                RadioButton selectedGender = (RadioButton) ge.getSelectedToggle();
//                String gender = selectedGender.getText();
//                String role = "patient";
//                if (!(username.equals("") || email.equals("") || password.equals("") || Fname.equals("") || Lname.equals("") || Age.equals("") || Phone.equals(""))) {
//                    String Query = "insert into users (username, passwrod, firstname, lastname, age, email, phone, gender, role)"
//                            + "VALUES('" + username + "','" + password + "','" + Fname + "','"
//                            + Lname + "','" + Age + "','" + email + "','" + Phone + "','" + gender + "','" + role + "')";
//                    int excut = statement.executeUpdate(Query);
//                    if (excut > -1) {
//                        usernameTF.clear();
//                        emailTF.clear();
//                        passwordTF.clear();
//                        firstNameTF.clear();
//                        lastNameTF.clear();
//                        ageTF.clear();
//                        phoneTF.clear();
//                        ViewManger.dashBorad.changeSceneToShowPation();
//                    } else {
//
//                    }
//                    statement.close();
//                    connection.close();
//                } else {
//
//                }
//
//            } catch (Exception ex) {
//                ex.getStackTrace();
//            }
//        } else if (AddorUpdate.equals("Update")) {
//            try {
//                Class.forName("com.mysql.cj.jdbc.Driver");
//                String url1 = "jdbc:mysql://127.0.0.1:3306/clinic_appointment?serverTimezone=UTC";
//                String usernameD = "root";
//                String passwordD = "";
//                Connection connection = DriverManager.getConnection(url1, usernameD, passwordD);
//                Statement statement = connection.createStatement();
//                String username = usernameTF.getText();
//                String email = emailTF.getText();
//                String password = passwordTF.getText();
//                String Fname = firstNameTF.getText();
//                String Lname = lastNameTF.getText();
//                String Age = ageTF.getText();
//                String Phone = phoneTF.getText();
//                RadioButton selectedGender = (RadioButton) ge.getSelectedToggle();
//                String genderName = selectedGender.getText();
//                String gender = genderName;
//                String roleName = "patient";
//                String role = roleName;
//                if (!(username.equals("") || email.equals("") || password.equals("") || Fname.equals("") || Lname.equals("") || Age.equals("") || Phone.equals(""))) {
//                    String Query = "UPDATE users SET username = '" + username + "' , passwrod = '" + password + "' , firstname ='" + Fname + "' , lastname ='" + Lname + "' , age ='" + Age + "' , email ='" + email + "' , gender ='" + gender + "' , role ='" + role + "' where id =" + this.use.getId();
//                    int excut = statement.executeUpdate(Query);
//                    if (excut > -1) {
//                        usernameTF.clear();
//                        emailTF.clear();
//                        passwordTF.clear();
//                        firstNameTF.clear();
//                        lastNameTF.clear();
//                        ageTF.clear();
//                        phoneTF.clear();
//                        ViewManger.dashBorad.changeSceneToShowPation();
//                    } else {
//
//                    }
//                    statement.close();
//                    connection.close();
//                } else {
//
//                }
//
//            } catch (Exception ex) {
//                ex.getStackTrace();
//            }
//        } else {
//            //error here
//        }
    }

    @FXML
    private void goback(ActionEvent event) {
//        appDate.setValue(LocalDate.parse(""));
        appDate.setValue(null);
        appDay.setValue(null);
        appTime.setValue(null);
        ViewManger.dashBorad.changeSceneToShowAppointment();
    }

    @FXML
    private void showOldData(ActionEvent event) {
//         if (!Objects.isNull(use)) {
//            usernameTF.setText(use.getUsername());
//            passwordTF.setText(use.getPasswrod());
//            emailTF.setText(use.getEmail());
//            firstNameTF.setText(use.getFirstname());
//            lastNameTF.setText(use.getLastname());
//            ageTF.setText(use.getAge());
//            phoneTF.setText(use.getPhone());
//            if (use.getGender().equals("Male")) {
//                genderMaleRB.setSelected(true);
//                genderFemaleRB.setSelected(false);
//            } else {
//                genderMaleRB.setSelected(false);
//                genderFemaleRB.setSelected(true);
//            }
//        }
    }

    @FXML
    private void MakeDate(ActionEvent event) {
    }

    @FXML
    private void MakeDay(ActionEvent event) {
    }

    @FXML
    private void MakeTime(ActionEvent event) {
    }

}
