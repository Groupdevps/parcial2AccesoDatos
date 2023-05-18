/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Helper.Md5;
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
        boolean acceso = true;
        while(acceso){
            System.out.println(" ****** Login *********");
            System.out.println("nombre");
            nombre = sc.next();
            System.out.println("Contrasena");
            password = sc.next();
            
//            Md5.verificarContrasena(password, hassPassword); 
            
        }
        Menu();
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
                    this.CrearUsuario();
                    break;
                case 2:
                    this.ListarUsuario();
                    break;               
                
                default:
                    break;        
            }
        }
        
        
    }
}
