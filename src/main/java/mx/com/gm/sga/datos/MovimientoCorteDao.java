/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.datos;

import java.util.List;
import mx.com.gm.sga.domain.MovimientoCorte;

/**
 *
 * @author alanm
 */
public interface MovimientoCorteDao {

    public List<MovimientoCorte> obtenerMovimientosDeCorteMatutino(String fecha);

    public List<MovimientoCorte> obtenerMovimientosDeCorteVespertino(String fecha);
    
    public void registrarMovimientoCorte(MovimientoCorte movimiento);
    

}
