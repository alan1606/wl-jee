/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import mx.com.gm.sga.domain.DatosFacturacion;

/**
 *
 * @author alanm
 */
@WebService
public interface DatosFacturacionServiceWs {
    
    @WebMethod
     public void registrarDatosFacturacion(DatosFacturacion datosFacturacion);
    
     @WebMethod
    public void modificarDatosFacturacion(DatosFacturacion datosFacturacion);
    
    @WebMethod
    public List<DatosFacturacion> obtenerDatosFacturacionPorIdOrdenVenta(Long idOrdenVenta);
    
    @WebMethod
    public DatosFacturacion obtenerDatosFacturacionPorPagoOrdenVenta(Long idPagoOrdenVenta);
    
    @WebMethod
    public DatosFacturacion obtenerDatosFacturacionPorId(Long idDatosFacturacion);
}
