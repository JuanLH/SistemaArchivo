/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utesa.sistemaoperativo.sistemaarchivos.utilidades;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author juanlht
 */
public class Form {
    
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
    
    public static void cleanTxt(JFrame frm){
        int size = frm.getComponents().length;
        System.out.println("Entrando"+" "+size);
        for(int i =0;i<size;i++){
            System.out.println(frm.getComponent(i).getName());
            if(frm.getComponent(i) instanceof Container){
                Container txt = (Container)frm.getComponent(i);
                
                System.out.println("Hecho-----"+"  "+txt.getClass());
                Component [] c = txt.getComponents();
                for(Component ca : c){
                    System.out.println("DO-----"+"  "+ca.getClass());
                    if(ca instanceof JPanel){
                        JPanel jp =  (JPanel)ca;
                        Component [] c2 = jp.getComponents();
                        for(Component ca2 : c){
                            System.out.println("DO2-----"+"  "+ca2.getClass());
                       }
                    }
                }
            }
            
        }
    }
    
}
