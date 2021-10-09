/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import java.util.List;
import javax.ejb.Local;
import mx.com.gm.sga.domain.Conceptos;

/**
 *
 * @author alanm
 */
@Local
public interface ConceptosService {

    public Conceptos encontrarConceptoPorId(Conceptos conceptos);

    public List<Conceptos> encontrarConceptosPorIdVentaConceptos(Long idVentaConceptos);

    public List<Conceptos> encontrarConceptosPorIdArea(Integer idArea);

    public List<Conceptos> encontrarConceptosPorInstitucionArea(Long idInstitucion, Integer idArea);

    public Conceptos encontrarConceptoPorNombre(String nombre);

    public List<Conceptos> encontrarTodosConceptos();

    public void registrarConcepto(Conceptos concepto);

    public List<Conceptos> encontrarConceptoLikeNombre(String nombre);
    
        public List<Conceptos> encontrarConceptosPorAreaYNombre(Integer idArea, String name);

}
