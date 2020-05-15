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
 	
private int id;
private String nom_video;
private int id_categorie;
private String 	url;
private int likes;
private int dislikes;


  public videos (int id, String nom_video, int id_categorie, String url, int likes, int dislikes) {
        this.id = id;
        this.nom_video= nom_video;
        this.id_categorie = id_categorie;
        this.url = url;
        this.likes = likes;
        this.dislikes = dislikes;
      
    }

    public int getId() {
        return id;
    }

    public String getNom_video() {
        return nom_video;
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public String getUrl() {
        return url;
    }

    public int getLikes() {
        return likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom_video(String nom_video) {
        this.nom_video = nom_video;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.id;
        hash = 89 * hash + Objects.hashCode(this.nom_video);
        hash = 89 * hash + this.id_categorie;
        hash = 89 * hash + Objects.hashCode(this.url);
        hash = 89 * hash + this.likes;
        hash = 89 * hash + this.dislikes;
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
        if (this.id != other.id) {
            return false;
        }
        if (this.id_categorie != other.id_categorie) {
            return false;
        }
        if (this.likes != other.likes) {
            return false;
        }
        if (this.dislikes != other.dislikes) {
            return false;
        }
        if (!Objects.equals(this.nom_video, other.nom_video)) {
            return false;
        }
        if (!Objects.equals(this.url, other.url)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "videos{" + "id=" + id + ", nom_video=" + nom_video + ", id_categorie=" + id_categorie + ", url=" + url + ", likes=" + likes + ", dislikes=" + dislikes + '}';
    }

  
  
  
}
