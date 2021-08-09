/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import mx.com.gm.sga.domain.Pacientes;

/**
 *
 * @author alanm
 */
@Path("/pacientes")
@Stateless

public class PacienteServiceRS {

    @Inject
    private PacienteService pacienteService;

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Pacientes> listarPacientes() {
        return pacienteService.listarTodo();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")//hace referencia a /personas/{id}
    public Pacientes encontrarPacientePorId(@PathParam("id") Long id) {
        return pacienteService.encontrarPacientePorId(new Pacientes(id));
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("curp/{curp}")//hace referencia a /personas/{id}
    public Pacientes encontrarPacientePorCurp(@PathParam("curp") String curp) {
        return pacienteService.encontrarPacientePorCurp(new Pacientes(curp));
    }
    
}
