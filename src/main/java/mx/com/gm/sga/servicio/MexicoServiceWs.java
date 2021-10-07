/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import mx.com.gm.sga.domain.Mexico;

/**
 *
 * @author alanm
 */
@WebService
public interface MexicoServiceWs {

    @WebMethod
    public List<Mexico> encontrarEstadosDeMexico();

    @WebMethod
        public Mexico encontrarEstadoPorId(Integer id);

        @WebMethod
        public Mexico encontrarEstadoPorNombre(String nombre);
}
