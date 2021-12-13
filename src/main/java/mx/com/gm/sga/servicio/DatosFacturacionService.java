/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import java.util.List;
import javax.ejb.Local;
import mx.com.gm.sga.domain.DatosFacturacion;

/**
 *
 * @author alanm
 */
@Local
public interface DatosFacturacionService {
    
     public void registrarDatosFacturacion(DatosFacturacion datosFacturacion);
    
    public void modificarDatosFacturacion(DatosFacturacion datosFacturacion);
    
    public List<DatosFacturacion> obtenerDatosFacturacionPorIdOrdenVenta(Long idOrdenVenta);
    
    public DatosFacturacion obtenerDatosFacturacionPorPagoOrdenVenta(Long idPagoOrdenVenta);
    
    public DatosFacturacion obtenerDatosFacturacionPorId(Long idDatosFacturacion);
}
