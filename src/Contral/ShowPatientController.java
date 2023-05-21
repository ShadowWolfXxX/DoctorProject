/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contral;

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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ShowPatientController implements Initializable {

    @FXML
    private Button showPaBTN;
    @FXML
    private Button showApBTN;
    @FXML
    private Button bookedApBTN;
    @FXML
    private Button logoutBTN;
    @FXML
    private TableView<User> tableView;
    @FXML
    private Button createP;
    @FXML
    private Button updateInfo;
    @FXML
    private Button deleteP;
    @FXML
    private TableColumn<User, Integer> idCol;
    @FXML
    private TableColumn<User, String> userNameCol;
    @FXML
    private TableColumn<User, String> firstNameCol;
    @FXML
    private TableColumn<User, String> lastNameCol;
    @FXML
    private TableColumn<User, String> ageCol;
    @FXML
    private TableColumn<User, String> genderCol;
    @FXML
    private Button searchBTN;
    @FXML
    private TextField searchTF;
    @FXML
    private Button showBTN;
    public static User use;
    public static Stage updateCrate;
    public static String statie;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idCol.setCellValueFactory(new PropertyValueFactory("id"));
        userNameCol.setCellValueFactory(new PropertyValueFactory("username"));
        firstNameCol.setCellValueFactory(new PropertyValueFactory("firstname"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory("lastname"));
        ageCol.setCellValueFactory(new PropertyValueFactory("age"));
        genderCol.setCellValueFactory(new PropertyValueFactory("gender"));

    }

    @FXML
    private void ShowPatient(ActionEvent event) {
        try {
            String Sql="SELECT * FROM users where role='patient' ";
            ResultSet rs=stat.executeQuery(Sql);
            while(rs.next()){
                User user=new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setFname(rs.getString("firstname"));
                user.setLname(rs.getString("lastname"));
                user.setAge(rs.getString("age"));
                user.setGender(rs.getString("gender"));
                this.tableView.getItems().add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ShowPatientController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    private void caretePatient(ActionEvent event) throws IOException {
        statie = "create";
        FXMLLoader loaderUpdate = new FXMLLoader(getClass().getResource("/View/DoctorFxml/UpdatePatient.fxml"));
        Parent rootUpdate = loaderUpdate.load();
        Scene updateUserScene = new Scene(rootUpdate);
        updateCrate = new Stage();
        updateCrate.setScene(updateUserScene);
        updateCrate.setTitle("Insert user");
        updateCrate.show();

    }

    @FXML
    private void UpdatePatient(ActionEvent event) throws IOException {
        if (tableView.getSelectionModel().getSelectedItem() != null) {
            statie = "update";
            use = tableView.getSelectionModel().getSelectedItem();
            FXMLLoader loaderUpdate = new FXMLLoader(getClass().getResource("/View/DoctorFxml/UpdatePatient.fxml"));
            Parent rootUpdate = loaderUpdate.load();
            Scene updateUserScene = new Scene(rootUpdate);
            updateCrate = new Stage();
            updateCrate.setScene(updateUserScene);
            updateCrate.setTitle("Update user " + use.getUsername());
            updateCrate.show();

        }
    }

    @FXML
    private void deletePatient(ActionEvent event) {

        if (tableView.getSelectionModel().getSelectedItem() != null) {
            User selectedUser = tableView.getSelectionModel().getSelectedItem();

            Alert deleteConfirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
            deleteConfirmAlert.setTitle("User delete");
            deleteConfirmAlert.setContentText("Are you sure to delete this user ?");
            deleteConfirmAlert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                 
                    try {
                        selectedUser.delete();
                    } catch (SQLException ex) {
                        Logger.getLogger(ShowPatientController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ShowPatientController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    Alert deletedSuccessAlert = new Alert(Alert.AlertType.INFORMATION);
                    deletedSuccessAlert.setTitle("User deleted");
                    deletedSuccessAlert.setContentText("User deleted");
                    deletedSuccessAlert.show();
                }
            });

        } else {
            Alert warnAlert = new Alert(Alert.AlertType.WARNING);
            warnAlert.setTitle("Select an user");
            warnAlert.setContentText("Please select an user from the table view");
            warnAlert.show();
        }
    }

    @FXML
    private void search(ActionEvent event) throws SQLException {

        String word = searchTF.getText();
        if (word.equals("")) {

        } else {
            ObservableList<User> ul = FXCollections.observableArrayList(User.search(word));
            tableView.setItems(ul);
        }
    }

    @FXML
    private void ShowPatientRelsut(ActionEvent event) throws SQLException {
        ObservableList<User> ul = FXCollections.observableArrayList(User.getAll());
        tableView.setItems(ul);
    }

}
