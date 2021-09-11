/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import java.util.List;
import javax.ejb.Local;
import mx.com.gm.sga.domain.OrdenVenta;

/**
 *
 * @author alanm
 */
@Local
public interface OrdenVentaService {

    public void registrarOrdenVenta(OrdenVenta orden);

    public List<OrdenVenta> obtenerOrdenVentaNoPagadosEnFecha(String date);

    public List<OrdenVenta> obtenerOrdenVentaNoPagadosFechaPaciente(String date, Long idPaciente);

    public List<OrdenVenta> obtenerOrdenVentaNoPagadosPaciente(String idPaciente);

    public OrdenVenta obtenerUltimaOrdenVentaRegistrada();

     public List<OrdenVenta> obtenerOrdenVentaConfirmadasEnFecha(String date);

    public List<OrdenVenta> obtenerOrdenVentaConfirmadasFechaPaciente(String date, Long idPaciente);

    public List<OrdenVenta> obtenerOrdenVentaConfirmadasPaciente(Long idPaciente);
    
        public OrdenVenta obtenerOrdenVentaPorId(Long idOrdenVenta);

     public void actualizarOrdenVenta(OrdenVenta ordenVenta);

}
