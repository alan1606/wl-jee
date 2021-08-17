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
import mx.com.gm.sga.domain.Institucion;
import mx.com.gm.sga.domain.Pacientes;
import mx.com.gm.sga.domain.VentaConceptos;

/**
 *
 * @author alanm
 */
@WebService
public interface VentaConceptosServiceWs {

    @WebMethod
    public List<VentaConceptos> listarTodo();

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

}
