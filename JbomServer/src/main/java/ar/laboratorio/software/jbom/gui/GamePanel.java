/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.laboratorio.software.jbom.gui;

import ar.laboratorio.software.jbom.domain.JBomCore;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author francisco
 */
public class GamePanel extends JPanel{
    
    private BufferedImage image;
    
    public GamePanel(){
        try {                
            image = ImageIO.read(new File("/home/francisco/Documents/Facultad/LaboratorioDeSoftware/Jbom/JbomServer/src/main/resources/imagenes/usuario.png"));
            Color backGroundColor = new Color(255, 255, 255, 255);
            this.setBackground(backGroundColor);
            this.updateUI();
       } catch (IOException ex) {
            Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, "No se puede cargar la imagen: usuario.png", ex);
       }
        
    }
    
    public void dibujarImagenJugador(Integer x, Integer y, String nombre){
        super.paintComponent(this.getGraphics());
        this.getGraphics().drawImage(image, x, y, null);
    }
}
