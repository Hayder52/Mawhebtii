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
    private int id_comp;
    private String nom_comp;
    private int id_cat;

    public competitions() {
    }

    public competitions(int id_comp, String nom_comp, int id_cat) {
        this.id_comp = id_comp;
        this.nom_comp = nom_comp;
        this.id_cat = id_cat;
    }

    public int getId_comp() {
        return id_comp;
    }

    public String getNom_comp() {
        return nom_comp;
    }

    public int getId_cat() {
        return id_cat;
    }

    public void setId_comp(int id_comp) {
        this.id_comp = id_comp;
    }

    public void setNom_comp(String nom_comp) {
        this.nom_comp = nom_comp;
    }

    public void setId_cat(int id_cat) {
        this.id_cat = id_cat;
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
        if (this.id_cat != other.id_cat) {
            return false;
        }
        if (!Objects.equals(this.nom_comp, other.nom_comp)) {
            return false;
        }
       
        return true;
    }

    @Override
    public String toString() {
        return "competitions{" + "id_comp=" + id_comp + ", nom_comp=" + nom_comp + ", id_cat=" + id_cat + '}';
    }

    public String getNom_cat() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getid_cat() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}