/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.esprit.entities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author bureau
 */
public class InputValidation {
     public static boolean validTextField(String test) {
        return test.equals("");
    }
 public void CopyImage(String url, String imageDestination) throws IOException {
        
        InputStream inputStream = new FileInputStream(imageDestination);//upload l'image
        System.out.println("Start uploading second file");

        OutputStream output = new FileOutputStream(url);
        byte[] bytesIn = new byte[4096];
        int read = 1;
        while ((read = inputStream.read(bytesIn)) != -1) {//copier l'image au serveur
            output.write(bytesIn, 0, read);
        }
        System.out.println("uploaded");
        output.close();
        inputStream.close();
}
}