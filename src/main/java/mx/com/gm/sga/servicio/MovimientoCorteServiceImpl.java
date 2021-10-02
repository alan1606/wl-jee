/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import java.util.List;
import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import mx.com.gm.sga.datos.MovimientoCorteDao;

import mx.com.gm.sga.domain.MovimientoCorte;

/**
 *
 * @author alanm
 */
@Stateless
@WebService(endpointInterface = "mx.com.gm.sga.servicio.MovimientoCorteServiceWs")
@DeclareRoles({"ROLE_ADMIN", "ROLE_USER", "ROLE_GUEST"})
@RolesAllowed({"ROLE_ADMIN", "ROLE_USER", "ROLE_GUEST"})

public class MovimientoCorteServiceImpl implements MovimientoCorteService, MovimientoCorteServiceWs {

    @Inject
    private MovimientoCorteDao movimientoCorteDao;

    @Resource
    private SessionContext contexto;

    @Override
    public List<MovimientoCorte> obtenerMovimientosDeCorteMatutino(String fecha) {
        return movimientoCorteDao.obtenerMovimientosDeCorteMatutino(fecha);
    }

    @Override
    public List<MovimientoCorte> obtenerMovimientosDeCorteVespertino(String fecha) {
        return movimientoCorteDao.obtenerMovimientosDeCorteVespertino(fecha);
    }

    @Override
    public void registrarMovimientoCorte(MovimientoCorte movimiento) {
        movimientoCorteDao.registrarMovimientoCorte(movimiento);
    }

}
