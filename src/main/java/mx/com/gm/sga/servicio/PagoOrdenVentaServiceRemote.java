/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import javax.ejb.Remote;
import mx.com.gm.sga.domain.PagoOrdenVenta;

/**
 *
 * @author alanm
 */
@Remote
public interface PagoOrdenVentaServiceRemote {
        public void registrarPagoOrdenVenta(PagoOrdenVenta pago);

}
