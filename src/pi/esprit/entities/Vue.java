/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.esprit.entities;

/**
 *
 * @author bureau
 */
public class Vue {
    private int id;
    private int id_vid;

    public Vue(int id_vid) {
        this.id_vid=id_vid;
    }

    public int getId() {
        return id;
    }

    public int getId_vid() {
        return id_vid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_vid(int id_vid) {
        this.id_vid = id_vid;
    }

    public Vue(int id, int id_vid) {
        this.id = id;
        this.id_vid = id_vid;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.id;
        hash = 47 * hash + this.id_vid;
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
        final Vue other = (Vue) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.id_vid != other.id_vid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vue{" + "id=" + id + ", id_vid=" + id_vid + '}';
    }
    
}
