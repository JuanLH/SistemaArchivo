/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utesa.sistemaoperativo.sistemaarchivos.run;

import edu.utesa.sistemaoperativo.sistemaarchivos.entidades.Persona;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanlht
 */
public class Main {
    public static void main(String [] args){
        
        try {
            Persona p = new Persona();
            File f = new File("//home//juanlht//NetBeansProjects//SistemaOperativo//src//edu//utesa//sistemaoperativo//sistemaarchivos//archivos//Persona");
            p.isEmpy(f);
            
            ArrayList<Persona>  list = p.getListaPersona(f);
            
            //p.prn(list.get(0).getId_persona()+" "+list.get(0).getNombre());
            if(list.isEmpty()){
                System.out.print("Vacia");
                p.addPersona("Juan", "Hiciano", "Los reyes","809-576-6074");
            }
            else{
                p.addPersona("Juan", "Hiciano", "Los reyes","809-576-6074");
                 p.printTable();
                
            }
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Persona per = new Persona();
        File file = new File("//home//juanlht//NetBeansProjects//SistemaOperativo//src//edu//utesa//sistemaoperativo//sistemaarchivos//archivos//Persona");
        try {
            ArrayList<Persona> list = per.getListaPersona(file);
            System.out.println(list.get(3).getNombre()+" "+list.get(3).getApellido());
            //---------------------------------------
            
            Persona p = new Persona();
            try {
            p.updatePersona(5, "Raul", "Maduro", "Venezuela", "555-555-5484");
            p.deletePersona(15);
            } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
}
