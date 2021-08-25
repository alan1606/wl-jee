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
import mx.com.gm.sga.domain.Areas;
import mx.com.gm.sga.domain.EquipoDicom;

/**
 *
 * @author alanm
 */
public class EquipoDicomDaoImpl implements EquipoDicomDao {

    @PersistenceContext(unitName = "SgaPU")
    EntityManager em;

    @Override
    public EquipoDicom findEquipoDicomById(EquipoDicom equipo) {
        return em.find(EquipoDicom.class, equipo.getIdEquipo());
    }

    @Override
    public List<EquipoDicom> findEquipoDicomByArea(Areas area) {
        Query query = em.createQuery("from EquipoDicom e where e.idArea.idA = :idA");
        query.setParameter("idA", area.getIdA());
        return query.getResultList();
    }

    @Override
    public List<EquipoDicom> findEquipoDicomByModalidad(String modalidad) {
        Query query = em.createQuery("from EquipoDicom e where e.modalidad = :modalidad");
        query.setParameter("modalidad", modalidad);
        return query.getResultList();
    }

    @Override
    public EquipoDicom findEquipoDicomByNombre(String nombre) {
        Query query = em.createQuery("from EquipoDicom e where e.nombre = :nombre");
        query.setParameter("nombre", nombre);
        return (EquipoDicom) query.getSingleResult();
    }

}
