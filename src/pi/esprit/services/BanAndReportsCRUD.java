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
import java.sql.Timestamp;
import pi.esprit.utils.MyConnection;

/**
 *
 * @author Fakhri Argoubi
 */
public class BanAndReportsCRUD {
    Connection cnx;

    public BanAndReportsCRUD() {
        cnx = MyConnection.getInstance().getCnx();
    }
    
    public  void initializeReportTab(int id) {
        try {
           
           String requete2 = "INSERT INTO reports(id_user,numberOfReports)"
                    + "VALUES (?,?)";  
            PreparedStatement pst = cnx.prepareStatement(requete2);
            
            pst.setInt(1, id);
            pst.setInt(2, 0);
            
            pst.executeUpdate();
            System.out.println("Ban added!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void reportRelations (int reportedId,int reporterId){
        try {
           
           String requete2 = "INSERT INTO reportRelations(reportedId,reporterId)"
                    + "VALUES (?,?)";  
            PreparedStatement pst = cnx.prepareStatement(requete2);
            
            pst.setInt(1, reportedId);
            pst.setInt(2, reporterId);
            
            pst.executeUpdate();
            System.out.println("reporter added!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public boolean checkReportStatus(int reportedId,int reporterId){
         try {
            String requete = "SELECT * FROM reportRelations WHERE reportedId = ? AND reporterId=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            
            pst.setInt(1, reportedId);
            pst.setInt(2, reporterId);
            ResultSet rs = pst.executeQuery(requete);
            if(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       return false;
    }
   
   public int selectNumberOfReports(int id){
       int nReports = -1;
        try {
            String requete = "SELECT numberOfReports FROM reports WHERE id_user = "+id;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
               nReports = rs.getInt("numberOfReports");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       return nReports;
   }
   
   public  void incrementNumberOfReports(int id) {
       int nReports = 0;
        try {
            String requete = "SELECT numberOfReports FROM reports WHERE id_user = "+id;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
               nReports = rs.getInt("numberOfReports");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        nReports++;
        try {
           
           String requete = "UPDATE reports SET numberOfReports=? "
                    + "WHERE id_user=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, nReports);
            pst.setInt(2, id);
          
           
            pst.executeUpdate();
            System.out.println("report added");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
   
   public  void ban(int id_user,int addedDays) {
        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
         try {
            date= addDays(addedDays, date);
         } catch (Exception ex) {
             System.out.println(ex.getMessage());         }
        try {
           
           String requete2 = "INSERT INTO bans(id_user,endOfBanDate)"
                    + "VALUES (?,?)";  
            PreparedStatement pst = cnx.prepareStatement(requete2);
            
            pst.setInt(1, id_user);
            pst.setTimestamp(2, date);
            
            pst.executeUpdate();
            System.out.println("Ban added!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
   
   
   
   
   public boolean banVerification(int id){
       Timestamp dateBan = null;
        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
       try {
            String requete = "SELECT endOfBanDate FROM bans WHERE id_user = "+id;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
               dateBan=rs.getTimestamp("endOfBanDate");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       VerificationCodeCRUD vc = new VerificationCodeCRUD();
       if(vc.compareTwoTimeStamps(dateBan,date)>0)
           return true;
        return false;
       
   }
   private Long dayToMiliseconds(int days){
    Long result = Long.valueOf(days * 24 * 60 * 60 * 1000);
    return result;
}

public Timestamp addDays(int days, Timestamp t1) throws Exception{
    if(days < 0){
        throw new Exception("Day in wrong format.");
    }
    Long miliseconds = dayToMiliseconds(days);
    return new Timestamp(t1.getTime() + miliseconds);
}
    
}
