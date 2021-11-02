/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.datos;

import java.util.List;
import mx.com.gm.sga.domain.ConceptoPaquete;
import mx.com.gm.sga.domain.Conceptos;

/**
 *
 * @author alanm
 */
public interface ConceptoPaqueteDao {

    public void registrarConceptoPaquete(ConceptoPaquete conceptoPaquete);

    public void eliminarConceptoPaquete(ConceptoPaquete conceptoPaquete);

    public List<Conceptos> obtenerConceptosDePaquete(Long idPaquete);

}
