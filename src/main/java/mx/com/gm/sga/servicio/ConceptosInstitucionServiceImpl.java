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
import mx.com.gm.sga.datos.ConceptosInstitucionDao;
import mx.com.gm.sga.domain.ConceptosInstitucion;

/**
 *
 * @author alanm
 */
@Stateless
@WebService(endpointInterface = "mx.com.gm.sga.servicio.ConceptosInstitucionServiceWs")
@DeclareRoles({"ROLE_ADMIN", "ROLE_USER"})
@RolesAllowed({"ROLE_ADMIN", "ROLE_USER"})

public class ConceptosInstitucionServiceImpl implements ConceptosInstitucionService, ConceptosInstitucionServiceRemote, ConceptosInstitucionServiceWs {

    @Inject
    private ConceptosInstitucionDao conceptosInstitucionDao;

    @Resource
    private SessionContext contexto;

    @Override
    public void registrarConceptosInstitucion(ConceptosInstitucion conceptoInstitucion) {
       conceptosInstitucionDao.registrarConceptosInstitucion(conceptoInstitucion);
    }

    @Override
    public void actualizarConceptosInstitucion(ConceptosInstitucion conceptoInstitucion) {
        conceptosInstitucionDao.actualizarConceptosInstitucion(conceptoInstitucion);
    }

    @Override
    public ConceptosInstitucion encontrarConceptoInstitucionPorIdConceptoIdInstitucion(Long idConcepto, Long idInstitucion) {
        return conceptosInstitucionDao.encontrarConceptoInstitucionPorIdConceptoIdInstitucion(idConcepto, idInstitucion);
        }

    @Override
    public List<ConceptosInstitucion> obtenerConceptosInstitucionPorIdInstitucion(Long idInstitucion) {
        return conceptosInstitucionDao.obtenerConceptosInstitucionPorIdInstitucion(idInstitucion);
    }

    @Override
    public List<ConceptosInstitucion> obtenerConceptosLikeNombrePorPorIdInstitucion(String nombre, Long idInstitucion) {
        return conceptosInstitucionDao.obtenerConceptosLikeNombrePorPorIdInstitucion(nombre, idInstitucion);
    }

    @Override
    public List<ConceptosInstitucion> obtenerConceptosLikeNombrePorPorIdInstitucionPorArea(String nombre, Long idInstitucion, int idArea) {
        return conceptosInstitucionDao.obtenerConceptosLikeNombrePorPorIdInstitucionPorArea(nombre, idInstitucion, idArea);
    }

    @Override
    public List<ConceptosInstitucion> obtenerConceptosPorPorIdInstitucionPorArea(Long idInstitucion, int idArea) {
        return conceptosInstitucionDao.obtenerConceptosPorPorIdInstitucionPorArea(idInstitucion, idArea);
    }

}
