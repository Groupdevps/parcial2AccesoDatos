/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Helper.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Dan
 */
public class UsuarioBodega {
      Connection con;
    Scanner cs = new Scanner(System.in);
    public UsuarioBodega() {
        Conectar conectar = new Conectar("jdbc:mysql://localhost/tarea",
                                 "aviloria", 
                                 "12345678");
        this.con = conectar.getConexion();
    }
    
    public int addusuario(Usuario us){
        int rest=0;
        try{
            String query = "INSERT INTO usuarios (nombre,correo, contraseña,edad, tipoUSU, dinero) VALUES (?,?,?,?,?,?)";
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setString(1,us.getNombre() );
                ps.setString(2,us.getCorreo());
                ps.setString(3,us.getContraseña());
                ps.setString(4, us.getEdad());
                ps.setString(5, us.getTipo_usuario());
                ps.setString(6, us.getDinero());
                rest = ps.executeUpdate();
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return rest;
    }
}
