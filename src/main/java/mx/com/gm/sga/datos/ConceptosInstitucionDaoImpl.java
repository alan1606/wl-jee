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

}
