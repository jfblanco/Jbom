/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.laboratorio.software.jbom.gui;

import ar.laboratorio.software.jbom.domain.JBomCore;

/**
 *
 * @author francisco
 */
public class ConfiguracionCarga extends javax.swing.JFrame {

    /**
     * Creates new form ConfiguracionCarga
     */
    public ConfiguracionCarga() {
        initComponents();
        inputJugadoresMaximo.setText(String.valueOf(JBomCore.getInstance().getjBomConfig().getJugadoresMaximo()));
        inputJugadoresMinimo.setText(String.valueOf(JBomCore.getInstance().getjBomConfig().getJugadoresMinimo()));
        inputPuerto.setText(String.valueOf(JBomCore.getInstance().getjBomConfig().getPort()));
        inputTiempoEsperaMaximo.setText(String.valueOf(JBomCore.getInstance().getjBomConfig().getTiempoMaximo()));
        inputTiempoJuego.setText(String.valueOf(JBomCore.getInstance().getjBomConfig().getTiempoMinimo()));
        inputCantidadDeRondas.setText(String.valueOf(JBomCore.getInstance().getjBomConfig().getCantidadDeRondas()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        botonGuardar = new javax.swing.JButton();
        inputJugadoresMaximo = new javax.swing.JTextField();
        inputJugadoresMinimo = new javax.swing.JTextField();
        inputPuerto = new javax.swing.JTextField();
        inputTiempoJuego = new javax.swing.JTextField();
        inputTiempoEsperaMaximo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        inputCantidadDeRondas = new javax.swing.JTextField();

        jLabel1.setText("Pantalla de Configuracion");

        jLabel2.setText("Jugadores Maximo:");

        jLabel3.setText("Jugadores Minimo:");

        jLabel4.setText("Puerto:");

        jLabel5.setText("Tiempo de Juego:");

        jLabel6.setText("Tiempo maximo de espera:");

        botonGuardar.setText("Guardar");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        jLabel7.setText("Cantidad de Rondas: ");

        inputCantidadDeRondas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputCantidadDeRondasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botonGuardar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(inputJugadoresMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inputTiempoEsperaMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(inputTiempoJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inputPuerto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inputJugadoresMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inputCantidadDeRondas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 136, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(inputJugadoresMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(inputJugadoresMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(inputPuerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(inputTiempoJuego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(inputTiempoEsperaMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(inputCantidadDeRondas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(botonGuardar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        JBomCore.getInstance().getjBomConfig().setPort(Integer.valueOf(inputPuerto.getText()));
        JBomCore.getInstance().getjBomConfig().setJugadoresMaximo(Integer.valueOf(inputJugadoresMaximo.getText()));
        JBomCore.getInstance().getjBomConfig().setJugadoresMinimo(Integer.valueOf(inputJugadoresMinimo.getText()));
        JBomCore.getInstance().getjBomConfig().setTiempoMaximo(Integer.valueOf(inputTiempoJuego.getText()));
        JBomCore.getInstance().getjBomConfig().setTiempoMinimo(Integer.valueOf(inputTiempoEsperaMaximo.getText()));
        JBomCore.getInstance().getjBomConfig().setCantidadDeRondas(Integer.valueOf(inputCantidadDeRondas.getText()));
        JBomCore.getInstance().getjBomConfig().salvar();
        this.setVisible(false);
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void inputCantidadDeRondasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputCantidadDeRondasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputCantidadDeRondasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonGuardar;
    private javax.swing.JTextField inputCantidadDeRondas;
    private javax.swing.JTextField inputJugadoresMaximo;
    private javax.swing.JTextField inputJugadoresMinimo;
    private javax.swing.JTextField inputPuerto;
    private javax.swing.JTextField inputTiempoEsperaMaximo;
    private javax.swing.JTextField inputTiempoJuego;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
