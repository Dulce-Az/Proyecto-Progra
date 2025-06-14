/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_a;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author az
 */
public class Usuario implements Serializable{
    public String nombre;
    public String password;
    public String rol; 
    public String usuario; 
    public ArrayList<telefono> telefonos=new ArrayList<>();
}
