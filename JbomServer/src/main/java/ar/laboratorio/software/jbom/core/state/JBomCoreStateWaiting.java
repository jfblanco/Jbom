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

    public void changeToPlay() {
        JBomCore.getInstance().setjBomCoreState(new JBomCoreStatePlaying());
    }

    public void changeToWait() {
        
    }

    public void update() {
        
    }

    public void jugadorConectado(JBomUser jBomUser) {
        JBomCore.getInstance().getJugadores().add(jBomUser);
        JBomCore.getInstance().getjBomGUI().dibujarImagenJugador(jBomUser.getUserIcon());
        JBomCore.getInstance().getjBomGUI().mostrarMensaje("se conecto el jugador "+jBomUser.getUsername());
        if(JBomCore.getInstance().getJugadores().size() >= JBomCore.getInstance().getjBomConfig().getJugadoresMinimo()){
            JBomCore.getInstance().getjBomGUI().mostrarMensaje("Todo listo, comenzando el juego");
            JBomCore.getInstance().getjBomCoreState().changeToPlay();
        }            
    }
    
}
