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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
        idCol.setCellValueFactory(new PropertyValueFactory("id"));
        appointment_id.setCellValueFactory(new PropertyValueFactory("appointment_id"));
        user_id.setCellValueFactory(new PropertyValueFactory("user_id"));
        status.setCellValueFactory(new PropertyValueFactory("status"));
        doctor_commnet.setCellValueFactory(new PropertyValueFactory("doctor_commnet"));
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
    private void logout(ActionEvent event) throws IOException {
        ViewManger.closedashBorad();
    }

    @FXML
    private void search(ActionEvent event) throws SQLException {

        String word = searchTF.getText();
        if (word.equals("")) {
            
        } else {
            ObservableList<BookedAppointments> ul = FXCollections.observableArrayList(BookedAppointments.search(word));
            tableView.setItems(ul);
        }
    }

    @FXML
    private void ShowAppointmentRelsut(ActionEvent event) throws SQLException {
        ObservableList<BookedAppointments> ul = FXCollections.observableArrayList(BookedAppointments.getAll());
        tableView.setItems(ul);
    }

    @FXML
    private void BookedTheAppointment(ActionEvent event) {
        BookedAppointments ba = tableView.getSelectionModel().getSelectedItem();
        if (!Objects.isNull(ba)) {
            CommentAppointmentController.save(ba);
            ViewManger.dashBorad.changeSceneToCommentAppointment();
        }
    }

}
