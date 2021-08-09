/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.datos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mx.com.gm.sga.domain.Conceptos;

/**
 *
 * @author alanm
 */
public class ConceptosDaoImpl implements ConceptosDao{

    @PersistenceContext(unitName = "SgaPU")
    EntityManager em;
    
    @Override
    public Conceptos findConceptoById(Conceptos conceptos) {
        return em.find(Conceptos.class, conceptos.getIdTo());
    }
    
}
