/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.datos;

import java.util.List;
import mx.com.gm.sga.domain.Areas;

/**
 *
 * @author alanm
 */
public interface AreasDao {
     public Areas findAreaById(Areas area);
     
     public List<Areas> findAllAreas();
     
     public Areas findAreaByNombre(String nombre);
     
     public List<Areas> findAreasByInstitucion(Long idInstitucion);
     
}
