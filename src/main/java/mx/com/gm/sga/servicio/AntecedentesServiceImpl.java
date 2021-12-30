/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import mx.com.gm.sga.datos.AntecedenteEstudioDao;
import mx.com.gm.sga.datos.AntecedentesDao;
import mx.com.gm.sga.domain.AntecedenteEstudio;
import mx.com.gm.sga.domain.Antecedentes;
import mx.com.gm.sga.datos.AntecedenteConceptoDao;
import mx.com.gm.sga.domain.AntecedenteConceptoIds;

/**
 *
 * @author alanm
 */
@Stateless
@WebService(endpointInterface = "mx.com.gm.sga.servicio.AntecedentesServiceWs")
@DeclareRoles({"ROLE_ADMIN", "ROLE_USER"})
@RolesAllowed({"ROLE_ADMIN", "ROLE_USER"})
public class AntecedentesServiceImpl implements AntecedentesService, AntecedentesServiceWs {

    @Inject
    private AntecedentesDao antecedentesDao;

    @Inject
    private AntecedenteEstudioDao antecedenteEstudioDao;

    @Inject
    private AntecedenteConceptoDao antecedentesConceptoDao;

    @Resource
    private SessionContext contexto;

    @Override
    public void registrarAntecedentes(Antecedentes antecedentes) {
        antecedentesDao.registrarAntecedentes(antecedentes);
    }

    @Override
    public void actualizarAntecedentes(Antecedentes antecedentes) {
        antecedentesDao.actualizarAntecedentes(antecedentes);
    }

    @Override
    public List<Antecedentes> listarAntecedentes() {
        return antecedentesDao.listarAntecedentes();
    }

    @Override
    public Antecedentes encontrarAntecedentesPorId(Long id) {
        return antecedentesDao.encontrarAntecedentesPorId(id);
    }

    @Override
    public List<Antecedentes> encontrarAntecedentesPorArea(Integer idArea) {
        return antecedentesDao.encontrarAntecedentesPorArea(idArea);
    }

    @Override
    public List<Antecedentes> encontrarAntecedentesPorEstudio(Long idEstudio) {
        return antecedentesDao.encontrarAntecedentesPorEstudio(idEstudio);
    }

    @Override
    public void registrarAntecedenteEstudio(AntecedenteEstudio antecedenteEstudio) {
        antecedenteEstudioDao.registrarAntecedenteEstudio(antecedenteEstudio);
    }

    @Override
    public void registrarAntecedentesEstudio(List<AntecedenteEstudio> antecedenteEstudio) {
        antecedenteEstudioDao.registrarAntecedentesEstudio(antecedenteEstudio);
    }

    @Override
    public Antecedentes encontrarAntecedentePorNombre(String nombre) {
        return antecedentesDao.encontrarAntecedentePorNombre(nombre);
    }

    @Override
    public List<Antecedentes> encontrarAntecedentesPorConcepto(Long idConcepto) {
        return antecedentesDao.encontrarAntecedentesPorConcepto(idConcepto);
    }

    @Override
    public void registrarAntecedenteConcepto(Long idAntecedente, Long idConcepto) {
        antecedentesConceptoDao.registrarAntecedenteConcepto(idAntecedente, idConcepto);
    }

    @Override
    public void eliminarAntecedentesConcepto(Long idAntecedente, Long idConcepto) {
        antecedentesConceptoDao.eliminarAntecedentesConcepto(idAntecedente, idConcepto);
    }

    @Override
    public void registrarAntecedentesConcepto(List<AntecedenteConceptoIds> antecedentesConcepto) {
        antecedentesConceptoDao.registrarAntecedentesConcepto(antecedentesConcepto);
    }

    @Override
    public void eliminarTodosAntecedentesConcepto(Long idConcepto) {
        antecedentesConceptoDao.eliminarTodosAntecedentesConcepto(idConcepto);
    }

}
