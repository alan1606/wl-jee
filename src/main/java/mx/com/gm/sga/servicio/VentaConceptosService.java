/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import java.util.Date;
import java.util.List;
import javax.ejb.Local;
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
@Local
public interface VentaConceptosService {

    public VentaConceptos encontrarVentaConceptosPorId(Long id);
    
    public List<VentaConceptos> listarTodosVentaConceptos();

    public List<VentaConceptos> encontrarVentaConceptosPorPacienteFechaEnWorklist(Pacientes paciente, String fecha, boolean enWorklist);

    public List<VentaConceptos> encontrarVentaConceptosPorInstitucionFechas(Institucion institucion, String fechaInicio, String fechaFin);

    public VentaConceptos encontrarVentaConceptosPorIdPacs(String idPacs);

    public boolean actualizarIdOrdenVenta();

    public List<VentaConceptos> encontarVentaConceptosPorIdOrdenVenta(Long idOrdenVenta);

    public List<VentaConceptos> encontrarAgendadosPorAreaEquipoDicomFecha(Integer idArea, Long idEquipoDicom, String fecha);

    public List<VentaConceptos> encontrarAgendadosPorAreaEquipoDicomFechaInstitucion(Integer idArea, Long idEquipoDicom, String fecha, Long idInstitucion);

    public void registrarVentaConceptos(VentaConceptos ventaConceptos);

    public void registrarVentaConceptosList(List<VentaConceptos> ventaConceptos);

    public VentaConceptos encontrarVentaConceptoPorOrdenVentaConceptoHoraAsignado(OrdenVenta ordenVenta, Conceptos conceptos, String horaAsingnado);
    
    public void eliminarVentaConceptos(VentaConceptos venta);

    
        public Long encontrarNumeroVentaConceptosPorEquipoFechaHora(EquipoDicom equipo, String fecha, String horaAsingnado);

}
