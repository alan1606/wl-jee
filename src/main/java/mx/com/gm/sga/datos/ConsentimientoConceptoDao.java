/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.datos;

import mx.com.gm.sga.domain.ConsentimientoConcepto;

/**
 *
 * @author alanm
 */
public interface ConsentimientoConceptoDao {
    
    public void eliminarConsentimientoConcepto(ConsentimientoConcepto consentimientoConcepto);
    
    public void registrarConsentimientoConcepto(ConsentimientoConcepto consentimientoConcepto);
    
    public ConsentimientoConcepto buscarConsentimientoConceptoPorIdConsentimientoIdConcepto(Long idConsentimiento, Long idConcepto);
    
}
