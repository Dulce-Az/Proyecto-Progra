/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_a;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author az
 */
public class Persistencia {
    private static final String ARCHIVO_DATOS = "datos_proyecto.bin";
    
    public static void guardarDatos(){
        try (FileOutputStream archivo = new FileOutputStream(ARCHIVO_DATOS);
                ObjectOutputStream escritor = new ObjectOutputStream(archivo)){
            
            Object [] datos = {
            Proyecto_A.usuarios,
            Proyecto_A.inventarioLibros,
            Proyecto_A.cuponesdescuento,
            Proyecto_A.RegistroVenta,
            Proyecto_A.ConsultaVenta,
            Proyecto_A.Proveedor
            };
        } catch (Exception e) {
            System.err.println("Error al guardar datos: " + e.getMessage());
        }
    }
    
    public static void cargarDatos(){
        try(FileInputStream archivo = new FileInputStream(ARCHIVO_DATOS);
            ObjectInputStream lector = new ObjectInputStream(archivo)) {
            
            Object[] datos = (Object[]) lector.readObject();
            
            Proyecto_A.usuarios = (ArrayList<Usuario>)datos[0];
            Proyecto_A.inventarioLibros = (ArrayList<libro>)datos[1];
            Proyecto_A.cuponesdescuento = (ArrayList<Cupon>)datos[2];
            Proyecto_A.RegistroVenta = (ArrayList<regisVen>)datos[3];
            Proyecto_A.ConsultaVenta = (ArrayList<VentaCompleta>)datos[4];
            Proyecto_A.Proveedor = (ArrayList<Proveedor>) datos[5];
        } catch (Exception e) {
            System.err.println("Error al cargar datos (se iniciará con datos vacios)" + e.getMessage());
            
            Proyecto_A.usuarios = new ArrayList<>();
            Proyecto_A.inventarioLibros = new ArrayList<>();
            Proyecto_A.cuponesdescuento = new ArrayList<>();
            Proyecto_A.RegistroVenta = new ArrayList<>();
            Proyecto_A.ConsultaVenta = new ArrayList<>();
            Proyecto_A.Proveedor = new ArrayList<>();
        }
    }
}
