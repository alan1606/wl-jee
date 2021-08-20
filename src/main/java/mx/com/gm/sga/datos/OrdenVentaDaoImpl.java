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

}
