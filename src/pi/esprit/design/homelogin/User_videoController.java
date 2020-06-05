/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.esprit.design.homelogin;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import pi.esprit.entities.loggedmembre;
import pi.esprit.entities.personnes;
import pi.esprit.entities.reacts;
import pi.esprit.entities.videos;
import pi.esprit.utils.MyConnection;

/**
 * FXML Controller class
 *
 * @author bureau
 */
public class User_videoController implements Initializable {

    @FXML
    private TableColumn<personnes, String> first_name;
    @FXML
    private TableColumn<personnes, String> lastname;
    @FXML
    private TableColumn<videos, Integer> videoid;
    @FXML
    private TableColumn<reacts, Integer> likenumber;

    ResultSet rs=null;
PreparedStatement pst;
    @FXML
    private TableView<personnes> tableview;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            showpersonnes();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        }
        tableview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }
      
     Connection cnx;    
 personnes pd = loggedmembre.getP();
     public ObservableList<personnes> getpersonneslist() throws SQLException{
         ObservableList<personnes> personneslist=FXCollections.observableArrayList();
          cnx = MyConnection.getInstance().getCnx();
          String sql="SELECT * FROM personnes";
          Statement st;
          st=cnx.createStatement();
          rs=st.executeQuery(sql);
          while(rs.next()){
             try {
                 personnes p=new personnes();
                 p.setNom(rs.getString("nom"));
                 p.setPrenom(rs.getString("prenom"));
                 p.setProfil(rs.getString("profil"));
                 p.setLogin(rs.getString("login"));
                 p.setPwd(rs.getString("pwd"));
                 p.setAdress(rs.getString("adress"));
                 p.setEmail(rs.getString("email"));

                 
                 
                 
               personneslist.add(p);
                         
                         } catch (SQLException ex) {
                 System.out.println(ex.getMessage());             }
          
    }
          return personneslist;
    }
    public void showpersonnes() throws SQLException{
        ObservableList<personnes> list=getpersonneslist();
        first_name.setCellValueFactory(new PropertyValueFactory<personnes,String>("nom"));
        lastname.setCellValueFactory(new PropertyValueFactory<personnes,String>("prenom"));
        // colprofil.setCellValueFactory(new PropertyValueFactory<personnes,String>("profil"));
       //  collogin.setCellValueFactory(new PropertyValueFactory<personnes,String>("login"));
       //   colpassword.setCellValueFactory(new PropertyValueFactory<personnes,Integer>("pwd"));
        //  coladress.setCellValueFactory(new PropertyValueFactory<personnes,String>("adress"));
        //  colemail.setCellValueFactory(new PropertyValueFactory<personnes,String>("email"));








tableview.setItems(list);


    }

    private void tableview(MouseEvent event) {
        personnes personne=tableview.getSelectionModel().getSelectedItem();
        first_name.setText(personne.getPrenom());
        lastname.setText(personne.getNom());
       // tprofil.setText(personne.getProfil());
       // tlogin.setText(personne.getLogin());
      //  tpassword.setText(personne.getPwd());
      //  tadress.setText(personne.getAdress());
      //  temail.setText(personne.getEmail());

    }
    
    
}
