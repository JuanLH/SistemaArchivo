/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utesa.sistemaoperativo.sistemaarchivos.utilidades;

/**
 *
 * @author JuanL
 */
public class Security {
   public static String encrypt(String message){
        int codascii;
        char[] array = message.toCharArray();

        for(int x = 0; x<array.length;x++){
            codascii = array[x];

            codascii = codascii * 2;
            array[x]= (char) codascii;
        }

        for(int x = 0; x<array.length;x++){
            codascii = array[x];
            codascii = codascii - 50;
            array[x]= (char) codascii;
        }


        for(int x = 0; x<array.length;x++){
            codascii = array[x];
            codascii = codascii + 5;
            array[x]= (char) codascii;
        }


        return message.valueOf(array);
    }

    public static String decrypt(String message){
        int codascii;
        char[] array = message.toCharArray();



        for(int x = 0; x<array.length;x++){
            codascii = array[x];
            codascii = codascii - 5;
            array[x]= (char) codascii;
        }


        for(int x = 0; x<array.length;x++){
            codascii = array[x];
            codascii = codascii + 50;
            array[x]= (char) codascii;
        }


        for(int x = 0; x<array.length;x++){
            codascii = array[x];
            codascii = codascii / 2;
            array[x]= (char) codascii;
        }




        return message.valueOf(array);
    }
    
}
