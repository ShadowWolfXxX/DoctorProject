/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contral;

import Modle.Appointment;
import Modle.User;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class UpdateAppointmentController implements Initializable {

    @FXML
    private Button submitBTN;
    @FXML
    private Button backBTN;
    @FXML
    private DatePicker appDate;
    @FXML
    private TextField appDay;
    @FXML
    private TextField appTime;

    private Appointment oldapp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (ShowAppointmentController.statie.equals("update")) {
            this.oldapp = ShowAppointmentController.app;
            appDate.setValue(oldapp.getAppointment_date().toLocalDate());
            appDay.setText(oldapp.getAppointment_day());
            appTime.setText(String.valueOf(oldapp.getAppointment_time()));

        } else {

        }
    }

    @FXML
    private void signin(ActionEvent event) throws SQLException {
        if (ShowAppointmentController.statie.equals("create")) {
            Date appointment_date = Date.valueOf(appDate.getValue());
            String appointment_day = appDay.getText();
            Time appointment_time = Time.valueOf(appTime.getText());
            Appointment appo = new Appointment(appointment_date, appointment_day, appointment_time, "free");
            int excut = appo.save();

            if (excut > 0) {
                appDate.setValue(null);
                appDay.setText("");
                appTime.setText("");
                Alert alret = new Alert(Alert.AlertType.CONFIRMATION);
                alret.setContentText("User have been add it");
                alret.showAndWait();
                ShowAppointmentController.updateCrate.close();
            }
        } else if (ShowAppointmentController.statie.equals("update")) {
            Date appointment_date = Date.valueOf(appDate.getValue());
            String appointment_day = appDay.getText();
            Time appointment_time = Time.valueOf(appTime.getText());
            Appointment appo = new Appointment(appointment_date, appointment_day, appointment_time, "free");
            appo.setId(this.oldapp.getId());
            int excut = appo.update();

            if (excut > 0) {
                appDate.setValue(null);
                appDay.setText("");
                appTime.setText("");
                Alert alret = new Alert(Alert.AlertType.CONFIRMATION);
                alret.setContentText("User have been Updating it");
                alret.showAndWait();
                ShowAppointmentController.updateCrate.close();
            } else {
                //error here
            }
        }
    }

    @FXML
    private void goback(ActionEvent event) {
        appDate.setValue(null);
        appDay.setText("");
        appTime.setText("");
        ShowAppointmentController.updateCrate.close();
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
