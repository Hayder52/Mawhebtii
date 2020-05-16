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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import pi.esprit.utils.MyConnection;

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
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
                JOptionPane.showMessageDialog(null,"Username and password are correct");
                
                btn_login.getScene().getWindow().hide();
                Parent root=FXMLLoader.load(getClass().getResource("menu.fxml"));
                Stage mainstage=new Stage();
                Scene scene=new Scene(root);
               mainstage.setScene(scene);
               mainstage.show(); 
              
            
            }else{
                                JOptionPane.showMessageDialog(null,"Username or password is not correct");

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        }
        return false;
    }

    @FXML
    private void sign(ActionEvent event) {
        
      
            btn_login.getScene().getWindow().hide();
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

   

   

   
}