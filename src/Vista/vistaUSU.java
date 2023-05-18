/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

/**
 *
 * @author Dan
 */

import Control.UsuarioController;
import java.util.Scanner;
import control.*;
import helper.onectar;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.security.NoSuchAlgorithmException;

public class vistaUSU {
    Scanner sc = new Scanner(System.in);
    String nombre,correo, contraseña, edad, tipoUSU, dinero;
    UsuarioController  uc = new UsuarioController();
    
    public vistaUSU() {
        menu();
    }
    
    
    public void menu(){
        int op=0;
        while (op!=5){
            System.out.println("MENU");
            System.out.println("1. Crear Usuario");
            System.out.println("2. Listar Usuario");
            System.out.println("3. Eliminar Usuario");
            System.out.println("4. Modificar Usuario");
            System.out.println("5. Salir");
            System.out.print("OP: ----> ");
            op = sc.nextInt();
            switch(op){
                case 1:
                    this.CrearUsuario();
                    break;
                case 2:
                    this.listarUsuario();
                                               
                    break;
                case 3:
                    this.eliminarUsuario();
                    
                    break;
                case 4:
                    this.modificarUsuario();
                    break;
                default:
                    break;        
            }
    }
    }
    public void CrearUsuario(){
          int op; 
          System.out.println("<<<<<Crear Usuario>>>>>");
          System.out.println("Nombre");
          this.nombre = sc.next(); 
          System.out.println("Correo Electronico");
          this.correo= sc.next();
          System.out.println("Contraseña");
          this.contraseña = sc.next();
          System.out.println("Edad");
          this.edad = sc.next();
          System.out.println("Tipo de Usuario");
          this.tipoUSU=sc.next();
          System.out.println("Cantidad de Dinero");
          this.dinero= sc.next();
          if(1==uc.CrearUsuario(nombre,correo,contraseña, edad,tipoUSU, dinero)){
              System.out.println("Usuario creado con exito");
          }else{
              System.out.println("Usuario no fue creado");
          }
          System.out.println("1. Regresar al Menu Principal");
          System.out.println("2. Crear otro Usuario");
          op = sc.nextInt();
          if (op==1)this.menu();
          if (op==2)this.CrearUsuario();    
    }
}
