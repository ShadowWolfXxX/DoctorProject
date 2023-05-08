/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewManger extends Stage {

    private static ViewManger instance  = null;
    private Scene PatientLogin;
    private Scene AdminLogin;
    private Scene PatientRigester;

    private ViewManger() throws IOException {

        FXMLLoader load = new FXMLLoader(getClass().getResource("/View/PatientLogin.fxml"));
        Parent p = load.load();
        PatientLogin = new Scene(p);

        FXMLLoader load2 = new FXMLLoader(getClass().getResource("/View/AdminLogin.fxml"));
        Parent p2 = load2.load();
        AdminLogin = new Scene(p2);
        
        FXMLLoader load3 = new FXMLLoader(getClass().getResource("/View/PatientRegister.fxml"));
        Parent p3 = load3.load();
        PatientRigester = new Scene(p3);

        this.setScene(PatientLogin);
        this.show();
        this.setTitle("login Page");
    }

    public void changeSceneToPatientLogin() {
        this.setScene(PatientLogin);
        this.setTitle("concrentConverstSystem");

    }

    public void changeSceneToAdminLogin() {
        this.setScene(AdminLogin);
        this.setTitle("AdminLogin");

    }
    
    public void changeSceneToPatientRegister() {
        this.setScene(PatientRigester);
        this.setTitle("PatientRegister");

    }
    
    public static ViewManger getInstance() throws IOException {
        if (instance == null) {
            instance = new ViewManger();
        }
        return instance;
    }

}
