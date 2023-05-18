package Control;

import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Dan
 */

import Modelo.Usuario;
import java.sql.*;
import java.util.ArrayList;

public class UsuarioController {
    private Connection conn = null;
    private PreparedStatement ps = null;

    public UsuarioController(Connection conn) {
        this.conn = conn;
    }

    public ArrayList<Usuario> listarUsuarios() {
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();

        try {
            String sql = "SELECT * FROM usuarios";
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario(
                    rs.getInt("id_usuario"),
                    rs.getString("nombre"),
                    rs.getString("correo"),
                    rs.getString("contrasena"),
                    rs.getInt("edad"),
                    rs.getString("tipo_usuario"),
                    rs.getDouble("dinero")
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
            ps = conn.prepareStatement(sql);
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

    public void editarUsuario(Usuario usuario) {
        try {
            String sql = "UPDATE usuarios SET nombre=?, correo=?, contrasena=? WHERE id=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getCorreo());
            ps.setString(3, usuario.getContrasena());
//            ps.setInt(4, usuario.getIdUsuario());
            ps.executeUpdate();

            ps.close();
            System.out.println("Usuario editado exitosamente");
        } catch (SQLException e) {
            System.out.println("Error al editar el usuario: " + e.getMessage());
        }
    }

    public void eliminarUsuario(int idUsuario) {
        try {
            String sql = "DELETE FROM usuarios WHERE id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idUsuario);
            ps.executeUpdate();

            ps.close();
            System.out.println("Usuario eliminado exitosamente");
        } catch (SQLException e) {
            System.out.println("Error al eliminar el usuario: " + e.getMessage());
        }
    }
    
    public Usuario buscarUsuario(String id ){
        Usuario usu;
//        = new Usuario()
        return usu;
    }
}
