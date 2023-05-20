/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Control.UsuarioController;
import Helper.Md5;
import Modelo.Usuario;
import java.util.Scanner;

/**
 *
 * @author Dan
 */
public class VistaLogin {
    Scanner sc = new Scanner(System.in);
    String nombre;
    String password;
    
    public VistaLogin() {
        boolean login = true;        
        Usuario user = null;
        
        UsuarioController usuCon = new UsuarioController();
        Md5 helperMd5 = new Md5();
        
        while(login){
            System.out.println(" ****** Login *********");
            System.out.println("nombre : ");
            nombre = sc.next();
            System.out.println("Contrasena : ");
            password = sc.next();
            user = usuCon.buscarUsuario(nombre);
            // Validar usuario
            if(user != null){
                String hashPassword = helperMd5.getMd5(password);
                // Verificar contrasena                 
                if (hashPassword.equals(user.getContrasena())){   
                    System.out.println("**************** Usuario logueado ***********");
                    System.out.println("Bienvenido " + user.getNombre());
                    System.out.println("*********************************************");
                    if (user.getTipo_usuario().equals("admin")){//
                        MenuAdmin admin = new MenuAdmin(user);
                        admin.mostrarMenu();
                    }else{
                        MenuUsuario usuario = new MenuUsuario(user);
                        usuario.MostrarMenu();
                    }
                }else{
                    System.out.println("Contrasena Incorrecta ! Intente de nuevo");
                }
            }else{
                System.out.println("Usuario no encontrado ");
            }   
            System.out.println("***************************************");
        }
    }
     
    public void Menu(){        
        int op=0;
        while (op!=5){
            System.out.println("MENU");
            System.out.println("1. Crear Usuario");
            System.out.println("2. Listar Usuario");
            System.out.println("3. Eliminar Usuario");
            System.out.println("4. Modificar Usuario");
            System.out.println("5. Salir");
            System.out.println("OP: ----> ");
            op = sc.nextInt();
            switch(op){
                case 1:
//                    this.CrearUsuario();
                    break;
                case 2:
//                    this.ListarUsuario();
                    break;               
                
                default:
                    break;        
            }
        }
        
        
    }
}
