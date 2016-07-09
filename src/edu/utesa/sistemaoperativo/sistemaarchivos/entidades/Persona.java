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
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanlht
 */
public class Persona extends FileManager {
    private int id_persona;
    String nombre,apellido,direccion,telefono;

    public Persona(int id_persona, String nombre, String apellido, String direccion, String telefono) {
        this.id_persona = id_persona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    
    public Persona() {}

    public String getPath_persona() {
        return path_persona;
    }
       
    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public boolean deletePersona(int id) throws IOException{
        File file = new File(path_persona);
        ArrayList<Persona> list = getListaPersona(file);
        for(int i=0;i<list.size();i++){
            if(list.get(i).getId_persona()==id){
                list.remove(i);
                writeTable(list);
                return true;
            }
        }
        return false;
    }
    public boolean updatePersona(int id,String nombre,String apellido,String direccion,String telefono) throws IOException{
        File file = new File(path_persona);
        ArrayList<Persona> list = getListaPersona(file);
        for(int i=0;i<list.size();i++){
            if(list.get(i).getId_persona()==id){
                list.get(i).setNombre(nombre);
                list.get(i).setApellido(apellido);
                list.get(i).setDireccion(direccion);
                list.get(i).setTelefono(telefono);
                
                writeTable(list);
                break;
            }
        }
        
        return true;
    }
    
    private void insertPersona(String id,String nombre,String apellido,String direccion,String telefono) throws IOException{
        File file = new File(path_persona);
        if(Exists(file) && file.isFile()){
            String per=geTextFile(file);
            FileWriter writer = new FileWriter(file);
            writer.write(per+""+id+","+nombre+","+apellido+","+direccion+","+telefono+"\n");
            writer.flush();
        }
    }
    
    public void addPersona(String nombre,String apellido,String direccion,String telefono) throws IOException{
        File file = new File(path_persona);
        ArrayList<Persona> list = getListaPersona(file);
        
        if(Exists(file) && file.isFile()){
            
            if(isEmpy(file)){
                prnln("-----------------------------");
                if(list.isEmpty()){
                    FileWriter writer;
                    writer = new FileWriter(file);
                    writer.write(1+","+nombre+","+apellido+","+direccion+","+telefono+"\n");
                    writer.flush();
                    prnln("++Se inserto correctamente");
                }
                
            }
            else
            {
                //prnln("--------------**---------------");
                //prnln("size lista "+Integer.toString(list.size()));
                int id = list.get(list.size()-1).getId_persona(); 
                String per=geTextFile(file);
                //prn(""+per);
                FileWriter writer = new FileWriter(file);
                writer.write(per+""+(id+1)+","+nombre+","+apellido+","+direccion+","+telefono+"\n");
                writer.flush();
                prnln("++Se inserto correctamente");
            }
        }
        
    }
    
    public ArrayList<Persona> getListaPersona(File file) throws FileNotFoundException, IOException{
        ArrayList<Persona> list = new ArrayList<Persona>();
  
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
            
            String id_persona,nombre,apellido,direccion,telefono;
            id_persona=nombre=apellido=direccion=telefono=null;
            String temp = null;
            
            for (int i = 0;i<count;i++)
            {
                char c = (char)bs[i];
                
                if(id_persona==null){    
                    if(c != ','){
                        if(temp==null)
                            temp=Character.toString(c);
                        else
                            temp=temp+c;
                        
                        continue;
                    }
                    else{
                        id_persona = temp;
                        temp = null;
                        continue;
                    }
                }
                
                if(nombre==null){
                    if(c != ','){
                        if(temp==null)
                            temp=Character.toString(c);
                        else
                            temp+=c;
                        continue;
                    }
                    else{
                        nombre = temp;
                        temp = null;
                        continue;
                    }
                }
                
                if(apellido==null){
                    if(c != ','){
                        if(temp==null)
                            temp=Character.toString(c);
                        else
                            temp+=c;
                        continue;
                    }
                    else{
                        apellido = temp;
                        temp = null;
                        continue;
                    }
                }
                
                if(direccion==null){
                    if(c != ','){
                        if(temp==null)
                            temp=Character.toString(c);
                        else
                            temp+=c;
                        continue;
                    }
                    else{
                        direccion = temp;
                        temp = null;
                        continue;
                    }
                }
                
                if(telefono==null){
                    if(c != '\n'){
                        if(temp==null)
                            temp=Character.toString(c);
                        else
                            temp+=c;
                        continue;
                    }
                    else{
                        telefono = temp;
                        temp = null;
                    }
                }
                
                
                list.add(new Persona(Integer.parseInt(id_persona), nombre, apellido, direccion, telefono));
                id_persona=nombre=apellido=direccion=telefono=null;
            }
        return list;
    }
    
    private void writeTable(ArrayList<Persona> list) throws IOException{
        File file = new File(path_persona);
        delete(file);
        for(int j=0;j<list.size();j++){
            insertPersona(Integer.toString(list.get(j).getId_persona()), list.get(j).getNombre(), list.get(j).getApellido(), list.get(j).getDireccion(), list.get(j).getTelefono());
        }
    }
  
    public void printTable() throws IOException{
        File file = new File(path_persona);
        ArrayList<Persona> list = getListaPersona(file);
        for(int i=0;i<list.size();i++){
            prnln(list.get(i).getId_persona()+" + "+list.get(i).getNombre()+" + "+list.get(i).getApellido()+" + "+list.get(i).getDireccion()+" + "+list.get(i).getTelefono());
        }
    }
    
    
}
