/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import java.util.List;
import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import mx.com.gm.sga.datos.MexicoDao;
import mx.com.gm.sga.domain.Mexico;

/**
 *
 * @author alanm
 */
@Stateless
@WebService(endpointInterface = "mx.com.gm.sga.servicio.MexicoServiceWs")
@DeclareRoles({"ROLE_ADMIN", "ROLE_USER"})
@RolesAllowed({"ROLE_ADMIN", "ROLE_USER"})


public class MexicoServiceImpl implements MexicoService, MexicoServiceRemote, MexicoServiceWs {

    @Inject
    private MexicoDao mexicoDao;

    @Resource
    private SessionContext contexto;

    @Override
    public List<Mexico> encontrarEstadosDeMexico() {
        return mexicoDao.encontrarEstadosDeMexico();
    }

    @Override
    public Mexico encontrarEstadoPorId(Integer id) {
        return mexicoDao.encontrarEstadoPorId(id);
    }

    @Override
    public Mexico encontrarEstadoPorNombre(String nombre) {
        return mexicoDao.encontrarEstadoPorNombre(nombre);
    }
    

}
