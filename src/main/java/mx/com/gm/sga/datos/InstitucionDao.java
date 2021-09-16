/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.datos;

import java.util.List;
import mx.com.gm.sga.domain.Institucion;

/**
 *
 * @author alanm
 */
public interface InstitucionDao {

    public List<Institucion> findAllInstituciones();

    public Institucion findInstitucionById(Institucion institucion);

    public Institucion findInstitucionByNombre(Institucion institucion);
    
    public Institucion findInstitucionByIdOrdenVenta(Long idOrdenVenta);
    
    public Integer obtenerLimiteInstitucion(Long idInstitucion);
    
    public Long obtenerCantidadDeEstudiosHechosEnInstitucionFecha(Long idInstitucion, String fecha);
}
