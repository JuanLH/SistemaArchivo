/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utesa.sistemaoperativo.sistemaarchivos.utilidades;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author juanlht
 */
public class PosicionFormulario {
    
    public static coordinates getCenterLocation(javax.swing.JDialog frm){
        // Determine the new location of the window
        int w = frm.getSize().width;
        int h = frm.getSize().height;
        int x = (getScreenSize().width-w)/2;
        int y = (getScreenSize().height-h)/2;
        
        // Move the window
        return new coordinates(x,y);
        
    }
    
    public static Dimension getScreenSize(){
       return Toolkit.getDefaultToolkit().getScreenSize();
    }
}
