/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.datos;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import mx.com.gm.sga.domain.CatalogoFormaPago;

/**
 *
 * @author alanm
 */
public class CatalogoFormaPagoDaoImpl implements CatalogoFormaPagoDao {

    @PersistenceContext(unitName = "SgaPU")
    EntityManager em;

    @Override
    public List<CatalogoFormaPago> findAll() {
        Query query = em.createQuery("from CatalogoFormaPago c order by c.formaPagoFp");
        return query.getResultList();
    }

    @Override
    public CatalogoFormaPago encontrarFormaPagoPorId(short id) {
        return em.find(CatalogoFormaPago.class, id);
    }

    @Override
    public CatalogoFormaPago encontrarFormaPagoPorNombre(String nombre) {
        Query query = em.createQuery("from CatalogoFormaPago c where c.formaPagoFp = :formaPagoFp");
        query.setParameter("formaPagoFp", nombre);
        return (CatalogoFormaPago) query.getSingleResult();
    }

}
