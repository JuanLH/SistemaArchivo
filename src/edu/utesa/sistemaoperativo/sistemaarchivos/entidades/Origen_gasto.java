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
import java.util.ArrayList;

/**
 *
 * @author juanlht
 */
public class Origen_gasto extends FileManager{
    private int id_origen_gasto;
    private String decripcion;

    public Origen_gasto() {
    }

    public Origen_gasto(int id_origen_gasto, String decripcion) {
        this.id_origen_gasto = id_origen_gasto;
        this.decripcion = decripcion;
    }
    
    
    

    public int getId_origen_gasto() {
        return id_origen_gasto;
    }

    public void setId_origen_gasto(int id_origen_gasto) {
        this.id_origen_gasto = id_origen_gasto;
    }

    public String getDecripcion() {
        return decripcion;
    }

    public void setDecripcion(String decripcion) {
        this.decripcion = decripcion;
    }

    public String getPath_origen_gasto() {
        return Rutas.path_origen_gasto;
    }
    
    
    
    
    public ArrayList<Origen_gasto>  getLista (File file) throws FileNotFoundException, IOException{
        ArrayList<Origen_gasto> list = new ArrayList<Origen_gasto>();
         // create input stream from file input stream
            InputStream is = new FileInputStream(file);
            
            // create data input stream
            DataInputStream dis = new DataInputStream(is);
            
            // count the available bytes form the input stream
            int count = is.available();//prn(Integer.toString(count));
            
            // create buffer
            byte[] bs = new byte[count];
         
            // read data into buffer
            dis.read(bs);
            
            String id_origen_gasto,descripcion;
            id_origen_gasto=descripcion=null;
            String temp = null;
            
            for (int i = 0;i<count;i++)
            {
                char c = (char)bs[i];
                
                if(id_origen_gasto==null){    
                    if(c != ','){
                        if(temp==null)
                            temp=Character.toString(c);
                        else
                            temp=temp+c;
                        
                        continue;
                    }
                    else{
                        id_origen_gasto = temp;
                        temp = null;
                        continue;
                    }
                }
                
                if(descripcion==null){
                    if(c != '\n'){
                        if(temp==null)
                            temp=Character.toString(c);
                        else
                            temp+=c;
                        continue;
                    }
                    else{
                        descripcion = temp;
                        temp = null;
                        
                    }
                }  
                
                list.add(new Origen_gasto(Integer.parseInt(id_origen_gasto), descripcion));
                id_origen_gasto=descripcion=null;
            }
            
        return list;
    }
    
     public void add(String descripcion) throws IOException{
        File file = new File(Rutas.path_origen_gasto);
       ArrayList<Origen_gasto> list = getLista(file);
        
        if(Exists(file) && file.isFile()){
            
            if(isEmpy(file)){
                prnln("-----------------------------");
              if(list.isEmpty()){
                    FileWriter writer;
                    writer = new FileWriter(file);
                    writer.write(1+","+descripcion+"\n");
                    writer.flush();
                    prnln("++Se inserto correctamente");
               }
                
            }
            else
            {
                //prnln("--------------**---------------");
                //prnln("size lista "+Integer.toString(list.size()));
                int id = list.get(list.size()-1).getId_origen_gasto();
                String per=geTextFile(file);
                //prn(""+per);
                FileWriter writer = new FileWriter(file);
                writer.write(per+""+(id+1)+","+descripcion+"\n");
                writer.flush();
                prnln("++Se inserto correctamente");
            }
        }       
    }
     
    public boolean update(int id,String descripcion) throws IOException{
        File file = new File(Rutas.path_origen_gasto);
        ArrayList<Origen_gasto> list = getLista(file);
        for(int i=0;i<list.size();i++){
            if(list.get(i).getId_origen_gasto()==id){
                list.get(i).setDecripcion(descripcion);    
                writeTable(list);
                prnln("Se actualizo correctamente");
                return true;
            }
        }
        return false;        
    }
    
    private void insert(String id_origen_gasto,String descripcion) throws IOException{
        File file = new File(Rutas.path_origen_gasto);
        if(Exists(file) && file.isFile()){
            String origen_gasto=geTextFile(file);
            FileWriter writer = new FileWriter(file);
            writer.write(origen_gasto+""+id_origen_gasto+","+descripcion+"\n");
            writer.flush();
        }
    }
    
    public boolean delete(int id) throws IOException{
        File file = new File(Rutas.path_origen_gasto);
        ArrayList<Origen_gasto> list = getLista(file);
        for(int i=0;i<list.size();i++){
            if(list.get(i).getId_origen_gasto()==id){
                list.remove(i);
                writeTable(list);
                return true;
            }
        }
        return false;
    }
    
    
    private void writeTable(ArrayList<Origen_gasto> list) throws IOException{
        File file = new File(Rutas.path_origen_gasto);
        delete(file);
        for(int j=0;j<list.size();j++){
            insert(Integer.toString(list.get(j).getId_origen_gasto()),list.get(j).getDecripcion());
        }
    }
    
    
}
