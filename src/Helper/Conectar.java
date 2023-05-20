/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Dan
 */
public class Conectar {
    private String cadena;
    private String usuario;
    private String password;
    public Conectar(String cadena, String usuario, String password) {
        this.cadena=cadena;
        this.password=password;
        this.usuario=usuario;
    }
    
    public Connection getConexion (){
        Connection con = null;
        try{
//          Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(this.cadena,this.usuario,this.password);
        }catch(Exception e){
            System.out.println(e.toString());
        }
        return con;
    }
}
