/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import mx.com.gm.sga.domain.Consentimiento;

/**
 *
 * @author alanm
 */
@WebService
public interface ConsentimientoServiceWs {

    @WebMethod
    public List<Consentimiento> obtenerConsentimientos();

    @WebMethod
    public List<Consentimiento> obtenerPorIdConcepto(Long idConcepto);

    @WebMethod
    public void registrarConsentimiento(Consentimiento consentimiento);

    @WebMethod
    public void eliminarConsentimiento(Consentimiento consentimiento);

    @WebMethod
    public void modificarConsentimiento(Consentimiento consentimieno);

    @WebMethod
    public Consentimiento obtenerConsentimientoPorId(Long id);

    @WebMethod
    public Consentimiento obtenerConsentimientoPorNombre(String nombre);

}
