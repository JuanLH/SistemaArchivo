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
public class Origen_ingreso extends FileManager{
    private int id_origen_ingreso;
    private String descripcion;

    public Origen_ingreso(int id_origen_ingreso, String descripcion) {
        this.id_origen_ingreso = id_origen_ingreso;
        this.descripcion = descripcion;
    }

    public Origen_ingreso() {
    }

    
    
    public int getId_origen_ingreso() {
        return id_origen_ingreso;
    }

    public void setId_origen_ingreso(int id_origen_ingreso) {
        this.id_origen_ingreso = id_origen_ingreso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPath_origen_ingreso() {
        return Rutas.path_origen_ingreso;
    }
    
    
    
    
    public ArrayList<Origen_ingreso>  getLista (File file) throws FileNotFoundException, IOException{
        ArrayList<Origen_ingreso> list = new ArrayList<Origen_ingreso>();
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
            
            String id_origen_ingreso=null;
            String descripcion=null;
            String temp = null;
            
            for (int i = 0;i<count;i++)
            {
                char c = (char)bs[i];
                
                if(id_origen_ingreso==null){    
                    if(c != ','){
                        if(temp==null)
                            temp=Character.toString(c);
                        else
                            temp=temp+c;
                        
                        continue;
                    }
                    else{
                        id_origen_ingreso = temp;
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
                
                
                
                
                list.add(new Origen_ingreso(Integer.parseInt(id_origen_ingreso), descripcion));
                id_origen_ingreso=descripcion=null;
            }
        return list;
    }
    
    
    public void add(String descripcion) throws IOException{
        File file = new File(Rutas.path_origen_ingreso);
        ArrayList<Origen_ingreso> list = getLista(file);
        
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
                int id = list.get(list.size()-1).getId_origen_ingreso(); 
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
        File file = new File(Rutas.path_origen_ingreso);
        ArrayList<Origen_ingreso> list = getLista(file);
        for(int i=0;i<list.size();i++){
            if(list.get(i).getId_origen_ingreso()==id){
                list.get(i).setDescripcion(descripcion);
                writeTable(list);
                return true;
            }
        }
        return false;
        
    }
    
    public boolean delete(int id) throws IOException{
        File file = new File(Rutas.path_origen_ingreso);
        ArrayList<Origen_ingreso> list = getLista(file);
        for(int i=0;i<list.size();i++){
            if(list.get(i).getId_origen_ingreso()==id){
                list.remove(i);
                writeTable(list);
                return true;
            }
        }
        return false;
    }
    
    private void insert(String id,String descripcion) throws IOException{
        File file = new File(Rutas.path_origen_ingreso);
        if(Exists(file) && file.isFile()){
            String origen=geTextFile(file);
            FileWriter writer = new FileWriter(file);
            writer.write(origen+""+id+","+descripcion+"\n");
            writer.flush();
        }
    }
    
    private void writeTable(ArrayList<Origen_ingreso> list) throws IOException{
        File file = new File(Rutas.path_origen_ingreso);
        delete(file);
        for(int j=0;j<list.size();j++){
            insert(Integer.toString(list.get(j).getId_origen_ingreso()), list.get(j).getDescripcion());
        }
    }
}
