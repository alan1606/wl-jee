/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import java.util.List;
import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import mx.com.gm.sga.datos.MedicoDao;
import mx.com.gm.sga.domain.Medico;

/**
 *
 * @author alanm
 */
@Stateless
@WebService(endpointInterface = "mx.com.gm.sga.servicio.MedicoServiceWs")
@DeclareRoles({"ROLE_ADMIN", "ROLE_USER"})
@RolesAllowed({"ROLE_ADMIN", "ROLE_USER"})

public class MedicoServiceImpl implements MedicoService, MedicoServiceWs{

    @Resource
    private SessionContext contexto;

    @Inject
    private MedicoDao medicoDao;
    
    @Override
    public void registrarMedico(Medico medico) {
        medicoDao.registrarMedico(medico);
    }

    @Override
    public void eliminarMedico(Medico medico) {
        medicoDao.eliminarMedico(medico);
    }

    @Override
    public Medico buscarMedicoPorId(Integer idMedico) {
        return medicoDao.buscarMedicoPorId(idMedico);
    }

    @Override
    public List<Medico> obtenerTodosLosMedicos() {
        return medicoDao.obtenerTodosLosMedicos();
    }

    @Override
    public List<Medico> obtenerMedicosReferentes() {
        return medicoDao.obtenerMedicosReferentes();
    }

    @Override
    public List<Medico> obtenerMedicosRadiologos() {
        return medicoDao.obtenerMedicosRadiologos();
    }

    @Override
    public List<Medico> buscarMedicosPorNombre(String nombre) {
        return medicoDao.buscarMedicosPorNombre(nombre);
    }

    @Override
    public List<Medico> buscarMedicoPorEspecialidad(String especialidad) {
        return medicoDao.buscarMedicoPorEspecialidad(especialidad);
    }

    @Override
    public List<Medico> buscarMedicoPorTelefono(String telefono) {
        return medicoDao.buscarMedicoPorTelefono(telefono);
    }

    @Override
    public List<Medico> buscarMedicoPorCorreo(String correo) {
        return medicoDao.buscarMedicoPorCorreo(correo);
    }

    @Override
    public void actualizarMedico(Medico medico) {
        medicoDao.actualizarMedico(medico);
    }
    
}
