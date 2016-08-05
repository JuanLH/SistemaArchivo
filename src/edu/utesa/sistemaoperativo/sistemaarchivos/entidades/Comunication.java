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
        File file=null;
        
        switch (soli.getGrupo()){
            case "Grupo 3":
                file = new File(Rutas.G1_G3_solicitudG1);
            break;
            
            case "Grupo 2":
               file = new File(Rutas.G1_G2_solicitudG1);
            break;     
        }
       
        FileWriter writer;
        writer = new FileWriter(file);
        Gson json = new Gson();
        String mensage = json.toJson(soli);
        prnln("Mensage "+mensage);
        mensage = Security.encrypt(mensage);
        prnln("Mensage encriptado "+mensage);
        writer.write(mensage);
        writer.flush();
        prnln("++Se inserto correctamente");
    }
    
    public void readRequest() throws IOException{
        File soliG2 = new File(Rutas.G1_G2_solicitudG2);
        File soliG3 = new File(Rutas.G1_G3_solicitudG3);
        if(!isEmpy(soliG2)){
            String peticion = getLineFile(soliG2);
            Gson json = new Gson();
            prnln("Peticion G2 encriptada --> "+peticion);
            String mensage = Security.decrypt(peticion);
            prnln("Peticion G2 decriptada --> "+mensage);
            solicitud soli = json.fromJson(mensage, solicitud.class);
            prnln("Grupo --> "+soli.getGrupo());
            prnln("Tabla --> "+soli.getTabla());
            makeResponse(soli);
        }
        
        if(!isEmpy(soliG3)){
            String peticion = getLineFile(soliG3);
            Gson json = new Gson();
            prnln("Peticion  G3 encriptada --> "+peticion);
            String mensage = Security.decrypt(peticion);
            prnln("Peticion G3 decriptada --> "+mensage);
            solicitud soli = json.fromJson(mensage, solicitud.class);
            prnln("Grupo --> "+soli.getGrupo());
            prnln("Tabla --> "+soli.getTabla());
            makeResponse(soli);
        }
        
        
        
        
    }
    
    
    public void makeResponse(solicitud soli) throws IOException{
        respuesta response;
        Gson json = new Gson();
        
        switch(soli.getTabla()){
            case "Cuenta":
                Cuenta cuenta = new Cuenta();
                ArrayList<Cuenta> list =cuenta.getLista(new File(Rutas.path_cuenta));
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
                ArrayList<Gasto> listGasto =gasto.getLista(new File(Rutas.path_gasto));
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
                ArrayList<Ingreso> listIng = ingreso.getLista(new File(Rutas.path_ingreso));
                if(listIng.isEmpty()){
                    response = new respuesta(0, soli.getGrupo(), "no hay resultados");
                }else
                {
                    response = new respuesta(1, soli.getGrupo(),json.toJson(listIng));
                }
                writeResponse(response);
            break;
            
            case "Cuenta_vs_Persona":  
                Cuenta_vs_Persona c_vs_p = new Cuenta_vs_Persona();
                ArrayList<Cuenta_vs_Persona> listC_vs_p = c_vs_p.getLista(new File(Rutas.path_cuenta_vs_persona));
                if(listC_vs_p.isEmpty()){
                    response = new respuesta(0, soli.getGrupo(), "no hay resultados");
                }else
                {
                    response = new respuesta(1, soli.getGrupo(),json.toJson(listC_vs_p));
                }
                writeResponse(response);
            break;
            
            case "Origen_gasto":  
                Origen_gasto origenG = new Origen_gasto();
                ArrayList<Origen_gasto> listOrigenG = origenG.getLista(new File(Rutas.path_origen_gasto));
                if(listOrigenG.isEmpty()){
                    response = new respuesta(0, soli.getGrupo(), "no hay resultados");
                }else
                {
                    response = new respuesta(1, soli.getGrupo(),json.toJson(listOrigenG));
                }
                writeResponse(response);
            break;
            
            case "Origen_ingreso":  
                Origen_ingreso origenI = new Origen_ingreso();
                ArrayList<Origen_ingreso> listOrigenI = origenI.getLista(new File(Rutas.path_ingreso));
                if(listOrigenI.isEmpty()){
                    response = new respuesta(0, soli.getGrupo(), "no hay resultados");
                }else
                {
                    response = new respuesta(1, soli.getGrupo(),json.toJson(listOrigenI));
                }
                writeResponse(response);
            break;
            
            case "Persona":  
                Persona persona = new Persona();
                ArrayList<Persona> listPersona = persona.getLista(new File(Rutas.path_persona));
                if(listPersona.isEmpty()){
                    response = new respuesta(0, soli.getGrupo(), "no hay resultados");
                }else
                {
                    response = new respuesta(1, soli.getGrupo(),json.toJson(listPersona));
                }
                writeResponse(response);
            break;
            
            case "Tipo_cuenta":  
                Tipo_cuenta tp = new Tipo_cuenta();
                ArrayList<Tipo_cuenta> listTp = tp.getLista(new File(Rutas.path_tipo_cuenta));
                if(listTp.isEmpty()){
                    response = new respuesta(0, soli.getGrupo(), "no hay resultados");
                }else
                {
                    response = new respuesta(1, soli.getGrupo(),json.toJson(listTp));
                }
                writeResponse(response);
            break;
            
            case "Transferencia":  
                Transferencia trans = new Transferencia();
                ArrayList<Transferencia> listTrans = trans.getLista(new File(Rutas.path_transferencia));
                if(listTrans.isEmpty()){
                    response = new respuesta(0, soli.getGrupo(), "no hay resultados");
                }else
                {
                    response = new respuesta(1, soli.getGrupo(),json.toJson(listTrans));
                }
                writeResponse(response);
            break;
            
            default:
                response = new respuesta(-1, soli.getGrupo(),"Error La tabla "+soli.getTabla()+" no existe");
                writeResponse(response);
            break;
        }
    }
    
    public void writeResponse(respuesta response) throws IOException{
        File file=null;
        switch (response.getGrupo()){
            case "Grupo 2":
                file = new File(Rutas.G1_G2_respuestaG1);
            break;
            case "Grupo 3":
                 file = new File(Rutas.G1_G3_respuestaG1);
            break;    
        }
        
        FileWriter writer;
        writer = new FileWriter(file);
        Gson json = new Gson();
        String mensage = json.toJson(response);
        prnln(mensage);
        mensage = Security.encrypt(mensage);
        prnln(mensage);
        writer.write(mensage);
        writer.flush();
        prnln("++Se inserto correctamente");
    }
}
