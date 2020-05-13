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
    private int like;
    private int dislike;
    private int id_vid;
    private int id_user;

    public int getId_react() {
        return id_react;
    }

    public int getLike() {
        return like;
    }

    public int getDislike() {
        return dislike;
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

   

    public void setId_vid(int id_vid) {
        this.id_vid = id_vid;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
    }

    @Override
    public String toString() {
        return "reacts{" + "id_react=" + id_react + ", like=" + like + ", dislike=" + dislike + ", id_vid=" + id_vid + ", id_user=" + id_user + '}';
    }

   
    public reacts(){
        
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.id_react;
        hash = 89 * hash + Objects.hashCode(this.like);
        hash = 89 * hash + Objects.hashCode(this.dislike);
        hash = 89 * hash + this.id_vid;
        hash = 89 * hash + this.id_user;
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
        if (!Objects.equals(this.like, other.like)) {
            return false;
        }
        if (!Objects.equals(this.dislike, other.dislike)) {
            return false;
        }
        return true;
    }

   

}