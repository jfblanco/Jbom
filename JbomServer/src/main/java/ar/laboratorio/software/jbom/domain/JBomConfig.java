/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.laboratorio.software.jbom.domain;

import org.json.JSONObject;

/**
 *
 * @author francisco
 */
public class JBomConfig {
    
    private Integer tiempoMaximo;
    private Integer tiempoMinimo;
    private Integer jugadoresMinimo;
    private Integer jugadoresMaximo;
    private Integer port = 1509;
    private String direccionIp;

    public void salvar(){
        JSONObject guardado = new JSONObject();
        guardado.put("tiempoMaximo", tiempoMaximo);
        guardado.put("tiempoMinimo", tiempoMinimo);
        guardado.put("jugadoresMinimo", jugadoresMinimo);
        guardado.put("jugadoresMaximo", jugadoresMaximo);
        guardado.put("port", port);
        System.out.println(guardado.toString());
    }
    
    public Integer getTiempoMaximo() {
        return tiempoMaximo;
    }

    public void setTiempoMaximo(Integer tiempoMaximo) {
        this.tiempoMaximo = tiempoMaximo;
    }

    public Integer getTiempoMinimo() {
        return tiempoMinimo;
    }

    public void setTiempoMinimo(Integer tiempoMinimo) {
        this.tiempoMinimo = tiempoMinimo;
    }

    public Integer getJugadoresMinimo() {
        return jugadoresMinimo;
    }

    public void setJugadoresMinimo(Integer jugadoresMinimo) {
        this.jugadoresMinimo = jugadoresMinimo;
    }

    public Integer getJugadoresMaximo() {
        return jugadoresMaximo;
    }

    public void setJugadoresMaximo(Integer jugadoresMaximo) {
        this.jugadoresMaximo = jugadoresMaximo;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getDireccionIp() {
        return direccionIp;
    }

    public void setDireccionIp(String direccionIp) {
        this.direccionIp = direccionIp;
    }
    
    
}
