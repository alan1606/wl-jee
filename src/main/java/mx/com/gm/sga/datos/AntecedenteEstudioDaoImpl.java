/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.datos;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mx.com.gm.sga.domain.AntecedenteEstudio;

/**
 *
 * @author alanm
 */
public class AntecedenteEstudioDaoImpl implements AntecedenteEstudioDao {

    @PersistenceContext(unitName = "SgaPU")
    EntityManager em;

    @Override
    public void registrarAntecedenteEstudio(AntecedenteEstudio antecedenteEstudio) {
        em.persist(antecedenteEstudio);
    }

    @Override
    public void registrarAntecedentesEstudio(List<AntecedenteEstudio> antecedenteEstudio) {
        antecedenteEstudio.forEach(a -> em.persist(a));
    }

}
