/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.laboratorio.software.jbom.domain;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author francisco
 */
public class Pregunta {
    
    private String preguntal;
    private String respuesta;
    private Set<String> opciones = new HashSet<String>();

    public String getPreguntal() {
        return preguntal;
    }

    public void setPreguntal(String preguntal) {
        this.preguntal = preguntal;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }    

    public Set<String> getOpciones() {
        return opciones;
    }

    public void setOpciones(Set<String> opciones) {
        this.opciones = opciones;
    }
}
