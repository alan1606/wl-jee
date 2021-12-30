/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.datos;

import java.util.List;
import mx.com.gm.sga.domain.Antecedentes;


/**
 *
 * @author alanm
 */
public interface AntecedentesDao {
    
    public void registrarAntecedentes(Antecedentes antecedentes);
    public void actualizarAntecedentes(Antecedentes antecedentes);
    public List<Antecedentes> listarAntecedentes();
    public Antecedentes encontrarAntecedentesPorId(Long id);
    public List<Antecedentes> encontrarAntecedentesPorArea(Integer idArea);
    public List<Antecedentes> encontrarAntecedentesPorEstudio(Long idEstudio);
    public Antecedentes encontrarAntecedentePorNombre(String nombre);
    public List<Antecedentes> encontrarAntecedentesPorConcepto(Long idConcepto);
}
