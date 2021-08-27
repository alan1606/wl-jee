/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import java.util.List;
import javax.ejb.Remote;
import mx.com.gm.sga.domain.OrdenVenta;

/**
 *
 * @author alanm
 */
@Remote
public interface OrdenVentaServiceRemote {

    public void registrarOrdenVenta(OrdenVenta orden);

    public List<OrdenVenta> obtenerOrdenVentaNoPagadosEnFecha(String date);

    public List<OrdenVenta> obtenerOrdenVentaNoPagadosFechaPaciente(String date, Long idPaciente);

    public List<OrdenVenta> obtenerOrdenVentaNoPagadosPaciente(String idPaciente);
    
        public OrdenVenta obtenerUltimaOrdenVentaRegistrada();

}
