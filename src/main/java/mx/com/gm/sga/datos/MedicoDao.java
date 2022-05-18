/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.datos;

import java.util.List;
import mx.com.gm.sga.domain.Medico;

/**
 *
 * @author alanm
 */
public interface MedicoDao {
    
    public void registrarMedico(Medico medico);
    
    public void eliminarMedico(Medico medico);
    
    public Medico buscarMedicoPorId(Integer idMedico);
    
    public List<Medico> obtenerTodosLosMedicos();
    
    public List<Medico> obtenerMedicosReferentes();
    
    public List<Medico> obtenerMedicosRadiologos();
    
    public List<Medico> buscarMedicosPorNombre(String nombre);
    
    public List<Medico> buscarMedicoPorEspecialidad(String especialidad);
    
    public List<Medico> buscarMedicoPorTelefono(String telefono);
    
    public List<Medico> buscarMedicoPorCorreo(String correo);
    
    public void actualizarMedico(Medico medico);
    
    public List<Medico> buscarReferenteLikeNombre(String nombre);
}
