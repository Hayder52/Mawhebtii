/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.esprit.services;

import pi.esprit.entities.commentaires;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pi.esprit.utils.MyConnection;

/**
 *
 * @author bureau
 */
public class CommentairesService  {
    


     Connection cnx;

    public CommentairesService() {
        cnx = MyConnection.getInstance().getCnx();
    }
 public void ajouterCommentaire() {
        try {
            String requete1 = "INSERT INTO commentaires(id_comm,descr,id_vid,id_user)"
                    + "VALUES (?,?,?,?)";
            Statement st = cnx.createStatement();
            st.executeUpdate(requete1);
            System.out.println("Personne ajoutée!");
        } catch (SQLException ex) {
          
            System.out.println(ex.getMessage());
        }
    }
    
      public boolean ajouterCommentaire(commentaires r) {
       String requete = "INSERT INTO commentaires( id_comm,descr,id_vid,id_user)" + " VALUES (?,?,?,?) ";
        
        
 
     
           try {
            PreparedStatement pst =cnx.prepareStatement(requete);
            pst.setInt(1,r.getId_comm());
            pst.setString(2,r.getDescr());
            pst.setInt(3,r.getId_vid());
            pst.setInt(4,r.getId_user());
             pst.executeUpdate();
            System.out.println("ajout commentaires reussit");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
            return false;
    }
       public void SupprimerCommentaire(int i)
{
  String requete="DELETE FROM commentaires WHERE id_comm='"+i+"' ";     
        Statement st;
        try {
            st = (Statement) cnx.createStatement(); 
            st.executeUpdate(requete);
      System.out.println("comm supprimé");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
}
       public boolean ModifierComm(commentaires r)
    {
        int nbr_ligne;
        
        try{
            
            String requete="UPDATE commentaires set id_comm = ?, descr=?  WHERE id_comm="+r.getId_comm()+"";
            PreparedStatement pst = cnx.prepareStatement(requete);
           pst.setInt(1,r.getId_comm());
            pst.setString(2,r.getDescr());
         
           
            
          
            
            nbr_ligne=pst.executeUpdate();
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        if(nbr_ligne == 0){
            return false;
        }else{
            return true;
        }
        
    }
      public List<commentaires> ListerCommentaires(String i){
         List<commentaires> listCom = new ArrayList<>();
        commentaires listForm= new commentaires();
         Statement ste = null;
        try {  
            String requete = "SELECT * FROM commentaires WHERE id_comm='"+i+"'";

           
            ResultSet rs = ste.executeQuery(requete);

             while(rs.next()){
                
                 listForm.setId_comm(rs.getInt("id_comm"));
              
               
                 listForm.setDescr(rs.getString("descr"));
                 
                 listCom.add(listForm);
                 
            }
             
        } catch (SQLException ex) {
System.out.println(ex.getMessage());        }
        return listCom;
    
    }
       public ResultSet RechercherComByImm(String i)
    {
         try {
             Statement ste = null;
             ResultSet rs=null;
             String requete = "SELECT * FROM commentaires WHERE id_comm ='"+i+"'";
             rs = ste.executeQuery(requete);
             return rs ;
         } catch (SQLException ex) {
             System.out.println(ex.getMessage());         }
         return null;

       
    }
}