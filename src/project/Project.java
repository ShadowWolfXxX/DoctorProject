/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import View.ViewManger;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author HP
 */
public class Project extends Application{

   
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
ViewManger vm = ViewManger.getInstance();
    }
    
}
