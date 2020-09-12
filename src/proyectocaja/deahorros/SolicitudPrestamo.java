/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocaja.deahorros;

import java.io.File;
import java.util.Date;
import java.util.Formatter;
import javax.swing.JOptionPane;

/**
 *
 * @author jowel
 */
public class SolicitudPrestamo extends javax.swing.JFrame {
    
    Date fecha = new Date();
    String barra = File.separator;
    String ubicacion = System.getProperty("user.dir") + barra + "Registros" + barra;
    String Cd;
    
    public SolicitudPrestamo() {
        initComponents();
        txtSP.setText(buscarTodasSolicitudesPrestamos() + "");
        txtFechaPrestamo.setText(fecha.getDate() + "/" + (fecha.getMonth() + 1) + "/" + fecha.getMonth());
        txtFechaPrestamo.setEditable(false);
        txtCedulaPrestamo.setEditable(false);
        txtSP.setEditable(false);
        txtAprobadoPrestamo.setEditable(false);
        txtInteresPrestamo.setEditable(false);
        cargarGarantes();
        cargardir();
        
    }
    
    public void cargarGarantes() {
        
        File maindir = new File(ubicacion);
        if (maindir.exists() && maindir.isDirectory()) {
            File arr[] = maindir.listFiles();
            RecursivePrint(arr, 0, 0);
        }
    }
    
    public void RecursivePrint(File[] arr, int index, int level) {
        // terminate condition 
        if (index == arr.length) {
            return;
        }

        // tabs for internal levels 
        for (int i = 0; i < level; i++) {
            System.out.print("\t");
        }

        // para archivos 
        if (arr[index].isFile()) {
            System.out.println();
            CBGarante.addItem(arr[index].getName().substring(0, 10));
        }

        // recursion for main directory 
        RecursivePrint(arr, ++index, level);
    }
    
    public String cedula(String cedula) {
        Cd = cedula;
        return cedula;
    }
    
    public void cargardir() {
        String ubicacionDir = System.getProperty("user.dir") + barra + "RegistroDirectorio" + barra;
        File maind = new File(ubicacionDir);
        if (maind.exists() && maind.isDirectory()) {
            File arr[] = maind.listFiles();
            RecursivePrintdir(arr, 0, 0);
        }
    }
    
    public void RecursivePrintdir(File[] arr, int index, int level) {
        // terminate condition 
        if (index == arr.length) {
            return;
        }

        // tabs for internal levels 
        for (int i = 0; i < level; i++) {
            System.out.print("\t");
        }

        // para archivos 
        if (arr[index].isFile()) {
            
            CBDiretorio.addItem(arr[index].getName().substring(0, 4));
            
        }

        // recursion for main directory 
        RecursivePrintdir(arr, ++index, level);
    }
    
    String ubicacion1 = System.getProperty("user.dir") + barra + "Prestamos" + barra;
    
    public int buscarTodasSolicitudesPrestamos() {
        int solicitudes = 0;
        File maindir = new File(ubicacion1);
        if (maindir.exists() && maindir.isDirectory()) {
            File arr[] = maindir.listFiles();
            solicitudes = arr.length + 1;
            
            if (solicitudes == 0) {
                solicitudes = 1;
            }
        }
        return solicitudes;
    }
    
