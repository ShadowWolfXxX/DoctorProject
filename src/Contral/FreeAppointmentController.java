/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contral;

import Modle.Appointment;
import Modle.BookedAppointments;
import View.ViewManger;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
public class FreeAppointmentController implements Initializable {

    @FXML
    private Button FreeAppBTN;
    @FXML
    private Button BookedAppBTN;
    @FXML
    private Button logoutBTN;
    @FXML
    private TableView<Appointment> viewTable;
    @FXML
    private TableColumn<Appointment, Integer> idCol;
    @FXML
    private TableColumn<Appointment, Date> appointmentDate;
    @FXML
    private TableColumn<Appointment, String> appointmentDay;
    @FXML
    private TableColumn<Appointment, Time> appointmentTime;
    @FXML
    private TableColumn<Appointment, String> status;
    @FXML
    private Button bookedABTN;

    private static int userId;
    @FXML
    private Button showBTN;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idCol.setCellValueFactory(new PropertyValueFactory("id"));
        appointmentDate.setCellValueFactory(new PropertyValueFactory("appointment_date"));
        appointmentDay.setCellValueFactory(new PropertyValueFactory("appointment_day"));
        appointmentTime.setCellValueFactory(new PropertyValueFactory("appointment_time"));
        status.setCellValueFactory(new PropertyValueFactory("status"));
    }

    @FXML
    private void FreeAppointment(ActionEvent event) {
        //here
    }

    @FXML
    private void MyBookedAppointment(ActionEvent event) {
        ViewManger.patient.changeSceneToMyBookedAppointment();
    }

    @FXML
    private void Logout(ActionEvent event) throws IOException {
        ViewManger.closepatient();

    }

    @FXML
    private void BookedAppointment(ActionEvent event) throws SQLException, ClassNotFoundException {
        if (viewTable.getSelectionModel().getSelectedItem() != null) {
            if (viewTable.getSelectionModel().getSelectedItem().getStatus().equals("free")) {
                for (BookedAppointments appa : BookedAppointments.getAll()) {
                    if (appa.getAppointment_id() == viewTable.getSelectionModel().getSelectedItem().getId() && appa.getUser_id() == userId) {
                        break;
                    } else {

                    }
                }
                BookedAppointments app = new BookedAppointments(viewTable.getSelectionModel().getSelectedItem().getId(), userId, "waiting", "");
                app.save();
                Appointment apo = viewTable.getSelectionModel().getSelectedItem();
                apo.setStatus("booked");
                apo.update();
            }
        }
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @FXML
    private void ShowApp(ActionEvent event) throws SQLException {
        ObservableList<Appointment> ul = FXCollections.observableArrayList(Appointment.getAll());
        viewTable.setItems(ul);
    }

}
