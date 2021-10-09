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
import mx.com.gm.sga.domain.Instrucciones;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author alanm
 */
public class InstruccionesDaoImpl implements InstruccionesDao {

    static Logger log = LogManager.getRootLogger();

    @PersistenceContext(unitName = "SgaPU")
    EntityManager em;

    @Override
    public List<Instrucciones> obtenerTodasInstrucciones() {
        return em.createNamedQuery("Instrucciones.findAll").getResultList();
    }

    @Override
    public void registrarInstrucciones(Instrucciones instrucciones) {
        em.persist(instrucciones);
    }

    @Override
    public Instrucciones encontrarPorNombre(String nombre) {
        String jpql = null;
        Query q = null;
        jpql = "select i from Instrucciones i where i.nombre = :nombre order by i.nombre";
        q = em.createQuery(jpql);
        q.setParameter("nombre", nombre);
        return (Instrucciones) q.getSingleResult();
    }

}
