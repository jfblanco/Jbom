/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.laboratorio.software.jbom.domain;

import ar.laboratorio.software.jbom.connection.JBomConnectionManager;
import ar.laboratorio.software.jbom.core.state.JBomCoreState;
import ar.laboratorio.software.jbom.core.state.JBomCoreStateWaiting;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.DateTime;

/**
 *
 * @author francisco
 */
public class JBomCore {
    
    private static JBomCore instance;
            
    private JBomGUI jBomGUI;
    private JBomConfig jBomConfig;
    private JBomClock jBomClock;
    private JBomCoreState jBomCoreState;
    private JBomConnectionManager jBomConnectionManager;
    private Boolean jugando = true;
    private Boolean recalcularGrafo = false;
    private DateTime startTime;
    private DateTime currentTime;
    private List<Pregunta> preguntas = new ArrayList<Pregunta>();
    private List<JBomUser> jugadores = new ArrayList<JBomUser>();
    private List<JBomUser> jugadoresEnEspera = new ArrayList<JBomUser>();
    
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
        jBomClock = new JBomClock(instance);
        jBomCoreState = new JBomCoreStateWaiting();
        jBomConnectionManager = new JBomConnectionManager();      
        jBomClock.start();        
    }
    
    public void recalcularGrafoDeJuego(){
        for(JBomUser jBomUser : this.jugadores){
            jBomUser.setVecinoNorte(jugadores.get(new Random().nextInt(jugadores.size())));
            jBomUser.setVecinoSur(jugadores.get(new Random().nextInt(jugadores.size())));
            jBomUser.setVecinoEste(jugadores.get(new Random().nextInt(jugadores.size())));
            jBomUser.setVecinoOeste(jugadores.get(new Random().nextInt(jugadores.size())));
        }
    }
    
    public void comenzarJuego() {
        jBomGUI.mostrarMensaje("Todo listo, comenzando el juego");
        startTime = DateTime.now();
        jBomGUI.getPantallaJuego().getTiempoDeJuego().setText(startTime.toString("mm:ss"));
        jugadores.get(new Random().nextInt(jugadores.size())).tenesLaBomba();
        jBomCoreState.changeToPlay();
    }
    
    public void updatePlaying(){
        currentTime = DateTime.now().minus(startTime.getMillis());
        jBomGUI.getPantallaJuego().getTiempoDeJuego().setText(currentTime.toString("mm:ss"));
    }
    
    public JBomGUI getjBomGUI() {
        return jBomGUI;
    }

    public void setjBomGUI(JBomGUI jBomGUI) {
        this.jBomGUI = jBomGUI;
    }    

    public void abrirPuerto() {
        JBomCore.getInstance().getjBomGUI().mostrarMensaje("Esperando por Jugadores...");
        new Thread(jBomConnectionManager).start();
    }
    
    public void tick(){
        this.jBomCoreState.update();
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
    
    public void closeCore() {
        try {
            System.out.println("Cerrando El core de JBom");
            jBomClock.stop();
            jBomClock.wait();
            System.out.println("Listo");
            System.exit(0);
        } catch (InterruptedException ex) {
            Logger.getLogger(JBomCore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public JBomClock getjBomClock() {
        return jBomClock;
    }

    public void setjBomClock(JBomClock jBomClock) {
        this.jBomClock = jBomClock;
    }    

    public JBomCoreState getjBomCoreState() {
        return jBomCoreState;
    }

    public void setjBomCoreState(JBomCoreState jBomCoreState) {
        this.jBomCoreState = jBomCoreState;
    }

    public JBomConnectionManager getjBomConnectionManager() {
        return jBomConnectionManager;
    }

    public void setjBomConnectionManager(JBomConnectionManager jBomConnectionManager) {
        this.jBomConnectionManager = jBomConnectionManager;
    }

    public List<JBomUser> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<JBomUser> jugadores) {
        this.jugadores = jugadores;
    }

    public List<JBomUser> getJugadoresEnEspera() {
        return jugadoresEnEspera;
    }

    public void setJugadoresEnEspera(List<JBomUser> jugadoresEnEspera) {
        this.jugadoresEnEspera = jugadoresEnEspera;
    }

    public Boolean getRecalcularGrafo() {
        return recalcularGrafo;
    }

    public void setRecalcularGrafo(Boolean recalcularGrafo) {
        this.recalcularGrafo = recalcularGrafo;
    }

    public DateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(DateTime startTime) {
        this.startTime = startTime;
    }

    public DateTime getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(DateTime currentTime) {
        this.currentTime = currentTime;
    }
}
