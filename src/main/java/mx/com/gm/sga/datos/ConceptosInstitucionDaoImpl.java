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
import mx.com.gm.sga.domain.Conceptos;
import mx.com.gm.sga.domain.ConceptosInstitucion;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author alanm
 */
public class ConceptosInstitucionDaoImpl implements ConceptosInstitucionDao {

    static Logger log = LogManager.getRootLogger();

    @PersistenceContext(unitName = "SgaPU")
    EntityManager em;

    @Override
    public void registrarConceptosInstitucion(ConceptosInstitucion conceptoInstitucion) {
        em.persist(conceptoInstitucion);
    }

    @Override
    public void actualizarConceptosInstitucion(ConceptosInstitucion conceptoInstitucion) {
        em.merge(conceptoInstitucion);
    }

    @Override
    public ConceptosInstitucion encontrarConceptoInstitucionPorIdConceptoIdInstitucion(Long idConcepto, Long idInstitucion) {
        Query query = em.createQuery("select c from ConceptosInstitucion c where c.idInstitucion.idInstitucion = :idInstitucion and c.idConcepto.idTo = :idConcepto");
        query.setParameter("idInstitucion", idInstitucion);
        query.setParameter("idConcepto", idConcepto);
        return (ConceptosInstitucion) query.getSingleResult();
    }

    @Override
    public List<ConceptosInstitucion> obtenerConceptosInstitucionPorIdInstitucion(Long idInstitucion) {
        Query query = em.createQuery("select c from ConceptosInstitucion c where c.idInstitucion.idInstitucion = :idInstitucion");
        query.setParameter("idInstitucion", idInstitucion);
        return query.getResultList();
    }

    @Override
    public List<ConceptosInstitucion> obtenerConceptosLikeNombrePorPorIdInstitucion(String nombre, Long idInstitucion) {
        Query query = em.createQuery("select c from ConceptosInstitucion c where c.idInstitucion.idInstitucion = :idInstitucion and c.idConcepto.conceptoTo like :nombre");
        query.setParameter("idInstitucion", idInstitucion);
        query.setParameter("nombre", "%" + nombre + "%");
        return query.getResultList();
    }

    @Override
    public List<ConceptosInstitucion> obtenerConceptosLikeNombrePorPorIdInstitucionPorArea(String nombre, Long idInstitucion, int idArea) {
        Query query = em.createQuery("select c from ConceptosInstitucion c join c.idConcepto t where c.idInstitucion.idInstitucion = :idInstitucion and t.conceptoTo like :nombre and t.idAreaTo.idA = :idA");
        query.setParameter("idInstitucion", idInstitucion);
        query.setParameter("nombre", "%" + nombre + "%");
        query.setParameter("idA", idArea);
        return query.getResultList();
    }

    @Override
    public List<ConceptosInstitucion> obtenerConceptosPorPorIdInstitucionPorArea(Long idInstitucion, int idArea) {
        Query query = em.createQuery("select c from ConceptosInstitucion c join c.idConcepto t where c.idInstitucion.idInstitucion = :idInstitucion  and t.idAreaTo.idA = :idA");
        query.setParameter("idInstitucion", idInstitucion);
        query.setParameter("idA", idArea);
        return query.getResultList();

    }

}
