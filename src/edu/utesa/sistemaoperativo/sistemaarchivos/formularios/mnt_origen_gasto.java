/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utesa.sistemaoperativo.sistemaarchivos.formularios;

import edu.utesa.sistemaoperativo.sistemaarchivos.entidades.Origen_gasto;
import edu.utesa.sistemaoperativo.sistemaarchivos.entidades.Origen_ingreso;
import edu.utesa.sistemaoperativo.sistemaarchivos.utilidades.Mensajes;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author juanlht
 */
public class mnt_origen_gasto extends javax.swing.JDialog {

    /**
     * Creates new form mnt_origen_gasto
     */
    
    Origen_gasto orig_g;
    File file;
    public mnt_origen_gasto() {
        initComponents();
        orig_g = new Origen_gasto();
        file = new File(orig_g.getPath_origen_gasto());
        setNextId();
    }
    
    public mnt_origen_gasto(JFrame parent) {
        super(parent,true);
        initComponents();
        orig_g = new Origen_gasto();
        file = new File(orig_g.getPath_origen_gasto());
        setNextId();
    }
    
    public final void setNextId(){
        ArrayList<Origen_gasto> list;
        try {
            list = orig_g.getLista(file);
            if(!list.isEmpty())
                txtId.setText(Integer.toString(list.get(list.size()-1).getId_origen_gasto()+1));
            else
                txtId.setText("1");
            
        } catch (IOException ex) {
            System.err.println("Error leyendo el archivo xxxxxxxxxxxxxxxxxx");
        }
        catch (IndexOutOfBoundsException ex){
            System.err.println("index incorrecto xxxxxxxxxxxxxxxxxxxxx");
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        btnInsertar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnConsultar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnElegir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableOrigenIngreso = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton4.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jButton4.setText("Salir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btnInsertar.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        btnInsertar.setText("Insertar");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setText("Id_origen_gasto:");

        txtId.setDisabledTextColor(new java.awt.Color(239, 132, 26));
        txtId.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel2.setText("Descripcion:");

        txtNombre.setDisabledTextColor(new java.awt.Color(239, 132, 26));

        btnConsultar.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnElegir.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        btnElegir.setText("Elegir");
        btnElegir.setEnabled(false);
        btnElegir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElegirActionPerformed(evt);
            }
        });

        tableOrigenIngreso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableOrigenIngreso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tableOrigenIngresoMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tableOrigenIngreso);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnElegir, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(21, 21, 21)
                                    .addComponent(btnInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(15, 15, 15)
                                    .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnElegir, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        if(!btnInsertar.getText().equals("Modificar")){
            if(!(txtNombre.getText().isEmpty()))
            {
                try {
                    // TODO add your handling code here:
                    orig_g.add(txtNombre.getText());
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
                orig_g.update(Integer.parseInt(txtId.getText()), txtNombre.getText());
                btnEliminar.setEnabled(false);
                btnInsertar.setText("Insertar");
                cleanTxt();
            } catch (IOException ex) {
                System.err.println("Error de lectura de archivo xxxxxxxxxxxxxxxx ");
            }
        }
        consultOrigenGasto();
    }//GEN-LAST:event_btnInsertarActionPerformed

    public final void cleanTxt(){
        setNextId();
        txtNombre.setText("");
        
    }
    
    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        // TODO add your handling code here:
        consultOrigenGasto();
    }//GEN-LAST:event_btnConsultarActionPerformed

    public void consultOrigenGasto(){
        DefaultTableModel modelo = new DefaultTableModel();
        
        String [] cols = {"id","descripcion"};
        for (int i=0;i<cols.length;i++)
            modelo.addColumn(cols[i]);
        
        int k;
        ArrayList<Origen_gasto> list;
        try {
            list = orig_g.getLista(file);
            for(Origen_gasto ori : list){
                k=0;
                Object[] fila = new Object[2];
                fila[k++]=(Object)ori.getId_origen_gasto();
                fila[k++]=(Object)ori.getDecripcion();
                modelo.addRow(fila);
            }
            
        } catch (IOException ex) {
            System.err.println("Error al consultar Persona");
        }
        tableOrigenIngreso.setModel(modelo);
    }
    
    
    
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            // TODO add your handling code here:
            orig_g.delete(Integer.parseInt(txtId.getText()));

        } catch (IOException ex) {
            System.err.println("Error eliminando la persona");
        }
        consultOrigenGasto();
        btnEliminar.setEnabled(false);
        cleanTxt();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnElegirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElegirActionPerformed
        // TODO add your handling code here:
        txtId.setText(tableOrigenIngreso.getModel().getValueAt(tableOrigenIngreso.getSelectedRow(), 0).toString());
        txtNombre.setText(tableOrigenIngreso.getModel().getValueAt(tableOrigenIngreso.getSelectedRow(), 1).toString());

        btnInsertar.setText("Modificar");
        btnEliminar.setEnabled(true);
    }//GEN-LAST:event_btnElegirActionPerformed

    private void tableOrigenIngresoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableOrigenIngresoMouseEntered
        // TODO add your handling code here:
        btnElegir.setEnabled(true);
    }//GEN-LAST:event_tableOrigenIngresoMouseEntered

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
            java.util.logging.Logger.getLogger(mnt_origen_gasto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mnt_origen_gasto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mnt_origen_gasto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mnt_origen_gasto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mnt_origen_gasto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnElegir;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableOrigenIngreso;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}