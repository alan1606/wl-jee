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
import mx.com.gm.sga.datos.OrdenVentaDao;
import mx.com.gm.sga.domain.OrdenVenta;

/**
 *
 * @author alanm
 */
@Stateless
@WebService(endpointInterface = "mx.com.gm.sga.servicio.OrdenVentaServiceWs")
@DeclareRoles({"ROLE_ADMIN", "ROLE_USER"})
@RolesAllowed({"ROLE_ADMIN", "ROLE_USER"})

public class OrdenVentaServiceImpl implements OrdenVentaService, OrdenVentaServiceRemote, OrdenVentaServiceWs {

    @Inject
    private OrdenVentaDao ordenVentaDao;

    @Resource
    private SessionContext contexto;

    @Override
    public void registrarOrdenVenta(OrdenVenta orden) {
        ordenVentaDao.registrarOrdenVenta(orden);
    }

    @Override
    public List<OrdenVenta> obtenerOrdenVentaNoPagadosEnFecha(String date) {
        return ordenVentaDao.obtenerNoPagadosEnFecha(date);
    }

    @Override
    public List<OrdenVenta> obtenerOrdenVentaNoPagadosFechaPaciente(String date, Long idPaciente) {
        return ordenVentaDao.obtenerNoPagadosFechaPaciente(date, idPaciente);
    }

    @Override
    public List<OrdenVenta> obtenerOrdenVentaNoPagadosPaciente(String idPaciente) {
        return ordenVentaDao.obtenerNoPagadosPaciente(idPaciente);
    }

}
