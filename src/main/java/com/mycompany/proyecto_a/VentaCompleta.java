/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_a;

import java.util.Date;

/**
 *
 * @author az
 */
public class VentaCompleta {
    public String nit;
    public String nombreCliente;
    public String direccion;
    public Date fechaHora;
    public double totalConIva;
    public double totalSinIva;
    
    public VentaCompleta(String nit, String nombre, String direccion, double totalConIva, double totalSinIva) {
        this.nit = nit;
        this.nombreCliente = nombre;
        this.direccion = direccion;
        this.fechaHora = new Date(); // Fecha y hora actual
        this.totalConIva = totalConIva;
        this.totalSinIva = totalSinIva;
    }

  
}
