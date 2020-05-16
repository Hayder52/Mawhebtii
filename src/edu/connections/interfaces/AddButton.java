/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connections.interfaces;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pi.esprit.entities.personnes;
import pi.esprit.services.PersonneCRUD;

/**
 *
 * @author Fakhri Argoubi
 */
public class AddButton {
    
    public static void addUser(){
        VBox v = new VBox();
        Label mainLb = new Label("Add User");
        HBox h1 = new HBox();
        Label lb1 = new Label("nom");
        lb1.setPrefWidth(150);
        TextField tf1 = new TextField();
        tf1.setPrefWidth(150);
        h1.getChildren().addAll(lb1,tf1);
        h1.setSpacing(40);
        
        HBox h2 = new HBox();
        Label lb2 = new Label("prenom");
        lb2.setPrefWidth(150);
        TextField tf2 = new TextField();
        tf2.setPrefWidth(150);
        h2.getChildren().addAll(lb2,tf2);
        h2.setSpacing(40);
        
        HBox h3 = new HBox();
        Label lb3 = new Label("email");
        lb3.setPrefWidth(150);
        TextField tf3 = new TextField();
        tf3.setPrefWidth(150);
        h3.getChildren().addAll(lb3,tf3);
        h3.setSpacing(40);
        
        HBox h4 = new HBox();
        Label lb4 = new Label("profil");
        lb4.setPrefWidth(150);
        TextField tf4 = new TextField();
        tf4.setPrefWidth(150);
        h4.getChildren().addAll(lb4,tf4);
        h4.setSpacing(40);
        
        HBox h5 = new HBox();
        Label lb5 = new Label("photo");
        lb5.setPrefWidth(150);
        TextField tf5 = new TextField();
        tf5.setPrefWidth(150);
        h5.getChildren().addAll(lb5,tf5);
        h5.setSpacing(40);
        
        HBox h6 = new HBox();
        Label lb6 = new Label("login");
        lb6.setPrefWidth(150);
        TextField tf6 = new TextField();
        tf6.setPrefWidth(150);
        h6.getChildren().addAll(lb6,tf6);
        h6.setSpacing(40);
        
        HBox h7 = new HBox();
        Label lb7 = new Label("pwd");
        lb7.setPrefWidth(150);
        TextField tf7 = new TextField();
        tf7.setPrefWidth(150);
        h7.getChildren().addAll(lb7,tf7);
        h7.setSpacing(40);
        
        HBox h8 = new HBox();
        Label lb8 = new Label("adress");
        lb8.setPrefWidth(150);
        TextField tf8 = new TextField();
        tf8.setPrefWidth(150);
        h8.getChildren().addAll(lb8,tf8);
        h8.setSpacing(40);
        
     
        
        HBox h10 = new HBox();
        Button addUser = new Button ("add");
        h10.getChildren().addAll(addUser);
        v.setSpacing(5);
        v.setPadding(new Insets(10, 0, 0, 10));
        v.getChildren().addAll(mainLb,h1,h2,h3,h4,h5,h6,h7,h8,h10);
        Scene scene = new Scene(new Group());
        ((Group) scene.getRoot()).getChildren().addAll(v);
        
        addUser.setOnAction(e->{
            personnes p = new personnes(0, tf1.getText(), tf2.getText(),tf3.getText(), 
                    tf4.getText(),tf5.getText(), tf6.getText(), tf7.getText(), tf8.getText());
            PersonneCRUD pc = new PersonneCRUD();
            pc.ajouterPersonne3(p);
            
            Alert a = new Alert(AlertType.NONE);
            a.setAlertType(AlertType.INFORMATION); 
            a.show();
            tf1.clear();
            tf2.clear();
            tf3.clear();
            tf4.clear();
            tf5.clear();
            tf6.clear();
            tf7.clear();
            tf8.clear();
            
        });
        
        Stage stage = new Stage();
        stage.setMinWidth(400);
        stage.setMinHeight(600);
        stage.setScene(scene);
        stage.show();
    }
    
}
