/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.datos;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mx.com.gm.sga.domain.Cfdi;

/**
 *
 * @author alanm
 */
public class CfdiDaoImpl implements CfdiDao {

    @PersistenceContext(unitName = "SgaPU")
    EntityManager em;

    @Override
    public Cfdi obtenerCfdiPorClave(String clave) {
        return em.find(Cfdi.class, clave);
    }

    @Override
    public List<Cfdi> listarCfdis() {
        return em.createNamedQuery("Cfdi.findAll").getResultList();
    }

    @Override
    public void registrarCfdi(Cfdi cfdi) {
        em.persist(cfdi);
    }

    @Override
    public void modificarCfdi(Cfdi cfdi) {
        em.merge(cfdi);
    }

}
