/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utesa.sistemaoperativo.sistemaarchivos.entidades;

import com.google.gson.Gson;
import edu.utesa.sistemaoperativo.sistemaarchivos.utilidades.Security;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author JuanL
 */
public class Comunication extends FileManager {
    
    public void writeRequest(solicitud soli) throws IOException{
        File file;
        /*
        if(soli.getGrupo().equals("Grupo 2")){
            file = new File("SolicitudGrupo2");
        }
        else
        {
            file = new File("SolicitudGrupo3");
        }*/
        
        
        /*Este es de prueba para grupo 1*/
       file = new File(path_peticion);
        FileWriter writer;
        writer = new FileWriter(file);
        Gson json = new Gson();
        writer.write(json.toJson(soli));
        writer.flush();
        prnln("++Se inserto correctamente");
    }
    
    public void readRequest() throws IOException{
        File file = new File(path_peticion);
        String peticion = geTextFile(file);
        Gson json = new Gson();
        prnln(peticion);
        solicitud soli = json.fromJson(peticion, solicitud.class);
        
        respuesta response;
        switch(soli.getTabla()){
            case "Cuenta":
                Cuenta cuenta = new Cuenta();
                ArrayList<Cuenta> list =cuenta.getLista(new File(path_cuenta));
                if(list.isEmpty()){
                    response = new respuesta(0, soli.getGrupo(), "no hay resultados");
                }else
                {
                    response = new respuesta(1, soli.getGrupo(),json.toJson(list));
                }
                writeResponse(response);
            break;
            
            case "Gasto":
                Gasto gasto = new Gasto();
                ArrayList<Gasto> listGasto =gasto.getLista(new File(path_gasto));
                if(listGasto.isEmpty()){
                    response = new respuesta(0, soli.getGrupo(), "no hay resultados");
                }else
                {
                    response = new respuesta(1, soli.getGrupo(),json.toJson(listGasto));
                }
                writeResponse(response);
            break;
            
            case "Ingreso":  
                Ingreso ingreso = new Ingreso();
                ArrayList<Ingreso> listIng = ingreso.getLista(new File(path_ingreso));
                if(listIng.isEmpty()){
                    response = new respuesta(0, soli.getGrupo(), "no hay resultados");
                }else
                {
                    response = new respuesta(1, soli.getGrupo(),json.toJson(listIng));
                }
                writeResponse(response);
            break;
            default:
                response = new respuesta(1, soli.getGrupo(),"Error La tabla "+soli.getTabla()+" no existe");
            break;
            
            
        }
        
    }
    
    
    public void writeResponse(respuesta response) throws IOException{
        File file;
        /*
        if(response.getGrupo().equals("Grupo 2")){
            file = new File("SolicitudGrupo2");
        }
        else{
            file = new File("SolicitudGrupo3");
        }
        */
        /*Este es de prueba para grupo 1*/
        file = new File(path_respuesta);
        FileWriter writer;
        writer = new FileWriter(file);
        Gson json = new Gson();
        writer.write(json.toJson(response));
        writer.flush();
        prnln("++Se inserto correctamente");
    }
}
