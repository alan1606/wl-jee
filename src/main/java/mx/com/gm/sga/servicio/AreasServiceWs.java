/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import mx.com.gm.sga.domain.Areas;

/**
 *
 * @author alanm
 */
@WebService
public interface AreasServiceWs {

    @WebMethod
    public Areas listarPorId(Areas area);

    @WebMethod
    public List<Areas> listarTodasAreas();

    @WebMethod
    public Areas obtenerAreaPorNombre(String nombre);
    
    @WebMethod
    public List<Areas> obtenerAreasPorInstitucion(Long idInstitucion);
    
    
    @WebMethod
    public List<Areas> findAreasLikeNombre(String nombre);

        
    @WebMethod
    public void updateArea(Areas area);

    @WebMethod
    public void registrarArea(Areas area);
}
