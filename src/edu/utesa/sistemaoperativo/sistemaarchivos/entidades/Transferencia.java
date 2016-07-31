/*
 * To change this license header, choose License Headers in Project Properties.   
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utesa.sistemaoperativo.sistemaarchivos.entidades;

import java.sql.Timestamp;
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
public class Transferencia extends FileManager {
    private int id_transferencia,id_cuenta_origen,id_cuenta_destino,id_persona;
    private float monto;
    private String time;
    private String comentario;

    public Transferencia() {
    }
    
    public Transferencia(int id_transferencia, int id_cuenta_origen, int id_cuenta_destino, int id_persona, float monto, String time, String comentario) {
        this.id_transferencia = id_transferencia;
        this.id_cuenta_origen = id_cuenta_origen;
        this.id_cuenta_destino = id_cuenta_destino;
        this.id_persona = id_persona;
        this.monto = monto;
        this.time = time;
        this.comentario = comentario;
    }
    
    public int getId_transferencia() {
        return id_transferencia;
    }

    public void setId_transferencia(int id_transferencia) {
        this.id_transferencia = id_transferencia;
    }

    public int getId_cuenta_origen() {
        return id_cuenta_origen;
    }

    public void setId_cuenta_origen(int id_cuenta_origen) {
        this.id_cuenta_origen = id_cuenta_origen;
    }

    public int getId_cuenta_destino() {
        return id_cuenta_destino;
    }

    public void setId_cuenta_destino(int id_cuenta_destino) {
        this.id_cuenta_destino = id_cuenta_destino;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    public String getPath_transferencia() {
        return path_transferencia;
    }
    
    public ArrayList<Transferencia>  getLista (File file) throws FileNotFoundException, IOException{
        ArrayList<Transferencia> list = new ArrayList<Transferencia>();
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
            
            String id_transferencia,id_cuenta_origen,id_cuenta_destino,id_persona,monto,time,comentario;
            id_transferencia=id_cuenta_origen=id_cuenta_destino=id_persona=monto=time=comentario=null;
            String temp = null;
            
            for (int i = 0;i<count;i++)
            {
                char c = (char)bs[i];
                
                if(id_transferencia==null){    
                    if(c != ','){
                        if(temp==null)
                            temp=Character.toString(c);
                        else
                            temp=temp+c;
                        
                        continue;
                    }
                    else{
                        id_transferencia = temp;
                        temp = null;
                        continue;
                    }
                }
                
                if(id_cuenta_origen==null){
                    if(c != ','){
                        if(temp==null)
                            temp=Character.toString(c);
                        else
                            temp+=c;
                        continue;
                    }
                    else{
                        id_cuenta_origen = temp;
                        temp = null;
                        continue;
                    }
                }  
                
                if(id_cuenta_destino==null){    
                    if(c != ','){
                        if(temp==null)
                            temp=Character.toString(c);
                        else
                            temp=temp+c;
                        
                        continue;
                    }
                    else{
                        id_cuenta_destino = temp;
                        temp = null;
                        continue;
                    }
                }
                
                if(id_persona==null){
                    if(c != ','){
                        if(temp==null)
                            temp=Character.toString(c);
                        else
                            temp+=c;
                        continue;
                    }
                    else{
                        id_persona = temp;
                        temp = null;
                        continue;
                    }
                }  
                
                if(monto==null){
                    if(c != ','){
                        if(temp==null)
                            temp=Character.toString(c);
                        else
                            temp+=c;
                        continue;
                    }
                    else{
                        monto = temp;
                        temp = null;
                        continue;
                    }
                }
                
                if(time==null){
                    if(c != ','){
                        if(temp==null)
                            temp=Character.toString(c);
                        else
                            temp+=c;
                        continue;
                    }
                    else{
                        time = temp;
                        temp = null;
                        continue;
                    }
                }
                
                if(comentario==null){
                    if(c != '\n'){
                        if(temp==null)
                            temp=Character.toString(c);
                        else
                            temp+=c;
                        continue;
                    }
                    else{
                        comentario = temp;
                        temp = null;
                    }
                }
                
                list.add(new Transferencia(Integer.parseInt(id_transferencia), Integer.parseInt(id_cuenta_origen), Integer.parseInt(id_cuenta_destino), Integer.parseInt(id_persona), Float.parseFloat(monto), time, comentario));
                id_transferencia=id_cuenta_origen=id_cuenta_destino=id_persona=monto=time=comentario=null;
            }
            
        return list;
    }
    
    public void add(String id_cuenta_origen,String id_cuenta_destino, String id_persona, String monto, String time, String comentario) throws IOException{
        File file = new File(path_transferencia);
        ArrayList<Transferencia> list = getLista(file);
        
        if(Exists(file) && file.isFile()){
            
            if(isEmpy(file)){
                prnln("-----------------------------");
                if(list.isEmpty()){
                    FileWriter writer;
                    writer = new FileWriter(file);
                    writer.write(1+","+id_cuenta_origen+","+id_cuenta_destino+","+id_persona+","+monto+","+time+","+comentario+"\n");
                    writer.flush();
                    prnln("++Se inserto correctamente");
                }
                
            }
            else
            {
                //prnln("--------------**---------------");
                //prnln("size lista "+Integer.toString(list.size()));
                int id = list.get(list.size()-1).getId_transferencia();
                String transferencia=geTextFile(file);
                //prn(""+per);
                FileWriter writer = new FileWriter(file);
                writer.write(transferencia+""+(id+1)+","+id_cuenta_origen+","+id_cuenta_destino+","+id_persona+","+monto+","+time+","+comentario+"\n");
                writer.flush();
                prnln("++Se inserto correctamente");
            }
        }        
    }
    
    public boolean update(int id,String id_cuenta_origen,String id_cuenta_destino,String id_persona, String monto, String time, String comentario) throws IOException{
        File file = new File(path_transferencia);
        ArrayList<Transferencia> list = getLista(file);
        for(int i=0;i<list.size();i++){
            if(list.get(i).getId_transferencia()==id){
                list.get(i).setId_cuenta_origen(Integer.parseInt(id_cuenta_origen));
                list.get(i).setId_cuenta_destino(Integer.parseInt(id_cuenta_destino));
                list.get(i).setId_persona(Integer.parseInt(id_persona));
                list.get(i).setMonto(Float.parseFloat(monto));
                list.get(i).setTime(time);
                list.get(i).setComentario(comentario);
                writeTable(list);
                prnln("Se actualizo correctamente");
                return true;
            }
        }
        return false;        
    }
    
    private void insert(String id,String id_cuenta_origen,String id_cuenta_destino,String id_persona, String monto, String time, String comentario) throws IOException{
        File file = new File(path_transferencia);
        if(Exists(file) && file.isFile()){
            String transferencia=geTextFile(file);
            FileWriter writer = new FileWriter(file);
            writer.write(transferencia+""+id+","+id_cuenta_origen+","+id_cuenta_destino+","+id_persona+","+monto+","+time+","+comentario+"\n");
            writer.flush();
        }
    }
    
    private void writeTable(ArrayList<Transferencia> list) throws IOException{
        File file = new File(path_transferencia);
        delete(file);
        for(int j=0;j<list.size();j++){
            insert(Integer.toString(list.get(j).getId_transferencia()), 
                    Integer.toString(list.get(j).getId_cuenta_origen()), 
                    Integer.toString(list.get(j).getId_cuenta_destino()), 
                    Integer.toString(list.get(j).getId_persona()), 
                    Float.toString(list.get(j).getMonto()),        
                    list.get(j).getTime(),
                    list.get(j).getComentario());
        }
    }
    
    public boolean delete(int id) throws IOException{
        File file = new File(path_transferencia);
        ArrayList<Transferencia> list = getLista(file);
        for(int i=0;i<list.size();i++){
            if(list.get(i).getId_transferencia()==id){
                list.remove(i);
                writeTable(list);
                return true;
            }
        }
        return false;
    }
}
