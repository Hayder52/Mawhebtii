
import javafx.stage.Stage;
import pi.esprit.design.homelogin.GestionDesCompteInterface;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fakhri Argoubi
 */
public class Admintest2 {
    public static void main(String[] args) {
        Stage primaryStage = new Stage();
         GestionDesCompteInterface gs = new GestionDesCompteInterface();
        gs.showAdminInterface(primaryStage);
    }

}
