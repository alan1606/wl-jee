/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.datos;

import java.util.List;
import mx.com.gm.sga.domain.AntecedenteConcepto;
import mx.com.gm.sga.domain.AntecedenteConceptoIds;

/**
 *
 * @author alanm
 */
public interface AntecedenteConceptoDao {

    public void registrarAntecedenteConcepto(Long idAntecedente, Long idConcepto);

    public void eliminarAntecedentesConcepto(Long idAntecedente, Long idConcepto);

    public void registrarAntecedentesConcepto(List<AntecedenteConceptoIds> antecedentesConcepto);
    
    public List<AntecedenteConcepto> encontrarAntecedentesConceptoDeConcepto(Long idConcepto);
    
        public void eliminarTodosAntecedentesConcepto(Long idConcepto);


}
