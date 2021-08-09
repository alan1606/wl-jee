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
import mx.com.gm.sga.domain.Areas;
import mx.com.gm.sga.domain.EquipoDicom;

/**
 *
 * @author alanm
 */
@Path("/equiposDicom")
@Stateless

public class EquipoDicomServiceRS {
    
    @Inject
    private EquipoDicomService equipoDicomService;


    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")//hace referencia a /personas/{id}
    public EquipoDicom encontrarEquipoDicomPorId(@PathParam("id") Long id) {
        return equipoDicomService.encontrarEquipoDicomPorId(new EquipoDicom(id));
    }
    
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("area/{idArea}")//hace referencia a /personas/{id}
    public List<EquipoDicom> encontrarEquipoDicomPorArea(@PathParam("idArea") Integer idArea) {
        return equipoDicomService.encontrarEquipoDicomPorArea(new Areas(idArea));
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("modalidad/{modalidad}")//hace referencia a /personas/{id}
    public List<EquipoDicom> encontrarEquipoDicomPorModalidad(@PathParam("modalidad") String modalidad) {
        return equipoDicomService.encontrarEquipoDicomPorModalidad(modalidad);
    }
}
