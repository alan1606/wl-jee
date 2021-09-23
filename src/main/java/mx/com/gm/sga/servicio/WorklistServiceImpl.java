/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import mx.com.gm.sga.datos.WorklistDao;

/**
 *
 * @author alanm
 */
@Stateless
@WebService(endpointInterface = "mx.com.gm.sga.servicio.WorklistServiceWs")
@DeclareRoles({"ROLE_ADMIN", "ROLE_USER"})
@RolesAllowed({"ROLE_ADMIN", "ROLE_USER"})
public class WorklistServiceImpl implements WorklistService, WorklistServiceWs {

    @Inject
    private WorklistDao worklistDao;

    @Resource
    private SessionContext contexto;


    @Override
    public void registrarEnWorklist(Long idVentaConcepto) {
        worklistDao.registrarEnWorklist(idVentaConcepto);
    }

    @Override
    public void registrarEnWorklistPorOrdenVenta(long idOrdenVenta) {
        worklistDao.registrarEnWorklistPorOrdenVenta(idOrdenVenta);
    }

}
