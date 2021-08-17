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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author alanm
 */
public class ConceptosDaoImpl implements ConceptosDao {

    static Logger log = LogManager.getRootLogger();

    @PersistenceContext(unitName = "SgaPU")
    EntityManager em;

    @Override
    public Conceptos findConceptoById(Conceptos conceptos) {
        return em.find(Conceptos.class, conceptos.getIdTo());
    }

    @Override
    public List<Conceptos> findConceptosByidVentaConcepto(Long idVentaConcepto) {
        String jpql = null;
        Query q = null;

        jpql = "select v.idConceptoEs from VentaConceptos v where v.idVc = :idVc ";

        q = em.createQuery(jpql);
        q.setParameter("idVc", idVentaConcepto);
        return q.getResultList();
    }

    @Override
    public List<Conceptos> findByIdArea(Integer idArea) {
        String jpql = null;
        Query q = null;
        
        jpql = "select c from Conceptos c where c.idAreaTo.idA = :idArea ";
        q = em.createQuery(jpql);
        q.setParameter("idArea", idArea);
        return q.getResultList();
    }

}
