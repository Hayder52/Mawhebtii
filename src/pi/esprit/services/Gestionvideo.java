/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.esprit.services;

import java.sql.Connection;
import pi.esprit.utils.MyConnection;

/**
 *
 * @author bureau
 */
public class Gestionvideo implements videoges {
        Connection cnx;
    public Gestionvideo() {
        cnx = MyConnection.getInstance().getCnx();
    }

    @Override
    public void ajouterVideos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimerVideos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void afficherVideos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
