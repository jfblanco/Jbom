/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.laboratorio.software.jbom.domain;

import ar.laboratorio.software.jbom.gui.PantallaError;
import ar.laboratorio.software.jbom.gui.PantallaInicial;
import ar.laboratorio.software.jbom.gui.PantallaJuego;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author francisco
 */
public class JBomDesktopClient {
    
    private static JBomDesktopClient instance = null;
    private PantallaInicial pantallaInicial = new PantallaInicial();
    private PantallaJuego pantallaJuego = new PantallaJuego();
    private PantallaError pantallaError = new PantallaError();
    private Socket socket = new Socket();
    
    public static JBomDesktopClient getInstance(){
        if(instance == null)
            instance = new JBomDesktopClient();
        return instance;
    }
    
    public void conectarConServer(String direccion){
        
    }

    public PantallaInicial getPantallaInicial() {
        return pantallaInicial;
    }

    public void setPantallaInicial(PantallaInicial pantallaInicial) {
        this.pantallaInicial = pantallaInicial;
    }

    public PantallaJuego getPantallaJuego() {
        return pantallaJuego;
    }

    public void setPantallaJuego(PantallaJuego pantallaJuego) {
        this.pantallaJuego = pantallaJuego;
    }

    public void conectarServidor(String direccion, String puerto, String username) throws IOException {
        socket = new Socket(direccion, Integer.valueOf(puerto));
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        dataOutputStream.writeUTF("{\"username\": \""+username+"\"}");
        dataOutputStream.flush();
    }

    public PantallaError getPantallaError() {
        return pantallaError;
    }

    public void setPantallaError(PantallaError pantallaError) {
        this.pantallaError = pantallaError;
    }
}
