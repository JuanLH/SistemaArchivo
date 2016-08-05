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
public class Cuenta_vs_Persona extends FileManager{
    private int id_cuenta,id_persona;

    public Cuenta_vs_Persona(int id_cuenta, int id_persona) {
        this.id_cuenta = id_cuenta;
        this.id_persona = id_persona;
    }

    
    public Cuenta_vs_Persona() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }
    public String getPath_Cuenta_vs_Persona() {
        String path_Cuenta_vs_Persona = null;
        return path_Cuenta_vs_Persona;
    }
    
    public ArrayList<Cuenta_vs_Persona>  getLista (File file) throws FileNotFoundException, IOException{
        ArrayList<Cuenta_vs_Persona> list;
        list = new ArrayList <Cuenta_vs_Persona> ();
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
            
            String id_Cuenta=null;
            String id_Persona=null;
            String temp = null;
            
            for (int i = 0;i<count;i++)
            {
                char c = (char)bs[i];
                
                if(id_Cuenta==null){    
                    if(c != ','){
                        if(temp==null)
                            temp=Character.toString(c);
                        else
                            temp=temp+c;
                        
                        continue;
                    }
                    else{
                        id_Cuenta = temp;
                        temp = null;
                        continue;
                    }
                }
                
                if(id_Persona==null){
                    if(c != '\n'){
                        if(temp==null)
                            temp=Character.toString(c);
                        else
                            temp+=c;
                        continue;
                    }
                    else{
                        id_Persona = temp;
                        temp = null;
                        
                    }
                }
                
                
                
                
                list.add(new Cuenta_vs_Persona (Integer.parseInt(id_Cuenta), Integer.parseInt(id_Persona)));
                id_Cuenta=id_Persona=null;
            }
        return list;
    }
    
    
   
    
    public boolean update_cvp_Persona(int id_cuenta,int id_persona,int id_new_persona) throws IOException{
        File file = new File(Rutas.path_origen_ingreso);
        ArrayList<Cuenta_vs_Persona> list = getLista(file);
        for(int i=0;i<list.size();i++){
            if(list.get(i).getId_cuenta()==id_cuenta && list.get(i).getId_persona()==id_persona){
                list.get(i).setId_persona(id_new_persona);
                writeTable(list);
                return true;
            }
        }
        return false;
        
    }
     public boolean update_cvp_cuenta(int id_cuenta,int id_persona,int id_new_cuenta) throws IOException{
        File file = new File(Rutas.path_origen_ingreso);
        ArrayList<Cuenta_vs_Persona> list = getLista(file);
        for(int i=0;i<list.size();i++){
            if(list.get(i).getId_cuenta()==id_cuenta && list.get(i).getId_persona()==id_persona){
                list.get(i).setId_cuenta(id_new_cuenta);
                writeTable(list);
                return true;
            }
        }
        return false;
        
    }
    
    public boolean delete(int id_cuenta,int id_persona) throws IOException{
        File file = new File(Rutas.path_cuenta_vs_persona);
        ArrayList<Cuenta_vs_Persona> list = getLista(file);
        for(int i=0;i<list.size();i++){
            if(list.get(i).getId_cuenta()==id_cuenta && list.get(i).getId_persona()==id_persona){
                list.remove(i);
                writeTable(list);
                return true;
            }
        }
        return false;
    }
    
    private void insert(int id_cuenta,int id_persona) throws IOException{
        File file = new File(Rutas.path_cuenta_vs_persona);
        if(Exists(file) && file.isFile()){
            String c_vs_p=geTextFile(file);
            FileWriter writer = new FileWriter(file);
            writer.write(c_vs_p+""+id_cuenta+","+id_persona+"\n");
            writer.flush();
        }
    }
    
    private void writeTable(ArrayList<Cuenta_vs_Persona> list) throws IOException{
        File file = new File(Rutas.path_origen_ingreso);
        delete(file);
        for(int j=0;j<list.size();j++){
            insert((list.get(j).getId_cuenta()), list.get(j).getId_persona());
        }
    }
}

 
    

