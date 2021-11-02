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
import mx.com.gm.sga.domain.Conceptos;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author alanm
 */
public class ConceptoPaqueteDaoImpl implements ConceptoPaqueteDao{
    
    static Logger log = LogManager.getRootLogger();

    @PersistenceContext(unitName = "SgaPU")
    EntityManager em;

    @Override
    public void registrarConceptoPaquete(ConceptoPaquete conceptoPaquete) {
        em.persist(conceptoPaquete);
    }

    @Override
    public void eliminarConceptoPaquete(ConceptoPaquete conceptoPaquete) {
        em.remove(em.merge(conceptoPaquete));
    }

    @Override
    public List<Conceptos> obtenerConceptosDePaquete(Long idPaquete) {
        Query query = em.createQuery("select c from ConceptoPaquete c where c.idIdPaquete.id = :idPaquete");
        query.setParameter("idPaquete", idPaquete);
        return query.getResultList();
    }
    
}
