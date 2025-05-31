/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_a;

/**
 *
 * @author az
 */
public class libro {

    
    
    public String titulo;
    public String autor;
    public String genero;
    public int precio;
    public int cantidadStock;
   
    public libro(String titulo, String autor, String genero, int precio, int cantidadStock){
     this.titulo=titulo;
     this.autor=autor;
     this.genero=genero;
     this.precio=precio;
     this.cantidadStock=cantidadStock;
    }

}