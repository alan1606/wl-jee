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

    @Override
    public Institucion findInstitucionByIdOrdenVenta(Long idOrdenVenta) {
        Query query = em.createQuery("select i from VentaConceptos v join v.idInstitucion i where v.idOrdenVenta.idOv = :idOrdenVenta group by v.idOrdenVenta  order by i.nombreInstitucion");
        query.setParameter("idOrdenVenta", idOrdenVenta);
        return (Institucion) query.getSingleResult();
    }

    @Override
    public Integer obtenerLimiteInstitucion(Long idInstitucion) {
        Query query = em.createQuery("select i.limite from Institucion i where i.idInstitucion = :id");
        query.setParameter("id", idInstitucion);
        return (Integer) query.getSingleResult();
    }

    @Override
    public Long obtenerCantidadDeEstudiosHechosEnInstitucionFecha(Long idInstitucion, String fecha) {
        Long result = 0l;
        try {
            Query query = em.createQuery("select count(v.idInstitucion.idInstitucion) from VentaConceptos v where v.fechaAsignado = :fecha  and v.idInstitucion.idInstitucion = :idInstitucion group by v.idInstitucion.idInstitucion");
            query.setParameter("fecha", fecha);
            query.setParameter("idInstitucion", idInstitucion);
            result = (Long) query.getSingleResult();
        } catch (Exception e) {
        }
        return result;
    }

}
