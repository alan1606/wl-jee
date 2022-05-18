/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import mx.com.gm.sga.domain.Medico;

/**
 *
 * @author alanm
 */
@WebService
public interface MedicoServiceWs {

    @WebMethod
    public void registrarMedico(Medico medico);

    @WebMethod
    public void eliminarMedico(Medico medico);

    @WebMethod
    public Medico buscarMedicoPorId(Integer idMedico);

    @WebMethod
    public List<Medico> obtenerTodosLosMedicos();

    @WebMethod
    public List<Medico> obtenerMedicosReferentes();

    @WebMethod
    public List<Medico> obtenerMedicosRadiologos();

    @WebMethod
    public List<Medico> buscarMedicosPorNombre(String nombre);

    @WebMethod
    public List<Medico> buscarMedicoPorEspecialidad(String especialidad);

    @WebMethod
    public List<Medico> buscarMedicoPorTelefono(String telefono);

    @WebMethod
    public List<Medico> buscarMedicoPorCorreo(String correo);

    @WebMethod
    public void actualizarMedico(Medico medico);

    @WebMethod
    public List<Medico> buscarRerefenteLikeNombre(String nombre);

}
