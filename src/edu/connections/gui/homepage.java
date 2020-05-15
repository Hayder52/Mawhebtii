/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connections.gui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author bureau
 */
public class homepage extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
           /*Parent root=FXMLLoader.load(getClass().getResource("Inscription.fxml"));
            Scene scene = new Scene(layout, 600, 500);*/
            
            primaryStage.setTitle("Welcome page");
             primaryStage.setWidth(600);
             primaryStage.setHeight(500);
            //primaryStage.setScene(scene);
            primaryStage.show();
             primaryStage.centerOnScreen();
             StackPane layout = new StackPane();
           /*  layout.getChildren().g
             Scene scene = new Scene(layout, 600, 500)*/
             //2me page
             Stage otherStage = new Stage();
             otherStage.setTitle("Home Page");
             otherStage.setWidth(800);
             otherStage.setHeight(700);
             otherStage.show();
             otherStage.centerOnScreen();
      //  System.out.println(Thread.currentThread().getName());//can't do anything that recuire time in application thread
      //New thread to have a time pose  
     new Thread(() -> {//new Runnable
         try {
             Thread.sleep(6000);
             Platform.runLater(() -> {
                 primaryStage.hide();
             });
         } catch (InterruptedException ex) {
             Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
         }
            }).start();
        
       
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
