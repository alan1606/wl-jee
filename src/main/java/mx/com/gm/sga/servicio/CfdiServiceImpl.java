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
import mx.com.gm.sga.datos.CfdiDao;
import mx.com.gm.sga.domain.Cfdi;

/**
 *
 * @author alanm
 */

@Stateless
@WebService(endpointInterface = "mx.com.gm.sga.servicio.CfdiServiceWs")
@DeclareRoles({"ROLE_ADMIN","ROLE_USER"})
@RolesAllowed({"ROLE_ADMIN","ROLE_USER"})

public class CfdiServiceImpl implements CfdiService, CfdiServiceWs{
    
    @Inject
    private CfdiDao cfdiDao;
    
    @Resource
    private SessionContext contexto;
    
    
    @Override
    public Cfdi obtenerCfdiPorClave(String clave) {
        return cfdiDao.obtenerCfdiPorClave(clave);
    }

    @Override
    public List<Cfdi> listarCfdis() {
        return cfdiDao.listarCfdis();
    }

    @Override
    public void registrarCfdi(Cfdi cfdi) {
        cfdiDao.registrarCfdi(cfdi);
    }

    @Override
    public void modificarCfdi(Cfdi cfdi) {
        cfdiDao.modificarCfdi(cfdi);
    }
    
}
