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
import mx.com.gm.sga.datos.ConceptosDao;
import mx.com.gm.sga.domain.Conceptos;

/**
 *
 * @author alanm
 */
@Stateless
@WebService(endpointInterface = "mx.com.gm.sga.servicio.ConceptosServiceWs")
@DeclareRoles({"ROLE_ADMIN", "ROLE_USER"})
@RolesAllowed({"ROLE_ADMIN", "ROLE_USER"})

public class ConceptosServiceImpl implements ConceptosService, ConceptosServiceRemote, ConceptosServiceWs {

    @Inject
    private ConceptosDao conceptosDao;

    @Resource
    private SessionContext contexto;

    @Override
    public Conceptos encontrarConceptoPorId(Conceptos conceptos) {
        return conceptosDao.findConceptoById(new Conceptos(conceptos.getIdTo()));
    }

    @Override
    public List<Conceptos> encontrarConceptosPorIdVentaConceptos(Long idVentaConceptos) {
        return conceptosDao.findConceptosByidVentaConcepto(idVentaConceptos);
    }

    @Override
    public List<Conceptos> encontrarConceptosPorIdArea(Integer idArea) {
        return conceptosDao.findByIdArea(idArea);
    }

    @Override
    public List<Conceptos> encontrarConceptosPorInstitucionArea(Long idInstitucion, Integer idArea) {
        return conceptosDao.findByInstitucionArea(idInstitucion, idArea);
    }

    @Override
    public Conceptos encontrarConceptoPorNombre(String nombre) {
        return conceptosDao.findByName(nombre);
    }

    @Override
    public List<Conceptos> encontrarTodosConceptos() {
        return conceptosDao.findAll();
    }

    @Override
    public void registrarConcepto(Conceptos concepto) {
        conceptosDao.save(concepto);
    }

    @Override
    public List<Conceptos> encontrarConceptoLikeNombre(String nombre) {
        return conceptosDao.findLikeName(nombre);
    }

    @Override
    public List<Conceptos> encontrarConceptosPorAreaYNombre(Integer idArea, String name) {
        return conceptosDao.findByIdAreaName(idArea, name);
    }

    @Override
    public List<Conceptos> encontrarConceptosPorIdInstitucion(Long idInstitucion) {
        return conceptosDao.findByInstitucion(idInstitucion);
    }

    @Override
    public void actualizarConcepto(Conceptos concepto) {
        conceptosDao.actualizarConcepto(concepto);
    }

    @Override
    public Conceptos obtenerUltimoConceptoRegistrado() {
        return conceptosDao.obtenerUltimoConceptoRegistrado();
    }



}
