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

/**
 *
 * @author alanm
 */
public class PacienteDaoImpl implements PacienteDao {

    @PersistenceContext(unitName = "SgaPU")
    EntityManager em;

    @Override
    public List<Pacientes> findAllPacientes() {
        return em.createNamedQuery("Pacientes.findAll").getResultList();
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

}
