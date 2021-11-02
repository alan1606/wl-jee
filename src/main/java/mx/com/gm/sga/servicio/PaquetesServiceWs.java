/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import mx.com.gm.sga.domain.ConceptoPaquete;
import mx.com.gm.sga.domain.Conceptos;
import mx.com.gm.sga.domain.Paquete;

/**
 *
 * @author alanm
 */
@WebService
public interface PaquetesServiceWs {

    @WebMethod
    public List<Paquete> listarPaquetes();

    @WebMethod
    public Paquete encontrarPaquetePorId(Long idPaquete);

    @WebMethod
    public void registrarPaquete(Paquete paquete);

    @WebMethod
    public void modificarPaquete(Paquete paquete);

    @WebMethod
    public void eliminarPaquete(Paquete paquete);

    @WebMethod
    public void registrarConceptoPaquete(ConceptoPaquete conceptoPaquete);

    @WebMethod
    public void eliminarConceptoPaquete(ConceptoPaquete conceptoPaquete);

    @WebMethod
    public List<Conceptos> obtenerConceptosDePaquete(Long idPaquete);

}
