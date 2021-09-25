/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import java.util.List;
import javax.ejb.Local;
import mx.com.gm.sga.domain.Areas;

/**
 *
 * @author alanm
 */
@Local
public interface AreasService {

    public Areas listarPorId(Areas area);

    public List<Areas> listarTodasAreas();

    public Areas obtenerAreaPorNombre(String nombre);

    public List<Areas> obtenerAreasPorInstitucion(Long idInstitucion);

        public List<Areas> findAreasLikeNombre(String nombre);

    public void updateArea(Areas area);

    public void registrarArea(Areas area);
    
}
