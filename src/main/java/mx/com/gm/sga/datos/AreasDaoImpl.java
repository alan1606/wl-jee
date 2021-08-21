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
import mx.com.gm.sga.domain.Areas;

/**
 *
 * @author alanm
 */
public class AreasDaoImpl implements AreasDao {

    @PersistenceContext(unitName = "SgaPU")
    EntityManager em;

    @Override
    public Areas findAreaById(Areas area) {
        return em.find(Areas.class, area.getIdA());
    }

    @Override
    public List<Areas> findAllAreas() {
        return em.createNamedQuery("Areas.findAll").getResultList();
    }

    @Override
    public Areas findAreaByNombre(String nombre) {
        Query query = em.createQuery("from Areas a where a.nombreA = :nombre");
        query.setParameter("nombre", nombre);
        return (Areas) query.getSingleResult();
    }

    @Override
    public List<Areas> findAreasByInstitucion(Long idInstitucion) {
        Query query = em.createQuery("select a from ConceptosInstitucion c join c.idConcepto o join o.idAreaTo a where c.idInstitucion.idInstitucion=:idInstitucion");
        query.setParameter("idInstitucion", idInstitucion);
        return query.getResultList();
    }

}
