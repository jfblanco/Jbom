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
public class JBomCoreStatePlaying implements JBomCoreState{

    public void changeState() {
        JBomCore.getInstance().getjBomGUI().mostrarMensaje("Se Termino el tiempo de juego");        
        JBomCore.getInstance().getjBomGUI().getPantallaJuego().getTiempoDeJuego().setText("--:--");
        JBomCore.getInstance().setjBomCoreState(new JBomCoreStateEnding());
    }

    public void update() {
        JBomCore.getInstance().updatePlaying();
    }

    public void jugadorConectado(JBomUser jBomUser) {
        JBomCore.getInstance().getJugadoresEnEspera().add(jBomUser);
        JBomCore.getInstance().getjBomGUI().mostrarMensaje("se conecto el jugador "+jBomUser.getUsername()+" pero fue puesto en espera");
    }
    
}
