/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.esprit.gui;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import pi.esprit.entities.competitions;
import pi.esprit.entities.personnes;
import pi.esprit.services.PersonneCRUD;
import pi.esprit.utils.MyConnection;


/**
 * FXML Controller class
 *
 * @author abassi
 */
public class Competition_adminController implements Initializable {

    @FXML
    private Button btnnext;
    @FXML
    private Button btnexit;
    @FXML
    private Label Done;
    @FXML
    private TextField tfid;
    @FXML
    private TextField tfnom_comp;
    @FXML
    private ComboBox<String> combo;
    @FXML
    private DatePicker date_deb;
    @FXML
    private DatePicker date_fin;
    @FXML
    private TableView<competitions> tableview;
    @FXML
    private TableColumn<competitions, Integer> Tid;
    @FXML
    private TableColumn<competitions, String> Tnom_comp;
    @FXML
    private TableColumn<competitions, String> Tnom_cat;
    @FXML
    private TableColumn<competitions, Date> Tdate_deb;
    @FXML
    private TableColumn<competitions, Date> Tdate_fin;
    @FXML
    private TextField tefrecheche;
    @FXML
    private Button btnajout;
    @FXML
    private Button btnsupp;
    @FXML
    private Button btnmodif;
    ObservableList<String> list= FXCollections.observableArrayList("sport","music","arts","other");
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            showcompeitions();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        combo.setItems(list);
    }
    
 Connection cnx; 
 ResultSet rs=null;
 PreparedStatement pst;


 

 
  
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
        Tid.setCellValueFactory(new PropertyValueFactory<competitions,Integer>("id_comp"));
        Tnom_comp.setCellValueFactory(new PropertyValueFactory<competitions,String>("nom_comp"));
        Tnom_cat.setCellValueFactory(new PropertyValueFactory<competitions,String>("nom_cat"));
        Tdate_deb.setCellValueFactory(new PropertyValueFactory<competitions,Date>("date_deb"));
        Tdate_fin.setCellValueFactory(new PropertyValueFactory<competitions,Date>("date_fin"));
               
        tableview.setItems(list);

       

    }

    @FXML
   private void tableview(MouseEvent event) {
        competitions competition=tableview.getSelectionModel().getSelectedItem();
         //String id = competition.getId_comp().toString();
         //tfid.setId(getId_comp());
       // tfid.setId(competition.getId_comp());
  
       tfnom_comp.setText(competition.getNom_comp());
    /*   combo.setText(competition.getNom_cat());
        String date = competition.getDate_deb().toString();
        date_deb.setT(date);
         String date2 = competition.getDate_fin().toString();

        date_fin.setText(date2);*/
           }

    @FXML
    private void pagessuivante(ActionEvent event) {
           btnnext.getScene().getWindow().hide();
            Parent root=null;
           // System.out.println("ehchoumi");
        try {
            root = FXMLLoader.load(getClass().getResource("table_user.fxml"));
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
         btnexit.getScene().getWindow().hide();
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
 
        
    
    @FXML
    private void ajoutercomp(ActionEvent event) {
        try{
          cnx = MyConnection.getInstance().getCnx();
        String requete2 = "INSERT INTO competitions(nom_comp,nom_cat,date_deb,date_fin)"
                    + "VALUES (?,?,?,?)";  
           pst=cnx.prepareStatement(requete2);
          
           pst.setString(1,tfnom_comp.getText());
         
          
            pst.setString(2,combo.getValue());
           // date_deb = new DatePicker();
            
            pst.setDate(3,java.sql.Date.valueOf(date_deb.getValue()));
            //date_fin = new DatePicker();
             pst.setDate(4,java.sql.Date.valueOf(date_fin.getValue()));
             pst.execute();
             showcompeitions();
            JOptionPane.showMessageDialog(null,"Competition added");
        } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(null,ex);
        }
        PersonneCRUD pc = new PersonneCRUD();
        List<personnes> p = new ArrayList<>(pc.displayAll());
        p.forEach(e->{
            try {
                sendMail(e.getEmail());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        });
           
            
    }
    public  void sendMail(String recepient) throws Exception {
        System.out.println("Preparing to send email");
        Properties properties = new Properties();
        //Enable authentication
        properties.put("mail.smtp.auth", "true");
        //Set TLS encryption enabled
        properties.put("mail.smtp.starttls.enable", "true");
        //Set SMTP host
        properties.put("mail.smtp.host", "smtp.gmail.com");
        //Set smtp port
        properties.put("mail.smtp.port", "587");
        //Your gmail address
        String myAccountEmail = "hamza.argoubi@esprit.tn";
        //Your gmail password
        String password = "191SMT2377";
        //Create a session with account credentials
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });
       
        Message message=verifMessage(session, myAccountEmail, recepient);
        //Send mail
        Transport.send(message);
        System.out.println("Message sent successfully");
       
    }
    private  Message verifMessage(Session session, String myAccountEmail, String recepient) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Competition aded");
            String htmlCode = "Nouvelle competition";
            message.setContent(htmlCode, "text/html");
            return message;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());        }
        return null;
    }
   
  
    @FXML
    private void supprimercomp(ActionEvent event) {
       competitions comp = new competitions();
        comp = tableview.getSelectionModel().getSelectedItem();
        try{
         cnx = MyConnection.getInstance().getCnx();
   
                String requete3 = "DELETE FROM competitions WHERE nom_comp=?";
          pst = cnx.prepareStatement(requete3);
            
          pst.setString(1, comp.getNom_comp());
            pst.executeUpdate();
            showcompeitions();
            System.out.println("Competition deleted");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
                 

    @FXML
    private void modifiercomp(ActionEvent event) {
         competitions comp = new competitions();
        comp = tableview.getSelectionModel().getSelectedItem();
          try {
            cnx = MyConnection.getInstance().getCnx();
            String requete4 = "UPDATE competitions SET nom_comp=?,nom_cat=?,date_deb=?,date_fin=? WHERE id_comp=? ";
                    
            pst=cnx.prepareStatement(requete4);      
        
           
            pst.setString(1,tfnom_comp.getText());
            pst.setString(2,combo.getValue());
            pst.setDate(3,java.sql.Date.valueOf(date_deb.getValue()));
            pst.setDate(4,java.sql.Date.valueOf(date_fin.getValue()));
            pst.executeUpdate();
            showcompeitions();
            System.out.println("Competition updated");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        }
    }

    }

