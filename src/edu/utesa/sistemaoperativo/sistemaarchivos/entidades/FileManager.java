/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utesa.sistemaoperativo.sistemaarchivos.entidades;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/**
 *
 * @author juanlht
 */
public class FileManager {
    
    
    
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
    
    
    public String getLineFile(File file) throws FileNotFoundException, IOException{
        String txt = "";
        BufferedReader bf = new BufferedReader(new FileReader(file));
        txt = bf.readLine();
        return txt;
    }
    
    protected void delete(File file) throws IOException{
        FileWriter writer = new FileWriter(file);
        writer.write("");
        writer.flush();
        prnln("++Se elimino correctamente");
    }
}
