/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.datos;

import java.util.List;
import mx.com.gm.sga.domain.Consentimiento;

/**
 *
 * @author alanm
 */
public interface ConsentimientoDao {

    public Consentimiento obtenerConsentimientoPorId(Long id);

    public List<Consentimiento> obtenerConsentimientos();

    public List<Consentimiento> obtenerPorIdConcepto(Long idConcepto);

    public void registrarConsentimiento(Consentimiento consentimiento);

    public void eliminarConsentimiento(Consentimiento consentimiento);

    public void modificarConsentimiento(Consentimiento consentimieno);

    public Consentimiento obtenerConsentimientoPorNombre(String nombre);

}
