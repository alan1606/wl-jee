/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import javax.ejb.Local;

/**
 *
 * @author alanm
 */
@Local
public interface WorklistService {
     public void registrarEnWorklist(Long idVentaConcepto);
         public void registrarEnWorklistPorOrdenVenta(long idOrdenVenta);

}
