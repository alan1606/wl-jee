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
import mx.com.gm.sga.datos.DevolucionDao;
import mx.com.gm.sga.domain.Devolucion;

/**
 *
 * @author alanm
*/

@Stateless
@WebService(endpointInterface = "mx.com.gm.sga.servicio.DevolucionServiceWs")
@DeclareRoles({"ROLE_ADMIN","ROLE_USER"})
@RolesAllowed({"ROLE_ADMIN","ROLE_USER"})

public class DevolucionServiceImpl implements DevolucionService, DevolucionServiceWs {

    @Inject
    private DevolucionDao devolucionDao;
    
    @Resource
    private SessionContext contexto;
    
    @Override
    public void registrarDevolucion(Devolucion devolucion) {
        devolucionDao.registrarDevolucion(devolucion);
    }

    @Override
    public List<Devolucion> buscarDevolucionesPorFecha(String fecha) {
        return devolucionDao.buscarDevolucionesPorFecha(fecha);
    }

    @Override
    public Devolucion encontrarDevolucionPorId(Long id) {
        return devolucionDao.encontrarDevolucionPorId(id);
    }

    @Override
    public List<Devolucion> obtenerDevolucionesPorIdOrdenVenta(Long idOrden) {
        return devolucionDao.obtenerDevolucionesPorIdOrdenVenta(idOrden);
    }

    @Override
    public Devolucion obtenerDevolucionPorIdPagoOrdenVenta(Long id) {
        return devolucionDao.obtenerDevolucionPorIdPagoOrdenVenta(id);
    }
    
    
    
}
