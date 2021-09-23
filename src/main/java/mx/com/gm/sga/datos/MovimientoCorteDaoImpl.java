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
import mx.com.gm.sga.domain.MovimientoCorte;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author alanm
 */
public class MovimientoCorteDaoImpl implements MovimientoCorteDao{

    static Logger log = LogManager.getRootLogger();

    @PersistenceContext(unitName = "SgaPU")
    EntityManager em;
    
    @Override
    public List<MovimientoCorte> obtenerMovimientosDeCorteMatutino(String fecha) {
        Query query = em.createQuery("from MovimientoCorte m where m.fecha between :fechaInicio and :fechaFin");
        query.setParameter("fechaInicio", fecha + " 07:00:00");
        query.setParameter("fechaFin", fecha + " 15:59:59");
        return query.getResultList();
    }

    @Override
    public List<MovimientoCorte> obtenerMovimientosDeCorteVespertino(String fecha) {
       Query query = em.createQuery("from MovimientoCorte m where m.fecha between :fechaInicio and :fechaFin");
        query.setParameter("fechaInicio", fecha + " 13:00:00");
        query.setParameter("fechaFin", fecha + " 23:59:59");
        return query.getResultList();
    }

    @Override
    public void registrarMovimientoCorte(MovimientoCorte movimiento) {
        em.persist(movimiento);
    }
    
}
