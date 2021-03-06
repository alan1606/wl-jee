/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import java.util.List;
import javax.ejb.Local;
import mx.com.gm.sga.domain.Pacientes;

/**
 *
 * @author alanm
 */
@Local
public interface PacienteService {
    
    public List<Pacientes> listarTodosPacientes();
    
    public Pacientes encontrarPacientePorId(Pacientes paciente);
    
    public Pacientes encontrarPacientePorCurp(Pacientes paciente);
    
    public List<Pacientes> encontrarEnVentaConceptos(String fecha);
    
    public List<Pacientes> encontrarPacienteLikeNombre(String nombre);
    
    public List<Pacientes> encontrarPacienteLikeCurp(String curp);
    
    public void registrarPaciente(Pacientes paciente);
    
    public void actualizarPaciente(Pacientes paciente);
}
