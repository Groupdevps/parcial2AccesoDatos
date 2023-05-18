/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Dan
 */
public class Bodega {
    private String codigo;
    private String nombre;
    private int numero_cajas;
    private float precio_caja;
    private int restriccion_edad;

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
     * @return the numero_cajas
     */
    public int getNumero_cajas() {
        return numero_cajas;
    }

    /**
     * @param numero_cajas the numero_cajas to set
     */
    public void setNumero_cajas(int numero_cajas) {
        this.numero_cajas = numero_cajas;
    }

    /**
     * @return the precio_caja
     */
    public float getPrecio_caja() {
        return precio_caja;
    }

    /**
     * @param precio_caja the precio_caja to set
     */
    public void setPrecio_caja(float precio_caja) {
        this.precio_caja = precio_caja;
    }

    /**
     * @return the restriccion_edad
     */
    public int getRestriccion_edad() {
        return restriccion_edad;
    }

    /**
     * @param restriccion_edad the restriccion_edad to set
     */
    public void setRestriccion_edad(int restriccion_edad) {
        this.restriccion_edad = restriccion_edad;
    }
    
}
