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
import java.util.logging.Level;
import java.util.logging.Logger;
import pi.esprit.entities.reacts;
import pi.esprit.utils.MyConnection;

/**
 *
 * @author bureau
 */
public class Reactservices {
     Connection cnx;

    public Reactservices() {
        cnx = MyConnection.getInstance().getCnx();
    }
    
    public void like(){
        reacts r=new reacts();
         try {
             int like = 0;
             String requete1="Select like From reacts where id_video=?";
             PreparedStatement pst1 = cnx.prepareStatement(requete1);
             pst1.setInt(1,r.getLike());
             ResultSet results = pst1.executeQuery();
             while(results.next())
                 like =results.getInt("likes");
             like++;
             String requete2="Update reacts SET like=? where id_user=? ";
             PreparedStatement pst2 = cnx.prepareStatement(requete2);
             pst2.setInt(1,r.getId_user());
             pst2.setInt(2,r.getLike());
             int rowsupdated = pst2.executeUpdate();
             if(rowsupdated>0)                
                 System.out.println("row updated");
         } catch (SQLException ex) {
             System.out.println(ex.getMessage());         }
            
    }
     public void dislike(){
        reacts r=new reacts();
         try {
             int dislike = 0;
             String requete1="Select type_react From reacts WHERE id_video=?";
             PreparedStatement pst1 = cnx.prepareStatement(requete1);
             pst1.setInt(2,r.getDislike());
             ResultSet results = pst1.executeQuery();
             while(results.next())
                 dislike =results.getInt("dislikes");
             dislike++;
             String requete2="Update reacts SET dislike=? WHERE id_user=?  ";
             PreparedStatement pst2 = cnx.prepareStatement(requete2);
             pst2.setInt(1,r.getId_user());
             pst2.setInt(2,r.getDislike());
             int rowsupdated = pst2.executeUpdate();
             if(rowsupdated>0)                
                 System.out.println("row updated");
         } catch (SQLException ex) {
             System.out.println(ex.getMessage());         }
            
    }
}
