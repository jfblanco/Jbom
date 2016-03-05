package ar.laboratorio.software.jbom;

import ar.laboratorio.software.jbom.domain.JBomDesktopClient;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        if(args.length == 1){
            JBomDesktopClient.getInstance().getPantallaInicial().setInputName(args[0]);  
        }
        JBomDesktopClient.getInstance().getPantallaInicial().setVisible(true);  
            
    }
}
