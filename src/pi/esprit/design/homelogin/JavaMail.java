/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.esprit.design.homelogin;

import javax.mail.MessagingException;

/**
 *
 * @author bureau
 */
public class JavaMail {
    public static void main(String[] args) throws MessagingException {
        JavaMailutil.sendmail("hamzasarraj5@gmail.com");
    }
           
}
