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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

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
    private DataOutputStream dataOutputStream;
    
    private JBomDesktopClient(){
        
    }
    
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
        dataOutputStream = new DataOutputStream(socket.getOutputStream());
        dataOutputStream.writeUTF("{\"username\": \""+username+"\"}");
        dataOutputStream.flush();
        new Thread(new JBomClientInputConnection(socket)).start();
    }

    public void answerdQuestion(String answer){
        try {
            sendServerInfo("answer", answer);
        } catch (IOException ex) {
            Logger.getLogger(JBomDesktopClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public PantallaError getPantallaError() {
        return pantallaError;
    }

    public void setPantallaError(PantallaError pantallaError) {
        this.pantallaError = pantallaError;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public DataOutputStream getDataOutputStream() {
        return dataOutputStream;
    }

    public void setDataOutputStream(DataOutputStream dataOutputStream) {
        this.dataOutputStream = dataOutputStream;
    }
    
    public void sendServerInfo(String tag, String value) throws IOException{
        JSONObject answerJSON = new JSONObject();
        answerJSON.put(tag, value);
        dataOutputStream.writeBytes(answerJSON.toString()+"\n");
        dataOutputStream.flush();
    }

    public void selectNorthGate() {
        try {
            sendServerInfo("gate", "north");
        } catch (IOException ex) {
            Logger.getLogger(JBomDesktopClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void selectWestGate() {
        try {
            sendServerInfo("gate", "west");
        } catch (IOException ex) {
            Logger.getLogger(JBomDesktopClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void selectEastGate() {
        try {
            sendServerInfo("gate", "east");
        } catch (IOException ex) {
            Logger.getLogger(JBomDesktopClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void selectSouthGate() {
        try {
            sendServerInfo("gate", "south");
        } catch (IOException ex) {
            Logger.getLogger(JBomDesktopClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
