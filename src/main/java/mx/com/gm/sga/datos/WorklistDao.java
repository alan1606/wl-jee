/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.datos;


/**
 *
 * @author alanm
 */
public interface WorklistDao {
    
    public void registrarEnWorklist(long idVentaConcepto);
   
    public void registrarEnWorklistPorOrdenVenta(long idOrdenVenta);
}
