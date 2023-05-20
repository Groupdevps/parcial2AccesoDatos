/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Control.BodegaController;
import Control.CompraController;
import Control.UsuarioController;
import Modelo.Bodega;
import Modelo.Usuario;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Dan
 */
public class MenuUsuario {
    private Usuario user = null;
    private int opcion = 1;
    private Scanner scanner;
    Scanner sc = new Scanner(System.in);
    UsuarioController  uc = new UsuarioController();
    BodegaController bod = new BodegaController();
    CompraController compra = new CompraController();

    public MenuUsuario( Usuario usr){
        this.user = usr;       
    }
    
    public void MostrarMenu(){
        System.out.println("=== Panel de Usuario ===");
        System.out.println("----- Modificar -----");            
        System.out.println("1. Modificar usuario");
        System.out.println("----- Realizar compra -----");            
        System.out.println("2. Listar productos");
        System.out.println("0. Salir");
        opcion = sc.nextInt();
        switch(opcion){
            case 1:
                this.modificarUsuario();
                break;
            case 2:
                this.listarProductos();             
                break;
            default:
                break;   
        }
    }
    
    public void modificarUsuario(){
        int op;
        String id = Integer.toString(this.user.getId());
        Usuario usu = uc.buscarUsuarioId(id);
        if (usu != null){
            System.out.println("---->"+usu.toString());
            System.out.println("Nombre : ");
            usu.setNombre(sc.next()); 
            System.out.println("Contraseña : ");
            usu.setContrasena(sc.next());
            if  (uc.modificarUsuario(usu)==1){
                System.out.println("Datos de usario editados con exito");
            }else{
                System.out.println("No se edito usuario");
            }
        }else{
            System.out.println("No se encontro el usuario");
        }
        
        
        
        System.out.println("1. Regresar al Menu Principal");
        System.out.println("2. Editar Usuario");
        op = sc.nextInt();
        if (op==1)this.MostrarMenu();
        if (op==2)this.modificarUsuario();
    }
    
    public void listarProductos(){
         int op;
        ArrayList<Bodega> productos = this.bod.ListarProductos();        
        System.out.println("Digite codigo del producto : ");
        String codigo = sc.next();
        Bodega bod = this.bod.buscarProducto(codigo);
        // validar producto
        if(bod != null){
            System.out.println(bod.toString());
            // Confirmar restriccion de edad
            if(this.user.getEdad() >= bod.getRestriccion_edad()){
                System.out.println("Digite numero de cajas : ");
                int numero = sc.nextInt();
                // Verificar stock
                int cajas = bod.getNumero_cajas() - numero; 
                if (cajas >= 0){
                    float total = numero * bod.getPrecio_caja();
                    bod.setNumero_cajas(cajas);
                    int res = this.compra.comprar(codigo, numero, total, bod);
                    if (res == 1){
                        float restante = this.user.getDinero() - total;
                        System.out.println("La Compra ha sido Exitosa! ");
                        System.out.println("Su nuevo saldo es : $" + restante);
                        System.out.println("Cajas en Stock : "+ cajas);
                        this.user.setDinero(restante);
                        uc.modificarUsuario(this.user);
                    }else{
                        System.out.println("No se ha podido completar su compra");
                    }
                }else{
                    System.out.println("El numero de cajas solicitado excede las existencias");
                }
            }else{
                System.out.println("El usuario no cumple con el requisito de edad");
            }
        }else{
            System.out.println("Producto no existe");
        }
        
        System.out.println("1. Regresar al Menu Principal");        
        System.out.println("2. Listar nuevamente");
        op = sc.nextInt();
        if (op==1)this.MostrarMenu();        
        if (op==2)this.listarProductos();
    }
    
}
