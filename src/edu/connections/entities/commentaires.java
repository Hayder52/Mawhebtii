/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connections.entities;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author bureau
 */
public class commentaires {
   private int id;
    private String id_user;
    private String contenu;
    private Date date;


    public commentaires() {
    }

    public commentaires(int id, String id_user, String contenu, Date date) {
        this.id = id;
        this.id_user =id_user;
        this.contenu = contenu;
        this.date = date;
      
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user= id_user;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

   

   

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final commentaires other = (commentaires) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.id_user, other.id_user)) {
            return false;
        }
        return true;
    }
      
}
