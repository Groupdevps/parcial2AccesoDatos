/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Helper.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Dan
 */
public class UsuarioBodega {
    Connection conn;
    
    Scanner cs = new Scanner(System.in);
    public UsuarioBodega() {
        Conectar conectar = new Conectar("jdbc:mysql://localhost/parcial",
                                 "aviloria", 
                                 "12345678");
        this.conn = conectar.getConexion();
//        System.out.println(this.conn);
    }
    
    public int addusuario(Usuario us){
        int rest=0;
        try{
            String query = "INSERT INTO usuario (nombre,correo, contrasena,edad, tipo_usuario, dinero) VALUES (?,?,?,?,?,?)";
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setString(1,us.getNombre() );
                ps.setString(2,us.getCorreo());
                ps.setString(3,us.getContrasena());
                ps.setInt(4, us.getEdad());
                ps.setString(5, us.getTipo_usuario());
                ps.setFloat(6, us.getDinero());
                rest = ps.executeUpdate();
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return rest;
    }
    
    public ArrayList<Usuario> listarUsuarios() {
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();

        try {
            String sql = "SELECT * FROM usuario";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("correo"),
                    rs.getString("contrasena"),
                    rs.getInt("edad"),
                    rs.getString("tipo_usuario"),
                    rs.getFloat("dinero")
                );
                listaUsuarios.add(usuario);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al listar los usuarios: " + e.getMessage());
        }

        return listaUsuarios;
    }

    public void agregarUsuario(Usuario usuario) {
        try {
            String sql = "INSERT INTO usuarios (nombre, correo, contrasena, edad, tipo_usuario, dinero) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getCorreo());
            ps.setString(3, usuario.getContrasena());
            ps.setInt(4, usuario.getEdad());
            ps.setString(5, usuario.getTipo_usuario());
            ps.setDouble(6, usuario.getDinero());
            ps.executeUpdate();

            ps.close();
            System.out.println("Usuario agregado exitosamente");
        } catch (SQLException e) {
            System.out.println("Error al agregar el usuario: " + e.getMessage());
        }
    }

    public int editarUsuario(Usuario usuario) {
        int editado = 0;
        try {
            String sql = "UPDATE usuario SET nombre=?, correo=?, contrasena=?, edad=?, tipo_usuario=?, dinero=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getCorreo());
            ps.setString(3, usuario.getContrasena());
            ps.setInt(4, usuario.getEdad());
            ps.setString(5, usuario.getTipo_usuario());
            ps.setFloat(6, usuario.getDinero());
            ps.setInt(7, usuario.getId());
            editado = ps.executeUpdate();
            
            
            ps.close();
//            System.out.println("Usuario editado exitosamente");
        } catch (SQLException e) {
            System.out.println("Error al editar el usuario: " + e.getMessage());
        }
        return editado;
    }

    public int eliminarUsuario(int idUsuario) {
        int rest = 0;
        try {
            String sql = "DELETE FROM usuario WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idUsuario);
            rest = ps.executeUpdate();

            ps.close();
            System.out.println("Usuario eliminado exitosamente");
        } catch (SQLException e) {
            System.out.println("Error al eliminar el usuario: " + e.getMessage());
        }
        return rest;
    }
    
    public Usuario buscarUsuarioNombre(String nombre ){
        Usuario usu = null;

        try {
            String sql = "SELECT * FROM usuario where nombre=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
//            System.out.println(rs);
            if(rs.next()){
                usu = new Usuario(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("correo"),
                    rs.getString("contrasena"),
                    rs.getInt("edad"),
                    rs.getString("tipo_usuario"),
                    rs.getFloat("dinero")
                );
            }else{
                usu = null;
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al buscar usuario: " + e.getMessage());
        }
        return usu;
    }
    
    public Usuario buscarUsuarioId(String id ){
        Usuario usu = null;

        try {
            String sql = "SELECT * FROM usuario where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
//            System.out.println(rs);
            if(rs.next()){
                usu = new Usuario(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("correo"),
                        rs.getString("contrasena"),
                        rs.getInt("edad"),
                        rs.getString("tipo_usuario"),
                        rs.getFloat("dinero")
                    );
            }else{
                usu = null;
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al buscar usuario: " + e.getMessage());
        }
        return usu;
    }
}
