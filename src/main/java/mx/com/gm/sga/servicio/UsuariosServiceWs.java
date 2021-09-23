/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import javax.jws.WebMethod;
import javax.jws.WebService;
import mx.com.gm.sga.domain.Usuarios;

/**
 *
 * @author alanm
 */
@WebService
public interface UsuariosServiceWs {
    @WebMethod
        public boolean esCorrectoLogin(Usuarios usuario);

}
