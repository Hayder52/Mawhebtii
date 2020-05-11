
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
     static Connection  cnx;

    public PersonneCRUD() {
        cnx = MyConnection.getInstance().getCnx();
    }

    public void ajouterPersonne() {
        try {
            String requete1 = "INSERT INTO personnes(nom,prenom,profil,photo,login,pwd,adress)"
                    + "VALUES (?,?,?,?,?,?,?)";
            Statement st = cnx.createStatement();
            st.executeUpdate(requete1);
            System.out.println("Personne ajoutée!");
        } catch (SQLException ex) {
          
            System.out.println(ex.getMessage());
        }
    }

    public void ajouterPersonne2(personnes p) {
        try {
           String requete2 = "INSERT INTO personnes(nom,prenom,profil,photo,login,pwd,adress)"
                    + "VALUES (?,?,?,?,?,?,?)";  
            PreparedStatement pst = cnx.prepareStatement(requete2);
          
            pst.setString(1, p.getNom());
            pst.setString(2, p.getPrenom());
           
            
            pst.setString(3, p.getProfil());
        
            
            pst.setString(4, p.getPhoto());
            pst.setString(5, p.getLogin());
            
            pst.setString(6, p.getPwd());   
            pst.setString(7, p.getAdress());
            
           
            
            
            pst.executeUpdate();
            System.out.println("Person added!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static void supprimerPersonne(int id_user) {
        try {
            String requete = "DELETE FROM personnes WHERE id_user=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, id_user);
            pst.executeUpdate();
            System.out.println("Personne supprimé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void updatePersonne(personnes p) {
        try {
            String requete = "UPDATE personnes SET nom=?,prenom=?,adress=?,profil=?,photo=?,"
                    + "login=?,pwd=?"
                    + "WHERE id_user=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, p.getNom());
            pst.setString(2, p.getPrenom());
            pst.setString(3, p.getAdress());
            pst.setString(4, p.getProfil());
            pst.setString(5, p.getPhoto());
            pst.setString(6, p.getLogin());
            pst.setString(7, p.getPwd());
            pst.setInt(8, p.getId_user());
            pst.executeUpdate();
            System.out.println("Personne modifiée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

   public static List<personnes> selectUsers(){
       List<personnes> listePersonnes = new ArrayList<>();
        try {
            String requete = "SELECT * FROM personnes";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
             personnes p=new personnes();
                p.setId_user(rs.getInt("id_user"));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));
                p.setProfil(rs.getString("profil"));
                p.setPhoto(rs.getString("photo"));
                p.setLogin(rs.getString("login"));
                p.setPwd(rs.getString("pwd"));
                 p.setAdress(rs.getString("adress"));
               
                
               
                listePersonnes.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return listePersonnes;
   } 
   
    public static void ajouterPersonne3(personnes p) {
        try {
           String requete2 = "INSERT INTO personnes(id_user,nom,prenom,dateDeNaissance,adress,profil,photo,login,pwd)"
                    + "VALUES (?,?,?,?,?,?,?,?)";  
            PreparedStatement pst = cnx.prepareStatement(requete2);
            pst.setInt(1, p.getId_user());
            pst.setString(2, p.getNom());
            pst.setString(3, p.getPrenom());
            pst.setString(4, p.getAdress());
            pst.setString(5, p.getProfil());
            pst.setString(6, p.getPhoto());
            pst.setString(7, p.getLogin());
            pst.setString(8, p.getPwd());
            pst.executeUpdate();
            System.out.println("Person added!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
