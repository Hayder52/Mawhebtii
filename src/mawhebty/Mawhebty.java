/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mawhebty;

import java.sql.SQLException;
import pi.esprit.entities.commentaires;
import pi.esprit.entities.competitions;
import pi.esprit.entities.personnes;
import pi.esprit.services.CommentairesService;
import pi.esprit.services.GestionCompetitions;
import pi.esprit.services.PersonneCRUD;
import pi.esprit.utils.MyConnection;

/**
 *
 * @author bureau
 */
public class Mawhebty {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        
          MyConnection mc = MyConnection.getInstance();
      MyConnection mc2 = MyConnection.getInstance();
       // System.out.println(mc.hashCode()+ " -- "+mc2.hashCode());
       /* PersonneCRUD pc = new PersonneCRUD();
       pc.ajouterPersonne();
       personnes p = new personnes(55,"sarraj","hamza","manouba","amateur","hamza.png","hamouz","azerty");
       pc.ajouterPersonne2(p);
       pc.supprimerPersonne(2);
       personnes p1 = new personnes(45,"ayechi","Anis","manouba","amateur","hamza.png","ham","ghare");
       pc.ajouterPersonne2(p1);
        System.out.println(pc.displayAll());
        pc.updatePersonne(p1, 1);
        CommentairesService cs=new CommentairesService();
    
        commentaires b =new commentaires (8,"hamza",1,5);
       cs.ajouterCommentaire(b);
       
       
       /*************************/
        /*GestionCompetitions pcm = new GestionCompetitions();
        pcm.ajoutercompetitions();
        competitions s = new competitions(5,"Music",2);*/
        
   
      
        GestionCompetitions gc = new GestionCompetitions();
        gc.supprimerCompetitions(2);
      
       
    }
    }
    

