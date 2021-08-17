/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.datos;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mx.com.gm.sga.domain.Areas;

/**
 *
 * @author alanm
 */
public class AreasDaoImpl implements AreasDao{

    @PersistenceContext(unitName = "SgaPU")
    EntityManager em;
    
    @Override
    public Areas findAreaById(Areas area) {
        return em.find(Areas.class, area.getIdA());
    }

    @Override
    public List<Areas> findAllAreas() {
        return em.createNamedQuery("Areas.findAll").getResultList();
    }
    
}
