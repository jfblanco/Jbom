/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.laboratorio.software.jbom.domain;

import java.io.DataInputStream;
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
public class JBomUser {
    
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    private Socket socket;
    private String username;
    private Boolean jugando;
    private JSONObject jSONObject;
    
    public void crearJugador(Socket socket) throws IOException{
        this.dataInputStream = new DataInputStream(socket.getInputStream());
        this.dataOutputStream = new DataOutputStream(socket.getOutputStream());
        this.jSONObject = new JSONObject(dataInputStream.readUTF());
        this.username = jSONObject.getString("username");
        this.socket = socket;
        this.jugando = true;
        Logger.getLogger(JBomCore.class.getName()).log(Level.INFO, "El usuario: "+username+" se ha unido al juego");
    }
    
    public DataInputStream getDataInputStream() {
        return dataInputStream;
    }

    public void setDataInputStream(DataInputStream dataInputStream) {
        this.dataInputStream = dataInputStream;
    }

    public DataOutputStream getDataOutputStream() {
        return dataOutputStream;
    }

    public void setDataOutputStream(DataOutputStream dataOutputStream) {
        this.dataOutputStream = dataOutputStream;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getJugando() {
        return jugando;
    }

    public void setJugando(Boolean jugando) {
        this.jugando = jugando;
    }

    public JSONObject getjSONObject() {
        return jSONObject;
    }

    public void setjSONObject(JSONObject jSONObject) {
        this.jSONObject = jSONObject;
    }
    
    public class ReaderThread implements Runnable{

        public void run() {
            while(jugando){
                
            }
        }
        
    }
}
