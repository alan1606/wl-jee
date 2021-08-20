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

import mx.com.gm.sga.domain.Institucion;

/**
 *
 * @author alanm
 */

@Path("/instituciones")
@Stateless

public class InstitucionServiceRS {
 
    @Inject
    private InstitucionService institucioService;

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Institucion> listarInstituciones() {
        return institucioService.listarTodasInstituciones();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")//hace referencia a /personas/{id}
    public Institucion encontrarInstitucionPorId(@PathParam("id") Long id) {
        return institucioService.encontrarInstitucionPorId(new Institucion(id));
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("nombre/{nombre}")//hace referencia a /personas/{id}
    public Institucion encontrarInstitucionPorNombre(@PathParam("nombre") String nombre) {
        return institucioService.encontrarInstitucionPorNombre(new Institucion(Long.parseLong("1"), nombre));
    }
    
}
