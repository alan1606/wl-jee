/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.datos;

import java.util.List;
import mx.com.gm.sga.domain.CatalogoFormaPago;

/**
 *
 * @author alanm
 */
public interface CatalogoFormaPagoDao {
    public List<CatalogoFormaPago> findAll();
    public CatalogoFormaPago encontrarFormaPagoPorId(short id);
    public CatalogoFormaPago encontrarFormaPagoPorNombre(String nombre);
}
