/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.datos;

import java.util.List;
import mx.com.gm.sga.domain.AntecedenteEstudio;

/**
 *
 * @author alanm
 */
public interface AntecedenteEstudioDao {
    
    public void registrarAntecedenteEstudio(AntecedenteEstudio antecedenteEstudio);
    public void registrarAntecedentesEstudio(List<AntecedenteEstudio> antecedenteEstudio);
    
}
