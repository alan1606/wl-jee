/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import mx.com.gm.sga.datos.UsuariosDao;
import mx.com.gm.sga.domain.Usuarios;

/**
 *
 * @author alanm
 */
@Stateless
@WebService(endpointInterface = "mx.com.gm.sga.servicio.UsuariosServiceWs")
@DeclareRoles({"ROLE_ADMIN", "ROLE_USER"})
@RolesAllowed({"ROLE_ADMIN", "ROLE_USER"})

public class UsuariosServiceImpl implements UsuariosService, UsuariosServiceWs {

    @Inject
    private UsuariosDao usuariosDao;

    @Resource
    private SessionContext contexto;

    @Override
    public boolean esCorrectoLogin(Usuarios usuario) {
        return usuariosDao.esCorrectoLogin(usuario);
    }

}
