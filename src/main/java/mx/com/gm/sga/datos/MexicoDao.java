/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.datos;

import java.util.List;
import mx.com.gm.sga.domain.Mexico;

/**
 *
 * @author alanm
 */
public interface MexicoDao {
    
    public List<Mexico> encontrarEstadosDeMexico();
    public Mexico encontrarEstadoPorId(Integer id);
    public Mexico encontrarEstadoPorNombre(String nombre);
}
