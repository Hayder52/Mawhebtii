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
import pi.esprit.entities.Vue;
import pi.esprit.entities.loggedmembre;
import pi.esprit.entities.personnes;
import pi.esprit.entities.reacts;
import pi.esprit.utils.MyConnection;

/**
 *
 * @author bureau
 */
public class VueService {
   
     Connection cnx;
public VueService(){
               cnx = MyConnection.getInstance().getCnx();

}
personnes pt=loggedmembre.getP();
    public  void ajouterVue(Vue v){
        try {
        
           
            String requete2="INSERT INTO Vue (id_vid) " + "VALUES(?)";
            PreparedStatement pst2 = cnx.prepareStatement(requete2);
            pst2.setInt(1,v.getId_vid());
         
            pst2.executeUpdate();
            System.out.println("vue ajoutee");
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        }
    }
    
     public String  Vue_number(Vue v) {
          String count = null;
        try {
            
            String sql="SELECT count(*) FROM Vue WHERE id_vid=? ";
            PreparedStatement pst1 = cnx.prepareStatement(sql);
            pst1.setInt(1,v.getId_vid());
          
            ResultSet results = pst1.executeQuery();
                    if(results.next()){
                        count=results.getString("count(*)");
                    
                    }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        }
         return count;
           
        
    }
    
}
