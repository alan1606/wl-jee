/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import java.util.List;
import javax.ejb.Local;
import mx.com.gm.sga.domain.ConceptoPaquete;
import mx.com.gm.sga.domain.ConceptosInstitucion;
import mx.com.gm.sga.domain.Paquete;

/**
 *
 * @author alanm
 */
@Local
public interface PaquetesService {

    public List<Paquete> listarPaquetes();

    public Paquete encontrarPaquetePorId(Long idPaquete);

    public void registrarPaquete(Paquete paquete);

    public void modificarPaquete(Paquete paquete);

    public void eliminarPaquete(Paquete paquete);

    public void registrarConceptoPaquete(ConceptoPaquete conceptoPaquete);

    public void eliminarConceptoPaquete(ConceptoPaquete conceptoPaquete);

    public List<ConceptosInstitucion> obtenerConceptosDePaquete(Long idPaquete);

        public Paquete obtenerPaquetePorNombre(String nombre);
  public List<Paquete> obtenerPaquetesLikeNombre(String nombre);
    
}
