/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.datos;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import mx.com.gm.sga.domain.Antecedentes;

/**
 *
 * @author alanm
 */
public class AntecedentesDaoImpl implements AntecedentesDao {

    @PersistenceContext(unitName = "SgaPU")
    EntityManager em;

    @Override
    public void registrarAntecedentes(Antecedentes antecedentes) {
        em.persist(antecedentes);
    }

    @Override
    public void actualizarAntecedentes(Antecedentes antecedentes) {
        em.merge(antecedentes);
    }

    @Override
    public List<Antecedentes> listarAntecedentes() {
        Query query = em.createQuery("select a from Antecedentes a order by a.nombre");
        return query.getResultList();
    }

    @Override
    public Antecedentes encontrarAntecedentesPorId(Long id) {
        return em.find(Antecedentes.class, id);
    }

    @Override
    public List<Antecedentes> encontrarAntecedentesPorArea(Integer idArea) {
        Query query = em.createQuery("select a.idAntecedente from AntecedentesAreas a where a.idArea.idA = :area");
        query.setParameter("area", idArea);
        return query.getResultList();
    }

    @Override
    public List<Antecedentes> encontrarAntecedentesPorEstudio(Long idEstudio) {
        Query query = em.createQuery("select a.idAntecedente from AntecedenteEstudio a where a.idVentaConcepto.idVc = :estudio");
        query.setParameter("estudio", idEstudio);
        return query.getResultList();
    }

    @Override
    public Antecedentes encontrarAntecedentePorNombre(String nombre) {
        Query query = em.createQuery("select a from Antecedentes a where a.nombre = :estudio");
        query.setParameter("estudio", nombre);
        return (Antecedentes) query.getSingleResult();
    }

    @Override
    public List<Antecedentes> encontrarAntecedentesPorConcepto(Long idConcepto) {
        Query query = em.createQuery("select a.idAntecedente from AntecedenteConcepto a where a.idConcepto.idTo = :estudio");
        query.setParameter("estudio", idConcepto);
        return query.getResultList();
    }

}
