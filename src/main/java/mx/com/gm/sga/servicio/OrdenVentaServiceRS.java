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
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import mx.com.gm.sga.domain.OrdenVenta;
import mx.com.gm.sga.domain.Pacientes;

/**
 *
 * @author alanm
 */
@Path("/ordenesVenta")
@Stateless

public class OrdenVentaServiceRS {

    @Inject
    private OrdenVentaService ordenVentaService;

    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response registrarPaciente(OrdenVenta ordenVenta) {
        try {
            ordenVentaService.registrarOrdenVenta(ordenVenta);
            return Response.ok().entity(ordenVenta).build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("fecha/{fecha}")//hace referencia a /personas/{id}
    public List<OrdenVenta> obtenerOrdenVentaNoPagadosEnFecha(@PathParam("fecha") String date) {
        return ordenVentaService.obtenerOrdenVentaNoPagadosEnFecha(date);
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("fecha/{fecha}/paciente/{id}")//hace referencia a /personas/{id}
    public List<OrdenVenta> obtenerOrdenVentaNoPagadosFechaPaciente(@PathParam("fecha") String date, @PathParam("id") Long idPaciente) {
        return ordenVentaService.obtenerOrdenVentaNoPagadosFechaPaciente(date, idPaciente);
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("paciente/{id}")//hace referencia a /personas/{id}
    public List<OrdenVenta> obtenerOrdenVentaNoPagadosPaciente(@PathParam("id") String idPaciente) {
        return ordenVentaService.obtenerOrdenVentaNoPagadosPaciente(idPaciente);
    }
    
   @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("total/{idOrdenVenta}")//hace referencia a /personas/{id}
    public double obtenerTotalOrdenVenta(@PathParam("idOrdenVenta") Long idOrdenVenta) {
        return ordenVentaService.obtenerTotalDeVenta(idOrdenVenta);
    }

}
