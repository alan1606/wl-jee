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
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import mx.com.gm.sga.domain.Pacientes;
import mx.com.gm.sga.domain.PagoOrdenVenta;


/**
 *
 * @author alanm
 */
@Path("/pagosOrdenVenta")
@Stateless

public class PagoOrdenVentaServiceRS {
    @Inject
    private PagoOrdenVentaService servicio;
    
    
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response registrarPagoOrdenVenta(PagoOrdenVenta pago) {
        try {
            servicio.registrarPagoOrdenVenta(pago);
            return Response.ok().entity(pago).build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
