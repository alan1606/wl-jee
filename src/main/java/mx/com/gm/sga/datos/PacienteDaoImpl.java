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
import mx.com.gm.sga.domain.Pacientes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author alanm
 */
public class PacienteDaoImpl implements PacienteDao {

    static Logger log = LogManager.getRootLogger();

    @PersistenceContext(unitName = "SgaPU")
    EntityManager em;

    @Override
    public List<Pacientes> findAllPacientes() {
        String jpql = null;
        Query q = null;
        jpql = "select p from Pacientes p order by p.nombreCompletoP";
        q = em.createQuery(jpql);
        return q.getResultList();
    }

    @Override
    public Pacientes findPacientesById(Pacientes paciente) {
        return em.find(Pacientes.class, paciente.getIdP());
    }

    @Override
    public Pacientes findPacienteByCurp(Pacientes paciente) {
        Query query = em.createQuery("from Pacientes p where p.curpP = :curp");
        query.setParameter("curp", paciente.getCurpP());
        return (Pacientes) query.getSingleResult();
    }

    @Override
    public List<Pacientes> findPacientesVentaConceptosByDate(String fecha) {

        String jpql = null;
        Query q = null;

        jpql = "select distinct v.pacientes from VentaConceptos v where v.fechaVentaVc like :fecha and v.enWorklist = :wl ";

        q = em.createQuery(jpql);
        fecha += "%";
        q.setParameter("fecha", fecha);
        q.setParameter("wl", false);
        return q.getResultList();

    }

    @Override
    public List<Pacientes> findPacienteLikeNombre(String nombre) {
        String jpql = null;
        Query q = null;
        jpql = "select p from Pacientes p where CONCAT(p.nombreP, ' ', p.apaternoP, ' ', p.amaternoP) like :nombre order by p.nombreCompletoP";
        q = em.createQuery(jpql);
        q.setParameter("nombre", "%" + nombre + "%");
        return q.getResultList();
    }

    @Override
    public List<Pacientes> findPacienteLikeCurp(String curp) {
        String jpql = null;
        Query q = null;
        jpql = "select p from Pacientes p where p.curpP like :curp order by p.curpP";
        q = em.createQuery(jpql);
        curp += "%";
        q.setParameter("curp", curp);
        return q.getResultList();
    }

    @Override
    public void registrarPaciente(Pacientes paciente) {
        em.persist(paciente);
    }

    @Override
    public void actualizarPaciente(Pacientes paciente) {
        em.merge(paciente);
    }

}
