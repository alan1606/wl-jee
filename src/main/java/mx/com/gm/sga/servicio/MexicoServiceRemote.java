/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import java.util.List;
import javax.ejb.Remote;
import mx.com.gm.sga.domain.Mexico;

/**
 *
 * @author alanm
 */
@Remote
public interface MexicoServiceRemote {
    
        public List<Mexico> encontrarEstadosDeMexico();

}
