/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.datos;

import java.util.List;
import mx.com.gm.sga.domain.Conceptos;

/**
 *
 * @author alanm
 */
public interface ConceptosDao {
    public Conceptos findConceptoById(Conceptos conceptos);
    public List<Conceptos> findConceptosByidVentaConcepto(Long idVentaConcepto);
    public List<Conceptos> findByIdArea(Integer idArea);
    public List<Conceptos> findByInstitucionArea(Long idInstitucion, Integer idArea);
    public Conceptos findByName(String nombre);
    public List<Conceptos> findAll();
    public void save(Conceptos concepto);
    public List<Conceptos> findLikeName(String nombre);
    public List<Conceptos> findByIdAreaName(Integer idArea, String name);
    public List<Conceptos> findByInstitucion(Long idInstitucion);
   public void actualizarConcepto(Conceptos concepto);
    
}
