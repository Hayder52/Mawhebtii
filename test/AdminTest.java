/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import pi.esprit.design.homelogin.UserGestionCompte;

/**
 *
 * @author Fakhri Argoubi
 */
public class AdminTest extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        UserGestionCompte ug = new UserGestionCompte();
        ug.UserPersonalInofrmation(primaryStage);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
