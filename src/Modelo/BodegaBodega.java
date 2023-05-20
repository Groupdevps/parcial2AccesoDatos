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

/**
 *
 * @author Dan
 */
public class BodegaBodega {
    Connection conn;

    public BodegaBodega() {
        Conectar conectar = new Conectar("jdbc:mysql://localhost/parcial",
                                 "aviloria", 
                                 "12345678");
        this.conn = conectar.getConexion();
    }
    public Bodega buscar(String codigo){
        Bodega bod = null;
        try {
            String sql = "SELECT * FROM bodega where codigo=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, codigo);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                bod = new Bodega(                        
                        rs.getString("codigo"),
                        rs.getString("nombre"),
                        rs.getInt("numero_cajas"),
                        rs.getFloat("precio_caja"),
                        rs.getInt("restriccion_edad")                        
                    );
            }else{
                bod = null;
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al buscar usuario: " + e.getMessage());
        }
        return bod;
    }
    
    
    public ArrayList<Bodega> Listar() {
        ArrayList<Bodega> lista = new ArrayList<>();

        try {
            String sql = "SELECT * FROM bodega";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                
                Bodega bodega = new Bodega(
                    rs.getString("codigo"),
                    rs.getString("nombre"),
                    rs.getInt("numero_cajas"),
                    rs.getFloat("precio_caja"),
                    rs.getInt("restriccion_edad")
                );
                System.out.println(bodega.toString());
                lista.add(bodega);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al listar los usuarios: " + e.getMessage());
        }

        return lista;
    }
    
    public int registrar(Bodega us){
        int rest=0;
        try{
            String query = "INSERT INTO bodega (nombre, codigo, numero_cajas, precio_caja, restriccion_edad) VALUES (?,?,?,?,?)";
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setString(1,us.getNombre() );
                ps.setString(2,us.getCodigo());
                ps.setInt(3,us.getNumero_cajas());
                ps.setFloat(4, us.getPrecio_caja());
                ps.setInt(5, us.getRestriccion_edad());          
                rest = ps.executeUpdate();
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return rest;
    }
    
    public int editar(Bodega us){
        int editado = 0;
        try {
            String sql = "UPDATE bodega SET nombre=?, numero_cajas=?, precio_caja=?, restriccion_edad=?  WHERE codigo=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, us.getNombre());
            ps.setInt(2, us.getNumero_cajas());
            ps.setFloat(3, us.getPrecio_caja());
            ps.setInt(4, us.getRestriccion_edad());
            ps.setString(5, us.getCodigo());            
            editado = ps.executeUpdate();
            ps.close();
//            System.out.println("Usuario editado exitosamente");
        } catch (SQLException e) {
            System.out.println("Error al editar bodega : " + e.getMessage());
        }
        return editado;
    }
}
