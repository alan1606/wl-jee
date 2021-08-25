/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import mx.com.gm.sga.domain.Pacientes;

/**
 *
 * @author alanm
 */
@WebService
public interface PacienteServiceWs {

    @WebMethod
    public List<Pacientes> listarTodosPacientes();

    @WebMethod
    public Pacientes encontrarPacientePorId(Pacientes paciente);

    @WebMethod
    public Pacientes encontrarPacientePorCurp(Pacientes paciente);

    @WebMethod
    public List<Pacientes> encontrarEnVentaConceptos(String fecha);

    @WebMethod
    public List<Pacientes> encontrarPacienteLikeNombre(String nombre);

    @WebMethod
    public List<Pacientes> encontrarPacienteLikeCurp(String curp);

    @WebMethod
    public void registrarPaciente(Pacientes paciente);

    @WebMethod
    public void actualizarPaciente(Pacientes paciente);
}
