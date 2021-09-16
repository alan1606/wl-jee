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
import mx.com.gm.sga.datos.InstitucionDao;
import mx.com.gm.sga.domain.Institucion;

/**
 *
 * @author alanm
 */
@Stateless
@WebService(endpointInterface = "mx.com.gm.sga.servicio.InstitucionServiceWs")
@DeclareRoles({"ROLE_ADMIN","ROLE_USER"})
@RolesAllowed({"ROLE_ADMIN","ROLE_USER"})

public class InstitucionServiceImpl implements InstitucionService, InstitucionServiceRemote, InstitucionServiceWs{
    
    @Inject
    private InstitucionDao institucionDao;

    @Resource
    private SessionContext contexto;


    @Override
    public Institucion encontrarInstitucionPorId(Institucion institucion) {
        return  institucionDao.findInstitucionById(institucion);
    }

    @Override
    public Institucion encontrarInstitucionPorNombre(Institucion institucion) {
        return institucionDao.findInstitucionByNombre(institucion);
    }

    @Override
    public List<Institucion> listarTodasInstituciones() {
        return institucionDao.findAllInstituciones();
    }

    @Override
    public Institucion findInstitucionByIdOrdenVenta(Long idOrdenVenta) {
        return institucionDao.findInstitucionByIdOrdenVenta(idOrdenVenta);
    }

    @Override
    public Integer obtenerLimiteInstitucion(Long idInstitucion) {
        return institucionDao.obtenerLimiteInstitucion(idInstitucion);
    }

    @Override
    public Long obtenerCantidadDeEstudiosHechosEnInstitucionFecha(Long idInstitucion, String fecha) {
        return institucionDao.obtenerCantidadDeEstudiosHechosEnInstitucionFecha(idInstitucion, fecha);
    }

    @Override
    public boolean aunEsPosibleAgendarEnInstitucion(Long idInstitucion, String fecha) {
        return obtenerLimiteInstitucion(idInstitucion)>obtenerCantidadDeEstudiosHechosEnInstitucionFecha(idInstitucion, fecha);
    }
    
}
