/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.datos;

import java.util.List;
import mx.com.gm.sga.domain.Devolucion;

/**
 *
 * @author alanm
 */
public interface DevolucionDao {
    
    public void registrarDevolucion(Devolucion devolucion);
    public List<Devolucion> buscarDevolucionesPorFecha(String fecha);
    public Devolucion encontrarDevolucionPorId(Long id);
    public List<Devolucion> obtenerDevolucionesPorIdOrdenVenta(Long idOrden);
    public Devolucion obtenerDevolucionPorIdPagoOrdenVenta(Long id);
}
