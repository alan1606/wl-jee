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
import mx.com.gm.sga.domain.Areas;

/**
 *
 * @author alanm
 */
@Path("/areas")
@Stateless

public class AreasServiceRS {
    
    @Inject
    private AreasService areasService;


    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")//hace referencia a /personas/{id}
    public Areas encontrarAreaPorId(@PathParam("id") int id) {
        return areasService.listarPorId(new Areas(id));
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Areas> listarAreas() {
        return areasService.listarTodo();
    }
    
}
