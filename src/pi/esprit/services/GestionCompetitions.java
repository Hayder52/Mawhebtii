/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.esprit.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pi.esprit.entities.competitions;
import pi.esprit.utils.MyConnection;

/**
 *
 * @author abassi
 */
public class GestionCompetitions {
        Connection cnx;

    public GestionCompetitions() {
        cnx = MyConnection.getInstance().getCnx();
    }
        
        
    
     public void ajoutercompetitions(competitions s) {
        try {
           String requete2 = "INSERT INTO competitions(nom_comp,id_cat)"
                    + "VALUES (?,?)";  
            PreparedStatement pst = cnx.prepareStatement(requete2);
          
            pst.setString(1, s.getNom_comp());
            pst.setInt(2, s.getId_cat());
           
            
            
                        
           
            
            
            pst.executeUpdate();
            System.out.println("competition added!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
     public void supprimerCompetitions(int id_comp ){
            try {
                String requete = "DELETE FROM competitions WHERE id_comp=?";
                PreparedStatement pst = cnx.prepareStatement(requete);
                pst.setInt(1, id_comp);
                pst.executeUpdate();
                System.err.println("personne supprimer");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
                 

     }
     public void updateCompetitions(competitions s , int id_comp){
            try {
                String requete = "UPDATE competitions SET nom_comp = ? , id_cat=? WHERE id_comp=?";
                        
                PreparedStatement pst =cnx.prepareStatement(requete);
                pst.setInt(3, id_comp);
                pst.setString(1, s.getNom_comp());
                pst.setInt(2, s.getId_cat());
                pst.executeUpdate();
                System.out.println("competition modifier");
                        
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
         
     }
 public List<competitions> displayAll(){
     List<competitions> listeCompetition = new ArrayList<>();
            try {
                
                String requete ="SELECT * FROM competitions";
                Statement st = cnx.createStatement();
                ResultSet rs = st.executeQuery(requete);
                while(rs.next()){
                    competitions s = new competitions();
                    s.setId_comp(rs.getInt(1));
                    s.setNom_comp(rs.getString("nom_comp"));
                    s.setId_cat(rs.getInt(3));
                    listeCompetition.add(s);
                    
                    
                }
               
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
             
             
     return listeCompetition;
  }
   
}
