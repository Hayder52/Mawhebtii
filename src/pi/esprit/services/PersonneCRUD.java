/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.esprit.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pi.esprit.entities.personnes;
import pi.esprit.utils.MyConnection;

/**
 *
 * @author bureau
 */
public class PersonneCRUD {
     Connection cnx;

    public PersonneCRUD() {
        cnx = MyConnection.getInstance().getCnx();
    }

    public void ajouterPersonne() {
        try {
            String requete = "INSERT INTO personnes(id_user,nom,prenom,date_de_nes,adress,profil,photo,login,pwd,vs)"
                    + "VALUES (?,?,?,?,?,?,?,?,?,?)";
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
            System.out.println("Personne ajoutée!");
        } catch (SQLException ex) {
            System.err.println("Erreur d'insertion");
            System.out.println(ex.getMessage());
        }
    }

    public void ajouterPersonne2(personnes p) {
        try {
           String requete2 = "INSERT INTO personnes(id_user,nom,prenom,date_de_nes,adress,profil,photo,login,pwd,vs)"
                    + "VALUES (?,?,?,?,?,?,?,?,?)";  
            PreparedStatement pst = cnx.prepareStatement(requete2);
            pst.setInt(1, p.getId_user());
            pst.setString(2, p.getNom());
            pst.setString(3, p.getPrenom());
            pst.setDate(4, (Date) p.getDate_de_nes());
            
            pst.setString(5, p.getAdress());
            pst.setString(6, p.getProfil());
            
            pst.setString(7, p.getPhoto());
            pst.setString(8, p.getLogin());
            
            pst.setString(9, p.getPwd());
           
            
            
            pst.executeUpdate();
            System.out.println("Person added!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void supprimerPersonne(int id_user) {
        try {
            String requete = "DELETE FROM personnes WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, id_user);
            pst.executeUpdate();
            System.out.println("Personne supprimé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void updatePersonne(personnes p, int id_user) {
        try {
            String requete = "UPDATE personnes SET nom,prenom=? "
                    + "WHERE id_user=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
           
            pst.setInt(1, p.getId_user());
            pst.setString(2, p.getNom());
            
            pst.setString(3, p.getPrenom());
            pst.executeUpdate();
            System.out.println("Personne modifiée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

   public List<personnes> displayAll(){
       List<personnes> listePersonnes = new ArrayList<>();
        try {
            String requete = "SELECT * FROM personnes";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
             personnes p=new personnes();
                p.setId_user(rs.getInt(1));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));
                p.setDate_de_nes(rs.getDate("date_de_ness"));
                
              
                p.setAdress(rs.getString("adresse"));
                p.setProfil(rs.getString("profil"));
                p.setPhoto(rs.getString("photo"));
                p.setLogin(rs.getString("login"));
                p.setPwd(rs.getString("password"));
               
                
               
                listePersonnes.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return listePersonnes;
   } 
}
