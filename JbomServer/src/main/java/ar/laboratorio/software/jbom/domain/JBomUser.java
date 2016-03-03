/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.laboratorio.software.jbom.domain;

import java.awt.Dimension;
import java.awt.Font;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import org.json.JSONObject;

/**
 *
 * @author francisco
 */
public class JBomUser {
    
    private Integer gameId = 0;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    private Socket socket;
    private String username;
    private Boolean jugando;
    private JSONObject jSONObject;
    private JLabel userIcon;
    private JBomUser vecinoNorte;
    private JBomUser vecinoSur;
    private JBomUser vecinoEste;
    private JBomUser vecinoOeste;
    private JLabel vecinoNorteLabel;
    private JLabel vecinoSurLabel;
    private JLabel vecinoEsteLabel;
    private JLabel vecinoOesteLabel;
    
    public void crearJugador(Socket socket) throws IOException{
        this.dataInputStream = new DataInputStream(socket.getInputStream());
        this.dataOutputStream = new DataOutputStream(socket.getOutputStream());
        this.jSONObject = new JSONObject(dataInputStream.readUTF());
        this.username = jSONObject.getString("username");
        this.socket = socket;
        this.jugando = true;
        this.userIcon = new JLabel();     
        userIcon.setSize(150, 50);
        
        this.gameId = JBomCore.getInstance().getJugadores().size() + 1;
        
        Dimension dimension = JBomCore.getInstance().getjBomGUI().getPantallaJuego().getGamePanel().getSize();
        Double seedX = Math.random();
        Double posX =  (dimension.getWidth() - 50) * seedX;        
        Double seedY = Math.random();
        Double posY = (dimension.getHeight() - 50) * seedY;
        userIcon.setFont(new Font(Font.DIALOG, Font.PLAIN, 10));
        
        userIcon.setLocation(posX.intValue(),posY.intValue());
        userIcon.setText("       "+this.username+"[ID:"+this.gameId+"]");
        userIcon.setIcon(new ImageIcon(JBomCore.getInstance().getjBomGUI().getPantallaJuego().getGamePanel().getImageUsuario()));
        userIcon.setDisabledIcon(new ImageIcon(JBomCore.getInstance().getjBomGUI().getPantallaJuego().getGamePanel().getImageUsuarioConBomba()));
        
        this.setVecinos(posX.intValue(),posY.intValue());
    }
    
    private void setVecinos(Integer x, Integer y){
        Font fuenteVecinos = new Font(Font.DIALOG, Font.PLAIN, 16);
        this.vecinoNorteLabel = new JLabel();
        this.vecinoSurLabel = new JLabel();
        this.vecinoEsteLabel = new JLabel();
        this.vecinoOesteLabel = new JLabel();
        
        vecinoNorteLabel.setSize(20,20);
        vecinoSurLabel.setSize(20,20);
        vecinoEsteLabel.setSize(20,20);
        vecinoOesteLabel.setSize(20,20);
        
        vecinoNorteLabel.setFont(fuenteVecinos);
        vecinoSurLabel.setFont(fuenteVecinos);
        vecinoEsteLabel.setFont(fuenteVecinos);
        vecinoOesteLabel.setFont(fuenteVecinos);
        
        vecinoNorteLabel.setLocation(x+10,y-10);
        vecinoSurLabel.setLocation(x+10,y+40);
        vecinoEsteLabel.setLocation(x+33,y+13);
        vecinoOesteLabel.setLocation(x-13,y+13);
        
        vecinoNorteLabel.setText(String.valueOf(this.gameId));
        vecinoSurLabel.setText(String.valueOf(this.gameId));
        vecinoEsteLabel.setText(String.valueOf(this.gameId));
        vecinoOesteLabel.setText(String.valueOf(this.gameId));
    }   

    void sendMessage(String message) {
        
    }
    
    void tenesLaBomba() {
        this.userIcon.setEnabled(false);
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

    public JLabel getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(JLabel userIcon) {
        this.userIcon = userIcon;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public JBomUser getVecinoNorte() {
        return vecinoNorte;
    }

    public void setVecinoNorte(JBomUser vecinoNorte) {
        this.vecinoNorte = vecinoNorte;
        this.getVecinoNorteLabel().setText(String.valueOf(vecinoNorte.getGameId()));
    }

    public JBomUser getVecinoSur() {
        return vecinoSur;
    }

    public void setVecinoSur(JBomUser vecinoSur) {
        this.vecinoSur = vecinoSur;
        this.getVecinoSurLabel().setText(String.valueOf(vecinoSur.getGameId()));
    }

    public JBomUser getVecinoEste() {
        return vecinoEste;
    }

    public void setVecinoEste(JBomUser vecinoEste) {
        this.vecinoEste = vecinoEste;
        this.getVecinoEsteLabel().setText(String.valueOf(vecinoEste.getGameId()));
    }

    public JBomUser getVecinoOeste() {
        return vecinoOeste;
    }

    public void setVecinoOeste(JBomUser vecinoOeste) {
        this.vecinoOeste = vecinoOeste;
        this.getVecinoOesteLabel().setText(String.valueOf(vecinoOeste.getGameId()));
    }

    public JLabel getVecinoNorteLabel() {
        return vecinoNorteLabel;
    }

    public void setVecinoNorteLabel(JLabel vecinoNorteLabel) {
        this.vecinoNorteLabel = vecinoNorteLabel;
    }

    public JLabel getVecinoSurLabel() {
        return vecinoSurLabel;
    }

    public void setVecinoSurLabel(JLabel vecinoSurLabel) {
        this.vecinoSurLabel = vecinoSurLabel;
    }

    public JLabel getVecinoEsteLabel() {
        return vecinoEsteLabel;
    }

    public void setVecinoEsteLabel(JLabel vecinoEsteLabel) {
        this.vecinoEsteLabel = vecinoEsteLabel;
    }

    public JLabel getVecinoOesteLabel() {
        return vecinoOesteLabel;
    }

    public void setVecinoOesteLabel(JLabel vecinoOesteLabel) {
        this.vecinoOesteLabel = vecinoOesteLabel;
    }
}
