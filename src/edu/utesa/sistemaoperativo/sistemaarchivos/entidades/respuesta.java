/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utesa.sistemaoperativo.sistemaarchivos.entidades;

/**
 *
 * @author JuanL
 */
public class respuesta {
    int estado;//estado de la respuesta 0 vacia , 1 correcto , -1 error
    String grupo;
    String respuesta;//Json respuesta

    public respuesta(int estado, String grupo, String respuesta) {
        this.estado = estado;
        this.grupo = grupo;
        this.respuesta = respuesta;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
    
    
    
}
