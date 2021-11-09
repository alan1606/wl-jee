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

        jpql = "select v.idConceptoEs from VentaConceptos v where v.idVc = :idVc order by v.idConceptoEs.conceptoTo";

        q = em.createQuery(jpql);
        q.setParameter("idVc", idVentaConcepto);
        return q.getResultList();
    }

    @Override
    public List<Conceptos> findByIdArea(Integer idArea) {
        String jpql = null;
        Query q = null;

        jpql = "select c from Conceptos c where c.idAreaTo.idA = :idArea order by c.conceptoTo";
        q = em.createQuery(jpql);
        q.setParameter("idArea", idArea);
        return q.getResultList();
    }

    @Override
    public List<Conceptos> findByInstitucionArea(Long idInstitucion, Integer idArea) {
        String jpql = null;
        Query q = null;
        jpql = "select o from ConceptosInstitucion c join c.idConcepto o join o.idAreaTo a where c.idInstitucion.idInstitucion = :idInstitucion and a.idA = :idArea and c.activo = true order by o.conceptoTo";
        q = em.createQuery(jpql);
        q.setParameter("idInstitucion", idInstitucion);
        q.setParameter("idArea", idArea);
        return q.getResultList();
    }

    @Override
    public Conceptos findByName(String nombre) {
        Query q = em.createNamedQuery("Conceptos.findByConceptoTo");
        q.setParameter("conceptoTo", nombre);
        return (Conceptos) q.getSingleResult();
    }

    @Override
    public List<Conceptos> findAll() {
        return em.createNamedQuery("Conceptos.findAll").getResultList();
    }

    @Override
    public void save(Conceptos concepto) {
        em.persist(concepto);
    }

    @Override
    public List<Conceptos> findLikeName(String nombre) {
        String jpql = null;
        Query q = null;

        jpql = "select c from Conceptos c where c.conceptoTo like :nombre order by c.conceptoTo";
        q = em.createQuery(jpql);
        q.setParameter("nombre", "%" + nombre + "%");
        return q.getResultList();
    }

    @Override
    public List<Conceptos> findByIdAreaName(Integer idArea, String name) {
        String jpql = null;
        Query q = null;

        jpql = "select c from Conceptos c where c.conceptoTo like :nombre and c.idAreaTo.idA = :idArea order by c.idAreaTo, c.conceptoTo";
        q = em.createQuery(jpql);
        q.setParameter("nombre", "%"+name+"%");
        q.setParameter("idArea", idArea);
        return q.getResultList();
    }

    @Override
    public List<Conceptos> findByInstitucion(Long idInstitucion) {
        String jpql = null;
        Query q = null;

        jpql = "select c.idConcepto from ConceptosInstitucion c where c.idInstitucion.idInstitucion = :idInstitucion";
        q = em.createQuery(jpql);
        q.setParameter("idInstitucion", idInstitucion);
        return q.getResultList();
    }

    @Override
    public void actualizarConcepto(Conceptos concepto) {
        em.merge(concepto);
    }

}
