/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utesa.sistemaoperativo.sistemaarchivos.entidades;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author juanlht
 */
public class FileManager {
    
    String path_persona="//home//juanlht//NetBeansProjects//SistemaOperativo//src//edu//utesa//sistemaoperativo//sistemaarchivos//archivos//Persona";
    String path_origen_ingreso="//home//juanlht//NetBeansProjects//SistemaOperativo//src//edu//utesa//sistemaoperativo//sistemaarchivos//archivos//Origen_ingreso";
    String path_tipo_cuenta="//home//juanlht//NetBeansProjects//SistemaOperativo//src//edu//utesa//sistemaoperativo//sistemaarchivos//archivos//Tipo_cuenta";
    String path_cuenta="//home//juanlht//NetBeansProjects//SistemaOperativo//src//edu//utesa//sistemaoperativo//sistemaarchivos//archivos//Cuenta";
    
    public boolean Exists(File file){
        if(file.exists())
            return true;
        else
            return false;
    }
    
    public void prn(String text){
         System.out.print(text);
    }   
    public void prnln(String text){
        System.out.println(text);
    }
    
    public boolean isEmpy(File file) throws FileNotFoundException, IOException{
        
        // create input stream from file input stream
        InputStream is = new FileInputStream(file);
        
        // count the available bytes form the input stream
        int count = is.available();//prn(Integer.toString(count));
        //prn(Integer.toString(count));
        
        if(count==0){
            return true;
        }
      
        return false;  
    }
    
    public String geTextFile(File file) throws FileNotFoundException, IOException{
        String txt = "";
        FileInputStream fi = new FileInputStream(file);
        DataInputStream di = new DataInputStream(fi);
        int count = fi.available();
        byte[] bs = new byte[count];
        di.read(bs);
        for(int i=0;i<count;i++){
            char c = (char)bs[i];
             txt+=c;
        }
        return txt;
    }
    
    protected void delete(File file) throws IOException{
        FileWriter writer = new FileWriter(file);
        writer.write("");
        writer.flush();
        prnln("++Se elimino correctamente");
    }
}
