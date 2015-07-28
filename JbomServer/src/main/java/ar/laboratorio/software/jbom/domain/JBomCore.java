/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.laboratorio.software.jbom.domain;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
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
    private List<Pregunta> preguntas = new ArrayList<Pregunta>();
    private List<JBomUser> jugadores = new ArrayList<JBomUser>();
    
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
        jBomConfig.cargar();
        serverSocketFactory = ServerSocketFactory.getDefault();
        try {
            serverSocket = serverSocketFactory.createServerSocket(jBomConfig.getPort());
            Logger.getLogger(JBomCore.class.getName()).log(Level.INFO, "El puerto de conexion es: "+String.valueOf(jBomConfig.getPort()));
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
        Runnable runner = new Runnable() {
                                            public void run() 
                                            {
                                                while(jugadores.size() < jBomConfig.getJugadoresMinimo()){
                                                    try {
                                                        Logger.getLogger(JBomCore.class.getName()).log(Level.INFO, "Esperando por Jugadores...");
                                                        Socket socket = serverSocket.accept();
                                                        JBomUser jBomUser = new JBomUser();
                                                        jBomUser.crearJugador(socket);
                                                        jugadores.add(jBomUser);
                                                        jBomGUI.dibujarImagenJugador(100, 300, jBomUser.getUsername());
                                                        jBomGUI.mostrarMensaje("se conecto el jugador "+jBomUser.getUsername());
                                                    } catch (IOException ex) {
                                                        Logger.getLogger(JBomCore.class.getName()).log(Level.SEVERE, null, ex);
                                                    }            
                                                }
                                                Logger.getLogger(JBomCore.class.getName()).log(Level.INFO, "Todo listo, comenzando el juego");
                                                while(jugando){
                                                                
                                                }
                                                cerrarPuerto();
                                            }
                                        };
        new Thread(runner).start();
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

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
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
