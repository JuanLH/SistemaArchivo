/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utesa.sistemaoperativo.sistemaarchivos.Dto;

import edu.utesa.sistemaoperativo.sistemaarchivos.entidades.Persona;

/**
 *
 * @author Eduardo Liz
 */
public class Dto_Persona {
    static Persona persona =  new Persona();

     public static Persona getPersona() {
        return persona;
    }

    public static void setPersona(Persona persona) {
        Dto_Persona.persona = persona;
    }
}
