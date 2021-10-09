/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import mx.com.gm.sga.domain.Instrucciones;

/**
 *
 * @author alanm
 */
@WebService
public interface InstruccionesServiceWs {

    @WebMethod
    public List<Instrucciones> obtenerTodasInstrucciones();

    @WebMethod
    public void registrarInstrucciones(Instrucciones instrucciones);

    @WebMethod
    public Instrucciones encontrarInstruccionesPorNombre(String nombre);
}
