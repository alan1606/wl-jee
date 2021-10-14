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
import mx.com.gm.sga.datos.ConsentimientoDao;
import mx.com.gm.sga.domain.Consentimiento;

/**
 *
 * @author alanm
 */
@Stateless
@WebService(endpointInterface = "mx.com.gm.sga.servicio.ConsentimientoServiceWs")
@DeclareRoles({"ROLE_ADMIN", "ROLE_USER"})
@RolesAllowed({"ROLE_ADMIN", "ROLE_USER"})

public class ConsentimientoServiceImpl implements ConsentimientoService, ConsentimientoServiceWs {

    @Inject
    private ConsentimientoDao consentimientoDao;

    @Resource
    private SessionContext contexto;

    @Override
    public List<Consentimiento> obtenerConsentimientos() {
        return consentimientoDao.obtenerConsentimientos();
    }

    @Override
    public List<Consentimiento> obtenerPorIdConcepto(Long idConcepto) {
        return consentimientoDao.obtenerPorIdConcepto(idConcepto);
    }

    @Override
    public void registrarConsentimiento(Consentimiento consentimiento) {
        consentimientoDao.registrarConsentimiento(consentimiento);
    }

    @Override
    public void eliminarConsentimiento(Consentimiento consentimiento) {
        consentimientoDao.eliminarConsentimiento(consentimiento);
    }

    @Override
    public void modificarConsentimiento(Consentimiento consentimieno) {
        consentimientoDao.modificarConsentimiento(consentimieno);
    }

    @Override
    public Consentimiento obtenerConsentimientoPorId(Long id) {
        return consentimientoDao.obtenerConsentimientoPorId(id);
    }

    @Override
    public Consentimiento obtenerConsentimientoPorNombre(String nombre) {
        return consentimientoDao.obtenerConsentimientoPorNombre(nombre);
    }

}
