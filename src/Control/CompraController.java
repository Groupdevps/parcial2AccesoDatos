/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Modelo.Bodega;
import Modelo.BodegaBodega;
import Modelo.Compra;
import Modelo.CompraBodega;
import java.util.Calendar;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author Dan
 */
public class CompraController {
    private CompraBodega compra = new CompraBodega();
    private BodegaBodega bodega = new BodegaBodega();
    
    public int comprar(String codigo, int numero, float total, Bodega bod){
        String dateTime = DateTimeFormatter.ofPattern("MMM dd yyyy, hh:mm:ss a")
                    .format(LocalDateTime.now());
        System.out.println(" ******************************* \n "
            + "Fecha de Compra = " + dateTime + 
            "\n Produco = " + bod.getNombre() + 
            "\n Numero de cajas = " + numero + 
            "\n Total = " + total + 
            "\n *********************************");
        Compra compra = new Compra(
            1,    
            dateTime,
            codigo,
            numero,
            total
        ); 
        this.bodega.editar(bod);
        return this.compra.agregar(compra);
    }

}
