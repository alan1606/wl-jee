/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import mx.com.gm.sga.domain.ConceptosInstitucion;


/**
 *
 * @author alanm
 */
/*
@Path("/conceptosInstitucion")
@Stateless

public class ConceptosInstitucionServiceRS {
    
    @Inject
    private ConceptosInstitucionService conceptosInstitucionService;
        
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
    public Response actualizarConceptosInstitucion(@PathParam("id") Long id, ConceptosInstitucion modificado) {
        try {
            ConceptosInstitucion conceptosInstitucion = conceptosInstitucionService.);
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
    
    public void registrarConceptosInstitucion(ConceptosInstitucion conceptoInstitucion);
    
    public void actualizarConceptosInstitucion(ConceptosInstitucion conceptoInstitucion); 
    
}
*/