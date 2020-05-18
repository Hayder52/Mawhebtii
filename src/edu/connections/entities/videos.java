/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connections.entities;

import java.util.Objects;

/**
 *
 * @author bureau
 */
public class videos {
 	
  private int id_vid;
    private String nom_vid;
    private String Desc_vid;
    private String path_vid;
    private String Cat_vid;
    private int id_comp;

    public videos() {
    }

    public videos(int id_vid, String nom_vid, String Desc_vid, String path_vid, String Cat_vid,int id_comp) {
        this.id_vid = id_vid;
        this.nom_vid = nom_vid;
        this.Desc_vid = Desc_vid;
        this.path_vid = path_vid;
        this.Cat_vid = Cat_vid;
          this.id_comp = id_comp;
    }

    public int getId_vid() {
        return id_vid;
    }

    public String getNom_vid() {
        return nom_vid;
    }

    public String getDesc_vid() {
        return Desc_vid;
    }

    public String getPath_vid() {
        return path_vid;
    }

    public String getCat_vid() {
        return Cat_vid;
    }

    public void setId_vid(int id_vid) {
        this.id_vid = id_vid;
    }

    public void setNom_vid(String nom_vid) {
        this.nom_vid = nom_vid;
    }

    public void setDesc_vid(String Desc_vid) {
        this.Desc_vid = Desc_vid;
    }

    public void setPath_vid(String path_vid) {
        this.path_vid = path_vid;
    }

    public void setCat_vid(String Cat_vid) {
        this.Cat_vid = Cat_vid;
    }

    public void setId_comp(int id_comp) {
        this.id_comp = id_comp;
    }

    public int getId_comp() {
        return id_comp;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.id_vid;
        hash = 71 * hash + Objects.hashCode(this.nom_vid);
        hash = 71 * hash + Objects.hashCode(this.Desc_vid);
        hash = 71 * hash + Objects.hashCode(this.path_vid);
        hash = 71 * hash + Objects.hashCode(this.Cat_vid);
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
        final videos other = (videos) obj;
        if (this.id_vid != other.id_vid) {
            return false;
        }
        if (!Objects.equals(this.nom_vid, other.nom_vid)) {
            return false;
        }
        if (!Objects.equals(this.Desc_vid, other.Desc_vid)) {
            return false;
        }
        if (!Objects.equals(this.path_vid, other.path_vid)) {
            return false;
        }
        if (!Objects.equals(this.Cat_vid, other.Cat_vid)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "VideoCrud{" + "id_vid=" + id_vid + ", nom_vid=" + nom_vid + ", Desc_vid=" + Desc_vid + ", path_vid=" + path_vid + ", Cat_vid=" + Cat_vid + '}';
    }

   
}
