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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ShowPatientController implements Initializable {

    @FXML
    private Button showPaBTN;
    @FXML
    private Button showApBTN;
    @FXML
    private Button bookedApBTN;
    @FXML
    private Button logoutBTN;
    @FXML
    private TableView<User> tableView;
    @FXML
    private Button createP;
    @FXML
    private Button updateInfo;
    @FXML
    private Button deleteP;
    @FXML
    private TableColumn<User, Integer> idCol;
    @FXML
    private TableColumn<User, String> userNameCol;
    @FXML
    private TableColumn<User, String> firstNameCol;
    @FXML
    private TableColumn<User, String> lastNameCol;
    @FXML
    private TableColumn<User, String> ageCol;
    @FXML
    private TableColumn<User, String> genderCol;
    @FXML
    private Button searchBTN;
    @FXML
    private TextField searchTF;
    @FXML
    private Button showBTN;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

       
    }

    @FXML
    private void ShowPatient(ActionEvent event) {
        //it here already
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
    private void caretePatient(ActionEvent event) {
        try {
            FXMLLoader load = new FXMLLoader(getClass().getResource("/View/DoctorFxml/ShowPatient.fxml"));
            Scene scene = new Scene(load.load());
            UpdatePatientController con = load.getController();
            con.save("Create", null);
        } catch (IOException ex) {
            Logger.getLogger(UpdatePatientController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ViewManger.dashBorad.changeSceneToUpdatePation();
        
    }

    @FXML
    private void UpdatePatient(ActionEvent event) {
        try {
            FXMLLoader load = new FXMLLoader(getClass().getResource("/View/DoctorFxml/ShowPatient.fxml"));
            Scene scene = new Scene(load.load());
            UpdatePatientController con = load.getController();
            con.save("Update" , tableView.getSelectionModel().getSelectedItem());
        } catch (IOException ex) {
            Logger.getLogger(UpdatePatientController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ViewManger.dashBorad.changeSceneToUpdatePation();
    }

    @FXML
    private void deletePatient(ActionEvent event) {
        User use = tableView.getSelectionModel().getSelectedItem();
         try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url1 = "jdbc:mysql://127.0.0.1:3306/clinic_appointment?serverTimezone=UTC";
                String usernameD = "root";
                String passwordD = "";
                Connection connection = DriverManager.getConnection(url1, usernameD, passwordD);
                Statement stat = connection.createStatement();
                String Sql = "DELETE FROM users WHERE id=" + use.getId();
                int excut = stat.executeUpdate(Sql);
                tableView.getItems().removeAll(use);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(ShowPatientController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void search(ActionEvent event) {
      
            String word = searchTF.getText();
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url1 = "jdbc:mysql://127.0.0.1:3306/clinic_appointment?serverTimezone=UTC";
                String usernameD = "root";
                String passwordD = "";
                Connection connection = DriverManager.getConnection(url1, usernameD, passwordD);
                Statement stat = connection.createStatement();
                String Sql = "SELECT * FROM users where firstname='" + word + "' and role='patient'";
                ResultSet rs = stat.executeQuery(Sql);
                this.tableView.getItems().clear();
                while (rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setUsername(rs.getString("username"));
                    user.setFirstname(rs.getString("firstname"));
                    user.setLastname(rs.getString("lastname"));
                    user.setAge(rs.getString("age"));
                    user.setGender(rs.getString("gender"));
                    this.tableView.getItems().add(user);
                }
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(ShowPatientController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    @FXML
    private void ShowPatientRelsut(ActionEvent event) {
         try {
            // TODO
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url1 = "jdbc:mysql://127.0.0.1:3306/clinic_appointment?serverTimezone=UTC";
            String usernameD = "root";
            String passwordD = "";
            Connection connection = DriverManager.getConnection(url1, usernameD, passwordD);
            Statement stat = connection.createStatement();

            idCol.setCellValueFactory(new PropertyValueFactory("id"));
            userNameCol.setCellValueFactory(new PropertyValueFactory("username"));
            firstNameCol.setCellValueFactory(new PropertyValueFactory("firstname"));
            lastNameCol.setCellValueFactory(new PropertyValueFactory("lastname"));
            ageCol.setCellValueFactory(new PropertyValueFactory("age"));
            genderCol.setCellValueFactory(new PropertyValueFactory("gender"));

            String Sql = "SELECT * FROM users where role='patient' ";
            ResultSet rs = stat.executeQuery(Sql);
            this.tableView.getItems().clear();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setFirstname(rs.getString("firstname"));
                user.setLastname(rs.getString("lastname"));
                user.setAge(rs.getString("age"));
                user.setGender(rs.getString("gender"));
                user.setRole(rs.getString("role"));
                this.tableView.getItems().add(user);
            }
        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ShowPatientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

}
