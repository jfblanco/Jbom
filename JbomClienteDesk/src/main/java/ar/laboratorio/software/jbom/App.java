package ar.laboratorio.software.jbom;

import ar.laboratorio.software.jbom.domain.JBomDesktopClient;
import ar.laboratorio.software.jbom.gui.PantallaInicial;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        JBomDesktopClient.getInstance().getPantallaInicial().setVisible(true);        
    }
}
