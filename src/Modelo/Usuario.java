/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Lab redes
 */
public class Usuario {

    private int id = 0;
    private String nombre;
    private String correo;
    private String contrasena;
    private int edad;
    private String tipo_usuario;
    private float dinero;
    
    public Usuario(int id, String nombre, String correo, String contrasena, int edad, String tipo_usuario, float dinero) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.edad = edad;
        this.tipo_usuario = tipo_usuario;
        this.dinero = dinero;
    }
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the contrasena
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * @param contrasena the contrasena to set
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @return the tipo_usuario
     */
    public String getTipo_usuario() {
        return tipo_usuario;
    }

    /**
     * @param tipo_usuario the tipo_usuario to set
     */
    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    /**
     * @return the dinero
     */
    public float getDinero() {
        return dinero;
    }

    /**
     * @param dinero the dinero to set
     */
    public void setDinero(float dinero) {
        this.dinero = dinero;
    }

    String getContraseña() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
    public String toString(){
        return "Id = " + this.id + ", Nombre = " + this.nombre + ", correo = " + this.correo + ", Edad = " + this.edad + ", Tipo usuario = " + this.tipo_usuario + ", dinero " + this.dinero;
    }
}
