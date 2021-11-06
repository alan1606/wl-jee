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
import mx.com.gm.sga.domain.Paquete;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author alanm
 */
public class PaqueteDaoImpl implements PaqueteDao {

    static Logger log = LogManager.getRootLogger();

    @PersistenceContext(unitName = "SgaPU")
    EntityManager em;

    @Override
    public List<Paquete> listarPaquetes() {
        return em.createNamedQuery("Paquete.findAll").getResultList();
    }

    @Override
    public Paquete encontrarPaquetePorId(Long idPaquete) {
        return em.find(Paquete.class, idPaquete);
    }

    @Override
    public void registrarPaquete(Paquete paquete) {
        em.persist(paquete);
    }

    @Override
    public void modificarPaquete(Paquete paquete) {
        em.merge(paquete);
    }

    @Override
    public void eliminarPaquete(Paquete paquete) {
        em.remove(em.merge(paquete));
    }

    @Override
    public Paquete obtenerPaquetePorNombre(String nombre) {
        Query query = em.createQuery("from Paquete p where p.idConcepto.conceptoTo = :nombre");
        query.setParameter("nombre", nombre);
        return (Paquete) query.getSingleResult();
    }

    @Override
    public List<Paquete> obtenerPaquetesLikeNombre(String nombre) {
        Query query = em.createQuery("from Paquete p where p.idConcepto.conceptoTo like :nombre");
        query.setParameter("nombre", "%" + nombre + "%");
        return query.getResultList();
    }

}
