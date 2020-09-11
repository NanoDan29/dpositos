/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocaja.deahorros;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Formatter;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author jowel
 */
public class Ahorro extends javax.swing.JFrame {

    String barra = File.separator;
    String ubicacion = System.getProperty("user.dir") + barra + "Ahorros" + barra;
    Date fecha = new Date();

    public Ahorro() {
        initComponents();
        labelCedulaAhorros.setVisible(false);
        txtFechaAhorro.setText(fecha.getDate() + "/" + (fecha.getMonth() + 1) + "/" + fecha.getMonth());
        txtFechaAhorro.setEnabled(false);
    }

    private void crear(double deposito) throws IOException {

        String nombreArchivo = labelCedulaAhorros.getText() + ".txt";
        File crearUbicacion = new File(ubicacion);
        File crearArchivo = new File(ubicacion + nombreArchivo);

        if (txtDepositoAhorro.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Por favor llene todos los campos");

        } else {
            try {
                if (crearArchivo.exists()) {
                    FileInputStream fis = new FileInputStream(crearArchivo);
                    Properties mostrar = new Properties();
                    mostrar.load(fis);
                    
                    //Obtengo el deposito y formateo para acumular depostitos
                    String depositoAnteriro = mostrar.getProperty("deposito");
                    String depositoActual = "," + deposito;
                    String formatearDeposito = depositoAnteriro + depositoActual;

                    //Obtengo la fecha y formateo para acumular fechas
                    String fechaAnterior = mostrar.getProperty("fechaDeposito");
                    String fechaActual = "," + txtFechaAhorro.getText();
                    String formatearFecha = fechaAnterior + fechaActual;

                    Formatter crea = new Formatter(ubicacion + nombreArchivo);
                    crea.format("%s\r\n%s",
                            "deposito=" + formatearDeposito,
                            "fechaDeposito=" + formatearFecha
                    );
                    crea.close();

                    JOptionPane.showMessageDialog(rootPane, "Ha sido depositado con exito");
                } else {
                    crearUbicacion.mkdir();
                    Formatter crea = new Formatter(ubicacion + nombreArchivo);
                    crea.format("%s\r\n%s",
                            "deposito=" + deposito,
                            "fechaDeposito=" + txtFechaAhorro.getText());
                    crea.close();

                    JOptionPane.showMessageDialog(rootPane, "Ha sido depositado con exito");

                    //Nos dirigimos al frame de login
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "No se pudo crear");
                System.out.println(e);
            }

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtDepositoAhorro = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtFechaAhorro = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtInteres = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        labelMDAhorro = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelCedulaAhorros = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Deposito"));

        jLabel1.setText("Cantidad Deposito:");

        txtDepositoAhorro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDepositoAhorroKeyTyped(evt);
            }
        });

        jButton1.setText("Depositar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Fecha:");

        jLabel4.setText("Interes:");

        txtInteres.setText("1");
        txtInteres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInteresActionPerformed(evt);
            }
        });

        jLabel5.setText("%");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(7, 7, 7)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtInteres, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txtDepositoAhorro, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFechaAhorro, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDepositoAhorro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtFechaAhorro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtInteres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        labelMDAhorro.setText("MinimDeposito");

        jLabel2.setText("Minimo a depositar:");

        labelCedulaAhorros.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelMDAhorro, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelCedulaAhorros)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMDAhorro, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(labelCedulaAhorros))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (Integer.parseInt(txtDepositoAhorro.getText()) < Integer.parseInt(labelMDAhorro.getText())) {
            JOptionPane.showMessageDialog(null, "El valor es menor al acordado");

        } else {
            try {
                //Calcular iteres deposito
                double deposito = Integer.parseInt(txtDepositoAhorro.getText());
                double interes = Integer.parseInt(txtInteres.getText());

                double valorTotal = ((deposito * interes) / 100) + deposito;
                System.out.println(valorTotal);
                crear(valorTotal);
            } catch (Exception e) {
            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtDepositoAhorroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDepositoAhorroKeyTyped
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese solo numeros");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtDepositoAhorroKeyTyped

    private void txtInteresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInteresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInteresActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ahorro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ahorro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ahorro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ahorro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Ahorro miAhorro = new Ahorro();
                miAhorro.setVisible(true);
                miAhorro.setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel labelCedulaAhorros;
    public javax.swing.JLabel labelMDAhorro;
    private javax.swing.JTextField txtDepositoAhorro;
    private javax.swing.JTextField txtFechaAhorro;
    private javax.swing.JTextField txtInteres;
    // End of variables declaration//GEN-END:variables
}
