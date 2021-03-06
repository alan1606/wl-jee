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
import mx.com.gm.sga.datos.ConceptosDao;
import mx.com.gm.sga.datos.ConsentimientoConceptoDao;
import mx.com.gm.sga.datos.ConsentimientoDao;
import mx.com.gm.sga.domain.Conceptos;
import mx.com.gm.sga.domain.ConsentimientoConcepto;

/**
 *
 * @author alanm
 */
@Stateless
@WebService(endpointInterface = "mx.com.gm.sga.servicio.ConsentimientoConceptoServiceWs")
@DeclareRoles({"ROLE_ADMIN","ROLE_USER"})
@RolesAllowed({"ROLE_ADMIN","ROLE_USER"})

public class ConsentimientoConceptoServiceImpl implements ConsentimientoConceptoService, ConsentimientoConceptoServiceWs{

    @Inject
    private ConsentimientoConceptoDao consentimientoConceptoDao;

    @Inject 
    private ConsentimientoDao consentimientoDao;
    
    @Inject 
    private ConceptosDao conceptoDao;
    
    @Resource
    private SessionContext contexto;
    
    
    @Override
    public void eliminarConsentimientoConcepto(ConsentimientoConcepto consentimientoConcepto) {
        consentimientoConcepto = consentimientoConceptoDao.buscarConsentimientoConceptoPorIdConsentimientoIdConcepto(consentimientoConcepto.getIdConsentimiento().getId(), consentimientoConcepto.getIdConcepto().getIdTo());
        consentimientoConceptoDao.eliminarConsentimientoConcepto(consentimientoConcepto);
    }

    @Override
    public void registrarConsentimientoConcepto(Long idConsentimiento, Long idConcepto) {
        ConsentimientoConcepto consentimientoConcepto = new ConsentimientoConcepto();
        Conceptos concepto = new Conceptos();
        concepto.setIdTo(idConcepto);
        consentimientoConcepto.setIdConcepto(conceptoDao.findConceptoById(concepto));
        consentimientoConcepto.setIdConsentimiento(consentimientoDao.obtenerConsentimientoPorId(idConsentimiento));
        consentimientoConceptoDao.registrarConsentimientoConcepto(consentimientoConcepto);
    }



    
}
