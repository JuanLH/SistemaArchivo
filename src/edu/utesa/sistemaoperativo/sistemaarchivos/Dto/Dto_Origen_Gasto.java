/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utesa.sistemaoperativo.sistemaarchivos.Dto;


import edu.utesa.sistemaoperativo.sistemaarchivos.entidades.Origen_gasto;

/**
 *
 * @author juanlht
 */
public class Dto_Origen_Gasto {
    
    public static Origen_gasto ori =  new Origen_gasto();

     public static Origen_gasto getOrigen_gasto() {
        return ori;
    }

    public static void setOrigen_gasto(Origen_gasto ori) {
        Dto_Origen_Gasto.ori = ori;
    }
    
}
