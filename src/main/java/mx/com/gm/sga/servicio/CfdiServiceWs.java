/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import mx.com.gm.sga.domain.Cfdi;

/**
 *
 * @author alanm
 */
@WebService
public interface CfdiServiceWs {

    @WebMethod
    public Cfdi obtenerCfdiPorClave(String clave);

    @WebMethod
    public List<Cfdi> listarCfdis();

    @WebMethod
    public void registrarCfdi(Cfdi cfdi);

    @WebMethod
    public void modificarCfdi(Cfdi cfdi);
}
