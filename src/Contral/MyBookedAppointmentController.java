/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contral;

import Modle.BookedAppointments;
import Modle.User;
import View.ViewManger;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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

    boolean showfinish = false;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bookedAppID.setCellValueFactory(new PropertyValueFactory("appointment_id"));
        BookedAppstatus.setCellValueFactory(new PropertyValueFactory("status"));
        doctorComment.setCellValueFactory(new PropertyValueFactory("doctor_commnet"));

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
    private void showWating(ActionEvent event) throws SQLException {
        ObservableList<BookedAppointments> ul = FXCollections.observableArrayList(BookedAppointments.getAllwaiting(userId));
        viewTable.setItems(ul);
        showfinish = false;
    }

    @FXML
    private void showFinised(ActionEvent event) throws SQLException {
        ObservableList<BookedAppointments> ul = FXCollections.observableArrayList(BookedAppointments.getAllfinished(userId));
        viewTable.setItems(ul);
        showfinish = true;
    }

    @FXML
    private void showComment(ActionEvent event) {
        if(showfinish){
             if (viewTable.getSelectionModel().getSelectedItem() != null) {
        ShowMyDoctorCommentController.setAppId(viewTable.getSelectionModel().getSelectedItem().getId());
        ViewManger.patient.changeSceneToShowMyDoctorComment();
             }
        }
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}
