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
import mx.com.gm.sga.domain.Mexico;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author alanm
 */
public class MexicoDaoImpl implements MexicoDao {

    static Logger log = LogManager.getRootLogger();

    @PersistenceContext(unitName = "SgaPU")
    EntityManager em;

    @Override
    public List<Mexico> encontrarEstadosDeMexico() {
        Query query = em.createQuery("select m from Mexico m group by m.dEstado order by m.dEstado");
        return query.getResultList();
    }

}
