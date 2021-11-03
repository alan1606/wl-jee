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
import mx.com.gm.sga.domain.OrdenVenta;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author alanm
 */
public class OrdenVentaDaoImpl implements OrdenVentaDao {

    static Logger log = LogManager.getRootLogger();

    @PersistenceContext(unitName = "SgaPU")
    EntityManager em;

    @Override
    public void registrarOrdenVenta(OrdenVenta orden) {
        em.persist(orden);
    }

    @Override
    public List<OrdenVenta> obtenerNoPagadosEnFecha(String date) {
        Query query = em.createQuery("from OrdenVenta v where v.fechaVentaOv like :date and v.pagado=false");
        date += "%";
        query.setParameter("date", date);
        return query.getResultList();
    }

    @Override
    public List<OrdenVenta> obtenerNoPagadosFechaPaciente(String date, Long idPaciente) {
        Query query = em.createQuery("select o from VentaConceptos v join v.idOrdenVenta o join v.idPacienteVc p where p.idP = :idPaciente and o.fechaVentaOv like :date and v.pagado=false");
        date += "%";
        query.setParameter("date", date);
        query.setParameter("idPaciente", idPaciente);
        return query.getResultList();
    }

    @Override
    public List<OrdenVenta> obtenerNoPagadosPaciente(String idPaciente) {
        Query query = em.createQuery("select p from VentaConceptos v join v.idPacienteVc p where p.idP = :idPaciente and v.pagado=false");
        query.setParameter("idPaciente", idPaciente);
        return query.getResultList();
    }

    @Override
    public OrdenVenta obtenerUltimoRegistro() {
        Query query = em.createQuery("select max(o.idOv) from OrdenVenta o");
        Long maximoId = (Long) query.getSingleResult();
        return em.find(OrdenVenta.class, maximoId);
    }

    @Override
    public List<OrdenVenta> obtenerConfirmadosEnFecha(String date) {
        Query query = em.createQuery("select o from VentaConceptos c join c.idOrdenVenta o where c.fechaAsignado = :date and o.pagado=false and c.estado = 'CONFIRMADO' group by o");
        query.setParameter("date", date);
        return query.getResultList();
    }

    @Override
    public List<OrdenVenta> obtenerConfirmadosFechaPaciente(String date, Long idPaciente) {
        Query query = em.createQuery("select o from VentaConceptos v join v.idOrdenVenta o where o.idPacienteOv.idP = :idPaciente and v.fechaAsignado = :date and o.pagado = false and v.estado = 'CONFIRMADO' group by o");
        query.setParameter("date", date);
        query.setParameter("idPaciente", idPaciente);
        return query.getResultList();
    }

    @Override
    public List<OrdenVenta> obtenerConfirmadosPaciente(Long idPaciente) {
        Query query = em.createQuery("select o from VentaConceptos v join v.idOrdenVenta o where o.idPacienteOv.idP = :idPaciente and o.pagado = false and v.estado = 'CONFIRMADO' group by o");
        query.setParameter("idPaciente", idPaciente);
        return query.getResultList();
    }

    @Override
    public OrdenVenta obtenerOrdenVentaPorId(Long idOrdenVenta) {
        return em.find(OrdenVenta.class, idOrdenVenta);
    }

    @Override
    public void actualizarOrdenVenta(OrdenVenta ordenVenta) {
        em.merge(ordenVenta);
    }

    @Override
    public double obtenerTotalDeVenta(Long idOrdenVenta) {
        Query query = em.createQuery("select sum(c.precioPublico) from VentaConceptos v "
                + "join v.idInstitucion i "
                + "join ConceptosInstitucion c ON "
                + "c.idConcepto.idTo = v.idConceptoEs.idTo and i.idInstitucion = c.idInstitucion.idInstitucion "
                + "where v.idOrdenVenta.idOv = :idOrdenVenta");
        query.setParameter("idOrdenVenta", idOrdenVenta);
        return (double) query.getSingleResult();
    }

    @Override
    public void actualizarTotalOrdenVenta(OrdenVenta ordenVenta, String institucion) {
        if (institucion.equals("PARTICULAR")) {
            ordenVenta.setTotalEi(Float.parseFloat(obtenerTotalDeVenta(ordenVenta.getIdOv()) + ""));
        } else {
            ordenVenta.setTotalEl(Float.parseFloat(obtenerTotalDeVenta(ordenVenta.getIdOv()) + ""));
            ordenVenta.setTotalEi(0f);
        }

        actualizarOrdenVenta(ordenVenta);
    }

    @Override
    public Long obtenerTotalOrdenesEnUnDia(String fecha) {
        Long result = 0l;
        try {
            Query query = em.createQuery("select count(o.idOv) from OrdenVenta o where o.fechaVentaOv like :fecha");
            fecha += "%";
            query.setParameter("fecha", fecha);
            result = (Long) query.getSingleResult();
        } catch (Exception e) {
        }
        return result;
    }

    @Override
    public List<OrdenVenta> obtenerConfirmadosPagadosEnFecha(String date) {
        Query query = em.createQuery("select o from VentaConceptos c join c.idOrdenVenta o where c.fechaAsignado = :date  and (c.estado = 'CONFIRMADO' or c.estado = 'PAGADO') group by o");
        query.setParameter("date", date);
        return query.getResultList();
    }

    @Override
    public List<OrdenVenta> obtenerConfirmadosPagadosFechaPaciente(String date, Long idPaciente) {
        Query query = em.createQuery("select o from VentaConceptos v join v.idOrdenVenta o where o.idPacienteOv.idP = :idPaciente and v.fechaAsignado = :date and (v.estado = 'CONFIRMADO' or v.estado = 'PAGADO') group by o");
        query.setParameter("date", date);
        query.setParameter("idPaciente", idPaciente);
        return query.getResultList();
    }

    @Override
    public List<OrdenVenta> obtenerConfirmadosPagadosPaciente(Long idPaciente) {
        Query query = em.createQuery("select o from VentaConceptos v join v.idOrdenVenta o where o.idPacienteOv.idP = :idPaciente  and (v.estado = 'CONFIRMADO' or v.estado = 'PAGADO') group by o");
        query.setParameter("idPaciente", idPaciente);
        return query.getResultList();
    }

    @Override
    public void eliminarOrdenVenta(OrdenVenta ordenVenta) {
        em.remove(em.merge(ordenVenta));
    }

}
