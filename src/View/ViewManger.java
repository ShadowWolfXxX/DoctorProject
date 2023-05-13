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

public class ViewManger extends Stage {

    private static ViewManger instance = null;
    private Scene PatientLogin;
    private Scene AdminLogin;
    private Scene PatientRigester;
    public static DashBoradManger dashBorad;
    public static PatientManger patient;

    private Scene DashBord;

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

    public void changeSceneToDashBoard() {
        this.setScene(DashBord);
        this.setTitle("DashBorad");

    }

    public static ViewManger getInstance() throws IOException {
        if (instance == null) {
            instance = new ViewManger();
        }
        return instance;
    }

    public static void opendashBorad() throws IOException {
        if (dashBorad == null) {
            dashBorad = new DashBoradManger();
            dashBorad.show();
            ViewManger.getInstance().close();
        } else {
            dashBorad.show();
            ViewManger.getInstance().close();

        }

    }

    public static void closedashBorad() throws IOException {
        if (dashBorad != null) {
            dashBorad.close();
            ViewManger.getInstance().show();
        }
    }

    public static void openpatient() throws IOException {
        if (patient == null) {
            patient = new PatientManger();
            patient.show();
            ViewManger.getInstance().close();

        } else {
            patient.show();
            ViewManger.getInstance().close();

        }

    }

    public static void closepatient() throws IOException {
        if (patient != null) {
            patient.close();
            ViewManger.getInstance().show();
        }
    }

}
