/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.datos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mx.com.gm.sga.domain.ConceptosInstitucion;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author alanm
 */
public class ConceptosInstitucionDaoImpl implements ConceptosInstitucionDao{

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
    
}
