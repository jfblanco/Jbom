/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.laboratorio.software.jbom.domain;

import ar.laboratorio.software.jbom.gui.ConfiguracionCarga;
import ar.laboratorio.software.jbom.gui.PantallaInicial;
import ar.laboratorio.software.jbom.gui.PantallaJuego;
import ar.laboratorio.software.jbom.gui.PreguntaCarga;

/**
 *
 * @author francisco
 */
public class JBomGUI {
    
    private PantallaInicial pantallaInicial;    
    private PantallaJuego pantallaJuego;    
    private PreguntaCarga preguntaCarga;
    private ConfiguracionCarga configuracionCarga;
    
    public JBomGUI(){
        
    }
    
    public void iniciarPantallas(){
        pantallaInicial = new PantallaInicial();
        pantallaJuego = new PantallaJuego();
        preguntaCarga = new PreguntaCarga();
        configuracionCarga = new ConfiguracionCarga();
    }

    public PantallaInicial getPantallaInicial() {
        return pantallaInicial;
    }

    public void setPantallaInicial(PantallaInicial pantallaInicial) {
        this.pantallaInicial = pantallaInicial;
    }

    public PantallaJuego getPantallaJuego() {
        return pantallaJuego;
    }

    public void setPantallaJuego(PantallaJuego pantallaJuego) {
        this.pantallaJuego = pantallaJuego;
    }

    public PreguntaCarga getPreguntaCarga() {
        return preguntaCarga;
    }

    public void setPreguntaCarga(PreguntaCarga preguntaCarga) {
        this.preguntaCarga = preguntaCarga;
    }

    public ConfiguracionCarga getConfiguracionCarga() {
        return configuracionCarga;
    }

    public void setConfiguracionCarga(ConfiguracionCarga configuracionCarga) {
        this.configuracionCarga = configuracionCarga;
    }    
}
