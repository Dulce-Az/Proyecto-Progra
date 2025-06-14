/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_a;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author az
 */
public class Persistencia {
    private static final String ARCHIVO_DATOS = "datos_proyecto.bin";
    private static final Path RUTA_ARCHIVO = Paths.get(System.getProperty("user.dir"),ARCHIVO_DATOS);
    
    public static void guardarDatos(){
       try {
            // Crear contenedor de datos
            Object[] datos = {
                Proyecto_A.usuarios,
                Proyecto_A.inventarioLibros,
                Proyecto_A.cuponesdescuento,
                Proyecto_A.RegistroVenta,
                Proyecto_A.ConsultaVenta,
                Proyecto_A.Proveedor
            };

            // Guardar con try-with-resources
            try (ObjectOutputStream escritor = new ObjectOutputStream(
                new FileOutputStream(RUTA_ARCHIVO.toFile()))) {
                escritor.writeObject(datos);
                System.out.println("Datos guardados en: " + RUTA_ARCHIVO.toAbsolutePath());
            }
        } catch (Exception e) {
            System.err.println("Error grave al guardar: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void cargarDatos() {
        if (!Files.exists(RUTA_ARCHIVO)) {
            System.out.println("Archivo de datos no existe. Se creará uno nuevo.");
            return;
        }

        try (ObjectInputStream lector = new ObjectInputStream(
            new FileInputStream(RUTA_ARCHIVO.toFile()))) {
            
            Object[] datos = (Object[]) lector.readObject();
            
            // Restaurar datos
            Proyecto_A.usuarios = (ArrayList<Usuario>) datos[0];
            Proyecto_A.inventarioLibros = (ArrayList<libro>) datos[1];
            Proyecto_A.cuponesdescuento = (ArrayList<Cupon>) datos[2];
            Proyecto_A.RegistroVenta = (ArrayList<regisVen>) datos[3];
            Proyecto_A.ConsultaVenta = (ArrayList<VentaCompleta>) datos[4];
            Proyecto_A.Proveedor = (ArrayList<Proveedor>) datos[5];
            
            System.out.println("Datos cargados correctamente desde: " + RUTA_ARCHIVO.toAbsolutePath());
        } catch (Exception e) {
            System.err.println("Error al cargar datos: " + e.getMessage());
            e.printStackTrace();
            inicializarDatosVacios();
        }
    }

    private static void inicializarDatosVacios() {
        Proyecto_A.usuarios = new ArrayList<>();
        Proyecto_A.inventarioLibros = new ArrayList<>();
        Proyecto_A.cuponesdescuento = new ArrayList<>();
        Proyecto_A.RegistroVenta = new ArrayList<>();
        Proyecto_A.ConsultaVenta = new ArrayList<>();
        Proyecto_A.Proveedor = new ArrayList<>();
    }
}
