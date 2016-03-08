/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.laboratorio.software.jbom.domain;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author francisco
 */
public class JBomConfig {
    
    private Integer tiempoMaximo = 0;
    private Integer tiempoMinimo = 0;
    private Integer jugadoresMinimo = 0;
    private Integer jugadoresMaximo = 0;
    private Integer cantidadDeRondas = 5;
    private Integer port = 1509;
    private String direccionIp;
    private JSONObject configuraciones = new JSONObject();

    public void cargar(){
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(new File("./configuracion.jbom")));
            configuraciones = new JSONObject(br.readLine());
            tiempoMaximo = configuraciones.getInt("tiempoMaximo");
            tiempoMinimo= configuraciones.getInt("tiempoMinimo");
            jugadoresMinimo= configuraciones.getInt("jugadoresMinimo");
            jugadoresMaximo= configuraciones.getInt("jugadoresMaximo");
            cantidadDeRondas= configuraciones.getInt("cantidadDeRondas");
            port= configuraciones.getInt("port");
            JSONArray preguntas = configuraciones.getJSONArray("preguntas");
            for(Integer i=0; i < preguntas.length(); i++)
            {
                Pregunta pregunta = new Pregunta();
                JSONObject preguntaJson = preguntas.getJSONObject(i);
                pregunta.setPreguntal(preguntaJson.getString("pregunta"));
                pregunta.setRespuesta(preguntaJson.getString("respuesta"));
                JSONArray opciones = preguntaJson.getJSONArray("opciones");
                for(Integer j=0; j < opciones.length(); j++)
                    pregunta.getOpciones().add(opciones.getString(j));
                JBomCore.getInstance().getPreguntas().add(pregunta);
            }            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JBomConfig.class.getName()).log(Level.SEVERE, "No se encontro archivo de configuracion: configucarion.jbom, se procede a crearlo", ex);
            guardarArchivo();
        } catch (IOException ex) {
            Logger.getLogger(JBomConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void salvar(){
        configuraciones.put("tiempoMaximo", tiempoMaximo);
        configuraciones.put("tiempoMinimo", tiempoMinimo);
        configuraciones.put("jugadoresMinimo", jugadoresMinimo);
        configuraciones.put("jugadoresMaximo", jugadoresMaximo);
        configuraciones.put("cantidadDeRondas", cantidadDeRondas);
        configuraciones.put("port", port);
        JSONArray preguntasJson = new JSONArray();
        for(Pregunta pregunta : JBomCore.getInstance().getPreguntas())
        {
            JSONObject p = new JSONObject();
            JSONArray opciones = new JSONArray();
            p.put("pregunta", pregunta.getPreguntal());
            p.put("respuesta", pregunta.getRespuesta());
            for(String opcion : pregunta.getOpciones())
                opciones.put(opcion);
            opciones.put(pregunta.getRespuesta());
            p.put("opciones",opciones);
            preguntasJson.put(p);
        }                
        configuraciones.put("preguntas", preguntasJson);
        guardarArchivo();
    }
    
    private void guardarArchivo() {
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(new File("./configuracion.jbom")));            
            bw.write(configuraciones.toString());
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(JBomConfig.class.getName()).log(Level.SEVERE, "No se pudo crear el archivo configucarion.jbom", ex);
        }
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

    public Integer getCantidadDeRondas() {
        return cantidadDeRondas;
    }

    public void setCantidadDeRondas(Integer cantidadDeRondas) {
        this.cantidadDeRondas = cantidadDeRondas;
    }

    public JSONObject getConfiguraciones() {
        return configuraciones;
    }

    public void setConfiguraciones(JSONObject configuraciones) {
        this.configuraciones = configuraciones;
    }    
}
