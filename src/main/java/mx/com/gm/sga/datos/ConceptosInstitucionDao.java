/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.datos;

import mx.com.gm.sga.domain.ConceptosInstitucion;

/**
 *
 * @author alanm
 */
public interface ConceptosInstitucionDao {
    
    public void registrarConceptosInstitucion(ConceptosInstitucion conceptoInstitucion);
    
    public void actualizarConceptosInstitucion(ConceptosInstitucion conceptoInstitucion); 
    
    public ConceptosInstitucion encontrarConceptoInstitucionPorIdConceptoIdInstitucion(Long idConcepto, Long idInstitucion);
    
}
