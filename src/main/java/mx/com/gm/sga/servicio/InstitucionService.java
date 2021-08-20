/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import java.util.List;
import javax.ejb.Local;
import mx.com.gm.sga.domain.Institucion;

/**
 *
 * @author alanm
 */
@Local
public interface InstitucionService {
    public List<Institucion> listarTodasInstituciones();

    public Institucion encontrarInstitucionPorId(Institucion institucion);

    public Institucion encontrarInstitucionPorNombre(Institucion institucion);

}
