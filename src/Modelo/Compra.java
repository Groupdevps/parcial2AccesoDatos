/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Dan
 */
public class Compra {
    private int id;
    private String fecha;
    private String codigoBodega;
    private int numero_cajas;
    private float total;
    
    public Compra(int id, String fecha, String codigo, int numero, float total){
        this.id = id;
        this.fecha = fecha;
        this.codigoBodega = codigo;
        this.numero_cajas = numero;
        this.total = total;
    }

    public String getCodigoBodega() {
        return codigoBodega;
    }

    public void setCodigoBodega(String codigoBodega) {
        this.codigoBodega = codigoBodega;
    }

    public int getNumero_cajas() {
        return numero_cajas;
    }

    public void setNumero_cajas(int numero_cajas) {
        this.numero_cajas = numero_cajas;
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

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the total
     */
    public float getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Compra{" + "id=" + id + ", fecha=" + fecha + ", codigoBodega=" + codigoBodega + ", numero_cajas=" + numero_cajas + ", total=" + total + '}';
    }
    
    
}
