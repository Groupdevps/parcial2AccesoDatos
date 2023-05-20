/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Control.BodegaController;
import Control.UsuarioController;
import Modelo.Bodega;
import Modelo.Usuario;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Dan
 */
public class MenuAdmin {

    private Scanner scanner;
    private int opcion = 1;
    Usuario user = null;
    Scanner sc = new Scanner(System.in);
    UsuarioController  uc = new UsuarioController();
    BodegaController bod = new BodegaController();
    private String nombre,correo, contrasena, tipoUSU, codigo;
    private int edad, numero_cajas, restriccion;
    private float dinero, precio;

    public MenuAdmin(Usuario usr) {
        this.user = usr;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        
//        while(opcion !=0){
            System.out.println("=== Panel de Administrador ===");
            System.out.println("----- Manejo de usuarios -----");            
            System.out.println("1. Agregar usuario");
            System.out.println("2. Listar usuarios");
            System.out.println("3. Modificar usuario");
            System.out.println("4. Eliminar usuario");
            System.out.println(" --------- Bodega ------");
            System.out.println("5. Registrar cajas en la bodega");
            System.out.println("6. Ingresar cajas a la bodega");
            System.out.println("7. Sacar cajas de la bodega");
            System.out.println("8. Listar productos en la bodega");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();
             switch(opcion){
                case 1:
                    this.CrearUsuario();
                    break;
                case 2:
                    this.listarUsuario();             
                    break;
                case 3:
                    this.modificarUsuario();
                    break;
                case 4:
                    this.eliminarUsuario();
                    break;
                case 5:
                    this.registrarCaja();
                    break;
                case 6:
                    this.ingresarCaja();
                    break;
                case 7:
                    this.sacarCaja();
                    break;
                case 8:
                    this.listarProductos();
                    break;
                default:
                    break;        
            }
//        }
        

    }

    public String solicitarNombreAdministrador() {
        scanner.nextLine();
        System.out.print("Ingrese el nombre del nuevo administrador: ");
        return scanner.nextLine();
    }

    public String solicitarContraseñaAdministrador() {
        System.out.print("Ingrese la contraseña del nuevo administrador: ");
        return scanner.nextLine();
    }

    public String solicitarNombreUsuario() {
        scanner.nextLine();
        System.out.print("Ingrese el nombre del nuevo usuario: ");
        return scanner.nextLine();
    }

    public String solicitarContraseñaUsuario() {
        System.out.print("Ingrese la contraseña del nuevo usuario: ");
        return scanner.nextLine();
    }

    public String solicitarNombreProducto() {
        scanner.nextLine();
        System.out.print("Ingrese el nombre del producto: ");
        return scanner.nextLine();
    }

    public String solicitarCodigoProducto() {
        System.out.print("Ingrese el código del producto: ");
        return scanner.nextLine();
    }

    public int solicitarNumeroCajas() {
        System.out.print("Ingrese el número de cajas: ");
        return scanner.nextInt();
    }

    public double solicitarPrecioCaja() {
        System.out.print("Ingrese el precio de la caja: ");
        return scanner.nextDouble();
    }

