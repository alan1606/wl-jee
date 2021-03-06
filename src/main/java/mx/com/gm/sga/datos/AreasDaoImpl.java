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
        Query query = em.createQuery("from Areas a where a.nombreA = :nombre order by a.nombreA");
        query.setParameter("nombre", nombre);
        return (Areas) query.getSingleResult();
    }

    @Override
    public List<Areas> findAreasByInstitucion(Long idInstitucion) {
        Query query = em.createQuery("select distinct(a) from ConceptosInstitucion c join c.idConcepto o join o.idAreaTo a where c.idInstitucion.idInstitucion=:idInstitucion and c.activo = true order by a.nombreA");
        query.setParameter("idInstitucion", idInstitucion);
        return query.getResultList();
    }

    @Override
    public List<Areas> findAreasLikeNombre(String nombre) {
          String jpql = null;
        Query q = null;
        jpql = "select a from Areas a where a.nombreA like :nombre order by a.nombreA";
        q = em.createQuery(jpql);
        nombre += "%";
        q.setParameter("nombre", nombre);
        return q.getResultList();
    }

    @Override
    public void updateArea(Areas area) {
        em.merge(area);
    }

    @Override
    public void registrarArea(Areas area) {
        em.persist(area);
    }

}
