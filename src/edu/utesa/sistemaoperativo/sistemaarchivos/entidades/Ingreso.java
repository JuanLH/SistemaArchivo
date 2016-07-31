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
import java.sql.Timestamp;
import java.util.ArrayList;
/**
 *
 * @author juanlht
 */
public class Ingreso extends FileManager {
    private int id_ingreso,id_cuenta,id_origen_ingreso,id_persona;
    private String time;
    private float monto;
    private String comentario;

    public Ingreso() {
    }
    
    public Ingreso(int id_ingreso, int id_cuenta, int id_origen_ingreso, int id_persona, float monto, String time, String comentario) {
        this.id_ingreso = id_ingreso;
        this.id_cuenta = id_cuenta;
        this.id_origen_ingreso = id_origen_ingreso;
        this.id_persona = id_persona;
        this.monto = monto;
        this.time = time;
        this.comentario = comentario;
    }    
    
    public int getId_ingreso() {
        return id_ingreso;
    }

    public int getId_persona() {
        return id_persona;
    }
    public int getId_cuenta_destino() {
        return id_cuenta;
    }
     public int getId_cuenta_origen() {
        return id_origen_ingreso;
    }
     public void setId_cuenta_origen(int id_cuenta_origen) {
        this.id_origen_ingreso = id_cuenta_origen;
    }
    public void setId_ingreso(int id_ingreso) {
        this.id_ingreso = id_ingreso;
    }

    public int getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public int getId_origen_ingreso() {
        return id_origen_ingreso;
    }

    public void setId_origen_ingreso(int id_origen_ingreso) {
        this.id_origen_ingreso = id_origen_ingreso;
    }

    

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    public String getPath_Ingreso() {
        return path_ingreso;
    }
    
    public ArrayList<Ingreso>  getLista (File file) throws FileNotFoundException, IOException{
        ArrayList<Ingreso> list = new ArrayList<Ingreso>();
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
            
            String id_ingreso,id_cuenta,id_origen_ingreso,id_persona,monto,time,comentario;
            id_ingreso=id_cuenta=id_origen_ingreso=id_persona=monto=time=comentario=null;
            String temp = null;
            
            for (int i = 0;i<count;i++)
            {
                char c = (char)bs[i];
                
                if(id_ingreso==null){    
                    if(c != ','){
                        if(temp==null)
                            temp=Character.toString(c);
                        else
                            temp=temp+c;
                        
                        continue;
                    }
                    else{
                        id_ingreso = temp;
                        temp = null;
                        continue;
                    }
                }
                
                if(id_cuenta==null){
                    if(c != ','){
                        if(temp==null)
                            temp=Character.toString(c);
                        else
                            temp+=c;
                        continue;
                    }
                    else{
                        id_cuenta = temp;
                        temp = null;
                        continue;
                    }
                }  
                
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
                
                list.add(new Ingreso(Integer.parseInt(id_ingreso), Integer.parseInt(id_cuenta), Integer.parseInt(id_origen_ingreso), Integer.parseInt(id_persona), Float.parseFloat(monto), time, comentario));
                id_ingreso=id_cuenta=id_origen_ingreso=id_persona=monto=time=comentario=null;
            }
            
        return list;
    }
    
   public void add(String id_cuenta,String id_origen_ingreso, String id_persona, String monto, String time, String comentario) throws IOException{
        File file = new File(path_ingreso);
       ArrayList<Ingreso> list = getLista(file);
        
        if(Exists(file) && file.isFile()){
            
            if(isEmpy(file)){
                prnln("-----------------------------");
              if(list.isEmpty()){
                    FileWriter writer;
                    writer = new FileWriter(file);
                    writer.write(1+","+id_cuenta+","+id_origen_ingreso+","+id_persona+","+monto+","+time+","+comentario+"\n");
                    writer.flush();
                    prnln("++Se inserto correctamente");
               }
                
            }
            else
            {
                //prnln("--------------**---------------");
                //prnln("size lista "+Integer.toString(list.size()));
                int id = list.get(list.size()-1).getId_ingreso(); 
                String per=geTextFile(file);
                //prn(""+per);
                FileWriter writer = new FileWriter(file);
                writer.write(per+""+(id+1)+","+id_cuenta+","+id_origen_ingreso+","+id_persona+","+monto+","+time+","+comentario+"\n");
                writer.flush();
                prnln("++Se inserto correctamente");
            }
        }       
    }
    
    public boolean update(int id,String id_cuenta,String id_origen_ingreso,String id_persona, String monto, String time, String comentario) throws IOException{
        File file = new File(path_ingreso);
        ArrayList<Ingreso> list = getLista(file);
        for(int i=0;i<list.size();i++){
            if(list.get(i).getId_ingreso()==id){
                list.get(i).setId_cuenta(Integer.parseInt(id_cuenta));
                list.get(i).setId_origen_ingreso(Integer.parseInt(id_origen_ingreso));
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
    
    private void insert(String id,String id_cuenta,String id_origen_ingreso,String id_persona, String monto, String time, String comentario) throws IOException{
        File file = new File(path_ingreso);
        if(Exists(file) && file.isFile()){
            String ingreso=geTextFile(file);
            FileWriter writer = new FileWriter(file);
            writer.write(ingreso+""+id+","+id_cuenta+","+id_origen_ingreso+","+id_persona+","+monto+","+time+","+comentario+"\n");
            writer.flush();
        }
    }
    
    private void writeTable(ArrayList<Ingreso> list) throws IOException{
        File file = new File(path_ingreso);
        delete(file);
        for(int j=0;j<list.size();j++){
            insert(Integer.toString(list.get(j).getId_ingreso()), 
                    Integer.toString(list.get(j).getId_cuenta()), 
                    Integer.toString(list.get(j).getId_origen_ingreso()), 
                    Integer.toString(list.get(j).getId_persona()), 
                    Float.toString(list.get(j).getMonto()),        
                    list.get(j).getTime(),
                    list.get(j).getComentario());
        }
    }
    
    public boolean delete(int id) throws IOException{
        File file = new File(path_ingreso);
        ArrayList<Ingreso> list = getLista(file);
        for(int i=0;i<list.size();i++){
            if(list.get(i).getId_ingreso()==id){
                list.remove(i);
                writeTable(list);
                return true;
            }
        }
        return false;
    }
}