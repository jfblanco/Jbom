/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.laboratorio.software.jbom.domain;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ServerSocketFactory;

/**
 *
 * @author francisco
 */
public class JBomCore {
    
    private static JBomCore instance;
            
    private JBomGUI jBomGUI;
    private JBomConfig jBomConfig;
    private ServerSocket serverSocket;
    private ServerSocketFactory serverSocketFactory;
    private Boolean jugando = true;
    
    private JBomCore(){
    
    }
    
    public static JBomCore getInstance(){
        if(instance == null)
            instance = new JBomCore();
        return instance;
    }
    
    public void iniciarJBomCore(){
        jBomGUI = new JBomGUI();
        jBomConfig = new JBomConfig();
        serverSocketFactory = ServerSocketFactory.getDefault();
        try {
            serverSocket = serverSocketFactory.createServerSocket(jBomConfig.getPort());
            Logger.getLogger(JBomCore.class.getName()).log(Level.INFO, "Se Inicio el servidor en el puerto: "+String.valueOf(jBomConfig.getPort()));
        } catch (IOException ex) {
            Logger.getLogger(JBomCore.class.getName()).log(Level.WARNING, "No se puede iniciar el puerto: "+String.valueOf(jBomConfig.getPort()), ex);
            System.exit(-1);
        }
    }
    
    public JBomGUI getjBomGUI() {
        return jBomGUI;
    }

    public void setjBomGUI(JBomGUI jBomGUI) {
        this.jBomGUI = jBomGUI;
    }    

    public void comenzarJuego() {
        jBomGUI.getPantallaInicial().setVisible(true);
        while(jugando){
            Socket socket;
            try {
                socket = serverSocket.accept();
                Logger.getLogger(JBomCore.class.getName()).log(Level.INFO, "Creando puerto cliente: "+String.valueOf(socket.getLocalPort()));
            } catch (IOException ex) {
                Logger.getLogger(JBomCore.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
        cerrarPuerto();
    }

    public JBomConfig getjBomConfig() {
        return jBomConfig;
    }

    public void setjBomConfig(JBomConfig jBomConfig) {
        this.jBomConfig = jBomConfig;
    }

    public Boolean getJugando() {
        return jugando;
    }

    public void setJugando(Boolean jugando) {
        this.jugando = jugando;
    }

    private void cerrarPuerto() {
        try {
            serverSocket.close();
            Logger.getLogger(JBomCore.class.getName()).log(Level.INFO, "Cerrando el puerto: "+String.valueOf(jBomConfig.getPort()));
        } catch (IOException ex) {
            Logger.getLogger(JBomCore.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
}
