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
 * @author juanlht
 */
public class Cuenta extends FileManager{
    private int id_cuenta,id_tipo_cuenta;
    private String descripcion;
    private float Balance;

    public Cuenta() {
    }

    
    
    public Cuenta(int id_cuenta, int id_tipo_cuenta, String descripcion, float Balance) {
        this.id_cuenta = id_cuenta;
        this.id_tipo_cuenta = id_tipo_cuenta;
        this.descripcion = descripcion;
        this.Balance = Balance;
    }

    
    
    public int getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public int getId_tipo_cuenta() {
        return id_tipo_cuenta;
    }

    public void setId_tipo_cuenta(int id_tipo_cuenta) {
        this.id_tipo_cuenta = id_tipo_cuenta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getBalance() {
        return Balance;
    }

    public void setBalance(float Balance) {
        this.Balance = Balance;
    }

    public String getPath_cuenta() {
        return path_cuenta;
    }
    
    
    
    public ArrayList<Cuenta>  getLista (File file) throws FileNotFoundException, IOException{
        ArrayList<Cuenta> list = new ArrayList<Cuenta>();
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
            
            String id_cuenta,id_tipo_cuenta,descripcion,balance;
            id_cuenta=id_tipo_cuenta=descripcion=balance=null;
            String temp = null;
            
            for (int i = 0;i<count;i++)
            {
                char c = (char)bs[i];
                
                if(id_cuenta==null){    
                    if(c != ','){
                        if(temp==null)
                            temp=Character.toString(c);
                        else
                            temp=temp+c;
                        
                        continue;
                    }
                    else{
                        id_cuenta = temp;
                        temp = null;
                        continue;
                    }
                }
                
                if(id_tipo_cuenta==null){
                    if(c != ','){
                        if(temp==null)
                            temp=Character.toString(c);
                        else
                            temp+=c;
                        continue;
                    }
                    else{
                        id_tipo_cuenta = temp;
                        temp = null;
                        continue;
                    }
                }  
                
                if(descripcion==null){    
                    if(c != ','){
                        if(temp==null)
                            temp=Character.toString(c);
                        else
                            temp=temp+c;
                        
                        continue;
                    }
                    else{
                        descripcion = temp;
                        temp = null;
                        continue;
                    }
                }
                
                if(balance==null){
                    if(c != '\n'){
                        if(temp==null)
                            temp=Character.toString(c);
                        else
                            temp+=c;
                        continue;
                    }
                    else{
                        balance = temp;
                        temp = null;
                    }
                }  
                
                list.add(new Cuenta(Integer.parseInt(id_cuenta), Integer.parseInt(id_tipo_cuenta), descripcion, Float.parseFloat(balance)));
                id_cuenta=id_tipo_cuenta=descripcion=balance=null;
            }
            
        return list;
    }
    
     public void add(String id_tipo_cuenta,String descripcion,String balance) throws IOException{
        File file = new File(path_cuenta);
        ArrayList<Cuenta> list = getLista(file);
        
        if(Exists(file) && file.isFile()){
            
            if(isEmpy(file)){
                prnln("-----------------------------");
                if(list.isEmpty()){
                    FileWriter writer;
                    writer = new FileWriter(file);
                    writer.write(1+","+id_tipo_cuenta+","+descripcion+","+balance+"\n");
                    writer.flush();
                    prnln("++Se inserto correctamente");
                }
                
            }
            else
            {
                //prnln("--------------**---------------");
                //prnln("size lista "+Integer.toString(list.size()));
                int id = list.get(list.size()-1).getId_cuenta();
                String cuenta=geTextFile(file);
                //prn(""+per);
                FileWriter writer = new FileWriter(file);
                writer.write(cuenta+""+(id+1)+","+id_tipo_cuenta+","+descripcion+","+balance+"\n");
                writer.flush();
                prnln("++Se inserto correctamente");
            }
        }
        
    }
     
     public boolean update(int id,String id_tipo_cuenta,String descripcion,String balance) throws IOException{
        File file = new File(path_cuenta);
        ArrayList<Cuenta> list = getLista(file);
        for(int i=0;i<list.size();i++){
            if(list.get(i).getId_cuenta()==id){
                list.get(i).setId_tipo_cuenta(Integer.parseInt(id_tipo_cuenta));
                list.get(i).setDescripcion(descripcion);
                list.get(i).setBalance(Float.parseFloat(balance));
                writeTable(list);
                prnln("Se actualizo correctamente");
                return true;
            }
        }
        return false;        
    }
     
    private void insert(String id,String id_tipo_cuenta,String descripcion,String balance) throws IOException{
        File file = new File(path_cuenta);
        if(Exists(file) && file.isFile()){
            String cuenta=geTextFile(file);
            FileWriter writer = new FileWriter(file);
            writer.write(cuenta+""+id+","+id_tipo_cuenta+","+descripcion+","+balance+"\n");
            writer.flush();
        }
    } 
     
     private void writeTable(ArrayList<Cuenta> list) throws IOException{
        File file = new File(path_cuenta);
        delete(file);
        for(int j=0;j<list.size();j++){
            insert(Integer.toString(list.get(j).getId_cuenta()),
                    Integer.toString(list.get(j).getId_tipo_cuenta()),
                    list.get(j).getDescripcion(),
                    Float.toString(list.get(j).getBalance()));
        }
    }
     
     public boolean delete(int id) throws IOException{
        File file = new File(path_cuenta);
        ArrayList<Cuenta> list = getLista(file);
        for(int i=0;i<list.size();i++){
            if(list.get(i).getId_cuenta()==id){
                list.remove(i);
                writeTable(list);
                return true;
            }
        }
        return false;
    }
}
