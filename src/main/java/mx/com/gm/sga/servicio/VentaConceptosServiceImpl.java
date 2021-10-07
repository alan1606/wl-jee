/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import mx.com.gm.sga.datos.VentaConceptosDao;
import mx.com.gm.sga.domain.Conceptos;
import mx.com.gm.sga.domain.EquipoDicom;
import mx.com.gm.sga.domain.Institucion;
import mx.com.gm.sga.domain.OrdenVenta;
import mx.com.gm.sga.domain.Pacientes;
import mx.com.gm.sga.domain.VentaConceptos;

/**
 *
 * @author alanm
 */
@Stateless
@WebService(endpointInterface = "mx.com.gm.sga.servicio.VentaConceptosServiceWs")
@DeclareRoles({"ROLE_ADMIN", "ROLE_USER", "ROLE_GUEST"})
@RolesAllowed({"ROLE_ADMIN", "ROLE_USER", "ROLE_GUEST"})

public class VentaConceptosServiceImpl implements VentaConceptosService, VentaConceptosServiceRemote, VentaConceptosServiceWs {

    @Inject
    private VentaConceptosDao ventaConceptosDao;

    @Resource
    private SessionContext contexto;

    @Override
    public List<VentaConceptos> listarTodosVentaConceptos() {
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

    @Override
    public void registrarVentaConceptos(VentaConceptos ventaConceptos) {
        ventaConceptosDao.registrarVentaConceptos(ventaConceptos);
    }

    @Override
    public void registrarVentaConceptosList(List<VentaConceptos> ventaConceptos) {
        ventaConceptosDao.registrarVentaConceptosList(ventaConceptos);
    }

    @Override
    public VentaConceptos encontrarVentaConceptoPorOrdenVentaConceptoHoraAsignado(OrdenVenta ordenVenta, Conceptos conceptos, String horaAsingnado) {
        return ventaConceptosDao.findByOrdenVentaConceptoHoraAsignado(ordenVenta, conceptos, horaAsingnado);
    }

    @Override
    public VentaConceptos encontrarVentaConceptosPorId(Long id) {
        return ventaConceptosDao.findById(id);
    }

    @Override
    public void eliminarVentaConceptos(VentaConceptos venta) {
        ventaConceptosDao.eliminarVentaConceptos(venta);
    }

    @Override
    public Long encontrarNumeroVentaConceptosPorEquipoFechaHora(EquipoDicom equipo, String fecha, String horaAsingnado) {
        return ventaConceptosDao.findCountByEquipoFechaHora(equipo, fecha, horaAsingnado);
    }

    @Override
    public List<VentaConceptos> findAgendadosByFecha(String fecha) {
        return ventaConceptosDao.findAgendadosByFecha(fecha);
    }

    @Override
    public void actualizarVentaConceptos(VentaConceptos venta) {
        ventaConceptosDao.actualizarVentaConceptos(venta);
    }

    @Override
    public List<Object[]> findCorteMatutino(String fecha) {
        return ventaConceptosDao.findCorteMatutino(fecha);
    }

    @Override
    public List<Object[]> findCorteVespertino(String fecha) {
        return ventaConceptosDao.findCorteVespertino(fecha);
    }

    @Override
    public List<Object[]> obtenerTotalesCorteMatutinoPorInstitucion(String fecha) {
        return ventaConceptosDao.obtenerTotalesCorteMatutinoPorInstitucion(fecha);
    }

    @Override
    public List<Object[]> obtenerTotalesCorteVespertinoPorInstitucion(String fecha) {
        return ventaConceptosDao.obtenerTotalesCorteVespertinoPorInstitucion(fecha);
    }

    @Override
    public List<Object[]> obtenerTotalesCorteMatutinoPorFormaDePago(String fecha) {
        return ventaConceptosDao.obtenerTotalesCorteMatutinoPorFormaDePago(fecha);
    }

    @Override
    public List<Object[]> obtenerTotalesCorteVespertinoPorFormaDePago(String fecha) {
        return ventaConceptosDao.obtenerTotalesCorteVespertinoPorFormaDePago(fecha);
    }

    @Override
    public List<Object[]> obtenerTotalesCorteMatutinoPorInstitucionArea(String fecha) {
        return ventaConceptosDao.obtenerTotalesCorteMatutinoPorInstitucionArea(fecha);
    }

    @Override
    public List<Object[]> obtenerTotalesCorteVespertinoPorInstitucionArea(String fecha) {
        return ventaConceptosDao.obtenerTotalesCorteVespertinoPorInstitucionArea(fecha);
    }

    @Override
    public void eliminarVentaConceptosPorIdOrdenVenta(Long idOrdenVenta) {
        ventaConceptosDao.eliminarVentaConceptosPorIdOrdenVenta(idOrdenVenta);
    }

    @Override
    public Long esCandidatoParaEliminarConceptosDeOrden(Long idOrdenVenta) {
        return ventaConceptosDao.esCandidatoParaEliminarConceptosDeOrden(idOrdenVenta);
    }

}
