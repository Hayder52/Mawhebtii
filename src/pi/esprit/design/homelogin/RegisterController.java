/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.esprit.design.homelogin;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import pi.esprit.utils.MyConnection;

/**
 * FXML Controller class
 *
 * @author bureau
 */
public class RegisterController implements Initializable {

    @FXML
    private TextField txt_name;
    @FXML
    private TextField txt_prenom;
    @FXML
    private PasswordField txt_pwd;
    @FXML
    private TextField txt_login;
    @FXML
    private TextField txt_email;
    @FXML
    private Button btnregister;
    @FXML
    private ComboBox profil;

     Connection cnx;
ResultSet rs=null;
PreparedStatement pst;
private ImageIcon format=null;
String filename=null;
int s=0;
byte[] personne_image=null;
Image image;
    @FXML
    private TextField txt_adress;
    @FXML
    private Button btn_back;
    @FXML
    private Button cmd_attach;
   
    @FXML
    private TextField txt_path;
    @FXML
    private AnchorPane anchor;
    @FXML
    private ImageView img;
    @FXML
    private Button btn_saveimage;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      profil.getItems().addAll("user");
    }    

    @FXML
    private void register(ActionEvent event) {
         try {
            cnx = MyConnection.getInstance().getCnx();
            String requete="insert into personnes(nom,prenom,profil,adress,photo,login,pwd,email,) values (?,?,?,?,?,?,?,?)";
            pst=cnx.prepareStatement(requete);
            pst.setString(1,txt_name.getText());
            pst.setString(2,txt_prenom.getText());
            pst.setString(3,profil.getItems().toString());
            pst.setString(4,txt_adress.getText());
            pst.setBytes(5,personne_image);
            pst.setString(6,txt_login.getText());
            pst.setString(7,txt_pwd.getText());
            pst.setString(8,txt_email.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null,"saved");
        } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(null,ex);
        }

         
    }

    @FXML
    private void back(ActionEvent event) {
            btn_back.getScene().getWindow().hide();
            Parent root=null;
        try {
            root = FXMLLoader.load(getClass().getResource("login.fxml"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());       
        }
            Stage mainstage=new Stage();
            Scene scene=new Scene(root);
            mainstage.setScene(scene); 
            mainstage.show();
    }

    @FXML
    private void attach(ActionEvent event) throws IOException  {
        FileChooser filechooser = new FileChooser();

        filechooser.setTitle("Open file dialog");
        Stage stage = (Stage) anchor.getScene().getWindow();
        File file = filechooser.showOpenDialog(stage);

        if (file != null) {
            txt_path.setText(file.getAbsolutePath());
            System.out.println("" + file.getAbsolutePath());

            image = new Image(file.getAbsoluteFile().toURI().toString(), img.getFitWidth(), img.getFitHeight(), true, true);
            img.setImage(image);
            img.setPreserveRatio(true);

        }
    }
        
   
    @FXML
    private void saveimage(ActionEvent event) {
    }
       
    }

   

    
    

