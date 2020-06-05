/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.esprit.design.homelogin;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import pi.esprit.utils.MyConnection;
import javafx.scene.control.ComboBox;
import javax.swing.JComboBox;
import pi.esprit.entities.loggedmembre;
import pi.esprit.entities.personnes;

/**
 * FXML Controller class
 *
 * @author bureau
 */
public class LoginController implements Initializable {

    @FXML
    private TextField txt_user;
    @FXML
    private PasswordField pwd_user;
    @FXML
    private Button btn_login;

  Connection cnx;
ResultSet rs=null;
PreparedStatement pst;
    @FXML
    private Button btnsign;
    @FXML
    private AnchorPane anchorpane;
    private CheckBox chshow;
    @FXML
    private Button btn_passfg;
  
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
  
    }    

    @FXML
    private boolean login(ActionEvent event) throws IOException {
      
        try {
            Connection cnx = MyConnection.getInstance().getCnx();
            String sql="SELECT * FROM personnes WHERE nom = ? and pwd = ?  ";
            pst=cnx.prepareStatement(sql);
            pst.setString(1, txt_user.getText());
            pst.setString(2,pwd_user.getText());
            rs=pst.executeQuery();
            if(rs.next()){ 
                int id=rs.getInt("id_user");
                String nom=rs.getString("nom");
                String prenom=rs.getString("prenom");
                String profil=rs.getString("profil");
                String pwd=rs.getString("pwd");
                String photo=rs.getString("photo");
                personnes ps=new personnes(id,nom,prenom,profil,photo,pwd);
                loggedmembre.setP(ps);
                System.out.println(ps);
               
                if(profil.equals("admin")){
                     btn_login.getScene().getWindow().hide();
                Parent root=FXMLLoader.load(getClass().getResource("adminmenu.fxml"));
                Stage mainstage=new Stage();
                Scene scene=new Scene(root);
                mainstage.setScene(scene);
                mainstage.show();
                }else{
                btn_login.getScene().getWindow().hide();
                Parent root=FXMLLoader.load(getClass().getResource("Menuprincipale.fxml"));
                Stage mainstage=new Stage();
                Scene scene=new Scene(root);
                mainstage.setScene(scene);
                mainstage.show();
                }
            }
            
            
            else{
                JOptionPane.showMessageDialog(null,"Username or password is not correct");
                
            }
            
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());   
        }
          return false;
    }

    @FXML
    private void sign(ActionEvent event) {
        
      
            btnsign.getScene().getWindow().hide();
            Parent root=null;
        try {
            root = FXMLLoader.load(getClass().getResource("register.fxml"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());        }
            Stage mainstage=new Stage();
            Scene scene=new Scene(root);
            mainstage.setScene(scene); 
            mainstage.show();
        
}

    private void showpassword(ActionEvent event) {
    
        if(chshow.isSelected()){
                       
        }
    }

    @FXML
    private void forgetpassword(ActionEvent event) {
        
            btn_passfg.getScene().getWindow().hide();
            Parent root=null;
        try {
            root = FXMLLoader.load(getClass().getResource("Forgotpassword.fxml"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());        }
            Stage mainstage=new Stage();
            Scene scene=new Scene(root);
            mainstage.setScene(scene); 
            mainstage.show();
    }
}

   

   

   
