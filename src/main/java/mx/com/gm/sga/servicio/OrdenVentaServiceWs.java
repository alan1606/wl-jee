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

/**
 *
 * @author alanm
 */
@WebService
public interface OrdenVentaServiceWs {

    @WebMethod
    public void registrarOrdenVenta(OrdenVenta orden);

    @WebMethod
    public List<OrdenVenta> obtenerOrdenVentaNoPagadosEnFecha(String date);

    @WebMethod
    public List<OrdenVenta> obtenerOrdenVentaNoPagadosFechaPaciente(String date, Long idPaciente);

    @WebMethod
    public List<OrdenVenta> obtenerOrdenVentaNoPagadosPaciente(String idPaciente);
}
