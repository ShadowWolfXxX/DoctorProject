/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contral;

import Modle.Appointment;
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
        
                                 try {
            String Sql="SELECT * FROM appointment WHERE appointment.status='free'";
            ResultSet rs=stat.executeQuery(Sql);
            while(rs.next()){
               Appointment appointment=new  Appointment();
               appointment.setId(rs.getInt("id"));
               appointment.setAppointment_date(rs.getDate("appointment_date"));
               appointment.setAppointment_day(rs.getString("appointment_day"));
               appointment.setAppointment_time(rs.getTime("appointment_time"));
               appointment.setStatus(rs.getString("status"));              
                this.tableView.getItems().add(appointment);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ShowPatientController.class.getName()).log(Level.SEVERE, null, ex);
        }    }

    @FXML
    private void MyBookedAppointment(ActionEvent event) {
        ViewManger.patient.changeSceneToMyBookedAppointment();
    }

    @FXML
    private void Logout(ActionEvent event) throws IOException {
        ViewManger.closepatient();

    }

    @FXML
    private void BookedAppointment(ActionEvent event) {
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
