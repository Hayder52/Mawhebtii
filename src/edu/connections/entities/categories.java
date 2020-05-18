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
public class categories {
    
    private int id;
    private String nom;

    public categories(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public categories() {
    }
    

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.nom);
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
        final categories other = (categories) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        return true;
        
    }

    @Override
    public String toString() {
        return "categories{" + "id=" + id + ", nom=" + nom + '}';
    }

    
    
    
    
}
