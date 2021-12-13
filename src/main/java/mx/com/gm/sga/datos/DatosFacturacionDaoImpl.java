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
import mx.com.gm.sga.domain.DatosFacturacion;

/**
 *
 * @author alanm
 */
public class DatosFacturacionDaoImpl implements DatosFacturacionDao {

    @PersistenceContext(unitName = "SgaPU")
    EntityManager em;

    @Override
    public void registrarDatosFacturacion(DatosFacturacion datosFacturacion) {
        em.persist(datosFacturacion);
    }

    @Override
    public void modificarDatosFacturacion(DatosFacturacion datosFacturacion) {
        em.merge(datosFacturacion);
    }

    @Override
    public List<DatosFacturacion> obtenerDatosFacturacionPorIdOrdenVenta(Long idOrdenVenta) {
        Query query = em.createQuery("from DatosFacturacion d where d.idPagoOrdenVenta.idOrdenVenta.idOv = :id");
        query.setParameter("id", idOrdenVenta);
        return query.getResultList();
    }

    @Override
    public DatosFacturacion obtenerDatosFacturacionPorPagoOrdenVenta(Long idPagoOrdenVenta) {
        Query query = em.createQuery("from DatosFacturacion d where d.idPagoOrdenVenta.id = :id");
        query.setParameter("id", idPagoOrdenVenta);
        return (DatosFacturacion) query.getSingleResult();
    }

    @Override
    public DatosFacturacion obtenerDatosFacturacionPorId(Long idDatosFacturacion) {
        return em.find(DatosFacturacion.class, idDatosFacturacion);
    }

}
