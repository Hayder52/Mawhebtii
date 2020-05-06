/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.esprit.entities;

import java.util.Objects;

/**
 *
 * @author bureau
 */
public class reacts {
    private int id_react;
    private String type_react;
    private int id_vid;
    private int id_user;

    public reacts(int id_react, String type_react, int id_vid, int id_user) {
        this.id_react = id_react;
        this.type_react = type_react;
        this.id_vid = id_vid;
        this.id_user = id_user;
    }

    public int getId_react() {
        return id_react;
    }

    public String getType_react() {
        return type_react;
    }

    public int getId_vid() {
        return id_vid;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_react(int id_react) {
        this.id_react = id_react;
    }

    public void setType_react(String type_react) {
        this.type_react = type_react;
    }

    public void setId_vid(int id_vid) {
        this.id_vid = id_vid;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
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
        final reacts other = (reacts) obj;
        if (this.id_react != other.id_react) {
            return false;
        }
        if (this.id_vid != other.id_vid) {
            return false;
        }
        if (this.id_user != other.id_user) {
            return false;
        }
        if (!Objects.equals(this.type_react, other.type_react)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "reacts{" + "id_react=" + id_react + ", type_react=" + type_react + ", id_vid=" + id_vid + ", id_user=" + id_user + '}';
    }
    
    
}
