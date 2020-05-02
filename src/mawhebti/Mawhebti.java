/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mawhebti;

import edu.connections.entities.personnes;
import edu.connections.services.PersonneCRUD;
import edu.connections.utils.MyConnection;

/**
 *
 * @author bureau
 */
public class Mawhebti {

    /**
     * @param args the command line arguments
     */

        
    public static void main(String[] args) {
       MyConnection mc = MyConnection.getInstance();
       // MyConnection mc2 = MyConnection.getInstance();
       // System.out.println(mc.hashCode()+ " -- "+mc2.hashCode());
        PersonneCRUD pc = new PersonneCRUD();
       pc.ajouterPersonne();
       personnes p = new personnes(14,"Messi", "Lionel","manouba","zartez","gare","jaer");
       pc.ajouterPersonne2(p);
       pc.supprimerPersonne(2);
       personnes p1 = new personnes(14,"Messi", "Lionel","benarous","gfar","agata","ajaj");
       pc.ajouterPersonne2(p1);
        System.out.println(pc.displayAll());
        pc.updatePersonne(p1, 1);
    }
}

    
    

