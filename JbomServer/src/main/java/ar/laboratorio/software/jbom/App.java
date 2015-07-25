package ar.laboratorio.software.jbom;

import ar.laboratorio.software.jbom.domain.JBomCore;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Iniciando Servidor de JBom" );
        JBomCore jBomCore = JBomCore.getInstance();
        jBomCore.iniciarJBomCore();
        jBomCore.getjBomGUI().iniciarPantallas();
        jBomCore.getjBomGUI().getPantallaInicial().setVisible(true);
    }
}
