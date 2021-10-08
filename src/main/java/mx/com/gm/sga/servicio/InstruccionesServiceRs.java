/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import mx.com.gm.sga.domain.Instrucciones;

/**
 *
 * @author alanm
 */
@Path("/instrucciones")
@Stateless
public class InstruccionesServiceRs {

    @Inject
    private InstruccionesService instruccionesService;

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Instrucciones> listarInstrucciones() {
        return instruccionesService.obtenerTodasInstrucciones();
    }

    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response registrarInstrucciones(Instrucciones instrucciones) {
        try {
            instruccionesService.registrarInstrucciones(instrucciones);
            return Response.ok().entity(instrucciones).build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
