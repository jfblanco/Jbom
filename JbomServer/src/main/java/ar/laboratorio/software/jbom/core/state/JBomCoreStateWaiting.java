/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.laboratorio.software.jbom.core.state;

import ar.laboratorio.software.jbom.domain.JBomCore;
import ar.laboratorio.software.jbom.domain.JBomUser;

/**
 *
 * @author Francisco Blanco <blanco.jose.francisco@gmail.com>
 */
public class JBomCoreStateWaiting implements JBomCoreState{

    public void changeState() {
        JBomCore.getInstance().getjBomGUI().getPantallaJuego().getTiempoDeJuego().setText("--:--");
        JBomCore.getInstance().setjBomCoreState(new JBomCoreStatePlaying());
    }

    public void update() {
        
    }

    public void jugadorConectado(JBomUser jBomUser) {
        JBomCore.getInstance().getJugadores().add(jBomUser);
        JBomCore.getInstance().getjBomGUI().dibujarImagenJugador(jBomUser.getUserIcon(), jBomUser.getVecinoNorteLabel(),jBomUser.getVecinoSurLabel(),jBomUser.getVecinoEsteLabel(),jBomUser.getVecinoOesteLabel());
        JBomCore.getInstance().getjBomGUI().mostrarMensaje("Se conecto el jugador "+jBomUser.getUsername());
        JBomCore.getInstance().recalcularGrafoDeJuego();        
        JBomCore.getInstance().broadCastMessage("Se conecto el jugador "+jBomUser.getUsername());
        if(JBomCore.getInstance().getJugadores().size() >= JBomCore.getInstance().getjBomConfig().getJugadoresMinimo()){
            JBomCore.getInstance().comenzarJuego();
        }            
    }
    
}
