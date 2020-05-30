/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.esprit.entities;




import java.sql.Date;
import java.util.Objects;


/**
 *
 * @author bureau
 */
public class competitions {

    public static Object getSelecyionModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static Object getSelectionModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private int id_comp;
    private String nom_comp;
    private String nom_cat;
    private Date date_deb;
    private Date date_fin;

    public competitions() {
    }

    public competitions(int id_comp, String nom_comp, String nom_cat, Date date_deb, Date date_fin) {
        this.id_comp = id_comp;
        this.nom_comp = nom_comp;
        this.nom_cat = nom_cat;
        this.date_deb = date_deb;
        this.date_fin = date_fin;
    }

    public competitions(String string, String string0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_comp() {
        return id_comp;
    }

    public String getNom_comp() {
        return nom_comp;
    }

    public String getNom_cat() {
        return nom_cat;
    }

    public Date getDate_deb() {
        return date_deb;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setId_comp(int id_comp) {
        this.id_comp = id_comp;
    }

    public void setNom_comp(String nom_comp) {
        this.nom_comp = nom_comp;
    }

    public void setNom_cat(String nom_cat) {
        this.nom_cat = nom_cat;
    }

    public void setDate_deb(Date date_deb) {
        this.date_deb = date_deb;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

 
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final competitions other = (competitions) obj;
        if (this.id_comp != other.id_comp) {
            return false;
        }
        if (!Objects.equals(this.nom_comp, other.nom_comp)) {
            return false;
        }
        if (!Objects.equals(this.nom_cat, other.nom_cat)) {
            return false;
        }
        if (!Objects.equals(this.date_deb, other.date_deb)) {
            return false;
        }
        if (!Objects.equals(this.date_fin, other.date_fin)) {
            return false;
        }
        return true;
    }

   


 
     @Override
    public String toString() {
        return "commentaires{" + "id_comp=" + id_comp + ", nom_comp=" + nom_comp + ", nom_cat=" + nom_cat + ", date_deb=" + date_deb +", date_fin=" + date_fin + '}';

    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

   