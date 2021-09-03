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
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import mx.com.gm.sga.domain.Mexico;

/**
 *
 * @author alanm
 */
@Path("/mexico")
@Stateless

public class MexicoServiceRS {

    @Inject
    private MexicoService mexicoService;

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("estados")//hace referencia a /personas/{id}
    public List<Mexico> encontrarEstadosDeMexico() {
        return mexicoService.encontrarEstadosDeMexico();
    }

}
