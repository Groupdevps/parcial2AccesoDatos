/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Helper.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Dan
 */
public class CompraBodega {
    Connection conn;

    public CompraBodega() {
        Conectar conectar = new Conectar("jdbc:mysql://localhost/parcial",
                                 "aviloria", 
                                 "12345678");
        this.conn = conectar.getConexion();
    }

    public int agregar(Compra us){
         int rest=0;
        try{
            String query = "INSERT INTO compra (fecha, codigoBodega, numero_cajas, total) VALUES (?,?,?,?)";
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setString(1,us.getFecha() );
                ps.setString(2,us.getCodigoBodega());
                ps.setInt(3,us.getNumero_cajas());
                ps.setFloat(4, us.getTotal());                
                rest = ps.executeUpdate();
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return rest;
    }
}
