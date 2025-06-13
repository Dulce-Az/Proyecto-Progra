/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyecto_a;
import java.util.ArrayList;

/**
 *
 * @author az
 */
public class Proyecto_A {
    
    public static ArrayList<Usuario> usuarios=new ArrayList<>();
    public static ArrayList<libro> inventarioLibros=new ArrayList<>();
    public static ArrayList<Cupon> cuponesdescuento =new ArrayList<>();
    public static ArrayList<regisVen>RegistroVenta=new ArrayList<>();
   public static ArrayList<VentaCompleta>ConsultaVenta = new ArrayList<>();
   public static ArrayList<Proveedor>Proveedor= new ArrayList<>();
   public static ArrayList<regisVen>InformeLibros=new ArrayList<>();

    public static void main(String[] args) {
        
        Usuario admin=new Usuario();
        admin.nombre="admin";
        admin.password="admin";
        admin.rol="A";
        admin.usuario="admin";
        usuarios.add(admin);
        
        
        
        login l=new login();
        l.setVisible(true);
        
        
    }

  
   
    }
    

