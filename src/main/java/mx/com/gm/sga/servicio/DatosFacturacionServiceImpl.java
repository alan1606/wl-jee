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
import mx.com.gm.sga.datos.DatosFacturacionDao;
import mx.com.gm.sga.domain.DatosFacturacion;

/**
 *
 * @author alanm
 */
@Stateless
@WebService(endpointInterface = "mx.com.gm.sga.servicio.DatosFacturacionServiceWs")
@DeclareRoles({"ROLE_ADMIN", "ROLE_USER"})
@RolesAllowed({"ROLE_ADMIN", "ROLE_USER"})
public class DatosFacturacionServiceImpl implements DatosFacturacionService, DatosFacturacionServiceWs {

    @Inject
    private DatosFacturacionDao datosFacturacionDao;

    @Resource
    private SessionContext contexto;

    @Override
    public void registrarDatosFacturacion(DatosFacturacion datosFacturacion) {
        datosFacturacionDao.registrarDatosFacturacion(datosFacturacion);
    }

    @Override
    public void modificarDatosFacturacion(DatosFacturacion datosFacturacion) {
        datosFacturacionDao.modificarDatosFacturacion(datosFacturacion);
    }

    @Override
    public List<DatosFacturacion> obtenerDatosFacturacionPorIdOrdenVenta(Long idOrdenVenta) {
        return datosFacturacionDao.obtenerDatosFacturacionPorIdOrdenVenta(idOrdenVenta);
    }

    @Override
    public DatosFacturacion obtenerDatosFacturacionPorPagoOrdenVenta(Long idPagoOrdenVenta) {
        return datosFacturacionDao.obtenerDatosFacturacionPorPagoOrdenVenta(idPagoOrdenVenta);
    }

    @Override
    public DatosFacturacion obtenerDatosFacturacionPorId(Long idDatosFacturacion) {
        return datosFacturacionDao.obtenerDatosFacturacionPorId(idDatosFacturacion);
    }
    
    
}
