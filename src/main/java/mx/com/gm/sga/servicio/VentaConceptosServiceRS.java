/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import mx.com.gm.sga.domain.Institucion;
import mx.com.gm.sga.domain.Pacientes;
import mx.com.gm.sga.domain.VentaConceptos;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author alanm
 */
@Path("/ventaConceptos")
@Stateless

public class VentaConceptosServiceRS {

     static Logger log = LogManager.getRootLogger();

    
    @Inject
    private VentaConceptosService ventaConceptosService;

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<VentaConceptos> listarTodo() {
        return ventaConceptosService.listarTodosVentaConceptos();
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("paciente/{idPaciente}/fecha/{fecha}/enWorklist/{wl}")//hace referencia a /personas/{id}
    public List<VentaConceptos> encontrarVentaConceptosPorPacienteFechaEnWorklist(@PathParam("idPaciente") Long idPaciente, @PathParam("fecha")String fecha, @PathParam("wl") boolean wl) {
        log.debug("Hay, a la vergas");
        return ventaConceptosService.encontrarVentaConceptosPorPacienteFechaEnWorklist(new Pacientes(idPaciente), fecha, wl);
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("institucion/{idInstitucion}/inicio/{fechaInicio}/fin/{fechaFin}")//hace referencia a /personas/{id}
    public List<VentaConceptos> encontrarVentaConceptosPorInstitucionFechas(@PathParam("idInstitucion")Long idInstitucion, @PathParam("fechaInicio")String fechaInicio, @PathParam("fechaFin")String fechaFin) {
        return ventaConceptosService.encontrarVentaConceptosPorInstitucionFechas(new Institucion(idInstitucion), fechaInicio, fechaFin);
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("idPacs/{idPacs}")//hace referencia a /personas/{id}
    public VentaConceptos encontrarVentaConceptosPorIdPacs(@PathParam("idPacs")String idPacs) {
        return ventaConceptosService.encontrarVentaConceptosPorIdPacs(idPacs);
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("actualizarOrdenVenta")//hace referencia a /personas/{id}
    public boolean actualizarOrdenVenta() {
        return ventaConceptosService.actualizarIdOrdenVenta();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("idOrdenVenta/{idOrdenVenta}")//hace referencia a /personas/{id}
    public List<VentaConceptos> encontrarVentaConceptosPorIdOrdenVenta(@PathParam("idOrdenVenta")Long idOrdenVenta) {
        return ventaConceptosService.encontarVentaConceptosPorIdOrdenVenta(idOrdenVenta);
    }
    
}
