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
public class Tipo_cuenta extends FileManager {
    private int id_tipo_cuenta;
    private String tipo,descripcion;

    public Tipo_cuenta(int id_tipo_cuenta, String tipo, String descripcion) {
        this.id_tipo_cuenta = id_tipo_cuenta;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    
    
    public Tipo_cuenta() {
    }
    
    public int getId_tipo_cuenta() {
        return id_tipo_cuenta;
    }

    public void setId_tipo_cuenta(int id_tipo_cuenta) {
        this.id_tipo_cuenta = id_tipo_cuenta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getPath_tipo_cuenta() {
        return Rutas.path_tipo_cuenta;
    }
    
    public ArrayList<Tipo_cuenta>  getLista (File file) throws FileNotFoundException, IOException{
        ArrayList<Tipo_cuenta> list = new ArrayList<Tipo_cuenta>();
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
            
            String id_tipo_cuenta=null;
            String tipo=null;
            String descripcion=null;
            String temp = null;
            
            for (int i = 0;i<count;i++)
            {
                char c = (char)bs[i];
                
                if(id_tipo_cuenta==null){    
                    if(c != ','){
                        if(temp==null)
                            temp=Character.toString(c);
                        else
                            temp=temp+c;
                        
                        continue;
                    }
                    else{
                        id_tipo_cuenta = temp;
                        temp = null;
                        continue;
                    }
                }
                
                if(tipo==null){    
                    if(c != ','){
                        if(temp==null)
                            temp=Character.toString(c);
                        else
                            temp=temp+c;
                        
                        continue;
                    }
                    else{
                        tipo = temp;
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
                
                list.add(new Tipo_cuenta(Integer.parseInt(id_tipo_cuenta),tipo, descripcion));
                id_tipo_cuenta=tipo=descripcion=null;
            }
        return list;
    }
    
    public void add(String descripcion) throws IOException{
        File file = new File(Rutas.path_tipo_cuenta);
        ArrayList<Tipo_cuenta> list = getLista(file);
        
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
                int id = list.get(list.size()-1).getId_tipo_cuenta(); 
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
        File file = new File(Rutas.path_tipo_cuenta);
        ArrayList<Tipo_cuenta> list = getLista(file);
        for(int i=0;i<list.size();i++){
            if(list.get(i).getId_tipo_cuenta()==id){
                list.get(i).setDescripcion(descripcion);
                writeTable(list);
                return true;
            }
        }
        return false;        
    }
    
    public boolean delete(int id) throws IOException{
        File file = new File(Rutas.path_tipo_cuenta);
        ArrayList<Tipo_cuenta> list = getLista(file);
        for(int i=0;i<list.size();i++){
            if(list.get(i).getId_tipo_cuenta()==id){
                list.remove(i);
                writeTable(list);
                return true;
            }
        }
        return false;
    }
    
    private void insert(String id,String descripcion) throws IOException{
        File file = new File(Rutas.path_tipo_cuenta);
        if(Exists(file) && file.isFile()){
            String tipo=geTextFile(file);
            FileWriter writer = new FileWriter(file);
            writer.write(tipo+""+id+","+descripcion+"\n");
            writer.flush();
        }
    }
    
    private void writeTable(ArrayList<Tipo_cuenta> list) throws IOException{
        File file = new File(Rutas.path_tipo_cuenta);
        delete(file);
        for(int j=0;j<list.size();j++){
            insert(Integer.toString(list.get(j).getId_tipo_cuenta()), list.get(j).getDescripcion());
        }
    }
    
}

