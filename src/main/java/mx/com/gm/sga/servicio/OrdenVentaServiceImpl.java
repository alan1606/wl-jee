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
import mx.com.gm.sga.datos.OrdenVentaDao;
import mx.com.gm.sga.datos.VentaConceptosDao;
import mx.com.gm.sga.domain.OrdenVenta;
import mx.com.gm.sga.domain.VentaConceptos;

/**
 *
 * @author alanm
 */
@Stateless
@WebService(endpointInterface = "mx.com.gm.sga.servicio.OrdenVentaServiceWs")
@DeclareRoles({"ROLE_ADMIN", "ROLE_USER"})
@RolesAllowed({"ROLE_ADMIN", "ROLE_USER"})

public class OrdenVentaServiceImpl implements OrdenVentaService, OrdenVentaServiceRemote, OrdenVentaServiceWs {

    @Inject
    private OrdenVentaDao ordenVentaDao;
    
    @Inject
    private VentaConceptosDao ventaConceptosDao;

    @Resource
    private SessionContext contexto;

    @Override
    public void registrarOrdenVenta(OrdenVenta orden) {
        ordenVentaDao.registrarOrdenVenta(orden);
    }

    @Override
    public List<OrdenVenta> obtenerOrdenVentaNoPagadosEnFecha(String date) {
        return ordenVentaDao.obtenerNoPagadosEnFecha(date);
    }

    @Override
    public List<OrdenVenta> obtenerOrdenVentaNoPagadosFechaPaciente(String date, Long idPaciente) {
        return ordenVentaDao.obtenerNoPagadosFechaPaciente(date, idPaciente);
    }

    @Override
    public List<OrdenVenta> obtenerOrdenVentaNoPagadosPaciente(String idPaciente) {
        return ordenVentaDao.obtenerNoPagadosPaciente(idPaciente);
    }

    @Override
    public OrdenVenta obtenerUltimaOrdenVentaRegistrada() {
        return ordenVentaDao.obtenerUltimoRegistro();
    }

    @Override
    public List<OrdenVenta> obtenerOrdenVentaConfirmadasEnFecha(String date) {
        return ordenVentaDao.obtenerConfirmadosEnFecha(date);
    }

    @Override
    public List<OrdenVenta> obtenerOrdenVentaConfirmadasFechaPaciente(String date, Long idPaciente) {
        return ordenVentaDao.obtenerConfirmadosFechaPaciente(date, idPaciente);
    }

    @Override
    public List<OrdenVenta> obtenerOrdenVentaConfirmadasPaciente(Long idPaciente) {
        return ordenVentaDao.obtenerConfirmadosPaciente(idPaciente);
    }

    @Override
    public OrdenVenta obtenerOrdenVentaPorId(Long idOrdenVenta) {
        return ordenVentaDao.obtenerOrdenVentaPorId(idOrdenVenta);
    }

    @Override
    public void actualizarOrdenVenta(OrdenVenta ordenVenta) {
        try {
            ordenVentaDao.actualizarOrdenVenta(ordenVenta);
        } catch (Throwable t) {
            contexto.setRollbackOnly();
            t.printStackTrace(System.out);
        }
    }

    @Override
    public double obtenerTotalDeVenta(Long idOrdenVenta) {
        return ordenVentaDao.obtenerTotalDeVenta(idOrdenVenta);
    }

    @Override
    public void actualizarTotalOrdenVenta(OrdenVenta ordenVenta) {
        List<VentaConceptos> conceptos = ventaConceptosDao.findByIdOrdenVenta(ordenVenta.getIdOv());
         ordenVentaDao.actualizarTotalOrdenVenta(ordenVenta, conceptos.get(0).getIdInstitucion().getNombreInstitucion());
    }

    @Override
    public Long obtenerTotalOrdenesEnUnDia(String fecha) {
        return ordenVentaDao.obtenerTotalOrdenesEnUnDia(fecha);
    }

    @Override
    public List<OrdenVenta> obtenerOrdenVentaConfirmadasPagadasEnFecha(String date) {
        return ordenVentaDao.obtenerConfirmadosPagadosEnFecha(date);
    }

    @Override
    public List<OrdenVenta> obtenerOrdenVentaConfirmadasPagadasFechaPaciente(String date, Long idPaciente) {
        return ordenVentaDao.obtenerConfirmadosPagadosFechaPaciente(date, idPaciente);
    }

    @Override
    public List<OrdenVenta> obtenerOrdenVentaConfirmadasPagadasPaciente(Long idPaciente) {
        return ordenVentaDao.obtenerConfirmadosPagadosPaciente(idPaciente);
    }

    @Override
    public void eliminarOrdenVenta(OrdenVenta ordenVenta) {
        ordenVentaDao.eliminarOrdenVenta(ordenVenta);
    }

}
