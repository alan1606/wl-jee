/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.datos;

import java.util.List;
import mx.com.gm.sga.domain.Pacientes;

/**
 *
 * @author alanm
 */
public interface PacienteDao {
     public List<Pacientes> findAllPacientes();
    
    public Pacientes findPacientesById(Pacientes paciente);
    
    public Pacientes findPacienteByCurp(Pacientes paciente);

    public List<Pacientes> findPacientesVentaConceptosByDate(String fecha);
    
}
