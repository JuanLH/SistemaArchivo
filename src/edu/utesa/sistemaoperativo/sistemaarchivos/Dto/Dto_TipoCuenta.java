/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utesa.sistemaoperativo.sistemaarchivos.Dto;

import edu.utesa.sistemaoperativo.sistemaarchivos.entidades.Tipo_cuenta;

/**
 *
 * @author juanlht
 * Data Transfer Object
 */
public class Dto_TipoCuenta {
    static Tipo_cuenta tipo_cuenta =  new Tipo_cuenta();

     public static Tipo_cuenta getTipo_cuenta() {
        return tipo_cuenta;
    }

    public static void setTipo_cuenta(Tipo_cuenta tipo_cuenta) {
        Dto_TipoCuenta.tipo_cuenta = tipo_cuenta;
    }

  
    
    
    
}
