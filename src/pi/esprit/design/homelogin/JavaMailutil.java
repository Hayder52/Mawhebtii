/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.esprit.design.homelogin;

import javax.mail.Authenticator;
import javax.mail.Session;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author bureau
 */
public class JavaMailutil {
    public static void sendmail(String recepient) throws MessagingException{
        System.out.println("Prepare to sent your email");

        Properties properties=new Properties();
        properties.put("mail.smtp.auth",true);
      //  properties.put("mail.smtp.starttls.enable",true);
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.socketFactory.port","465");
        properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");


        properties.put("mail.smtp.port","465");
        String Myaccountemail="hamza.sarraj@esprit.tn";
        String password="191SMT0123";
     Session session=Session.getInstance(properties,new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(Myaccountemail, password);
            }
        
    });  
    
      Message message=prepareMessage( session, Myaccountemail, recepient);  
        
        Transport.send(message);
        System.out.println("Message  was sent sucssesfully");
        
        
        
        
        
    }

    private static Message prepareMessage(Session session,String Myaccountemail,String recepient ) throws MessagingException {
        try {
            Message message=new MimeMessage(session);
            message.setFrom(new InternetAddress(Myaccountemail));
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(recepient));
            message.setSubject("My first application email");
           // message.setText("hey ! how are you !!");
           String htmlcode="<h1>we love java</h1>";
           message.setContent(htmlcode,"text/html");
            return message;
        } catch (AddressException ex) {
            Logger.getLogger(JavaMailutil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
