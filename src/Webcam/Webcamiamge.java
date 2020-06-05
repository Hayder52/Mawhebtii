/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Webcam;

import com.github.sarxos.webcam.Webcam;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author bureau
 */
public class Webcamiamge {
      public static void main(String[] args) throws IOException {
         Webcam webcam=Webcam.getDefault();
         for(Dimension supportedSize:webcam.getViewSizes()){
             System.out.println(supportedSize.toString());
         }
    webcam.open();
        ImageIO.write(webcam.getImage(),"JPG", new File("FirstCapture.jpg"));
    }
}
