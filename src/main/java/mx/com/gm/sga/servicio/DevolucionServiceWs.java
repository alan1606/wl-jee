/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import mx.com.gm.sga.domain.Devolucion;

/**
 *
 * @author alanm
 */
@WebService
public interface DevolucionServiceWs {
    
    @WebMethod
    public void registrarDevolucion(Devolucion devolucion);
    
    @WebMethod
    public List<Devolucion> buscarDevolucionesPorFecha(String fecha);
    
    @WebMethod
    public Devolucion encontrarDevolucionPorId(Long id);
    
    @WebMethod
    public List<Devolucion> obtenerDevolucionesPorIdOrdenVenta(Long idOrden);
    
    @WebMethod
    public Devolucion obtenerDevolucionPorIdPagoOrdenVenta(Long id);
    
}
