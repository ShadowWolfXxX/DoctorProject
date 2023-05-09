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

    public DashBoradManger() throws IOException {
        FXMLLoader load4 = new FXMLLoader(getClass().getResource("/View/DashBoard.fxml"));
        Parent p4 = load4.load();
        DashBord = new Scene(p4);
        this.setScene(DashBord);
    }
    
    
    
    
}
