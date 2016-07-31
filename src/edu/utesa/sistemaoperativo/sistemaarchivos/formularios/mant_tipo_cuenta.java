/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utesa.sistemaoperativo.sistemaarchivos.formularios;

import edu.utesa.sistemaoperativo.sistemaarchivos.entidades.Tipo_cuenta;
import edu.utesa.sistemaoperativo.sistemaarchivos.entidades.Origen_ingreso;
import edu.utesa.sistemaoperativo.sistemaarchivos.entidades.Persona;
import edu.utesa.sistemaoperativo.sistemaarchivos.utilidades.Form;
import edu.utesa.sistemaoperativo.sistemaarchivos.utilidades.Mensajes;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Eduardo Liz
 */
public class mant_tipo_cuenta extends javax.swing.JDialog {

    Tipo_cuenta tipo;
    File file;
    /**
     * Creates new form mant_tipo_cuenta
     */
    public mant_tipo_cuenta() {
        initComponents();
        tipo = new Tipo_cuenta();
        file = new File(tipo.getPath_tipo_cuenta());
        setNextId();
        
    }
    
     public mant_tipo_cuenta(JFrame parent) {
        super(parent,true); 
        initComponents();
        tipo = new Tipo_cuenta();
        file = new File(tipo.getPath_tipo_cuenta());
        setNextId();
        
    }

    public final void setNextId(){
        ArrayList<Tipo_cuenta> list;
        try {
            list = tipo.getLista(file);
            if(!list.isEmpty())
                txtid.setText(Integer.toString(list.get(list.size()-1).getId_tipo_cuenta()+1));
            else
                txtid.setText("1");
            
        } catch (IOException ex) {
            System.err.println("Error leyendo el archivo xxxxxxxxxxxxxxxxxx");
        }
        catch (IndexOutOfBoundsException ex){
            System.err.println("index incorrecto xxxxxxxxxxxxxxxxxxxxx");
        }
    }
    
    public final void cleanTxt(){
        setNextId();
        txtdescripcion.setText("");
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtdescripcion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableTipoCuentas = new javax.swing.JTable();
        btnElegir = new javax.swing.JButton();
        btnInsertar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Id_tipo_cuenta:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Descripcion:");

        txtid.setEditable(false);
        txtid.setBackground(new java.awt.Color(240, 240, 240));
        txtid.setDisabledTextColor(new java.awt.Color(239, 132, 26));

        tableTipoCuentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableTipoCuentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tableTipoCuentasMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tableTipoCuentas);

        btnElegir.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnElegir.setText("Elegir");
        btnElegir.setEnabled(false);
        btnElegir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElegirActionPerformed(evt);
            }
        });

        btnInsertar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnInsertar.setText("Insertar");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnConsultar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton5.setText("Salir");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnElegir, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnInsertar)
                                .addGap(14, 14, 14)
                                .addComponent(btnEliminar)
                                .addGap(18, 18, 18)
                                .addComponent(btnConsultar))
                            .addComponent(jLabel3)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton5)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(250, 250, 250))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnElegir, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableTipoCuentasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTipoCuentasMouseEntered
        // TODO add your handling code here:
        btnElegir.setEnabled(true);
    }//GEN-LAST:event_tableTipoCuentasMouseEntered

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        //this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnElegirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElegirActionPerformed
        // TODO add your handling code here:
        txtid.setText(tableTipoCuentas.getModel().getValueAt(tableTipoCuentas.getSelectedRow(), 0).toString());
        txtdescripcion.setText(tableTipoCuentas.getModel().getValueAt(tableTipoCuentas.getSelectedRow(), 1).toString());
        
        btnInsertar.setText("Modificar");
        btnEliminar.setEnabled(true);
    }//GEN-LAST:event_btnElegirActionPerformed

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        // TODO add your handling code here:
        if(!btnInsertar.getText().equals("Modificar")){
            if(!(txtdescripcion.getText().isEmpty()))
            {
                try {
                    // TODO add your handling code here:
                    tipo.add(txtdescripcion.getText());
                    cleanTxt();
                } catch (IOException ex) {
                    System.err.println("Error de lectura de archivo xxxxxxxxxxxxxxxx ");
                }
            }
            else
            {
                Mensajes.mensajeError(evt, "Debe completar todos los campos!");
            }
        }
        else{
            try {
                tipo.update(Integer.parseInt(txtid.getText()), txtdescripcion.getText());
                btnEliminar.setEnabled(false);
                btnInsertar.setText("Insertar");
                cleanTxt();
            } catch (IOException ex) {
                System.err.println("Error de lectura de archivo xxxxxxxxxxxxxxxx ");
            }
        }
        consultTipoCuenta();
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        // TODO add your handling code here:
        consultTipoCuenta();
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            tipo.delete(Integer.parseInt(txtid.getText()));
            
        } catch (IOException ex) {
           System.err.println("Error eliminando la persona");
        }
        consultTipoCuenta();
        btnEliminar.setEnabled(false);
        cleanTxt();
    }//GEN-LAST:event_btnEliminarActionPerformed

    public void consultTipoCuenta(){
        DefaultTableModel modelo = new DefaultTableModel();
        
        String [] cols = {"id","descripcion"};
        for (int i=0;i<cols.length;i++)
            modelo.addColumn(cols[i]);
        
        int k;
        ArrayList<Tipo_cuenta> list;
        try {
            list = tipo.getLista(file);
            for(Tipo_cuenta ori : list){
                k=0;
                Object[] fila = new Object[2];
                fila[k++]=(Object)ori.getId_tipo_cuenta();
                fila[k++]=(Object)ori.getDescripcion();
                modelo.addRow(fila);
            }
            
        } catch (IOException ex) {
            System.err.println("Error al consultar Persona");
        }
        tableTipoCuentas.setModel(modelo);
    }
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
            java.util.logging.Logger.getLogger(mant_tipo_cuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mant_tipo_cuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mant_tipo_cuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mant_tipo_cuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mant_tipo_cuenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnElegir;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableTipoCuentas;
    private javax.swing.JTextField txtdescripcion;
    private javax.swing.JTextField txtid;
    // End of variables declaration//GEN-END:variables
}
