/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.laboratorio.software.jbom.domain;

import ar.laboratorio.software.jbom.connection.JBomConnectionManager;
import ar.laboratorio.software.jbom.core.state.JBomCoreState;
import ar.laboratorio.software.jbom.core.state.JBomCoreStateWaiting;
import java.io.IOException;
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
    private DateTime endTime;
    private DateTime currentTime;
    private Pregunta currentQuestion;
    private JBomUser bomberMan;
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
        generateRandomQuestion();
    }

    public void generateRandomQuestion() {
        currentQuestion = JBomCore.getInstance().getPreguntas().get(new Random().nextInt(JBomCore.getInstance().getPreguntas().size()));
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
        endTime = startTime.plusMinutes(Integer.valueOf(jBomGUI.getPantallaInicial().getInputTiempoDeJuego().getText().split(":")[0]));
        jBomGUI.getPantallaJuego().getTiempoDeJuego().setText(startTime.toString("mm:ss"));
        this.setUserWithBomb();        
        jBomCoreState.changeState();
    }

    public void setUserWithBomb() {
        generateRandomQuestion();
        if(jugadores.size() > 0){
            try {
                bomberMan = jugadores.get(new Random().nextInt(jugadores.size()));
                bomberMan.youHaveTheBomb();
            } catch (IOException ex) {
                jugadores.remove(bomberMan);
                Logger.getLogger(JBomCore.class.getName()).log(Level.INFO, "El jugador: "+bomberMan.getUsername()+" esta caido, se procede a eliminarlo", ex);
                this.setUserWithBomb();
            }
        }
    }
    
    public void updatePlaying(){
        currentTime = DateTime.now();
        jBomGUI.getPantallaJuego().getTiempoDeJuego().setText(endTime.minus(currentTime.getMillis()).toString("mm:ss"));
        if(endTime.minus(currentTime.getMillis()).getMillis() <= 0.0)
            jBomCoreState.changeState();
    }
    
    public void broadCastMessage(String message){
        for(JBomUser jBomUser : jugadores){
            jBomUser.sendMessage(message, "info", currentQuestion.toJSON());            
        }
    }  

    public void answerRigth() {
        bomberMan.sendMessage("Respuesta correcta, usa las flechas para deshacerte de la bomba", "rigth", currentQuestion.toJSON());
    }

    public void answerWrong() {
        this.broadCastMessage(bomberMan.getUsername()+" contesto incorrectamente");
        generateRandomQuestion();
        bomberMan.sendMessage("La Respesta es incorrecta!!", "wrong", currentQuestion.toJSON());
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
       System.out.println("Cerrando El core de JBom");
       jBomClock.stop();
       System.out.println("Listo");
       System.exit(0);
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

    public DateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(DateTime endTime) {
        this.endTime = endTime;
    }

    public Pregunta getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(Pregunta currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    public JBomUser getBomberMan() {
        return bomberMan;
    }

    public void setBomberMan(JBomUser bomberMan) {
        this.bomberMan = bomberMan;
    }
}
