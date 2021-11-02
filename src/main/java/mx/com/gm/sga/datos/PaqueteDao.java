/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.datos;

import java.util.List;
import mx.com.gm.sga.domain.Paquete;

/**
 *
 * @author alanm
 */
public interface PaqueteDao {
    
    public List<Paquete> listarPaquetes();
    public Paquete encontrarPaquetePorId(Long idPaquete);
    public void registrarPaquete(Paquete paquete);
    public void modificarPaquete(Paquete paquete);
    public void eliminarPaquete(Paquete paquete);
    
}
