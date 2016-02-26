/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.laboratorio.software.jbom.core.state;

import ar.laboratorio.software.jbom.domain.JBomUser;

/**
 *
 * @author Francisco Blanco <blanco.jose.francisco@gmail.com>
 */
public interface JBomCoreState {
    
    public void jugadorConectado(JBomUser jBomUser);
    
    public void changeToPlay();
    
    public void changeToWait();
    
    public void update();
}