    public int solicitarRestriccionEdad() {
        System.out.print("Ingrese la restricción de edad para compra: ");
        return scanner.nextInt();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarError(String error) {
        System.err.println(error);
    }
     public void CrearUsuario(){
          int op; 
          System.out.println("<<<<<Crear Usuario>>>>>");
          System.out.println("Nombre");
          this.nombre = sc.next(); 
          System.out.println("Correo Electronico");
          this.correo= sc.next();
          System.out.println("Contraseña");
          this.contrasena = sc.next();
          System.out.println("Edad");
          this.edad = sc.nextInt();
          System.out.println("Tipo de Usuario. 1 <- admin, 2 <- usuario ");
          this.tipoUSU=(sc.nextInt()==1)?"admin":"usuario";
          System.out.println("Cantidad de Dinero");
          this.dinero= sc.nextFloat();
          int res = uc.CrearUsuario(this.nombre,this.correo,this.contrasena, this.edad,this.tipoUSU, this.dinero);
          if(res==1){
              System.out.println("Usuario creado con exito");
          }else{
              System.out.println("Usuario no fue creado");
          }
          System.out.println("1. Regresar al Menu Principal");
          System.out.println("2. Crear otro Usuario");
          op = sc.nextInt();
          if (op==1)this.mostrarMenu();
          if (op==2)this.CrearUsuario();    
    }
    
    public void listarUsuario(){
        int op;
        ArrayList<Usuario> usuarios =uc.ListarUsuario();
        Iterator <Usuario> it = usuarios.iterator();
        while (it.hasNext()){
            Usuario usr = it.next();
            System.out.println(usr.toString());
            
        }
        System.out.println("1. Regresar al Menu Principal");
        System.out.println("2. Listar nuevamente");
        op = sc.nextInt();
        if (op==1)this.mostrarMenu();
        if (op==2)this.listarUsuario();
    }
    
    
    public void eliminarUsuario(){
        int op;
        System.out.println("Ingrese id a eliminar: ");
        String id = sc.next();
        Usuario usu = uc.buscarUsuarioId(id);
        if (usu != null){
            System.out.println("---->"+usu.toString());
            System.out.println("Desea eliminar el usuario Si(1) No(2):");
            op = sc.nextInt();
            if (op==1){
                uc.eliminar_usuario(Integer.parseInt(id));            
            }  
        }else{
            System.out.println("Usuario no existe");
        }                
        System.out.println("1. Regresar al Menu Principal");
        System.out.println("2. Eliminar usuario");

        op = sc.nextInt();
        if (op==1)this.mostrarMenu();
        if (op==2)this.eliminarUsuario();
    }
    
    public void modificarUsuario(){
        int op;
        System.out.println("Ingrese id a modificar: ");
        String id = sc.next();
        Usuario usu = uc.buscarUsuarioId(id);
        if (usu != null){
            System.out.println("---->"+usu.toString());
            System.out.println("Nombre");
            usu.setNombre(sc.next()); 
            System.out.println("Correo Electronico");
            usu.setCorreo(sc.next());
            System.out.println("Contraseña");
            usu.setContrasena(sc.next());
            System.out.println("Edad");
            usu.setEdad(sc.nextInt());
            System.out.println("Tipo de Usuario. 1 <- admin, 2 <- usuario ");
            usu.setTipo_usuario((sc.nextInt()==1)?"admin":"usuario");
            System.out.println("Cantidad de Dinero");
            usu.setDinero(sc.nextFloat());
            if  (uc.modificarUsuario(usu)==1){
                System.out.println("Usuario Editado");
            }else{
                System.out.println("No se edito a usuario");
            }
        }else{
            System.out.println("No se encontro el usuario");
        }
        
        
        
        System.out.println("1. Regresar al Menu Principal");
        System.out.println("2. Editar Usuario");
        op = sc.nextInt();
        if (op==1)this.mostrarMenu();
        if (op==2)this.modificarUsuario();
    }
    
    public void registrarCaja(){
        int op;
        System.out.println("<<<<< Registrar  >>>>>");
        System.out.println("Nombre producto : ");
        this.nombre = sc.next(); 
        System.out.println("Codigo producto : ");
        this.codigo = sc.next(); 
        System.out.println("Numero cajas: ");
        this.numero_cajas = sc.nextInt(); 
        System.out.println("Precio producto : ");
        this.precio = sc.nextFloat(); 
        System.out.println("Restriccion de edad : ");
        this.restriccion = sc.nextInt();       
        int res = this.bod.registrarProducto(
                this.codigo,
                this.nombre,
                this.numero_cajas,
                this.precio,
                this.restriccion
        );
        if(res==1){
              System.out.println("Producto registrado con exito");
        }else{
              System.out.println("Producto no fue registrado");
        }
        System.out.println("1. Regresar al Menu Principal");
        System.out.println("2. Registrar Producto");
        op = sc.nextInt();
        if (op==1)this.mostrarMenu();
        if (op==2)this.registrarCaja();
    }
    
    public void listarProductos(){
         int op;
        ArrayList<Bodega> productos = this.bod.ListarProductos();        
        System.out.println("1. Regresar al Menu Principal");
        System.out.println("2. Listar nuevamente");
        op = sc.nextInt();
        if (op==1)this.mostrarMenu();
        if (op==2)this.listarProductos();
    }
    
    public void ingresarCaja(){
        int op;
        System.out.println("Ingrese codigo de producto a ingresar: ");
        String codigo = sc.next();
        Bodega bod = this.bod.buscarProducto(codigo);
        if (bod != null){
            System.out.println("Numero cajas: ");
            this.numero_cajas = sc.nextInt(); 
            bod.setNumero_cajas(bod.getNumero_cajas() + this.numero_cajas);
            int res =this.bod.ingresarProducto(bod);
            if(res==1){
              System.out.println("Ingreso de cajas con exito");
            }else{
                System.out.println(" El ingreso de cajas no fue posible");
            }
        }else{
            System.out.println("No existe producto");
        }
        System.out.println("1. Regresar al Menu Principal");
        System.out.println("2. Ingresar Producto");
        op = sc.nextInt();
        if (op==1)this.mostrarMenu();
        if (op==2)this.ingresarCaja();        
    }
    
    
    public void sacarCaja(){
        int op;
        System.out.println("Ingrese codigo de producto a retirar: ");
        String codigo = sc.next();
        Bodega bod = this.bod.buscarProducto(codigo);
        if (bod != null){
            System.out.println("Numero cajas : ");
            this.numero_cajas = sc.nextInt(); 
            if(bod.getNumero_cajas() - this.numero_cajas >= 0 ){
                bod.setNumero_cajas(bod.getNumero_cajas() - this.numero_cajas);
                int res =this.bod.ingresarProducto(bod);
                if(res==1){
                    System.out.println("Numero de cajas retirado con exito");
                }else{
                    System.out.println("El ingreso de cajas no fue posible");
                }
            }else{
                System.out.println("No se puede retirar mas cajas de lo existente");
            }
           
        }else{
            System.out.println("No existe producto");
        }
        System.out.println("1. Regresar al Menu Principal");
        System.out.println("2. Sacar Producto");
        op = sc.nextInt();
        if (op==1)this.mostrarMenu();
        if (op==2)this.sacarCaja();        
    }
}