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
import mx.com.gm.sga.datos.InstruccionesDao;
import mx.com.gm.sga.domain.Instrucciones;

/**
 *
 * @author alanm
 */
@Stateless
@WebService(endpointInterface = "mx.com.gm.sga.servicio.InstruccionesServiceWs")
@DeclareRoles({"ROLE_ADMIN", "ROLE_USER"})
@RolesAllowed({"ROLE_ADMIN", "ROLE_USER"})

public class InstruccionesServiceImpl implements InstruccionesService, InstruccionesServiceWs{

    @Inject
    private InstruccionesDao instruccionesDao;
    
     @Resource
    private SessionContext contexto;
    
    @Override
    public List<Instrucciones> obtenerTodasInstrucciones() {
        return instruccionesDao.obtenerTodasInstrucciones();
    }

    @Override
    public void registrarInstrucciones(Instrucciones instrucciones) {
        instruccionesDao.registrarInstrucciones(instrucciones);
    }

    @Override
    public Instrucciones encontrarInstruccionesPorNombre(String nombre) {
        return instruccionesDao.encontrarPorNombre(nombre);
    }

 

 
    
}
