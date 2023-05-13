/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author HP
 */
public class DashBoradManger extends Stage {

    private Scene DashBord;
    private Scene ShowPation;
    private Scene ShowAppointment;
    private Scene BookedAppointment;
    private Scene UpdatePation;
    private Scene UpdateAppointment;
    private Scene CommentAppointment;

    public DashBoradManger() throws IOException {
        FXMLLoader load = new FXMLLoader(getClass().getResource("/View/DashBoard.fxml"));
        Parent p = load.load();
        DashBord = new Scene(p);
        this.setScene(DashBord);

        FXMLLoader load1 = new FXMLLoader(getClass().getResource("/View/DoctorFxml/ShowPatient.fxml"));
        Parent p1 = load1.load();
        ShowPation = new Scene(p1);

        FXMLLoader load2 = new FXMLLoader(getClass().getResource("/View/DoctorFxml/ShowAppointment.fxml"));
        Parent p2 = load2.load();
        ShowAppointment = new Scene(p2);

        FXMLLoader load3 = new FXMLLoader(getClass().getResource("/View/DoctorFxml/BookedAppointment.fxml"));
        Parent p3 = load3.load();
        BookedAppointment = new Scene(p3);

        FXMLLoader load4 = new FXMLLoader(getClass().getResource("/View/DoctorFxml/UpdatePatient.fxml"));
        Parent p4 = load4.load();
        UpdatePation = new Scene(p4);
        
        FXMLLoader load5 = new FXMLLoader(getClass().getResource("/View/DoctorFxml/UpdateAppointment.fxml"));
        Parent p5 = load5.load();
        UpdateAppointment = new Scene(p5);
        
        FXMLLoader load6 = new FXMLLoader(getClass().getResource("/View/DoctorFxml/CommentAppointment.fxml"));
        Parent p6 = load6.load();
        CommentAppointment = new Scene(p6);
    }

    public void changeSceneToDashBord() {
        this.setScene(DashBord);
        this.setTitle("DashBord");

    }

    public void changeSceneToShowPation() {
        this.setScene(ShowPation);
        this.setTitle("ShowPation");

    }

    public void changeSceneToShowAppointment() {
        this.setScene(ShowAppointment);
        this.setTitle("ShowAppointment");

    }

    public void changeSceneToBookedAppointment() {
        this.setScene(BookedAppointment);
        this.setTitle("BookedAppointment");

    }

    public void changeSceneToUpdatePation() {
        this.setScene(UpdatePation);
        this.setTitle("UpdatePation");

    }
    
    public void changeSceneToUpdateAppointment() {
        this.setScene(UpdateAppointment);
        this.setTitle("UpdateAppointment");

    }
    
    public void changeSceneToCommentAppointment() {
        this.setScene(CommentAppointment);
        this.setTitle("CommentAppointment");

    }
}
