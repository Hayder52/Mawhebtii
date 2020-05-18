/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connections.gui;

import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import edu.connections.entities.categories;
import edu.connections.services.CategoriesCrud;
import edu.connections.utils.MyConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author MAHHOUTTA
 */
public class GererCategorieController implements Initializable {
  @FXML
    private TableView<categories> table;
    
    @FXML
    private TableColumn<categories,Integer> col_id;
    @FXML
    private TableColumn<categories, String> name_col;
    @FXML
     private Button savebtn;
    @FXML
     private TextField tf_nom;
 Connection cnx;
ResultSet rs=null;
PreparedStatement pst;
  
   
    @FXML
    private TextField tf_nom1;
    @FXML
    private Button savebtn1;
      

    /**
     * Initializes the controller class.
     */
  
    ObservableList<categories> oblist = FXCollections.observableArrayList();
  
   
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Connection  cnx = MyConnection.getInstance().getCnx();
        try {
            ResultSet rs =cnx.createStatement().executeQuery("select * from  categoris");
                 while (rs.next())  { 
                  oblist.add(new categories(rs.getInt("id_cat"), rs.getString("nom_cat")));
                 }} catch (SQLException ex) {
            Logger.getLogger(GererCategorieController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
          col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
          name_col.setCellValueFactory(new PropertyValueFactory<>("nom"));
          table.setItems(oblist);
         
    }    
    @FXML
      public void add(ActionEvent event) throws SQLException{
            cnx = MyConnection.getInstance().getCnx();
            String requete="insert into categoris(nom_cat) values(?)";
            pst=cnx.prepareStatement(requete);
            pst.setString(1,tf_nom.getText());
             pst.execute();
            JOptionPane.showMessageDialog(null,"saved");
        } 
           public void update(ActionEvent event) throws SQLException{
            cnx = MyConnection.getInstance().getCnx();
            String requete="UPDATE categoris SET nom_cat=?"+"WHERE id_cat=?";
            pst=cnx.prepareStatement(requete);
            pst.setString(1,tf_nom.getText());
             pst.execute();
            JOptionPane.showMessageDialog(null,"updated");
}

}
      