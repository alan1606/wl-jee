/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import mx.com.gm.sga.domain.MovimientoCorte;

/**
 *
 * @author alanm
 */
@WebService
public interface MovimientoCorteServiceWs {

    @WebMethod
    public List<MovimientoCorte> obtenerMovimientosDeCorteMatutino(String fecha);

    @WebMethod
    public List<MovimientoCorte> obtenerMovimientosDeCorteVespertino(String fecha);

    @WebMethod
    public void registrarMovimientoCorte(MovimientoCorte movimiento);
}
