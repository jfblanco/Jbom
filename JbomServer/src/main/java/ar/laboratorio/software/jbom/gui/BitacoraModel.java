/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.laboratorio.software.jbom.gui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author francisco
 */
public class BitacoraModel extends DefaultListModel{

    List<String> mensajes = new ArrayList<String>();
    
    @Override
    public int getSize() {
        return mensajes.size();
    }

    @Override
    public Object getElementAt(int index) {
        return mensajes.get(index);
    }
    
    public void add(String mensaje){
        mensajes.add(mensaje);
        this.update(mensajes.size());
    }
    
    public void update(int index)
    {
        this.fireContentsChanged(this, index, index);
    }
}
