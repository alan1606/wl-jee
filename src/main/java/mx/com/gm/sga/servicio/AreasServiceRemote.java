/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import java.util.List;
import javax.ejb.Remote;
import mx.com.gm.sga.domain.Areas;

/**
 *
 * @author alanm
 */
@Remote
public interface AreasServiceRemote {
         public Areas listarPorId(Areas area);
          public List<Areas> listarTodasAreas();
          public Areas obtenerAreaPorNombre(String nombre);
}
