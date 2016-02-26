/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.laboratorio.software.jbom.connection;

import ar.laboratorio.software.jbom.domain.JBomCore;
import ar.laboratorio.software.jbom.domain.JBomUser;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ServerSocketFactory;

/**
 *
 * @author Francisco Blanco <blanco.jose.francisco@gmail.com>
 */
public class JBomConnectionManager implements Runnable{

    private ServerSocket serverSocket;
    private ServerSocketFactory serverSocketFactory;   
    private Boolean cerrado = false;
    
    public JBomConnectionManager(){
        serverSocketFactory = ServerSocketFactory.getDefault();
        try {
            serverSocket = serverSocketFactory.createServerSocket(JBomCore.getInstance().getjBomConfig().getPort());
            Logger.getLogger(JBomCore.class.getName()).log(Level.INFO, "El puerto de conexion es: "+String.valueOf(JBomCore.getInstance().getjBomConfig().getPort()));
        } catch (IOException ex) {
            Logger.getLogger(JBomCore.class.getName()).log(Level.WARNING, "No se puede iniciar el puerto: "+String.valueOf(JBomCore.getInstance().getjBomConfig().getPort()), ex);
            System.exit(-1);
        }
    }
    
    public void cerrar(){
        this.cerrado = true;
    }
    
    public void run() {
        while(!cerrado){
            try {
                Socket socket = serverSocket.accept();
                JBomUser jBomUser = new JBomUser();
                jBomUser.crearJugador(socket);
                JBomCore.getInstance().getjBomCoreState().jugadorConectado(jBomUser);
            } catch (IOException ex) {
                Logger.getLogger(JBomCore.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public ServerSocketFactory getServerSocketFactory() {
        return serverSocketFactory;
    }

    public void setServerSocketFactory(ServerSocketFactory serverSocketFactory) {
        this.serverSocketFactory = serverSocketFactory;
    }

    public Boolean getCerrado() {
        return cerrado;
    }

    public void setCerrado(Boolean cerrado) {
        this.cerrado = cerrado;
    }
}
