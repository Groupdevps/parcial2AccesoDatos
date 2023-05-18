/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import java.util.Scanner;

/**
 *
 * @author Dan
 */
public class MenuAdmin {

    private Scanner scanner;

    public MenuAdmin() {
        this.scanner = new Scanner(System.in);
    }

    public int mostrarMenu() {
        System.out.println("=== Panel de Administrador ===");
        System.out.println("1. Agregar nuevo administrador");
        System.out.println("2. Agregar nuevo usuario");
        System.out.println("3. Listar usuarios");
        System.out.println("4. Modificar usuario");
        System.out.println("5. Eliminar usuario");
        System.out.println("6. Registrar cajas en la bodega");
        System.out.println("7. Ingresar cajas a la bodega");
        System.out.println("8. Sacar cajas de la bodega");
        System.out.println("9. Listar cajas en la bodega");
        System.out.println("10. Salir");
        System.out.print("Ingrese su opción: ");
        return scanner.nextInt();
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
}