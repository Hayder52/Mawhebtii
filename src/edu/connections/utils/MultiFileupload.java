/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connections.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author MAHHOUTTA
 */
public class MultiFileupload {
    
    public static void main(String[] args) {
        String charset = "UTF-8";
        File uploadFile = new File("C:\\test\\logo.png");
       
        String requestURL = "http://localhost:8080/VideoUpload/Uploads";
    try {
         uploadhhtp multipart = new uploadhhtp(requestURL, charset);
           
            multipart.addHeaderField("User-Agent", "CodeJava");
            multipart.addHeaderField("Test-Header", "Header-Value");
             
            multipart.addFormField("description", "Cool Pictures");
            multipart.addFormField("keywords", "Java,upload,Spring");
             
            multipart.addFilePart("fileUpload", uploadFile);
          
 
            List<String> response = multipart.finish();
             
            System.out.println("SERVER REPLIED:");
             
            for (String line : response) {
                System.out.println(line);
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
 
