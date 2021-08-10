/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.datos;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import mx.com.gm.sga.domain.Institucion;
import mx.com.gm.sga.domain.Pacientes;
import mx.com.gm.sga.domain.VentaConceptos;
import org.apache.logging.log4j.*;

/**
 *
 * @author alanm
 */
public class VentaConceptosDaoImpl implements VentaConceptosDao {

    static Logger log = LogManager.getRootLogger();
    
    @PersistenceContext(unitName = "SgaPU")
    EntityManager em;

    @Override
    public List<VentaConceptos> findAllVentaConceptos() {
        return em.createNamedQuery("VentaConceptos.findAll").getResultList();
    }

    @Override
    public List<VentaConceptos> findVentaConceptosByPacienteFechaEnWorklist(Pacientes paciente, String fecha, boolean enWorklist) {
        Query query = em.createQuery("from VentaConceptos v where v.pacientes.idP = :paciente and v.fechaVentaVc like :fecha and v.enWorklist = :wl");
        query.setParameter("paciente", paciente.getIdP());
        fecha += "%";
        query.setParameter("fecha", fecha);
        query.setParameter("wl", enWorklist);
        return query.getResultList();
    }

    @Override
    public List<VentaConceptos> findVentaConceptosByInstitucionFechas(Institucion institucion, String fechaInicio, String fechaFin) {
        Query query = em.createQuery("from VentaConceptos v where v.institucion.idInstitucion = :institucion and v.fechaVentaVc between :fechaInicio and :fechaFin");
        query.setParameter("institucion", institucion.getIdInstitucion());
        query.setParameter("fechaInicio", fechaInicio);
        query.setParameter("fechaFin", fechaFin);
        return query.getResultList();
    }

   

}
