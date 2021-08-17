/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import java.util.List;
import javax.ejb.Remote;
import mx.com.gm.sga.domain.Conceptos;

/**
 *
 * @author alanm
 */
@Remote
public interface ConceptosServiceRemote {

    public Conceptos encontrarConceptoPorId(Conceptos conceptos);

    public List<Conceptos> encontrarConceptosPorIdVentaConceptos(Long idVentaConceptos);

    public List<Conceptos> encontrarConceptosPorIdArea(Integer idArea);

}
