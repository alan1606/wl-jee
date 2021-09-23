/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.datos;

import mx.com.gm.sga.domain.Usuarios;

/**
 *
 * @author alanm
 */
public interface UsuariosDao {
    
    public boolean esCorrectoLogin(Usuarios usuario);
    
}
