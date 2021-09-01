/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import java.util.Date;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
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
@WebService
public interface VentaConceptosServiceWs {

    @WebMethod
    public List<VentaConceptos> listarTodosVentaConceptos();

    @WebMethod
    public List<VentaConceptos> encontrarVentaConceptosPorPacienteFechaEnWorklist(Pacientes paciente, String fecha, boolean enWorklist);

    @WebMethod
    public List<VentaConceptos> encontrarVentaConceptosPorInstitucionFechas(Institucion institucion, String fechaInicio, String fechaFin);

    @WebMethod
    public VentaConceptos encontrarVentaConceptosPorIdPacs(String idPacs);

    @WebMethod
    public boolean actualizarIdOrdenVenta();

    @WebMethod
    public List<VentaConceptos> encontarVentaConceptosPorIdOrdenVenta(Long idOrdenVenta);

    @WebMethod
    public List<VentaConceptos> encontrarAgendadosPorAreaEquipoDicomFecha(Integer idArea, Long idEquipoDicom, String fecha);

    @WebMethod
    public List<VentaConceptos> encontrarAgendadosPorAreaEquipoDicomFechaInstitucion(Integer idArea, Long idEquipoDicom, String fecha, Long idInstitucion);

    @WebMethod
    public void registrarVentaConceptos(VentaConceptos ventaConceptos);

    @WebMethod
    public void registrarVentaConceptosList(List<VentaConceptos> ventaConceptos);

    @WebMethod
    public VentaConceptos encontrarVentaConceptoPorOrdenVentaConceptoHoraAsignado(OrdenVenta ordenVenta, Conceptos conceptos, String horaAsingnado);

    @WebMethod
    public VentaConceptos encontrarVentaConceptosPorId(Long id);

    @WebMethod
    public void eliminarVentaConceptos(VentaConceptos venta);

    @WebMethod
    public Long encontrarNumeroVentaConceptosPorEquipoFechaHora(EquipoDicom equipo, String fecha, String horaAsingnado);

}
