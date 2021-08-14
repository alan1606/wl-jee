/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import java.util.Date;
import java.util.List;
import javax.ejb.Remote;
import mx.com.gm.sga.domain.Institucion;
import mx.com.gm.sga.domain.Pacientes;
import mx.com.gm.sga.domain.VentaConceptos;

/**
 *
 * @author alanm
 */
@Remote
public interface VentaConceptosServiceRemote {
    
    public List<VentaConceptos> listarTodo();

    public List<VentaConceptos> encontrarVentaConceptosPorPacienteFechaEnWorklist(Pacientes paciente, String fecha, boolean enWorklist);

    public List<VentaConceptos> encontrarVentaConceptosPorInstitucionFechas(Institucion institucion, String fechaInicio, String fechaFin);
    
        
    public VentaConceptos encontrarVentaConceptosPorIdPacs(String idPacs);
    
    public boolean actualizarIdOrdenVenta();
}
