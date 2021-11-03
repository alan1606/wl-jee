/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.datos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import mx.com.gm.sga.domain.ConsentimientoConcepto;

/**
 *
 * @author alanm
 */
public class ConsentimientoConceptoDaoImpl implements ConsentimientoConceptoDao {

    @PersistenceContext(unitName = "SgaPU")
    EntityManager em;

    @Override
    public void eliminarConsentimientoConcepto(ConsentimientoConcepto consentimientoConcepto) {
        em.remove(consentimientoConcepto);
    }

    @Override
    public void registrarConsentimientoConcepto(ConsentimientoConcepto consentimientoConcepto) {
        em.merge(consentimientoConcepto);
    }

    @Override
    public ConsentimientoConcepto buscarConsentimientoConceptoPorIdConsentimientoIdConcepto(Long idConsentimiento, Long idConcepto) {
        Query query = em.createQuery("select c from ConsentimientoConcepto c where c.idConcepto.idTo = :idConcepto and c.idConsentimiento.id = :idConsentimiento");
        query.setParameter("idConcepto", idConcepto);
        query.setParameter("idConsentimiento", idConsentimiento);
        return (ConsentimientoConcepto) query.getSingleResult();
    }

}
