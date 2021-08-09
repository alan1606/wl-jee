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
import mx.com.gm.sga.domain.Institucion;

/**
 *
 * @author alanm
 */
public class InstitucionDaoImpl implements InstitucionDao {

    @PersistenceContext(unitName = "SgaPU")
    EntityManager em;


    @Override
    public Institucion findInstitucionById(Institucion institucion) {
        return em.find(Institucion.class, institucion.getIdInstitucion());
    }

    @Override
    public Institucion findInstitucionByNombre(Institucion institucion) {
        Query query = em.createQuery("from Institucion i where i.nombreInstitucion= :nombre");
        query.setParameter("nombre", institucion.getNombreInstitucion());
        return (Institucion) query.getSingleResult();
    }

    @Override
    public List<Institucion> findAllInstituciones() {
        return em.createNamedQuery("Institucion.findAll").getResultList();
    }

}
