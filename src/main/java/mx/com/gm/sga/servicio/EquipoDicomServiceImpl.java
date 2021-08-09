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
import mx.com.gm.sga.datos.EquipoDicomDao;
import mx.com.gm.sga.domain.Areas;
import mx.com.gm.sga.domain.EquipoDicom;

/**
 *
 * @author alanm
 */

@Stateless
@WebService(endpointInterface = "mx.com.gm.sga.servicio.EquipoDicomServiceServiceWs")
@DeclareRoles({"ROLE_ADMIN","ROLE_USER"})
@RolesAllowed({"ROLE_ADMIN","ROLE_USER"})

public class EquipoDicomServiceImpl implements EquipoDicomService, EquipoDicomServiceRemote, EquipoDicomServiceWs{

    @Inject
    private EquipoDicomDao equipoDicomDao;

    @Resource
    private SessionContext contexto;
    
    @Override
    public EquipoDicom encontrarEquipoDicomPorId(EquipoDicom equipo) {
        return equipoDicomDao.findEquipoDicomById(equipo);
    }

    @Override
    public List<EquipoDicom> encontrarEquipoDicomPorArea(Areas area) {
        return equipoDicomDao.findEquipoDicomByArea(area);
    }

    @Override
    public List<EquipoDicom> encontrarEquipoDicomPorModalidad(String modalidad) {
        return equipoDicomDao.findEquipoDicomByModalidad(modalidad);
    }
    
}
