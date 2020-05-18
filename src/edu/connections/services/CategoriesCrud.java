/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connections.services;

import edu.connections.entities.categories;
import edu.connections.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author MAHHOUTTA
 */
public class CategoriesCrud {
      static Connection cnx;

    public CategoriesCrud () {
        cnx = MyConnection.getInstance().getCnx();
    }
        public static void ajouterCategorie() {
        try {
            String requete1 = "INSERT INTO categoris (id_cat,nom_cat)"
                    + "VALUES (?,?)";  
            Statement st = cnx.createStatement();
            st.executeUpdate(requete1);
            System.out.println("Category added");
        } catch (SQLException ex) {
          
            System.out.println(ex.getMessage());
        }
    }
    public static void ajouterCategorie( categories c) {
        try {
           String requeteC = "INSERT INTO categoris (id_cat,nom_cat)"
                    + "VALUES (?,?)";  
            PreparedStatement pst = cnx.prepareStatement(requeteC);
          
            pst.setInt(1,c.getId());
            pst.setString(2,c.getNom());
            pst.executeUpdate();
            System.out.println("Category added!");
        } catch (SQLException ex) {
            System.err.println("ajouter cat"+ex.getMessage());
        }
    }
       public static void updateCategories(categories c) {
        try {
            String requete = "UPDATE categoris SET nom=?"
                    + "login=?,pwd=?"
                    + "WHERE id_user=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, c.getNom());
            
            pst.executeUpdate();
            System.out.println("Category updated");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void supprimerCategorie(int id) {
        try {
            String requete = "DELETE FROM categoris WHERE id=?";
            
            PreparedStatement pst = cnx.prepareStatement(requete);
            
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("Category deleted");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
    
    
 
    


