/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import mx.com.gm.sga.domain.OrdenVenta;
import mx.com.gm.sga.domain.PagoOrdenVenta;

/**
 *
 * @author alanm
 */
@WebService
public interface PagoOrdenVentaServiceWs {
    @WebMethod
        public void registrarPagoOrdenVenta(PagoOrdenVenta pago);

        @WebMethod
            public void eliminarPagoOrdenVentaPorIdOrdenVenta(Long idOrdenVenta);

            @WebMethod
               public List<PagoOrdenVenta> obtenerPagosDeOrdenVenta(OrdenVenta ordenVenta);

}
