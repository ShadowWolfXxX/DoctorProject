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
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class MyBookedAppointmentController implements Initializable {

    @FXML
    private Button FreeAppBTN;
    @FXML
    private Button BookedAppBTN;
    @FXML
    private Button logoutBTN;
    @FXML
    private TableView<BookedAppointments> viewTable;
    @FXML
    private TableColumn<BookedAppointments, Integer> bookedAppID;
    @FXML
    private TableColumn<BookedAppointments, String> BookedAppstatus;
    @FXML
    private TableColumn<BookedAppointments, String> doctorComment;
    @FXML
    private Button watingAppBTN;
    @FXML
    private Button finishedAppBTN;
    @FXML
    private Button showCommentBTN;

    private static int userId;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @FXML
    private void FreeAppointment(ActionEvent event) {
        ViewManger.patient.changeSceneToFreeAppointment();
    }

    @FXML
    private void MyBookedAppointment(ActionEvent event) {
        //here already
    }

    @FXML
    private void Logout(ActionEvent event) throws IOException {
        ViewManger.closepatient();
    }

    @FXML
    private void showWating(ActionEvent event) {
        String sql="SELECT * FROM `booked_appointments` WHERE booked_appointments.status='waiting'";
        ResultSet rs=stat.executeQuery(sql);
            while(rs.next()){
        BookedAppointments bookedAppointments=new BookedAppointments();
            bookedAppointments.setId(rs.getInt("id"));
            bookedAppointments.setStatus(rs.getString("status"));
            bookedAppointments.setDoctor_commnet(rs.getString("doctor_commnet"));
            this.tableView.getItems().add(bookedAppointments);
    }

    @FXML
    private void showFinised(ActionEvent event) {
                String sql="SELECT * FROM `booked_appointments` WHERE booked_appointments.status='finised'";
        ResultSet rs=stat.executeQuery(sql);
            while(rs.next()){
        BookedAppointments bookedAppointments=new BookedAppointments();
            bookedAppointments.setId(rs.getInt("id"));
            bookedAppointments.setStatus(rs.getString("status"));
            bookedAppointments.setDoctor_commnet(rs.getString("doctor_commnet"));
            this.tableView.getItems().add(bookedAppointments);
    }

    @FXML
    private void showComment(ActionEvent event) {
        ViewManger.patient.changeSceneToShowMyDoctorComment();
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}
