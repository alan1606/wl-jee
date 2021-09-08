/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import mx.com.gm.sga.domain.Institucion;

/**
 *
 * @author alanm
 */
@WebService
public interface InstitucionServiceWs {

    @WebMethod
    public List<Institucion> listarTodasInstituciones();

    @WebMethod
    public Institucion encontrarInstitucionPorId(Institucion institucion);

    @WebMethod
    public Institucion encontrarInstitucionPorNombre(Institucion institucion);
    
    @WebMethod
     public Institucion findInstitucionByIdOrdenVenta(Long idOrdenVenta);

}
