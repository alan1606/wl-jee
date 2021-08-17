/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.datos;


import java.util.List;
import mx.com.gm.sga.domain.Institucion;
import mx.com.gm.sga.domain.Pacientes;
import mx.com.gm.sga.domain.VentaConceptos;

/**
 *
 * @author alanm
 */
public interface VentaConceptosDao {
    
    public List<VentaConceptos> findAllVentaConceptos();
    
    public List<VentaConceptos> findVentaConceptosByPacienteFechaEnWorklist(Pacientes paciente, String fecha, boolean enWorklist);

    public List<VentaConceptos> findVentaConceptosByInstitucionFechas(Institucion institucion, String fechaInicio, String fechaFin);

    public VentaConceptos findByIdPacs(String idPacs);

    public void registrarVentaConceptos(VentaConceptos ventaConceptos);
    
    public void registrarVentaConceptos(List<VentaConceptos> ventaConceptos);
    
    public boolean actualizarIdOrdenVenta();
    
    public List<VentaConceptos> findByIdOrdenVenta(Long idOrdenVenta);
}
