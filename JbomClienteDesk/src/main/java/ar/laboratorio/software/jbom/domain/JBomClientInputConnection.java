/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.laboratorio.software.jbom.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

/**
 *
 * @author Francisco Blanco <blanco.jose.francisco@gmail.com>
 */
public class JBomClientInputConnection implements Runnable{

    private InputStreamReader inputStreamReader;
    private BufferedReader bufferedReader;
    
    public JBomClientInputConnection(Socket socket) throws IOException{
        inputStreamReader = new InputStreamReader(socket.getInputStream());
        bufferedReader = new BufferedReader(inputStreamReader);
    }
    
    public void run() {
        try {
            String message = null;
            while((message = bufferedReader.readLine()) != null){
                JSONObject messageJson = new JSONObject(message);
                if(messageJson.getString("code").equals("info")){
                    JBomDesktopClient.getInstance().getPantallaJuego().disableUI();
                    JBomDesktopClient.getInstance().getPantallaJuego().disableBottons();
                }
                if(messageJson.getString("code").equals("bomb") || messageJson.getString("code").equals("wrong")){
                    JBomDesktopClient.getInstance().getPantallaJuego().enableUI();
                    JBomDesktopClient.getInstance().getPantallaJuego().showQuestion(messageJson.getString("pregunta"));
                }
                if(messageJson.getString("code").equals("rigth")){
                    JBomDesktopClient.getInstance().getPantallaJuego().enableBottons();
                }
                JBomDesktopClient.getInstance().getPantallaJuego().publishMessage(messageJson.getString("message"));
            }            
        } catch (IOException ex) {
            Logger.getLogger(JBomClientInputConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public InputStreamReader getInputStreamReader() {
        return inputStreamReader;
    }

    public void setInputStreamReader(InputStreamReader inputStreamReader) {
        this.inputStreamReader = inputStreamReader;
    }

    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }

    public void setBufferedReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }
    
}
