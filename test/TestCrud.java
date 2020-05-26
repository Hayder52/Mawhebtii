
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import pi.esprit.services.MailService;
import pi.esprit.utils.MyConnection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fakhri Argoubi
 */
public class TestCrud {
    public static void main(String[] args) {
        try {
            MailService.sendBanMail("hamzaargoubi@hotmail.com", "13/12/2022");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());        }
    }
}
