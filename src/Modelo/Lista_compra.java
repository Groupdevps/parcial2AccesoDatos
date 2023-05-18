/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Dan
 */
public class Lista_compra {
    private int id;
    private int compraId;
    private String codigo_bodega;
    private int numero_cajas;
    private float total;

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
     * @return the compraId
     */
    public int getCompraId() {
        return compraId;
    }

    /**
     * @param compraId the compraId to set
     */
    public void setCompraId(int compraId) {
        this.compraId = compraId;
    }

    /**
     * @return the codigo_bodega
     */
    public String getCodigo_bodega() {
        return codigo_bodega;
    }

    /**
     * @param codigo_bodega the codigo_bodega to set
     */
    public void setCodigo_bodega(String codigo_bodega) {
        this.codigo_bodega = codigo_bodega;
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
    
}
