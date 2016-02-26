/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.laboratorio.software.jbom.domain;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Francisco Blanco <blanco.jose.francisco@gmail.com>
 */
public class JBomClock implements Runnable{
    
    JBomCore jBomCore;
    Boolean stopped = false;

    public JBomClock(JBomCore jBomCore){
        this.jBomCore = jBomCore;
    }
    
    public void start(){
        new Thread(this).start();
    }
    
    public void stop(){
        this.stopped = true;
    }
    
    public JBomCore getjBomCore() {
        return jBomCore;
    }

    public void setjBomCore(JBomCore jBomCore) {
        this.jBomCore = jBomCore;
    }

    public void run() {
        while(!this.stopped){
            try {
                jBomCore.tick();
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(JBomClock.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Cerrando Clock");
        this.notifyAll();
    }
}
