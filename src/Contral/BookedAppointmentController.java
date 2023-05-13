/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contral;

import Modle.BookedAppointments;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class BookedAppointmentController implements Initializable {

    @FXML
    private Button showPaBTN;
    @FXML
    private Button showApBTN;
    @FXML
    private Button bookedApBTN;
    @FXML
    private Button logoutBTN;
    @FXML
    private TableView<BookedAppointments> tableView;
    @FXML
    private TableColumn<BookedAppointments, Integer> idCol;
    @FXML
    private TableColumn<BookedAppointments, Integer> appointment_id;
    @FXML
    private TableColumn<BookedAppointments, Integer> user_id;
    @FXML
    private TableColumn<BookedAppointments, String> status;
    @FXML
    private TableColumn<BookedAppointments, String> doctor_commnet;
    @FXML
    private Button searchBTN;
    @FXML
    private TextField searchTF;
    @FXML
    private Button doneBTN;
    @FXML
    private Button showBTN;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
        //it here already
    }

    @FXML
    private void logout(ActionEvent event) {
        ViewManger.closedashBorad();
    }

    @FXML
    private void search(ActionEvent event) {

        String word = searchTF.getText();
        int id = -1 ;
        try {
            // TODO
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url1 = "jdbc:mysql://127.0.0.1:3306/clinic_appointment?serverTimezone=UTC";
            String usernameD = "root";
            String passwordD = "";
            Connection connection = DriverManager.getConnection(url1, usernameD, passwordD);
            Statement stat = connection.createStatement();

            idCol.setCellValueFactory(new PropertyValueFactory("id"));
            appointment_id.setCellValueFactory(new PropertyValueFactory("appointment_id"));
            user_id.setCellValueFactory(new PropertyValueFactory("user_id"));
            status.setCellValueFactory(new PropertyValueFactory("status"));
            doctor_commnet.setCellValueFactory(new PropertyValueFactory("doctor_commnet"));
            String Sql2 = "SELECT id FROM users where firstname ='"+word+"'";
            ResultSet rs2 = stat.executeQuery(Sql2);
             while (rs2.next()) {
                  id = rs2.getInt("id");
             }
            String Sql = "SELECT * FROM booked_appointments where user_id  ="+id;
            ResultSet rs = stat.executeQuery(Sql);
            this.tableView.getItems().clear();
            while (rs.next()) {
                BookedAppointments ba = new BookedAppointments();
                ba.setId(rs.getInt("id"));
                ba.setAppointment_id(rs.getInt("appointment_id"));
                ba.setUser_id(rs.getInt("user_id"));
                ba.setStatus(rs.getString("status"));
                ba.setDoctor_commnet(rs.getString("doctor_commnet"));
                this.tableView.getItems().add(ba);
            }
        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ShowPatientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ShowAppointmentRelsut(ActionEvent event) {
        try {
            // TODO
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url1 = "jdbc:mysql://127.0.0.1:3306/clinic_appointment?serverTimezone=UTC";
            String usernameD = "root";
            String passwordD = "";
            Connection connection = DriverManager.getConnection(url1, usernameD, passwordD);
            Statement stat = connection.createStatement();

            idCol.setCellValueFactory(new PropertyValueFactory("id"));
            appointment_id.setCellValueFactory(new PropertyValueFactory("appointment_id"));
            user_id.setCellValueFactory(new PropertyValueFactory("user_id"));
            status.setCellValueFactory(new PropertyValueFactory("status"));
            doctor_commnet.setCellValueFactory(new PropertyValueFactory("doctor_commnet"));

            String Sql = "SELECT * FROM booked_appointments ";
            ResultSet rs = stat.executeQuery(Sql);
            this.tableView.getItems().clear();
            while (rs.next()) {
                BookedAppointments ba = new BookedAppointments();
                ba.setId(rs.getInt("id"));
                ba.setAppointment_id(rs.getInt("appointment_id"));
                ba.setUser_id(rs.getInt("user_id"));
                ba.setStatus(rs.getString("status"));
                ba.setDoctor_commnet(rs.getString("doctor_commnet"));
                this.tableView.getItems().add(ba);
            }
        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ShowPatientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
