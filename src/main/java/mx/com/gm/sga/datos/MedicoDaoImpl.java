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
import mx.com.gm.sga.domain.Medico;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author alanm
 */
public class MedicoDaoImpl implements MedicoDao {

    static Logger log = LogManager.getRootLogger();

    @PersistenceContext(unitName = "SgaPU")
    EntityManager em;

    @Override
    public void registrarMedico(Medico medico) {
        em.persist(medico);
    }

    @Override
    public void eliminarMedico(Medico medico) {
        em.remove(em.merge(medico));
    }

    @Override
    public Medico buscarMedicoPorId(Integer idMedico) {
        return em.find(Medico.class, idMedico);
    }

    @Override
    public List<Medico> obtenerTodosLosMedicos() {
        return em.createNamedQuery("Medico.findAll").getResultList();
    }

    @Override
    public List<Medico> obtenerMedicosReferentes() {
        Query query = em.createNamedQuery("Medico.findByRadiologo");
        query.setParameter("radiologo", false);
        return query.getResultList();
    }

    @Override
    public List<Medico> obtenerMedicosRadiologos() {
        Query query = em.createNamedQuery("Medico.findByRadiologo");
        query.setParameter("radiologo", true);
        return query.getResultList();
    }

    @Override
    public List<Medico> buscarMedicosPorNombre(String nombre) {
        Query query = em.createQuery("from Medico m where m.nombres like :nombre or m.apellidos like :nombre");
        nombre += "%";
        query.setParameter("nombre", nombre);
        return query.getResultList();
    }

    @Override
    public List<Medico> buscarMedicoPorEspecialidad(String especialidad) {
        Query query = em.createQuery("from Medico m where m.especialidad like :especialidad");
        especialidad += "%";
        query.setParameter("especialidad", especialidad);
        return query.getResultList();
    }

    @Override
    public List<Medico> buscarMedicoPorTelefono(String telefono) {
        Query query = em.createQuery("from Medico m where m.telefono like :telefono or m.whatsapp like :telefono");
        telefono += "%";
        query.setParameter("telefono", telefono);
        return query.getResultList();
    }

    @Override
    public List<Medico> buscarMedicoPorCorreo(String correo) {
        Query query = em.createQuery("from Medico m where m.correo like :correo");
        correo += "%";
        query.setParameter("correo", correo);
        return query.getResultList();
    }

    @Override
    public void actualizarMedico(Medico medico) {
        em.merge(medico);
    }

}
