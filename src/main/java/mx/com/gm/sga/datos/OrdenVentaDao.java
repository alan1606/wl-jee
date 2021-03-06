/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.datos;

import java.util.List;
import mx.com.gm.sga.domain.OrdenVenta;

/**
 *
 * @author alanm
 */
public interface OrdenVentaDao {

    public OrdenVenta obtenerOrdenVentaPorId(Long idOrdenVenta);
    
    public void registrarOrdenVenta(OrdenVenta orden);

    public List<OrdenVenta> obtenerNoPagadosEnFecha(String date);

    public List<OrdenVenta> obtenerNoPagadosFechaPaciente(String date, Long idPaciente);

    public List<OrdenVenta> obtenerNoPagadosPaciente(String idPaciente);

    public OrdenVenta obtenerUltimoRegistro();
    
    public List<OrdenVenta> obtenerConfirmadosEnFecha(String date);

    public List<OrdenVenta> obtenerConfirmadosFechaPaciente(String date, Long idPaciente);

    public List<OrdenVenta> obtenerConfirmadosPaciente(Long idPaciente);
    
        public List<OrdenVenta> obtenerConfirmadosPagadosEnFecha(String date);

    public List<OrdenVenta> obtenerConfirmadosPagadosFechaPaciente(String date, Long idPaciente);

    public List<OrdenVenta> obtenerConfirmadosPagadosPaciente(Long idPaciente);
    
    public void actualizarOrdenVenta(OrdenVenta ordenVenta);
    
    public double obtenerTotalDeVenta(Long idOrdenVenta);
    
    public void actualizarTotalOrdenVenta(OrdenVenta ordenVenta, String institucion);
    
    public Long obtenerTotalOrdenesEnUnDia(String fecha);
    
    public void eliminarOrdenVenta(OrdenVenta ordenVenta);
    
    
}
