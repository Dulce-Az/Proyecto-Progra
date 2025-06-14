/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_a;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author az
 */
class regisVen implements Serializable{
    public String libro;  
    public int cantidad;
    public double total;
    public Date fecha;

    

    public regisVen(Date fecha, String libro, int cantidad, double total) {
        this.fecha = fecha;
        this.libro = libro;  
        this.cantidad = cantidad;
        this.total = total;
    }

   public regisVen(){
       this.fecha=new Date();
       this.libro = "";
       this.cantidad = 0;
       this.total = 0.0;
   }

    
}