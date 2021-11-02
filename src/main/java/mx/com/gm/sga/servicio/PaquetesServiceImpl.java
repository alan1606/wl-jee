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
import mx.com.gm.sga.datos.ConceptoPaqueteDao;
import mx.com.gm.sga.datos.PaqueteDao;
import mx.com.gm.sga.domain.ConceptoPaquete;
import mx.com.gm.sga.domain.Conceptos;
import mx.com.gm.sga.domain.Paquete;

/**
 *
 * @author alanm
 */

@Stateless
@WebService(endpointInterface = "mx.com.gm.sga.servicio.PaquetesServiceWs")
@DeclareRoles({"ROLE_ADMIN","ROLE_USER"})
@RolesAllowed({"ROLE_ADMIN","ROLE_USER"})

public class PaquetesServiceImpl implements PaquetesService, PaquetesServiceWs{

     @Inject
    private PaqueteDao paqueteDao;

     @Inject
     private ConceptoPaqueteDao conceptoPaqueteDao;
     
    @Resource
    private SessionContext contexto;
    
    @Override
    public List<Paquete> listarPaquetes() {
        return paqueteDao.listarPaquetes();
    }

    @Override
    public Paquete encontrarPaquetePorId(Long idPaquete) {
        return paqueteDao.encontrarPaquetePorId(idPaquete);
    }

    @Override
    public void registrarPaquete(Paquete paquete) {
        paqueteDao.registrarPaquete(paquete);
    }

    @Override
    public void modificarPaquete(Paquete paquete) {
        paqueteDao.modificarPaquete(paquete);
    }

    @Override
    public void eliminarPaquete(Paquete paquete) {
        paqueteDao.eliminarPaquete(paquete);
    }

    @Override
    public void registrarConceptoPaquete(ConceptoPaquete conceptoPaquete) {
        conceptoPaqueteDao.registrarConceptoPaquete(conceptoPaquete);
    }

    @Override
    public void eliminarConceptoPaquete(ConceptoPaquete conceptoPaquete) {
        conceptoPaqueteDao.eliminarConceptoPaquete(conceptoPaquete);
    }

    @Override
    public List<Conceptos> obtenerConceptosDePaquete(Long idPaquete) {
        return conceptoPaqueteDao.obtenerConceptosDePaquete(idPaquete);
    }
    
}
