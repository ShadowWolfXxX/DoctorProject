/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contral;

import static Contral.UpdatePatientController.AddorUpdate;
import Modle.Appointment;
import View.ViewManger;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Objects;
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
    private TextField appDay;
    @FXML
    private TextField appTime;

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
    private void logout(ActionEvent event) throws IOException {
        ViewManger.closedashBorad();
    }

    @FXML
    private void signin(ActionEvent event) throws SQLException {
        if (AddorUpdate.equals("Create")) {

            Date date = Date.valueOf(appDate.getValue());
            String Day = appDay.getText();
            Time time = Time.valueOf(appTime.getText());
            Appointment app = new Appointment(date, Day, time, "free");
            int excut = app.save();
            if (excut > 0) {
                appDate.setValue(null);
                appDay.setText("");
                appTime.setText("");
                Alert alret = new Alert(Alert.AlertType.CONFIRMATION);
                alret.setContentText("Appointment have been add it");
                alret.showAndWait();
                ViewManger.dashBorad.changeSceneToShowAppointment();
            } else {

            }

        } else if (AddorUpdate.equals("Update")) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url1 = "jdbc:mysql://127.0.0.1:3306/clinic_appointment?serverTimezone=UTC";
                String usernameD = "root";
                String passwordD = "";
                Connection connection = DriverManager.getConnection(url1, usernameD, passwordD);
                Statement statement = connection.createStatement();
                LocalDate Date = appDate.getValue();
                String Day = appDay.getText();
                String Time = appTime.getText();
                if (!(Date.equals("") || Day.equals("") || Time.equals(""))) {
                    String Query = "UPDATE appointment SET appointment_date = '" + Date + "' , appointment_day = '" + Day + "' , appointment_time ='" + Time + "' where id =" + this.app.getId();
                    int excut = statement.executeUpdate(Query);
                    if (excut > -1) {
                        appDate.setValue(null);
                        appDay.setText("");
                        appTime.setText("");
                        ViewManger.dashBorad.changeSceneToShowAppointment();
                    } else {

                    }
                    statement.close();
                    connection.close();
                } else {

                }

            } catch (Exception ex) {
                ex.getStackTrace();
            }
        } else {
            //error here
        }
    }

    @FXML
    private void goback(ActionEvent event) {
//        appDate.setValue(LocalDate.parse(""));
        appDate.setValue(null);
        appDay.setText("");
        appTime.setText("");
        ViewManger.dashBorad.changeSceneToShowAppointment();
    }

    @FXML
    private void showOldData(ActionEvent event) {
        if (!Objects.isNull(app)) {
            appDate.setValue(app.getAppointment_date().toLocalDate());
            appDay.setText(app.getAppointment_day());
            appTime.setText(String.valueOf(app.getAppointment_time()));

        }
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
