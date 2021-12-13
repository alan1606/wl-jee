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
import mx.com.gm.sga.domain.Devolucion;

/**
 *
 * @author alanm
 */
public class DevolucionDaoImpl implements DevolucionDao {

    @PersistenceContext(unitName = "SgaPU")
    EntityManager em;

    @Override
    public void registrarDevolucion(Devolucion devolucion) {
        em.persist(devolucion);
    }

    @Override
    public List<Devolucion> buscarDevolucionesPorFecha(String fecha) {
        Query query = em.createQuery("from Devolucion d where d.fecha = :fecha");
        query.setParameter("fecha", fecha);
        return query.getResultList();
    }

    @Override
    public Devolucion encontrarDevolucionPorId(Long id) {
        return em.find(Devolucion.class, id);
    }

    @Override
    public List<Devolucion> obtenerDevolucionesPorIdOrdenVenta(Long idOrden) {
        Query query = em.createQuery("from Devolucion d where d.idOrdenVenta.idOv = :id");
        query.setParameter("id", idOrden);
        return query.getResultList();
    }

    @Override
    public Devolucion obtenerDevolucionPorIdPagoOrdenVenta(Long id) {
        Query query = em.createQuery("from Devolucion d where d.idPagoOrdenVenta.id = :id");
        query.setParameter("id", id);
        return (Devolucion) query.getSingleResult();
    }

}
