/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connections.services;

import edu.connections.entities.Session;
import edu.connections.entities.Userservice;
import edu.connections.entities.abonnes;
import edu.connections.entities.commentaires;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bureau
 */
public class CommentairesService {
     private static CommentairesService instance;
    public static CommentairesService getInstance() throws SQLException {
       
         if (instance == null) {
            instance = new CommentairesService();
        }
        return instance;
    }
 
    public Statement ste;
Connection con;
    public CommentairesService() throws SQLException {
       ste = (Statement) con.createStatement();
    }
    
    
     public boolean ajouterCommentaire(commentaires r) throws SQLException{
       String requete = "INSERT INTO commentaire( id, contenu,date) VALUES (?,?,?) ";
        commentaires a =new commentaires();
       
        Userservice us= new Userservice();
     
           try {
            PreparedStatement pst =con.prepareStatement(requete);
            pst.setInt(1,a.getId());
            pst.setString(2,a.getContenu());
            pst.setDate(3, (Date) a.getDate());
             pst.executeUpdate();
            System.out.println("ajout commentaires reussit");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
            return false;
    }
       public void SupprimerCommentaire(int i)
{
  String requete="DELETE FROM commentaires WHERE id='"+i+"' ";     
        Statement st;
        try {
            st = (Statement) con.createStatement(); 
            st.executeUpdate(requete);
      System.out.println("comm supprimé");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
}
       public boolean ModifierComm(commentaires r)
    {
        int nbr_ligne;
         commentaires a =new commentaires();
        try{
            
            String requete="UPDATE commentaires set id=?, contenu=?,date=?  WHERE id="+r.getId()+"";
            PreparedStatement pst = con.prepareStatement(requete);
           pst.setInt(1,a.getId());
            pst.setString(2,a.getContenu());
            pst.setDate(3, (Date) a.getDate());
           
            
          
            
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
        try {  
            String requete = "SELECT * FROM commentaire WHERE id='"+i+"'";

           
            ResultSet rs = ste.executeQuery(requete);

             while(rs.next()){
                
                 listForm.setId(rs.getInt("id"));
              
                 listForm.setDate(rs.getDate("date"));
                 listForm.setContenu(rs.getString("contenu"));
                 
                 listCom.add(listForm);
                 
            }
             
        } catch (SQLException ex) {
System.out.println(ex.getMessage());        }
        return listCom;
    
    }
       public ResultSet RechercherComByImm(String i)
    {
        ResultSet rs=null;
        String requete = "SELECT * FROM commentaires WHERE id ='"+i+"'";
        try {
            rs = ste.executeQuery(requete);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rs ;

       
    }
}
