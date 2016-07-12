/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utesa.sistemaoperativo.sistemaarchivos.Dto;

import edu.utesa.sistemaoperativo.sistemaarchivos.entidades.Cuenta;

/**
 *
 * @author Eduardo Liz
 */
public class Dto_Cuenta {
    static Cuenta cuenta =  new Cuenta();

     public static Cuenta getCuenta() {
        return cuenta;
    }

    public static void setCuenta(Cuenta cuenta) {
        Dto_Cuenta.cuenta = cuenta;
    }
}
