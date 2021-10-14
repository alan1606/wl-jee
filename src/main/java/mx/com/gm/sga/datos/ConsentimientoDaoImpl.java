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
import mx.com.gm.sga.domain.Consentimiento;

/**
 *
 * @author alanm
 */
public class ConsentimientoDaoImpl implements ConsentimientoDao {

    @PersistenceContext(unitName = "SgaPU")
    EntityManager em;

    @Override
    public List<Consentimiento> obtenerConsentimientos() {
        return em.createNamedQuery("Consentimiento.findAll").getResultList();
    }

    @Override
    public List<Consentimiento> obtenerPorIdConcepto(Long idConcepto) {
        Query query = em.createQuery("select c.idConsentimiento from ConsentimientoConcepto c where c.idConcepto.idTo = :idConcepto");
        query.setParameter("idConcepto", idConcepto);
        return query.getResultList();
    }

    @Override
    public void registrarConsentimiento(Consentimiento consentimiento) {
        em.persist(consentimiento);
    }

    @Override
    public void eliminarConsentimiento(Consentimiento consentimiento) {
        em.remove(em.merge(consentimiento));
    }

    @Override
    public void modificarConsentimiento(Consentimiento consentimieno) {
        em.merge(consentimieno);
    }

    @Override
    public Consentimiento obtenerConsentimientoPorId(Long id) {
        return em.find(Consentimiento.class, id);
    }

    @Override
    public Consentimiento obtenerConsentimientoPorNombre(String nombre) {
        Query query = em.createQuery("select c from Consentimiento c where c.nombre = :nombre");
        query.setParameter("nombre", nombre);
        return (Consentimiento) query.getSingleResult();
    }

}
