/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connections.services;


import edu.connections.entities.personnes;
import edu.connections.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author House
 */
public class PersonneCRUD {

    Connection cnx;

    public PersonneCRUD() {
        cnx = MyConnection.getInstance().getCnx();
    }

    public void ajouterPersonne() {
        try {
            String requete = "INSERT INTO personnes(id,nom,prenom,adresse,num_tel,login,password)"
                    + "VALUES (1,'hamza','sarraj','manouba','erty','fffg','ghj')";
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
           String requete2 = "INSERT INTO personnes(id,nom,prenom,adresse,num_tel,login,password)"
                    + "VALUES (1,'hamza','sarraj','manouba','erty','fffg','ghj')";
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
            String requete = "DELETE FROM personnes WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("Personne supprimé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void updatePersonne(personnes p, int id) {
        try {
            String requete = "UPDATE personnes SET nom=?,prenom=? "
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

   public List<personnes> displayAll(){
       List<personnes> listePersonnes = new ArrayList<>();
        try {
            String requete = "SELECT * FROM personnes";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
             personnes p=new personnes();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));
                p.setAdresse(rs.getString("adresse"));
                p.setNum_tel(rs.getString("num_tel"));
                p.setLogin(rs.getString("login"));
                p.setPassword(rs.getString("password"));
                
               
                listePersonnes.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return listePersonnes;
   } 
}
