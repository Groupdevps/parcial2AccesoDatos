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
import Modelo.UsuarioBodega;
import java.sql.*;
import java.util.ArrayList;
import Helper.Md5;

public class UsuarioController {
    private UsuarioBodega usuBodega = new UsuarioBodega();
    private Md5 helperMd5 = new Md5();

    public UsuarioController() {
    
    }
    public Usuario buscarUsuario(String nombre){
        return this.usuBodega.buscarUsuarioNombre(nombre);
    }
    public Usuario buscarUsuarioId(String id){
        return this.usuBodega.buscarUsuarioId(id);
    }
    
    public int CrearUsuario(String nombre, String correo, String contrasena, int edad, String tipo_usuario, float dinero){
        Usuario usr = buscarUsuario(nombre);
        if (usr != null && usr.getNombre().equals(nombre)){
            System.out.println("Ya existe un usuario con mismo Nombre");
            return 0;
        }
        Usuario user = new Usuario(0,nombre, correo, helperMd5.getMd5(contrasena), edad, tipo_usuario, dinero);
        return usuBodega.addusuario(user);
    } 
    
    public ArrayList ListarUsuario(){
//       ArrayList<Usuario> listaUsuarios = new ArrayList<>();
       return usuBodega.listarUsuarios();
    }
    
    public void eliminar_usuario(int id){
        usuBodega.eliminarUsuario(id);
    }
    
    public int modificarUsuario(Usuario usr){
        Usuario user = buscarUsuario(usr.getNombre());
        if (user != null && user.getNombre().equals(usr.getNombre())){
            if (usr.getId() != (user.getId()) ){
                System.out.println("Ya existe un usuario con mismo Nombre");
                return 0;
            }            
        }
        usr.setContrasena(helperMd5.getMd5(usr.getContrasena()));
        return usuBodega.editarUsuario(usr);
    }
}
