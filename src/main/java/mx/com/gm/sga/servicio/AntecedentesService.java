/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import mx.com.gm.sga.domain.AntecedenteConcepto;
import mx.com.gm.sga.domain.AntecedenteConceptoIds;
import mx.com.gm.sga.domain.AntecedenteEstudio;
import mx.com.gm.sga.domain.Antecedentes;

/**
 *
 * @author alanm
 */
@Local
public interface AntecedentesService {

    public void registrarAntecedentes(Antecedentes antecedentes);

    public void actualizarAntecedentes(Antecedentes antecedentes);

    public List<Antecedentes> listarAntecedentes();

    public Antecedentes encontrarAntecedentesPorId(Long id);

    public List<Antecedentes> encontrarAntecedentesPorArea(Integer idArea);

    public List<Antecedentes> encontrarAntecedentesPorEstudio(Long idEstudio);

    public void registrarAntecedenteEstudio(AntecedenteEstudio antecedenteEstudio);

    public void registrarAntecedentesEstudio(List<AntecedenteEstudio> antecedenteEstudio);

    public Antecedentes encontrarAntecedentePorNombre(String nombre);

    public List<Antecedentes> encontrarAntecedentesPorConcepto(Long idConcepto);

    public void registrarAntecedenteConcepto(Long idAntecedente, Long idConcepto);

    public void eliminarAntecedentesConcepto(Long idAntecedente, Long idConcepto);

    public void registrarAntecedentesConcepto(List<AntecedenteConceptoIds> antecedentesConcepto);
    
     public void eliminarTodosAntecedentesConcepto(Long idConcepto);

}
