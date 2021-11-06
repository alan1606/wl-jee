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
import mx.com.gm.sga.domain.ConceptoPaquete;
import mx.com.gm.sga.domain.ConceptosInstitucion;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author alanm
 */
public class ConceptoPaqueteDaoImpl implements ConceptoPaqueteDao {

    static Logger log = LogManager.getRootLogger();

    @PersistenceContext(unitName = "SgaPU")
    EntityManager em;

    @Override
    public void registrarConceptoPaquete(ConceptoPaquete conceptoPaquete) {
        em.persist(conceptoPaquete);
    }

    @Override
    public void eliminarConceptoPaquete(ConceptoPaquete conceptoPaquete) {
        conceptoPaquete = buscarConceptoPaquetePorIdConceptoPorIdPaquete(conceptoPaquete.getIdConcepto().getIdTo(), conceptoPaquete.getIdPaquete().getId());
        em.remove(em.merge(conceptoPaquete));
    }

    @Override
    public List<ConceptosInstitucion> obtenerConceptosDePaquete(Long idPaquete) {
        Query query = em.createQuery("select l from ConceptoPaquete c join c.idConcepto t join fetch t.conceptosInstitucionList l where c.idPaquete.id = :idPaquete and l.idInstitucion.nombreInstitucion = :particular");
        query.setParameter("idPaquete", idPaquete);
        query.setParameter("particular", "particular");
        return query.getResultList();
    }

    @Override
    public ConceptoPaquete buscarConceptoPaquetePorIdConceptoPorIdPaquete(Long idConcepto, Long idPaquete) {
        Query query = em.createQuery("select c from ConceptoPaquete c where c.idConcepto.idTo = :idConcepto and c.idPaquete.id = :idPaquete");
        query.setParameter("idPaquete", idPaquete);
        query.setParameter("idConcepto", idConcepto);
        return (ConceptoPaquete) query.getSingleResult();
    }

}
