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
import mx.com.gm.sga.datos.VentaConceptosDao;
import mx.com.gm.sga.domain.Institucion;
import mx.com.gm.sga.domain.Pacientes;
import mx.com.gm.sga.domain.VentaConceptos;

/**
 *
 * @author alanm
 */
@Stateless
@WebService(endpointInterface = "mx.com.gm.sga.servicio.VentaConceptosServiceWs")
@DeclareRoles({"ROLE_ADMIN", "ROLE_USER"})
@RolesAllowed({"ROLE_ADMIN", "ROLE_USER"})

public class VentaConceptosServiceImpl implements VentaConceptosService, VentaConceptosServiceRemote, VentaConceptosServiceWs {

    
    
    @Inject
    private VentaConceptosDao ventaConceptosDao;

    @Resource
    private SessionContext contexto;

    @Override
    public List<VentaConceptos> listarTodo() {
        return ventaConceptosDao.findAllVentaConceptos();
    }

    @Override
    public List<VentaConceptos> encontrarVentaConceptosPorPacienteFechaEnWorklist(Pacientes paciente, String fecha, boolean enWorklist) {
        return ventaConceptosDao.findVentaConceptosByPacienteFechaEnWorklist(paciente, fecha, enWorklist);
    }

    @Override
    public List<VentaConceptos> encontrarVentaConceptosPorInstitucionFechas(Institucion institucion, String fechaInicio, String fechaFin) {
        return ventaConceptosDao.findVentaConceptosByInstitucionFechas(institucion, fechaInicio, fechaFin);
    }

    @Override
    public VentaConceptos encontrarVentaConceptosPorIdPacs(String idPacs) {
        return ventaConceptosDao.findByIdPacs(idPacs);
    }

    @Override
    public boolean actualizarIdOrdenVenta() {
        return ventaConceptosDao.actualizarIdOrdenVenta();
    }

    @Override
    public List<VentaConceptos> encontarVentaConceptosPorIdOrdenVenta(Long idOrdenVenta) {
        return ventaConceptosDao.findByIdOrdenVenta(idOrdenVenta);
    }

    @Override
    public List<VentaConceptos> encontrarAgendadosPorAreaEquipoDicomFecha(Integer idArea, Long idEquipoDicom, String fecha) {
        return ventaConceptosDao.findAgendadosByAreaEquipoDicomFecha(idArea, idEquipoDicom, fecha);
    }

    @Override
    public List<VentaConceptos> encontrarAgendadosPorAreaEquipoDicomFechaInstitucion(Integer idArea, Long idEquipoDicom, String fecha, Long idInstitucion) {
        return ventaConceptosDao.findAgendadosByAreaEquipoDicomFechaInstitucion(idArea, idEquipoDicom, fecha, idInstitucion);
    }

    
    
}
