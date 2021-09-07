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

    public void registrarOrdenVenta(OrdenVenta orden);

    public List<OrdenVenta> obtenerNoPagadosEnFecha(String date);

    public List<OrdenVenta> obtenerNoPagadosFechaPaciente(String date, Long idPaciente);

    public List<OrdenVenta> obtenerNoPagadosPaciente(String idPaciente);

    public OrdenVenta obtenerUltimoRegistro();
 
    
        public List<OrdenVenta> obtenerConfirmadosEnFecha(String date);

    public List<OrdenVenta> obtenerConfirmadosFechaPaciente(String date, Long idPaciente);

    public List<OrdenVenta> obtenerConfirmadosPaciente(String idPaciente);
    
}
