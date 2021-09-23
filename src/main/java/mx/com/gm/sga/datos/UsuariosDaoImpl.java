/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.datos;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import mx.com.gm.sga.domain.Usuarios;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author alanm
 */
public class UsuariosDaoImpl implements UsuariosDao {

    static Logger log = LogManager.getRootLogger();

    @PersistenceContext(unitName = "SgaPU")
    EntityManager em;

    @Override
    public boolean esCorrectoLogin(Usuarios usuario) {
        Query query = em.createQuery("from Usuarios u where u.usuarioU = :usuario");
        query.setParameter("usuario", usuario.getUsuarioU());
        Usuarios bd = (Usuarios) query.getSingleResult();
        if (bd.getContrasenaU().equals(usuario.getContrasenaU())) {
            return true;
        }
        return false;
    }

    

}
