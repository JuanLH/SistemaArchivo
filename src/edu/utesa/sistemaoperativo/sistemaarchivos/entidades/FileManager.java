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
    
    protected String path_persona="C:\\Users\\JuanL\\OneDrive\\Documents\\NetBeansProjects\\SistemaArchivo\\src\\edu\\utesa\\sistemaoperativo\\sistemaarchivos\\archivos\\Persona";
    protected String path_origen_ingreso="C:\\Users\\JuanL\\OneDrive\\Documents\\NetBeansProjects\\SistemaArchivo\\src\\edu\\utesa\\sistemaoperativo\\sistemaarchivos\\archivos\\Origen_ingreso";
    protected String path_origen_gasto="C:\\Users\\JuanL\\OneDrive\\Documents\\NetBeansProjects\\SistemaArchivo\\src\\edu\\utesa\\sistemaoperativo\\sistemaarchivos\\archivos\\Origen_gasto";
    protected String path_tipo_cuenta="C:\\Users\\JuanL\\OneDrive\\Documents\\NetBeansProjects\\SistemaArchivo\\src\\edu\\utesa\\sistemaoperativo\\sistemaarchivos\\archivos\\Tipo_cuenta";
    protected String path_cuenta="C:\\Users\\JuanL\\OneDrive\\Documents\\NetBeansProjects\\SistemaArchivo\\src\\edu\\utesa\\sistemaoperativo\\sistemaarchivos\\archivos\\Cuenta";
    protected String path_transferencia="C:\\Users\\JuanL\\OneDrive\\Documents\\NetBeansProjects\\SistemaArchivo\\src\\edu\\utesa\\sistemaoperativo\\sistemaarchivos\\archivos\\Transferencia";
    protected String path_ingreso="C:\\Users\\JuanL\\OneDrive\\Documents\\NetBeansProjects\\SistemaArchivo\\src\\edu\\utesa\\sistemaoperativo\\sistemaarchivos\\archivos\\Ingreso";
    protected String path_cuenta_vs_persona = "C:\\Users\\JuanL\\OneDrive\\Documents\\NetBeansProjects\\SistemaArchivo\\src\\edu\\utesa\\sistemaoperativo\\sistemaarchivos\\archivos\\Cuenta_vs_Persona";
    protected String path_gasto="C:\\Users\\JuanL\\OneDrive\\Documents\\NetBeansProjects\\SistemaArchivo\\src\\edu\\utesa\\sistemaoperativo\\sistemaarchivos\\archivos\\Gasto";
    public String path_peticion="C:\\Users\\JuanL\\OneDrive\\Documents\\CarpetaPruebaS.O\\peticion.txt";
    public String path_respuesta = "C:\\Users\\JuanL\\OneDrive\\Documents\\CarpetaPruebaS.O\\respuesta.txt";
    
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
