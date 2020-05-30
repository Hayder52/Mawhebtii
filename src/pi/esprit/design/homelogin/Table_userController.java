/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.esprit.design.homelogin;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import pi.esprit.entities.competitions;
import pi.esprit.utils.MyConnection;

/**
 * FXML Controller class
 *
 * @author abassi
 */
public class Table_userController implements Initializable {

    @FXML
    private TableColumn<competitions, Integer> tid;
    @FXML
    private TableColumn<competitions, String> tnom_comp;
    @FXML
    private TableColumn<competitions, String> tnom_cat;
    @FXML
    private TableColumn<competitions, Date> tdate_deb;
    @FXML
    private TableColumn<competitions, Date> tdate_fin;
    @FXML
    private Button btnNext;
    @FXML
    private Button btnRetour;
    @FXML
    private TableView<competitions> tablevew;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          try {
            showcompeitions();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
 Connection cnx; 
 ResultSet rs=null;
 PreparedStatement pst;


 

 
    public void entred(Event e){
    

       ((Button)e.getSource()).setScaleX(1.1);
       ((Button)e.getSource()).setScaleX(1.1);
       ((Button)e.getSource()).setTextFill(Color.BLUE);
       
       }
    public void exited(Event e){
    

       ((Button)e.getSource()).setScaleX(1);
       ((Button)e.getSource()).setScaleX(1);
       ((Button)e.getSource()).setTextFill(Color.BLACK);
       }
    public ObservableList<competitions> getcompetitionslist() throws SQLException{
         ObservableList<competitions> competitionslist=FXCollections.observableArrayList();
          cnx = MyConnection.getInstance().getCnx();
          String sql="SELECT * FROM competitions";
          Statement st;
          st=cnx.createStatement();
          rs=st.executeQuery(sql);
          while(rs.next()){
              competitions p=new competitions();
              
              p.setId_comp(rs.getInt("id_comp"));
              p.setNom_comp(rs.getString("nom_comp"));
              p.setNom_cat(rs.getString("nom_cat"));
              p.setDate_deb(rs.getDate("date_deb"));
              p.setDate_fin(rs.getDate("date_fin"));
              competitionslist.add(p);
          
    }
          return competitionslist;
    }
    public void showcompeitions() throws SQLException{
        ObservableList<competitions> list=getcompetitionslist();
        tid.setCellValueFactory(new PropertyValueFactory<competitions,Integer>("id_comp"));
        tnom_comp.setCellValueFactory(new PropertyValueFactory<competitions,String>("nom_comp"));
         tnom_cat.setCellValueFactory(new PropertyValueFactory<competitions,String>("nom_cat"));
         tdate_deb.setCellValueFactory(new PropertyValueFactory<competitions,Date>("date_deb"));
         tdate_fin.setCellValueFactory(new PropertyValueFactory<competitions,Date>("date_fin"));
         







tablevew.setItems(list);



    }

        @FXML
    private void tableview(MouseEvent event) {
        competitions competition=tablevew.getSelectionModel().getSelectedItem();
  
       tnom_comp.setText(competition.getNom_comp());
       tnom_cat.setText(competition.getNom_cat());
        String date = competition.getDate_deb().toString();
        tdate_deb.setText(date);
         String date2 = competition.getDate_fin().toString();

        tdate_fin.setText(date2);
           }
     @FXML
    private void pagessuivante(ActionEvent event) {
           btnNext.getScene().getWindow().hide();
            Parent root=null;
        try {
            root = FXMLLoader.load(getClass().getResource("upload_video.fxml"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());       
        }
            Stage mainstage=new Stage();
            Scene scene=new Scene(root);
            mainstage.setScene(scene); 
            mainstage.show();
    }

    @FXML
    private void sortire(ActionEvent event) {
         btnRetour.getScene().getWindow().hide();
            Parent root=null;
        try {
            root = FXMLLoader.load(getClass().getResource("Menuprincipale.fxml"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());       
        }
            Stage mainstage=new Stage();
            Scene scene=new Scene(root);
            mainstage.setScene(scene); 
            mainstage.show();
    }
    
    }    
    

