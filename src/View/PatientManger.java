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
public class PatientManger extends Stage{
private Scene FreeAppointment;
private Scene MyBookedAppointment;

    public PatientManger() throws IOException {
         FXMLLoader load1 = new FXMLLoader(getClass().getResource("/View/PatientFxml/FreeAppointment.fxml"));
        Parent p1 = load1.load();
        FreeAppointment = new Scene(p1);
        this.setScene(FreeAppointment);
        
        FXMLLoader load2 = new FXMLLoader(getClass().getResource("/View/PatientFxml/MyBookedAppointment.fxml"));
        Parent p2 = load2.load();
        MyBookedAppointment = new Scene(p2);
        
    }
    
    public void changeSceneToFreeAppointment() {
        this.setScene(FreeAppointment);
        this.setTitle("FreeAppointment");

    }

    public void changeSceneToMyBookedAppointment() {
        this.setScene(MyBookedAppointment);
        this.setTitle("MyBookedAppointment");

    }
    
}
