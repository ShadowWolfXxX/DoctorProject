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
public class DashBoradManger extends Stage{
private Scene DashBord;
private Scene ShowPation;


    public DashBoradManger() throws IOException {
        FXMLLoader load = new FXMLLoader(getClass().getResource("/View/DashBoard.fxml"));
        Parent p = load.load();
        DashBord = new Scene(p);
        this.setScene(DashBord);
        
         FXMLLoader load1 = new FXMLLoader(getClass().getResource("/View/DoctorFxml/ShowPatient.fxml"));
        Parent p1 = load1.load();
        ShowPation = new Scene(p1);
    }
    
    public void changeSceneToDashBord() {
        this.setScene(DashBord);
        this.setTitle("DashBord");

    }

    public void changeSceneToShowPation() {
        this.setScene(ShowPation);
        this.setTitle("ShowPation");

    }
    
    
}
