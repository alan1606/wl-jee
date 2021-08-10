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
import mx.com.gm.sga.datos.PacienteDao;
import mx.com.gm.sga.domain.Pacientes;

/**
 *
 * @author alanm
 */
@Stateless
@WebService(endpointInterface = "mx.com.gm.sga.servicio.PacienteServiceWs")
@DeclareRoles({"ROLE_ADMIN","ROLE_USER"})
@RolesAllowed({"ROLE_ADMIN","ROLE_USER"})

public class PacienteServiceImpl implements PacienteService, PacienteServiceRemote, PacienteServiceWs{
    
    @Inject
    private PacienteDao pacienteDao;

    @Resource
    private SessionContext contexto;

    @Override
    public List<Pacientes> listarTodo() {
        return pacienteDao.findAllPacientes();
    }

    @Override
    public Pacientes encontrarPacientePorId(Pacientes paciente) {
        return pacienteDao.findPacientesById(paciente);
    }

    @Override
    public Pacientes encontrarPacientePorCurp(Pacientes paciente) {
        return pacienteDao.findPacienteByCurp(paciente);
    }

    @Override
    public List<Pacientes> encontrarEnVentaConceptos(String fecha) {
        return pacienteDao.findPacientesVentaConceptosByDate(fecha);
    }
    
}
