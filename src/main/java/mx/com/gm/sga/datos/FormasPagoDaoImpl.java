/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.datos;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mx.com.gm.sga.domain.CatalogoFormaPago;

/**
 *
 * @author alanm
 */
public class FormasPagoDaoImpl implements FormasPagoDao {

    @PersistenceContext(unitName = "SgaPU")
    EntityManager em;

    @Override
    public List<CatalogoFormaPago> findAll() {
        return em.createNamedQuery("CatalogoFormaPago.findAll").getResultList();
    }

}
