/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

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
        return pacienteService.listarTodosPacientes();
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
        Pacientes paciente = new Pacientes();
        paciente.setCurpP(curp);
        return pacienteService.encontrarPacientePorCurp(paciente);
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("fecha/{fecha}")//hace referencia a /personas/{id}
    public List<Pacientes> encontrarPacientesEnVentaConceptos(@PathParam("fecha") String fecha) {
        return pacienteService.encontrarEnVentaConceptos(fecha);
    }

    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("likeNombre/{nombre}")//hace referencia a /personas/{id}
    public List<Pacientes> encontrarPacienteLikeNombre(@PathParam("nombre")String nombre){
        return pacienteService.encontrarPacienteLikeNombre(nombre);
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("likeCurp/{curp}")//hace referencia a /personas/{id}
    public List<Pacientes> encontrarPacienteLikeCurp(@PathParam("curp")String curp){
        return pacienteService.encontrarPacienteLikeCurp(curp);
    }

    
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response registrarPaciente(Pacientes paciente) {
        try {
            pacienteService.registrarPaciente(paciente);
            return Response.ok().entity(paciente).build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Response actualizarPaciente(@PathParam("id") Long id, Pacientes pacienteModificado) {
        try {
            Pacientes paciente = pacienteService.encontrarPacientePorId(new Pacientes(id));
            if (paciente != null) {
                pacienteService.actualizarPaciente(pacienteModificado);
                return Response.ok().entity(pacienteModificado).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
}


