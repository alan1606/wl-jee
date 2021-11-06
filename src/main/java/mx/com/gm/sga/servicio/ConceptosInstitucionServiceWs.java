/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import mx.com.gm.sga.domain.Conceptos;
import mx.com.gm.sga.domain.ConceptosInstitucion;

/**
 *
 * @author alanm
 */
@WebService
public interface ConceptosInstitucionServiceWs {

    @WebMethod
    public void registrarConceptosInstitucion(ConceptosInstitucion conceptoInstitucion);

    @WebMethod
    public void actualizarConceptosInstitucion(ConceptosInstitucion conceptoInstitucion);

    @WebMethod
    public ConceptosInstitucion encontrarConceptoInstitucionPorIdConceptoIdInstitucion(Long idConcepto, Long idInstitucion);

    @WebMethod
    public List<ConceptosInstitucion> obtenerConceptosInstitucionPorIdInstitucion(Long idInstitucion);

     @WebMethod
        public List<ConceptosInstitucion> obtenerConceptosLikeNombrePorPorIdInstitucion(String nombre, Long idInstitucion);
     @WebMethod
    public List<ConceptosInstitucion> obtenerConceptosLikeNombrePorPorIdInstitucionPorArea(String nombre, Long idInstitucion, int idArea);
     @WebMethod
    public List<ConceptosInstitucion> obtenerConceptosPorPorIdInstitucionPorArea( Long idInstitucion, int idArea);
}
