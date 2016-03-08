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
public class JBomCoreStateRounEnding implements JBomCoreState{

    public void jugadorConectado(JBomUser jBomUser) {
        
    }

    public void changeState() {
        JBomCore.getInstance().getjBomGUI().getPantallaJuego().getTiempoDeJuego().setText("--:--");
        JBomCore.getInstance().comenzarContadorNuevaRonda();
        JBomCore.getInstance().setjBomCoreState(new JBomCoreStatePlaying());
    }

    public void update() {
        JBomCore.getInstance().updateWaitingNewRound();
    }
    
}
