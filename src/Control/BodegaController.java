/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Modelo.Bodega;
import Modelo.BodegaBodega;
import java.util.ArrayList;

/**
 *
 * @author Dan
 */
public class BodegaController {
    private BodegaBodega bodega = new BodegaBodega();

    
    
    public int registrarProducto(String codigo, String nombre, int numero, float precio, int restriccion){
        Bodega bog = new Bodega(codigo, nombre, numero, precio, restriccion);
        return bodega.registrar(bog);
    }
    
    public Bodega buscarProducto(String codigo){        
        return bodega.buscar(codigo);
    }
    
    public ArrayList ListarProductos(){
       return this.bodega.Listar();
    }
    
    public int ingresarProducto(Bodega bodega){
        return this.bodega.editar(bodega);
    }
}
