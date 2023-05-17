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
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

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
    private TableColumn<Appointment, Date> appointment_date;
    @FXML
    private TableColumn<Appointment, String> appointment_day;
    @FXML
    private TableColumn<Appointment, Time> appointment_time;
    @FXML
    private TableColumn<Appointment, String> status;
    @FXML
    private Button createA;
    @FXML
    private Button deleteA;
    @FXML
    private Button showBTN;

    public static Appointment app;
    public static Stage updateCrate;
    public static String statie;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // name virable in class Appoitnment
        idCol.setCellValueFactory(new PropertyValueFactory("id"));
        appointment_date.setCellValueFactory(new PropertyValueFactory("appointment_date"));
        appointment_day.setCellValueFactory(new PropertyValueFactory("appointment_day"));
        appointment_time.setCellValueFactory(new PropertyValueFactory("appointment_time"));
        status.setCellValueFactory(new PropertyValueFactory("status"));

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
    private void careteAppointment(ActionEvent event) throws IOException {
        statie = "create";
        FXMLLoader loaderUpdate = new FXMLLoader(getClass().getResource("/View/DoctorFxml/UpdateAppointment.fxml"));
        Parent rootUpdate = loaderUpdate.load();
        Scene updateUserScene = new Scene(rootUpdate);
        updateCrate = new Stage();
        updateCrate.setScene(updateUserScene);
        updateCrate.setTitle("Insert user");
        updateCrate.show();
    }

    @FXML
    private void UpdateAppointment(ActionEvent event) throws IOException {
        if (tableView.getSelectionModel().getSelectedItem() != null) {
            statie = "update";
            app = tableView.getSelectionModel().getSelectedItem();
            FXMLLoader loaderUpdate = new FXMLLoader(getClass().getResource("/View/DoctorFxml/UpdateAppointment.fxml"));
            Parent rootUpdate = loaderUpdate.load();
            Scene updateUserScene = new Scene(rootUpdate);
            updateCrate = new Stage();
            updateCrate.setScene(updateUserScene);
            updateCrate.setTitle("Update Appointment");
            updateCrate.show();

        }
    }

    @FXML
    private void deleteAppointment(ActionEvent event) {

        if (tableView.getSelectionModel().getSelectedItem() != null) {
            Appointment selectedApp = tableView.getSelectionModel().getSelectedItem();

            Alert deleteConfirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
            deleteConfirmAlert.setTitle("Appointment delete");
            deleteConfirmAlert.setContentText("Are you sure to delete this Appointment ?");
            deleteConfirmAlert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    try {
                        selectedApp.delete();
                    } catch (SQLException ex) {
                        Logger.getLogger(ShowAppointmentController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ShowAppointmentController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Alert deletedSuccessAlert = new Alert(Alert.AlertType.INFORMATION);
                    deletedSuccessAlert.setTitle("Appointment deleted");
                    deletedSuccessAlert.setContentText("Appointment deleted");
                    deletedSuccessAlert.show();
                }
            });

        } else {
            Alert warnAlert = new Alert(Alert.AlertType.WARNING);
            warnAlert.setTitle("Select an Appointment");
            warnAlert.setContentText("Please select an Appointment from the table view");
            warnAlert.show();
        }
    }

    @FXML
    private void ShowAppointmentRelsut(ActionEvent event) throws SQLException {
        ObservableList<Appointment> ul = FXCollections.observableArrayList(Appointment.getAll());
        tableView.setItems(ul);
    }
}
