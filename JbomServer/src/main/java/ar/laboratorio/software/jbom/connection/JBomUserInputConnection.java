/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.laboratorio.software.jbom.connection;

import ar.laboratorio.software.jbom.domain.JBomCore;
import ar.laboratorio.software.jbom.domain.JBomUser;
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
public class JBomUserInputConnection implements Runnable{

    private InputStreamReader inputStreamReader;
    private BufferedReader bufferedReader;
    
    public JBomUserInputConnection(Socket socket) throws IOException{
        inputStreamReader = new InputStreamReader(socket.getInputStream());
        bufferedReader = new BufferedReader(inputStreamReader);
    }
    
    public void run() {
        try {
            String message = null;
            while((message = bufferedReader.readLine()) != null){
                JSONObject messageJson = new JSONObject(message);
                if(!messageJson.isNull("answer")){
                    if(JBomCore.getInstance().getCurrentQuestion().getRespuesta().equals(messageJson.get("answer")))
                        JBomCore.getInstance().answerRigth();
                    else
                        JBomCore.getInstance().answerWrong();
                }
                if(!messageJson.isNull("gate")){
                    JBomUser jBomUser = null;
                    JBomCore.getInstance().generateRandomQuestion();
                    JBomCore.getInstance().getBomberMan().througthTheBomb();
                    if(messageJson.getString("gate").equals("north"))
                        jBomUser = JBomCore.getInstance().getBomberMan().getVecinoNorte();
                    if(messageJson.getString("gate").equals("south"))
                        jBomUser = JBomCore.getInstance().getBomberMan().getVecinoSur();    
                    if(messageJson.getString("gate").equals("east"))
                        jBomUser = JBomCore.getInstance().getBomberMan().getVecinoEste();
                    if(messageJson.getString("gate").equals("west"))
                        jBomUser = JBomCore.getInstance().getBomberMan().getVecinoOeste();
                    jBomUser.youHaveTheBomb();
                    JBomCore.getInstance().setBomberMan(jBomUser);                    
                }
            }            
        } catch (IOException ex) {
            Logger.getLogger(JBomUserInputConnection.class.getName()).log(Level.SEVERE, null, ex);
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
