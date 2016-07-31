/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utesa.sistemaoperativo.sistemaarchivos.formularios;

import edu.utesa.sistemaoperativo.sistemaarchivos.Dto.Dto_Origen_Gasto;
import edu.utesa.sistemaoperativo.sistemaarchivos.entidades.Origen_gasto;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author juanlht
 */
public class cns_origen_gasto extends javax.swing.JDialog{
     
    
    Origen_gasto ori;
    File file;
    public cns_origen_gasto() {
        initComponents();
        ori = new Origen_gasto();
        file = new File(ori.getPath_origen_gasto());
        
    }
    
    public cns_origen_gasto(JDialog parent) {
        super(parent);
        initComponents();
        ori = new Origen_gasto();
        file = new File(ori.getPath_origen_gasto());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTipo = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_cuenta = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton5.setText("Buscar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        table_cuenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        table_cuenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_cuentaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_cuenta);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Buscar por descripcion:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        ArrayList<Origen_gasto> listfiltrada = new ArrayList();
        ArrayList<Origen_gasto> list = new ArrayList();

        try {
            list = ori.getLista(file);
        } catch (IOException ex) {
            Logger.getLogger(cns_cuenta.class.getName()).log(Level.SEVERE, null, ex);
        }

        for(Origen_gasto tp : list){
            if(tp.getDecripcion().startsWith(txtTipo.getText()) || txtTipo.getText().isEmpty()){
                listfiltrada.add(tp);
            }
        }
        consultCuenta(listfiltrada);
    }//GEN-LAST:event_jButton5ActionPerformed

    public void consultCuenta(ArrayList<Origen_gasto> list){
        DefaultTableModel modelo = new DefaultTableModel();
        
        String [] cols = {"id","origen"};
        for (int i=0;i<cols.length;i++)
            modelo.addColumn(cols[i]);
        
        int k;
       
        for(Origen_gasto ori : list){
             k=0;
                Object[] fila = new Object[4];
                fila[k++]=(Object)ori.getId_origen_gasto();
                fila[k++]=(Object)ori.getDecripcion();
                modelo.addRow(fila);
        }    
            
        
        table_cuenta.setModel(modelo);
    }
    
    private void table_cuentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_cuentaMouseClicked
        // TODO add your handling code here:
        Origen_gasto cu = new Origen_gasto();
        cu.setId_origen_gasto(Integer.parseInt(table_cuenta.getModel().getValueAt(table_cuenta.getSelectedRow(), 0).toString()));
        cu.setDecripcion(table_cuenta.getModel().getValueAt(table_cuenta.getSelectedRow(), 1).toString());
        
        Dto_Origen_Gasto.setOrigen_gasto(cu);
        this.dispose();
    }//GEN-LAST:event_table_cuentaMouseClicked

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
            java.util.logging.Logger.getLogger(cns_origen_gasto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cns_origen_gasto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cns_origen_gasto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cns_origen_gasto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cns_origen_gasto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_cuenta;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}