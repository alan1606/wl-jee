/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author alanm
 */
@WebService
public interface WorklistServiceWs {

    @WebMethod
    public void registrarEnWorklist(Long  idVentaConceptos);

    @WebMethod
        public void registrarEnWorklistPorOrdenVenta(long idOrdenVenta);

}
