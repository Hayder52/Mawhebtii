
import pi.esprit.entities.competitions;
import pi.esprit.services.GestionCompetitions;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abassi
 */
public class Cometition_test_insert {
    public static void main(String[] args) {
        //competitions s = new competitions(5,"nom_comp",1);
        GestionCompetitions gc = new GestionCompetitions();
        //gc.ajoutercompetitions(s);
        //gc.supprimerCompetitions(7);
      // competitions s1 = new competitions(6,"youtube", 3);
       // gc.updateCompetitions(s1, 4);
        System.out.println(gc.displayAll());
        
    }
    
}

