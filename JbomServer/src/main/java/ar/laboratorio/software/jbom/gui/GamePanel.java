/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.laboratorio.software.jbom.gui;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.EventListenerList;
import javax.swing.plaf.ComponentUI;

/**
 *
 * @author francisco
 */
public class GamePanel extends JPanel{
    
    private BufferedImage imageUsuario;
    private BufferedImage imageUsuarioConBomba;
    
    public GamePanel(){
        try {                
            imageUsuario = ImageIO.read(new File("/home/francisco/Documents/Facultad/LaboratorioDeSoftware/Jbom/JbomServer/src/main/resources/imagenes/usuario.png"));
            imageUsuarioConBomba = ImageIO.read(new File("/home/francisco/Documents/Facultad/LaboratorioDeSoftware/Jbom/JbomServer/src/main/resources/imagenes/usuarioconbomba.png"));
            Color backGroundColor = new Color(255, 255, 255, 255);
            this.setBackground(backGroundColor);
            this.updateUI();
       } catch (IOException ex) {
            Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, "No se puede cargar la imagen: usuario.png", ex);
       }
        
    }
    
    public void dibujarImagenJugador(JLabel userIcon){
        this.add(userIcon);
        this.repaint();
    }

    public BufferedImage getImageUsuario() {
        return imageUsuario;
    }

    public void setImageUsuario(BufferedImage imageUsuario) {
        this.imageUsuario = imageUsuario;
    }

    public BufferedImage getImageUsuarioConBomba() {
        return imageUsuarioConBomba;
    }

    public void setImageUsuarioConBomba(BufferedImage imageUsuarioConBomba) {
        this.imageUsuarioConBomba = imageUsuarioConBomba;
    }

    public ComponentUI getUi() {
        return ui;
    }

    public void setUi(ComponentUI ui) {
        this.ui = ui;
    }

    public EventListenerList getListenerList() {
        return listenerList;
    }

    public void setListenerList(EventListenerList listenerList) {
        this.listenerList = listenerList;
    }
}
