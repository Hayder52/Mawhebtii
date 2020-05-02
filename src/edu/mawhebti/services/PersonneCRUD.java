/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mawhebti.services;

import edu.mawhebti.entities.Personne;
import edu.mawhebti.utilities.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author House
 */
public class PersonneCRUD {

    Connection cnx;

    public PersonneCRUD() {
        cnx = MyConnection.getInstance().getCnx();
    }

    public void ajouterPersonne(Personne p) {
        try {
            String requete = "INSERT INTO personne(nom,prenom)"
                    + "VALUES ('"+p.getPrenom()+"','"+p.getNom()+"')";
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
            System.out.println("Personne ajoutée!");
        } catch (SQLException ex) {
            System.err.println("Erreur d'insertion");
            System.out.println(ex.getMessage());
        }
    }

    public void ajouterPersonne2(Personne p) {
        try {
            String requete2 = "INSERT INTO personne (nom, prenom)"
                    + "VALUES (?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete2);
            pst.setString(1, p.getNom());
            pst.setString(2, p.getPrenom());
            pst.executeUpdate();
            System.out.println("Person added!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void supprimerPersonne(int id) {
        try {
            String requete = "DELETE FROM personne WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("Personne supprimé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void updatePersonne(Personne p, int id) {
        try {
            String requete = "UPDATE personne SET nom=?,prenom=? "
                    + "WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(3, id);
            pst.setString(1, p.getNom());
            pst.setString(2, p.getPrenom());
            pst.executeUpdate();
            System.out.println("Personne modifiée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

   public List<Personne> displayAll(){
       List<Personne> listePersonnes = new ArrayList<>();
        try {
            String requete = "SELECT * FROM personne";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
                Personne p = new Personne();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));
                listePersonnes.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return listePersonnes;
   } 
   public boolean  login(String msg,String login,String pwd) {
            boolean allow=false;
            ResultSet result;
            String sqlLogin="";
            String sqlPwd="";
            String requete = "select login,password from logintab where login=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, login);
             result = pst.executeQuery(requete);
             while(result.next()){
               sqlLogin=result.getString("login");
               sqlPwd=result.getString("pwd");
             }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        }
        if(sqlLogin==""&&sqlLogin==""){
            allow=false;
            msg="your email is not recognized";
        }
            
        if( login.equals(sqlLogin)&&!pwd.equals(sqlPwd))
        {
            allow=false;
            msg="wrong password";       
        }
        if (login.equals(sqlLogin)&&pwd.equals(sqlPwd))
        {
            allow=true;
            msg="welcome";
        }
        return allow;
            

   }
   
}
