/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connections.interfaces;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import pi.esprit.entities.PersonForTab;
import pi.esprit.services.PersonneCRUD;

/**
 *
 * @author Fakhri Argoubi
 */
public class GestionDesCompteInterface {
    public static void showAdminInterface(){
        
    Stage stage= new Stage();
    PersonneCRUD p = new PersonneCRUD();
         TableView<PersonForTab> tableview = new TableView<PersonForTab>();
      ObservableList<PersonForTab> data =
            FXCollections.observableArrayList(p.selectUsers());
    final HBox hb = new HBox();
        Scene scene = new Scene(new Group());
        stage.setTitle("Table View Sample");
        stage.setWidth(1280);
        stage.setHeight(720);
 
        final Label label = new Label("Address Book");
        label.setFont(new Font("Arial", 20));
 
        tableview.setEditable(true);
        //id column 
        TableColumn idColumn = new TableColumn("Id");
        idColumn.setMinWidth(100);
        idColumn.setCellValueFactory(
        new PropertyValueFactory<PersonForTab, String>("id_user"));
        // name column
        TableColumn nomColumn = new TableColumn("Name");
        nomColumn.setMinWidth(100);
        nomColumn.setCellValueFactory(
            new PropertyValueFactory<PersonForTab, String>("nom"));
        nomColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        nomColumn.setOnEditCommit(
            new EventHandler<CellEditEvent<PersonForTab, String>>() {
                @Override
                public void handle(CellEditEvent<PersonForTab, String> t) {
                    ((PersonForTab) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setNom(t.getNewValue());
                    PersonForTab p = tableview.getSelectionModel().getSelectedItem();
                    PersonneCRUD pc = new PersonneCRUD();
                    pc.updatePersonne2(p);
                }
            }
        );
        //prenom Column
        
        TableColumn prenomColumn = new TableColumn("Prenom");
        prenomColumn.setMinWidth(100);
        prenomColumn.setCellValueFactory(
            new PropertyValueFactory<PersonForTab, String>("prenom"));
        prenomColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        prenomColumn.setOnEditCommit(
            new EventHandler<CellEditEvent<PersonForTab, String>>() {
                @Override
                public void handle(CellEditEvent<PersonForTab, String> t) {
                    ((PersonForTab) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setPrenom(t.getNewValue());
                    PersonForTab p = tableview.getSelectionModel().getSelectedItem();
                    PersonneCRUD pc = new PersonneCRUD();
                    pc.updatePersonne2(p);

                }
            }
        );
 
        TableColumn emailCol = new TableColumn("Email");
        emailCol.setMinWidth(200);
        emailCol.setCellValueFactory(
            new PropertyValueFactory<PersonForTab, String>("email"));
        emailCol.setCellFactory(TextFieldTableCell.forTableColumn());
        emailCol.setOnEditCommit(
            new EventHandler<CellEditEvent<PersonForTab, String>>() {
                @Override
                public void handle(CellEditEvent<PersonForTab, String> t) {
                    ((PersonForTab) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setEmail(t.getNewValue());
                    PersonForTab p = tableview.getSelectionModel().getSelectedItem();
                    PersonneCRUD pc = new PersonneCRUD();
                    pc.updatePersonne2(p);

                }
            }
        );
        
        TableColumn profileColumn = new TableColumn("Profile");
        profileColumn.setMinWidth(50);
        profileColumn.setCellValueFactory(
            new PropertyValueFactory<PersonForTab, String>("profil"));
        profileColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        profileColumn.setOnEditCommit(
            new EventHandler<CellEditEvent<PersonForTab, String>>() {
                @Override
                public void handle(CellEditEvent<PersonForTab, String> t) {
                    ((PersonForTab) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setProfil(t.getNewValue());
                    PersonForTab p = tableview.getSelectionModel().getSelectedItem();
                    PersonneCRUD pc = new PersonneCRUD();
                    pc.updatePersonne2(p);
                }
            }
        );
        
        TableColumn loginColumn = new TableColumn("Login");
        loginColumn.setMinWidth(100);
        loginColumn.setCellValueFactory(
            new PropertyValueFactory<PersonForTab, String>("login"));
        loginColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        loginColumn.setOnEditCommit(
            new EventHandler<CellEditEvent<PersonForTab, String>>() {
                @Override
                public void handle(CellEditEvent<PersonForTab, String> t) {
                    ((PersonForTab) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setLogin(t.getNewValue());
                    PersonForTab p = tableview.getSelectionModel().getSelectedItem();
                    PersonneCRUD pc = new PersonneCRUD();
                    pc.updatePersonne2(p);
                }
            }
        );
        
        TableColumn pwdColumn = new TableColumn("Password");
        pwdColumn.setMinWidth(100);
        pwdColumn.setCellValueFactory(
            new PropertyValueFactory<PersonForTab, String>("pwd"));
        pwdColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        pwdColumn.setOnEditCommit(
            new EventHandler<CellEditEvent<PersonForTab, String>>() {
                @Override
                public void handle(CellEditEvent<PersonForTab, String> t) {
                    ((PersonForTab) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setPwd(t.getNewValue());
                    PersonForTab p = tableview.getSelectionModel().getSelectedItem();
                    PersonneCRUD pc = new PersonneCRUD();
                    pc.updatePersonne2(p);
                }
            }
        );
        
        TableColumn adressColumn = new TableColumn("Adress");
        adressColumn.setMinWidth(100);
        adressColumn.setCellValueFactory(
            new PropertyValueFactory<PersonForTab, String>("adress"));
        adressColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        adressColumn.setOnEditCommit(
            new EventHandler<CellEditEvent<PersonForTab, String>>() {
                @Override
                public void handle(CellEditEvent<PersonForTab, String> t) {
                    ((PersonForTab) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setAdress(t.getNewValue());
                    PersonForTab p = tableview.getSelectionModel().getSelectedItem();
                    PersonneCRUD pc = new PersonneCRUD();
                    pc.updatePersonne2(p);
                }
            }
        );
        
 
        tableview.setItems(data);
        tableview.getColumns().addAll(idColumn, nomColumn,prenomColumn, 
                emailCol,profileColumn,loginColumn,pwdColumn,adressColumn);
 
        
        
        final Button addButton = new Button("Add");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                AddButton.addUser();
            }
        });
        final Button deleteButton = new Button("delete");
        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
        @Override 
        public void handle(ActionEvent e) {
            Alert alert = new Alert(AlertType.CONFIRMATION, "Delete " + "Are you sure you want to delete this person"
                    + " ?", ButtonType.YES, ButtonType.NO);
            alert.showAndWait();

            if (alert.getResult() == ButtonType.YES) {
                PersonForTab p = tableview.getSelectionModel().getSelectedItem();
                tableview.getItems().removeAll(tableview.getSelectionModel().getSelectedItem());
                PersonneCRUD pc = new PersonneCRUD();
                pc.supprimerPersonne2(Integer.parseInt(p.getId_user()));
            }
        }
    });
        
        
        
        hb.getChildren().addAll(deleteButton, addButton);
        hb.setSpacing(3);
        
        final Button back = new Button("back");
        
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(back,label, tableview, hb);
 
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
 
        stage.setScene(scene);
        stage.show();
    
    
}}
