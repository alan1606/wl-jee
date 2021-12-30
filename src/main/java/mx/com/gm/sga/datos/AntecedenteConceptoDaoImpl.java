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
import mx.com.gm.sga.domain.AntecedenteConcepto;
import mx.com.gm.sga.domain.AntecedenteConceptoIds;
import mx.com.gm.sga.domain.Antecedentes;
import mx.com.gm.sga.domain.Conceptos;

/**
 *
 * @author alanm
 */
public class AntecedenteConceptoDaoImpl implements AntecedenteConceptoDao {

    @PersistenceContext(unitName = "SgaPU")
    EntityManager em;

    @Override
    public void registrarAntecedenteConcepto(Long idAntecedente, Long idConcepto) {
        AntecedenteConcepto antecedenteConcepto = new AntecedenteConcepto();
        Antecedentes antecedente = new Antecedentes();
        Conceptos concepto = new Conceptos();

        antecedente.setId(idAntecedente);
        concepto.setIdTo(idConcepto);

        antecedenteConcepto.setIdAntecedente(antecedente);
        antecedenteConcepto.setIdConcepto(concepto);
        em.persist(antecedenteConcepto);
    }

    @Override
    public void eliminarAntecedentesConcepto(Long idAntecedente, Long idConcepto) {
        AntecedenteConcepto antecedenteConcepto = new AntecedenteConcepto();
        Antecedentes antecedente = new Antecedentes();
        Conceptos concepto = new Conceptos();

        antecedente.setId(idAntecedente);
        concepto.setIdTo(idConcepto);

        antecedenteConcepto.setIdAntecedente(antecedente);
        antecedenteConcepto.setIdConcepto(concepto);

        em.remove(em.merge(antecedenteConcepto));
    }

    @Override
    public void registrarAntecedentesConcepto(List<AntecedenteConceptoIds> antecedentesConcepto) {
        antecedentesConcepto.forEach(a -> {
            AntecedenteConcepto antecedenteConcepto = new AntecedenteConcepto();
            Antecedentes antecedente = new Antecedentes();
            Conceptos concepto = new Conceptos();

            antecedente.setId(a.getIdAntecedente());
            concepto.setIdTo(a.getIdConcepto());

            antecedenteConcepto.setIdAntecedente(antecedente);
            antecedenteConcepto.setIdConcepto(concepto);
            em.persist(antecedenteConcepto);
        });
    }

    @Override
    public List<AntecedenteConcepto> encontrarAntecedentesConceptoDeConcepto(Long idConcepto) {
        Query query = em.createQuery("select a from AntecedenteConcepto a where a.idConcepto.idTo = :estudio");
        query.setParameter("estudio", idConcepto);
        return query.getResultList();
    }

    @Override
    public void eliminarTodosAntecedentesConcepto(Long idConcepto) {
        encontrarAntecedentesConceptoDeConcepto(idConcepto).forEach(a -> em.remove(a));
    }

}
