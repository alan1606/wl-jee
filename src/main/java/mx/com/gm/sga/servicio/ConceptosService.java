/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import javax.ejb.Local;
import mx.com.gm.sga.domain.Conceptos;

/**
 *
 * @author alanm
 */
@Local
public interface ConceptosService {

    public Conceptos encontrarConceptoPorId(Conceptos conceptos);
}
