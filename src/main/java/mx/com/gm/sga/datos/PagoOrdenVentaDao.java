/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.datos;

import java.util.List;
import mx.com.gm.sga.domain.OrdenVenta;
import mx.com.gm.sga.domain.PagoOrdenVenta;

/**
 *
 * @author alanm
 */
public interface PagoOrdenVentaDao {
    public void registrarPagoOrdenVenta(PagoOrdenVenta pago);
    public List<PagoOrdenVenta> obtenerPagosDeOrdenVenta(OrdenVenta ordenVenta);
    public void eliminarPagoOrdenVentaPorIdOrdenVenta(Long idOrdenVenta);
}
