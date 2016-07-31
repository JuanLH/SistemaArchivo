/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utesa.sistemaoperativo.sistemaarchivos.formularios;

import edu.utesa.sistemaoperativo.sistemaarchivos.entidades.Persona;
import edu.utesa.sistemaoperativo.sistemaarchivos.utilidades.Mensajes;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author juanlht
 */
public class mnt_persona extends javax.swing.JDialog {

    /**
     * Creates new form mnt_persona
     */
    Persona p;
    File file;
    
    
    public mnt_persona() {
        initComponents();
        p = new Persona();
        file = new File(p.getPath_persona());
        setNextId();
    }
    
    public mnt_persona(javax.swing.JFrame parent) {
        super(parent,true);
        initComponents();
        p = new Persona();
        file = new File(p.getPath_persona());
        setNextId();
    }
    
    public final void setNextId(){
        ArrayList<Persona> list;
        try {
            list = p.getListaPersona(file);
            if(!list.isEmpty())
                txtId.setText(Integer.toString(list.get(list.size()-1).getId_persona()+1));
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

        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        btnConsultar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnElegir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePersona = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        btnInsertar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setText("Id_Persona:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 14, -1, -1));

        txtId.setDisabledTextColor(new java.awt.Color(239, 132, 26));
        txtId.setEnabled(false);
        getContentPane().add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 12, 45, -1));

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel2.setText("Nombre:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 48, -1, -1));

        txtNombre.setDisabledTextColor(new java.awt.Color(239, 132, 26));
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 46, 103, -1));

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel3.setText("Apellido:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 82, -1, -1));

        txtApellido.setDisabledTextColor(new java.awt.Color(239, 132, 26));
        getContentPane().add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 80, 103, -1));

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel4.setText("Direccion:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 116, -1, -1));

        txtDireccion.setDisabledTextColor(new java.awt.Color(239, 132, 26));
        getContentPane().add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 114, 244, -1));

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel5.setText("Telefono:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 150, -1, -1));

        txtTelefono.setDisabledTextColor(new java.awt.Color(239, 132, 26));
        getContentPane().add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 148, 134, -1));

        btnConsultar.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });
        getContentPane().add(btnConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 150, 47));

        btnEliminar.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 194, 98, 47));

        btnElegir.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        btnElegir.setText("Elegir");
        btnElegir.setEnabled(false);
        btnElegir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElegirActionPerformed(evt);
            }
        });
        getContentPane().add(btnElegir, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 194, 98, 47));

        tablePersona.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablePersona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tablePersonaMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tablePersona);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 580, 190));

        jButton4.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jButton4.setText("Salir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 480, 98, 47));

        btnInsertar.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        btnInsertar.setText("Insertar");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });
        getContentPane().add(btnInsertar, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 194, 98, 47));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            // TODO add your handling code here:
            p.deletePersona(Integer.parseInt(txtId.getText()));
            
        } catch (IOException ex) {
           System.err.println("Error eliminando la persona");
        }
        consultPersona();
        btnEliminar.setEnabled(false);
        cleanTxt();
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        // TODO add your handling code here:
        consultPersona();
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void consultPersona(){
        DefaultTableModel modelo = new DefaultTableModel();
        
        String [] cols = {"id","nombre","apellido","direccion","telefono"};
        for (int i=0;i<cols.length;i++)
            modelo.addColumn(cols[i]);
        
        int k;
        ArrayList<Persona> list;
        try {
            list = p.getListaPersona(file);
            for(Persona per : list){
                k=0;
                Object[] fila = new Object[5];
                fila[k++]=(Object)per.getId_persona();
                fila[k++]=(Object)per.getNombre();
                fila[k++]=(Object)per.getApellido();
                fila[k++]=(Object)per.getDireccion();
                fila[k++]=(Object)per.getTelefono();
                modelo.addRow(fila);
            }
            
        } catch (IOException ex) {
            System.err.println("Error al consultar Persona");
        }
        tablePersona.setModel(modelo);
    }
    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        if(!btnInsertar.getText().equals("Modificar")){
            if(!(txtNombre.getText().isEmpty() && txtApellido.getText().isEmpty() && txtDireccion.getText().isEmpty() && txtTelefono.getText().isEmpty()))
            {
                try {
                    // TODO add your handling code here:
                    p.addPersona(txtNombre.getText(), 
                            txtApellido.getText(),
                            txtDireccion.getText(),
                            txtTelefono.getText());
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
                p.updatePersona(Integer.parseInt(txtId.getText()), txtNombre.getText(),
                        txtApellido.getText()
                        , txtDireccion.getText()
                        , txtTelefono.getText());
                btnEliminar.setEnabled(false);
                btnInsertar.setText("Insertar");
                cleanTxt();
            } catch (IOException ex) {
                System.err.println("Error de lectura de archivo xxxxxxxxxxxxxxxx ");
            }
        }
        consultPersona();
        
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void tablePersonaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePersonaMouseEntered
        // TODO add your handling code here:
        btnElegir.setEnabled(true);
        
        
    }//GEN-LAST:event_tablePersonaMouseEntered

    private void btnElegirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElegirActionPerformed
        // TODO add your handling code here:
        txtId.setText(tablePersona.getModel().getValueAt(tablePersona.getSelectedRow(), 0).toString());
        txtNombre.setText(tablePersona.getModel().getValueAt(tablePersona.getSelectedRow(), 1).toString());
        txtApellido.setText(tablePersona.getModel().getValueAt(tablePersona.getSelectedRow(), 2).toString());
        txtDireccion.setText(tablePersona.getModel().getValueAt(tablePersona.getSelectedRow(), 3).toString());
        txtTelefono.setText(tablePersona.getModel().getValueAt(tablePersona.getSelectedRow(), 4).toString());
        btnInsertar.setText("Modificar");
        btnEliminar.setEnabled(true);
    }//GEN-LAST:event_btnElegirActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    
    public void cleanTxt(){
        txtNombre.setText("");
        txtApellido.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        setNextId();
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
            java.util.logging.Logger.getLogger(mnt_persona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mnt_persona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mnt_persona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mnt_persona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mnt_persona().setVisible(true);
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablePersona;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