    private void crear() {
        
        int solicitud = buscarTodasSolicitudesPrestamos();
        String ubicacionAhorros = System.getProperty("user.dir") + barra + "Prestamos" + barra;
        System.out.println(solicitud);
        String nombreArchivoAhorros = txtCedulaPrestamo.getText() + "-" + solicitud + ".txt";
        
        File crearUbicacionAhorros = new File(ubicacionAhorros);
        if (CBDiretorio.getSelectedIndex() == 0
                || txtSP.getText().equals("")
                || txtCedulaPrestamo.equals("")
                || CBDiretorio.getSelectedIndex() == 0
                || txtFechaPrestamo.getText().equals("")
                || txtFechaPrestamo.getText().equals("")
                || txtAprobadoPrestamo.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "No deje los campos vacios");
        } else {
            try {
                if (crearUbicacionAhorros.exists()) {
                    Formatter crea = new Formatter(ubicacionAhorros + nombreArchivoAhorros);
                    crea.format("%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s",
                            "id=" + CBDiretorio.getSelectedItem().toString(),
                            "noSoli=" + txtSP.getText(),
                            "cedula=" + txtCedulaPrestamo.getText(),
                            "profesorGarante=" + CBGarante.getSelectedItem().toString(),
                            "fecha=" + txtFechaPrestamo.getText(),
                            "cantidad=" + txtCantidadPrestamo.getText(),
                            "plazo=" + txtMesePlazo.getText(),
                            "aprobar=" + txtAprobadoPrestamo.getText());
                    
                    crea.close();
                    JOptionPane.showMessageDialog(rootPane, "Este Registro ha sido creado");
                } else {
                    crearUbicacionAhorros.mkdir();
                    Formatter crea = new Formatter(ubicacionAhorros + nombreArchivoAhorros);
                    crea.format("%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s",
                            "id=" + CBDiretorio.getSelectedItem().toString(),
                            "noSoli=" + txtSP.getText(),
                            "cedula=" + txtCedulaPrestamo.getText(),
                            "profesorGarante=" + CBGarante.getSelectedItem().toString(),
                            "fecha=" + txtFechaPrestamo.getText(),
                            "cantidad=" + txtCantidadPrestamo.getText(),
                            "plazo=" + txtMesePlazo.getText(),
                            "aprobar=" + txtAprobadoPrestamo.getText());
                    
                    crea.close();
                    JOptionPane.showMessageDialog(rootPane, "Este Registro ha sido creado");
                    
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e);
            }
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        CBDiretorio = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtSP = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCedulaPrestamo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtFechaPrestamo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCantidadPrestamo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtMesePlazo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtAprobadoPrestamo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtInteresPrestamo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        CBGarante = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Solicitar Prestamo");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Prestamo"));

        jLabel2.setText("Id:Directorio:");

        CBDiretorio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Directorio" }));

        jLabel3.setText("Nro Solicitud:");

        jLabel4.setText("Cedula:");

        jLabel5.setText("Garante:");

        jLabel6.setText("Fecha:");

        jLabel7.setText("Cantidad:");

        txtCantidadPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadPrestamoActionPerformed(evt);
            }
        });
        txtCantidadPrestamo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadPrestamoKeyTyped(evt);
            }
        });

        jLabel8.setText("Meses plazo:");

        jLabel9.setText("Aprobado:");

        txtAprobadoPrestamo.setText("SinAprobar");
        txtAprobadoPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAprobadoPrestamoActionPerformed(evt);
            }
        });

        jLabel10.setText("Interes:");

        txtInteresPrestamo.setText("1");

        jLabel11.setText("%");

        jButton1.setText("Solicitar Prestamo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        CBGarante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Garante" }));

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
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel2)
                                .addComponent(jLabel6))
                            .addComponent(jLabel8)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtInteresPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
                            .addComponent(txtMesePlazo, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtFechaPrestamo)
                            .addComponent(CBDiretorio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCedulaPrestamo))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSP)
                            .addComponent(txtCantidadPrestamo)
                            .addComponent(txtAprobadoPrestamo, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                            .addComponent(CBGarante, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(CBDiretorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCedulaPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(CBGarante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtFechaPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtCantidadPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMesePlazo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(txtAprobadoPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtInteresPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCantidadPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadPrestamoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadPrestamoActionPerformed

    private void txtCantidadPrestamoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadPrestamoKeyTyped
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese solo numeros");
        }
    }//GEN-LAST:event_txtCantidadPrestamoKeyTyped

    private void txtAprobadoPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAprobadoPrestamoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAprobadoPrestamoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        crear();

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(SolicitudPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SolicitudPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SolicitudPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SolicitudPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SolicitudPrestamo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> CBDiretorio;
    public javax.swing.JComboBox<String> CBGarante;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtAprobadoPrestamo;
    public javax.swing.JTextField txtCantidadPrestamo;
    public javax.swing.JTextField txtCedulaPrestamo;
    public javax.swing.JTextField txtFechaPrestamo;
    private javax.swing.JTextField txtInteresPrestamo;
    public javax.swing.JTextField txtMesePlazo;
    public javax.swing.JTextField txtSP;
    // End of variables declaration//GEN-END:variables
}
