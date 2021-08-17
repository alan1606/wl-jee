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
import mx.com.gm.sga.domain.Conceptos;

/**
 *
 * @author alanm
 */

@Path("/conceptos")
@Stateless

public class ConceptosServiceRS {
    
    @Inject
    private ConceptosService conceptosService;


    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")//hace referencia a /personas/{id}
    public Conceptos encontrarConceptoPorId(@PathParam("id") Long id) {
        return conceptosService.encontrarConceptoPorId(new Conceptos(id));
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/ventaConceptos/{idVentaConceptos}")//hace referencia a /personas/{id}
    public List<Conceptos> encontrarConceptosPorIdVentaConceptos(@PathParam("id") Long idVentaConceptos) {
        return conceptosService.encontrarConceptosPorIdVentaConceptos(idVentaConceptos);
    }
    
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/idArea/{idArea}")//hace referencia a /personas/{id}
    public List<Conceptos> encontrarConceptosPorIdArea(@PathParam("idArea") Integer idArea) {
        return conceptosService.encontrarConceptosPorIdArea(idArea);
    }
}
