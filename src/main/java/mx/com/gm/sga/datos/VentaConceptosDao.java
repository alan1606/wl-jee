/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.datos;

import java.util.List;
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
public interface VentaConceptosDao {

    public VentaConceptos findById(Long id);

    public List<VentaConceptos> findAllVentaConceptos();

    public List<VentaConceptos> findVentaConceptosByPacienteFechaEnWorklist(Pacientes paciente, String fecha, boolean enWorklist);

    public List<VentaConceptos> findVentaConceptosByInstitucionFechas(Institucion institucion, String fechaInicio, String fechaFin);

    public VentaConceptos findByIdPacs(String idPacs);

    public void registrarVentaConceptos(VentaConceptos ventaConceptos);

    public void registrarVentaConceptosList(List<VentaConceptos> ventaConceptos);

    public boolean actualizarIdOrdenVenta();

    public List<VentaConceptos> findByIdOrdenVenta(Long idOrdenVenta);

    public List<VentaConceptos> findAgendadosByAreaEquipoDicomFecha(Integer idArea, Long idEquipoDicom, String fecha);

    public List<VentaConceptos> findAgendadosByAreaEquipoDicomFechaInstitucion(Integer idArea, Long idEquipoDicom, String fecha, Long idInstitucion);

    public VentaConceptos findByOrdenVentaConceptoHoraAsignado(OrdenVenta ordenVenta, Conceptos conceptos, String horaAsingnado);

    public void eliminarVentaConceptos(VentaConceptos venta);

    public Long findCountByEquipoFechaHora(EquipoDicom equipo, String fecha, String horaAsingnado);

    public List<VentaConceptos> findAgendadosByFecha(String fecha);

    public void actualizarVentaConceptos(VentaConceptos venta);

    public List<Object[]> findCorteMatutino(String fecha);

    public List<Object[]> findCorteVespertino(String fecha);

    public List<Object[]> obtenerTotalesCorteMatutinoPorInstitucion(String fecha);

    public List<Object[]> obtenerTotalesCorteVespertinoPorInstitucion(String fecha);

    public List<Object[]> obtenerTotalesCorteMatutinoPorFormaDePago(String fecha);

    public List<Object[]> obtenerTotalesCorteVespertinoPorFormaDePago(String fecha);
    
         public List<Object[]> obtenerTotalesCorteMatutinoPorInstitucionArea(String fecha);

    public List<Object[]> obtenerTotalesCorteVespertinoPorInstitucionArea(String fecha);
    
    public void eliminarVentaConceptosPorIdOrdenVenta(Long idOrdenVenta);
    
    public Long esCandidatoParaEliminarConceptosDeOrden(Long idOrdenVenta);
}
