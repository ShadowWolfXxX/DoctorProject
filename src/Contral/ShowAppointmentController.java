/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contral;

import Modle.Appointment;
import Modle.User;
import View.ViewManger;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ShowAppointmentController implements Initializable {

    @FXML
    private Button showPaBTN;
    @FXML
    private Button showApBTN;
    @FXML
    private Button bookedApBTN;
    @FXML
    private Button logoutBTN;
    @FXML
    private TableView<Appointment> tableView;
    @FXML
    private TableColumn<Appointment, Integer> idCol;
    @FXML
    private Button updateInfo;
    @FXML
    private TableColumn<Appointment, String> appointment_date;
    @FXML
    private TableColumn<Appointment, String> appointment_day;
    @FXML
    private TableColumn<Appointment, String> appointment_time;
    @FXML
    private TableColumn<Appointment, String> status;
    @FXML
    private Button createA;
    @FXML
    private Button deleteA;
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
        //it here already
    }

    @FXML
    private void BookedAppointment(ActionEvent event) {
        ViewManger.dashBorad.changeSceneToBookedAppointment();
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
        ViewManger.closedashBorad();
    }

    @FXML
    private void careteAppointment(ActionEvent event) {
        UpdateAppointmentController.save("Create", null);
        ViewManger.dashBorad.changeSceneToUpdateAppointment();

    }

    @FXML
    private void UpdateAppointment(ActionEvent event) {
        Appointment app = tableView.getSelectionModel().getSelectedItem();
        if (!Objects.isNull(app)) {
            UpdateAppointmentController.save("Update", app);
            ViewManger.dashBorad.changeSceneToUpdateAppointment();
        }
    }

    @FXML
    private void deleteAppointment(ActionEvent event) {
        Appointment app = tableView.getSelectionModel().getSelectedItem();
        if (!Objects.isNull(app)) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url1 = "jdbc:mysql://127.0.0.1:3306/clinic_appointment?serverTimezone=UTC";
                String usernameD = "root";
                String passwordD = "";
                Connection connection = DriverManager.getConnection(url1, usernameD, passwordD);
                Statement stat = connection.createStatement();
                String Sql = "DELETE FROM appointment WHERE id=" + app.getId();
                int excut = stat.executeUpdate(Sql);
                tableView.getItems().removeAll(app);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(ShowPatientController.class.getName()).log(Level.SEVERE, null, ex);
            }
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
              // name virable in class Appoitnment
            idCol.setCellValueFactory(new PropertyValueFactory("id"));
            appointment_date.setCellValueFactory(new PropertyValueFactory("appointment_date"));
            appointment_day.setCellValueFactory(new PropertyValueFactory("appointment_day"));
            appointment_time.setCellValueFactory(new PropertyValueFactory("appointment_time"));
            status.setCellValueFactory(new PropertyValueFactory("status"));

            String Sql = "SELECT * FROM  appointment ";
            ResultSet rs = stat.executeQuery(Sql);
            this.tableView.getItems().clear();
            while (rs.next()) {// rs and the datatype then the name in dataBase
                Appointment appointment = new Appointment();
                appointment.setId(rs.getInt("id"));
                appointment.setAppointment_date(rs.getDate("appointment_date"));
                appointment.setAppointment_day(rs.getString("appointment_day"));
                appointment.setAppointment_time(rs.getTime("appointment_time"));
                appointment.setStatus(rs.getString("status"));
                this.tableView.getItems().add(appointment);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ShowAppointmentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
