/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.datos;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import mx.com.gm.sga.domain.Conceptos;
import mx.com.gm.sga.domain.EquipoDicom;
import mx.com.gm.sga.domain.Institucion;
import mx.com.gm.sga.domain.OrdenVenta;
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

    @Override
    public VentaConceptos findByIdPacs(String idPacs) {
        Query query = em.createQuery("from VentaConceptos v where v.idPacs = :idPacs");
        query.setParameter("idPacs", idPacs);
        return (VentaConceptos) query.getSingleResult();
    }

    @Override
    public boolean actualizarIdOrdenVenta() {
        String jpql = null;
        Iterator iter = null;
        Object[] tupla = null;
        boolean cambiosHechos = false;

        //Se obtiene el m??ximo id de orden de venta
        jpql = "select max(o.idOv) from OrdenVenta o";
        Long encontrada = (Long) em.createQuery(jpql).getSingleResult();

        ///Obtiene la lista de ventasConceptos a actualizar
        Query query = em.createQuery("from VentaConceptos v where v.idOrdenVenta.idOv = 1");
        List<VentaConceptos> insertadosPeroNoActualizados = query.getResultList();

        //Recorre la lista y setea la orden de venta con el id de la ??ltima orden de venta
        for (VentaConceptos venta : insertadosPeroNoActualizados) {
            venta.setIdOrdenVenta(new OrdenVenta(encontrada));
            em.merge(venta);
            cambiosHechos = true;
        }

        return cambiosHechos;
    }

    @Override
    public void registrarVentaConceptos(VentaConceptos ventaConceptos) {
        em.persist(ventaConceptos);
    }

    @Override
    public void registrarVentaConceptosList(List<VentaConceptos> ventaConceptos) {
        for (VentaConceptos venta : ventaConceptos) {
            em.persist(venta);
        }
    }

    @Override
    public List<VentaConceptos> findByIdOrdenVenta(Long idOrdenVenta) {
        Query query = em.createQuery("from VentaConceptos v where v.idOrdenVenta.idOv = :idOrdenVenta");
        query.setParameter("idOrdenVenta", idOrdenVenta);
        return query.getResultList();
    }

    @Override
    public List<VentaConceptos> findAgendadosByAreaEquipoDicomFecha(Integer idArea, Long idEquipoDicom, String fecha) {
        //Query query = em.createQuery("from VentaConceptos v join v.idConceptoEs c join c.idAreaTo a join v.idEquipoDicom e where v.fechaAsignado like :fecha and v.estado != :estado and a.idA=:idArea and e.idEquipo=:idEquipoDicom");
        Query query = em.createQuery("select v from VentaConceptos v join v.idConceptoEs c join v.idEquipoDicom e where v.fechaAsignado = :fecha and v.idEquipoDicom.idEquipo = :idEquipoDicom and v.estado != :estado and c.idAreaTo.idA = :idArea ORDER BY v.horaAsignado DESC");
        query.setParameter("fecha", fecha);
        query.setParameter("idEquipoDicom", idEquipoDicom);
        query.setParameter("estado", "NO AGENDADO");
        query.setParameter("idArea", idArea);
        return query.getResultList();

    }

    @Override
    public List<VentaConceptos> findAgendadosByAreaEquipoDicomFechaInstitucion(Integer idArea, Long idEquipoDicom, String fecha, Long idInstitucion) {
        Query query = em.createQuery("select v from VentaConceptos v join v.idInstitucion i join v.idConceptoEs c join c.idAreaTo a join v.idEquipoDicom e where v.fechaAsignado = :fecha and v.estado != :estado and a.idA=:idArea and e.idEquipo=:idEquipoDicom and i.idInstitucion=:idInstitucion");
        query.setParameter("idArea", idArea);
        query.setParameter("fecha", fecha);
        query.setParameter("idEquipoDicom", idEquipoDicom);
        query.setParameter("estado", "NO AGENDADO");
        query.setParameter("idInstitucion", idInstitucion);
        return query.getResultList();
    }

    @Override
    public VentaConceptos findByOrdenVentaConceptoHoraAsignado(OrdenVenta ordenVenta, Conceptos conceptos, String horaAsingnado) {
        Query query = em.createQuery("select v from VentaConceptos v where v.idOrdenVenta.idOv = :ordenVenta and v.idConceptoEs.idTo = :concepto and v.horaAsignado like :horaAsignado");
        query.setParameter("ordenVenta", ordenVenta.getIdOv());
        query.setParameter("concepto", conceptos.getIdTo());
        horaAsingnado += "%";
        query.setParameter("horaAsignado", horaAsingnado);

        return (VentaConceptos) query.getSingleResult();
    }

    @Override
    public VentaConceptos findById(Long id) {
        return em.find(VentaConceptos.class, id);
    }

    @Override
    public void eliminarVentaConceptos(VentaConceptos venta) {
        em.remove(em.merge(venta));
    }

    @Override
    public Long findCountByEquipoFechaHora(EquipoDicom equipo, String fecha, String horaAsingnado) {
        Query query = em.createQuery("select count(v) from VentaConceptos v join v.idEquipoDicom e where v.horaAsignado like :horaAsignado and v.fechaAsignado = :fecha and e.idEquipo = :idEquipo");
        horaAsingnado += "%";
        query.setParameter("horaAsignado", horaAsingnado);
        query.setParameter("fecha", fecha);
        query.setParameter("idEquipo", equipo.getIdEquipo());
        Long total = (Long) query.getSingleResult();
        return total;
    }

    @Override
    public List<VentaConceptos> findAgendadosByFecha(String fecha) {
        Query query = em.createQuery("select v from VentaConceptos v where v.fechaAsignado = :fecha and v.estado = 'AGENDADO'");
        query.setParameter("fecha", fecha);
        return query.getResultList();
    }

    @Override
    public void actualizarVentaConceptos(VentaConceptos venta) {
        em.merge(venta);
    }

    @Override
    public List<Object[]> findCorteMatutino(String fecha) {
        Iterator iter = null;
        Object[] tupla = null;
        List<Object[]> lista = new ArrayList<Object[]>();
        Query nativeQuery = em.createQuery("SELECT p.nombreCompletoP, "
                + "i.nombreInstitucion, "
                + "o.idOv, "
                + "o.totalEi, "
                + "o.requiereFactura, "
                + "p.rfcP "
                + "from VentaConceptos v "
                + "join v.idOrdenVenta o "
                + "join v.idInstitucion i "
                + "join v.idPacienteVc p "
                + "join v.idConceptoEs c "
                + "where o.pagado = true and v.fechaVentaVc between :fechaInicio and :fechaFin "
                + "group by o.idOv");
        nativeQuery.setParameter("fechaInicio", fecha + " 07:00:00");
        nativeQuery.setParameter("fechaFin", fecha + " 12:59:59");

        iter = nativeQuery.getResultList().iterator();

        while (iter.hasNext()) {
            tupla = (Object[]) iter.next();
            String paciente = (String) tupla[0];
            String institucion = (String) tupla[1];
            Long idOv = (Long) tupla[2];
            float totalD = (float) tupla[3];

            boolean facturaB = (boolean) tupla[4];

            String rfc = (String) tupla[5];
            lista.add(new Object[]{paciente, institucion, idOv, totalD, facturaB, rfc});
            //log.debug("nombre:" + nombre + ", apellido:" + apellido + ", email:" + email) ;
        }

        return lista;
    }

    @Override
    public List<Object[]> findCorteVespertino(String fecha) {
        Iterator iter = null;
        Object[] tupla = null;
        List<Object[]> lista = new ArrayList<Object[]>();
        Query nativeQuery = em.createQuery("SELECT p.nombreCompletoP, "
                + "i.nombreInstitucion, "
                + "o.idOv, "
                + "o.totalEi, "
                + "o.requiereFactura, "
                + "p.rfcP "
                + "from VentaConceptos v "
                + "join v.idOrdenVenta o "
                + "join v.idInstitucion i "
                + "join v.idPacienteVc p "
                + "join v.idConceptoEs c "
                + "where o.pagado = true and v.fechaVentaVc between :fechaInicio and :fechaFin "
                + "group by o.idOv");
        nativeQuery.setParameter("fechaInicio", fecha + " 13:00:00");
        nativeQuery.setParameter("fechaFin", fecha + " 23:59:59");

        iter = nativeQuery.getResultList().iterator();

        while (iter.hasNext()) {
            tupla = (Object[]) iter.next();
            String paciente = (String) tupla[0];
            String institucion = (String) tupla[1];
            Long idOv = (Long) tupla[2];
            float totalD = (float) tupla[3];

            boolean facturaB = (boolean) tupla[4];

            String rfc = (String) tupla[5];
            lista.add(new Object[]{paciente, institucion, idOv, totalD, facturaB, rfc});
            //log.debug("nombre:" + nombre + ", apellido:" + apellido + ", email:" + email) ;
        }

        return lista;

    }

    @Override
    public List<Object[]> obtenerTotalesCorteMatutinoPorInstitucion(String fecha) {
        Iterator iter = null;
        Object[] tupla = null;
        List<Object[]> lista = new ArrayList<Object[]>();
        Query nativeQuery = em.createQuery("SELECT i.nombreInstitucion, "
                + "count(i.idInstitucion) "
                + "from VentaConceptos v "
                + "join v.idInstitucion i "
                + "where v.fechaVentaVc between :fechaInicio and :fechaFin "
                + "group by i.idInstitucion");
        nativeQuery.setParameter("fechaInicio", fecha + " 07:00:00");
        nativeQuery.setParameter("fechaFin", fecha + " 12:59:59");

        iter = nativeQuery.getResultList().iterator();

        while (iter.hasNext()) {
            tupla = (Object[]) iter.next();
            String institucion = (String) tupla[0];
            Long estudios = (Long) tupla[1];

            lista.add(new Object[]{institucion, estudios});
            //log.debug("nombre:" + nombre + ", apellido:" + apellido + ", email:" + email) ;
        }

        return lista;
    }

    @Override
    public List<Object[]> obtenerTotalesCorteVespertinoPorInstitucion(String fecha) {
        Iterator iter = null;
        Object[] tupla = null;
        List<Object[]> lista = new ArrayList<Object[]>();
        Query nativeQuery = em.createQuery("SELECT i.nombreInstitucion, "
                + "count(i.idInstitucion) "
                + "from VentaConceptos v "
                + "join v.idInstitucion i "
                + "where v.fechaVentaVc between :fechaInicio and :fechaFin "
                + "group by i.idInstitucion");
        nativeQuery.setParameter("fechaInicio", fecha + " 13:00:00");
        nativeQuery.setParameter("fechaFin", fecha + " 23:59:59");

        iter = nativeQuery.getResultList().iterator();

        while (iter.hasNext()) {
            tupla = (Object[]) iter.next();
            String institucion = (String) tupla[0];
            Long estudios = (Long) tupla[1];

            lista.add(new Object[]{institucion, estudios});
            //log.debug("nombre:" + nombre + ", apellido:" + apellido + ", email:" + email) ;
        }

        return lista;
    }

    @Override
    public List<Object[]> obtenerTotalesCorteMatutinoPorFormaDePago(String fecha) {
        Iterator iter = null;
        Object[] tupla = null;
        List<Object[]> lista = new ArrayList<Object[]>();
        Query nativeQuery = em.createQuery("SELECT f.formaPagoFp, "
                + "sum(p.cantidad) "
                + "from PagoOrdenVenta p "
                + "join p.idOrdenVenta o "
                + "join p.idFormaPago f "
                + "where o.pagado = true and o.fechaVentaOv between :fechaInicio and :fechaFin group by (f.idFp)");
        nativeQuery.setParameter("fechaInicio", fecha + " 07:00:00");
        nativeQuery.setParameter("fechaFin", fecha + " 12:59:59");

        iter = nativeQuery.getResultList().iterator();

        while (iter.hasNext()) {
            tupla = (Object[]) iter.next();
            String nombreFormaPago = (String) tupla[0];
            double institucion = (double) tupla[1];

            lista.add(new Object[]{nombreFormaPago, institucion});
            //log.debug("nombre:" + nombre + ", apellido:" + apellido + ", email:" + email) ;
        }

        return lista;
    }

    @Override
    public List<Object[]> obtenerTotalesCorteVespertinoPorFormaDePago(String fecha) {

        Iterator iter = null;
        Object[] tupla = null;
        List<Object[]> lista = new ArrayList<Object[]>();
        Query nativeQuery = em.createQuery("SELECT f.formaPagoFp , "
                + "sum(p.cantidad) "
                + "from PagoOrdenVenta p "
                + "join p.idOrdenVenta o "
                + "join p.idFormaPago f "
                + "where o.pagado = true and o.fechaVentaOv between :fechaInicio and :fechaFin group by (f.idFp)");
        nativeQuery.setParameter("fechaInicio", fecha + " 13:00:00");
        nativeQuery.setParameter("fechaFin", fecha + " 23:59:59");

        iter = nativeQuery.getResultList().iterator();

        while (iter.hasNext()) {
            tupla = (Object[]) iter.next();
            String nombreFormaPago = (String) tupla[0];
            double institucion = (double) tupla[1];

            lista.add(new Object[]{nombreFormaPago, institucion});
            //log.debug("nombre:" + nombre + ", apellido:" + apellido + ", email:" + email) ;
        }

        return lista;
    }

    @Override
    public List<Object[]> obtenerTotalesCorteMatutinoPorInstitucionArea(String fecha) {
        Iterator iter = null;
        Object[] tupla = null;
        List<Object[]> lista = new ArrayList<Object[]>();
        Query nativeQuery = em.createQuery("select i.nombreInstitucion, a.nombreA, "
                + "count(e.idEquipo) "
                + "from VentaConceptos v "
                + "join v.idInstitucion i "
                + "join v.idEquipoDicom e "
                + "join e.idArea a "
                + "where v.fechaVentaVc "
                + "between :fechaInicio and :fechaFin "
                + "GROUP BY e.idEquipo, i.idInstitucion ");
        nativeQuery.setParameter("fechaInicio", fecha + " 07:00:00");
        nativeQuery.setParameter("fechaFin", fecha + " 12:59:59");

        iter = nativeQuery.getResultList().iterator();

        while (iter.hasNext()) {
            tupla = (Object[]) iter.next();
            String institucion = (String) tupla[0];
            String area = (String) tupla[1];
            Long estudios = (Long) tupla[2];

            lista.add(new Object[]{institucion, area, estudios});
            //log.debug("nombre:" + nombre + ", apellido:" + apellido + ", email:" + email) ;
        }

        return lista;
    }

    @Override
    public List<Object[]> obtenerTotalesCorteVespertinoPorInstitucionArea(String fecha) {
        Iterator iter = null;
        Object[] tupla = null;
        List<Object[]> lista = new ArrayList<Object[]>();
        Query nativeQuery = em.createQuery("select i.nombreInstitucion, a.nombreA, "
                + "count(e.idEquipo) "
                + "from VentaConceptos v "
                + "join v.idInstitucion i "
                + "join v.idEquipoDicom e "
                + "join e.idArea a "
                + "where v.fechaVentaVc "
                + "between :fechaInicio and :fechaFin "
                + "GROUP BY e.idEquipo, i.idInstitucion ");
        nativeQuery.setParameter("fechaInicio", fecha + " 13:00:00");
        nativeQuery.setParameter("fechaFin", fecha + " 23:59:59");

        iter = nativeQuery.getResultList().iterator();

        while (iter.hasNext()) {
            tupla = (Object[]) iter.next();
            String institucion = (String) tupla[0];
            String area = (String) tupla[1];
            Long estudios = (Long) tupla[2];

            lista.add(new Object[]{institucion, area, estudios});
            //log.debug("nombre:" + nombre + ", apellido:" + apellido + ", email:" + email) ;
        }

        return lista;
    }

    @Override
    public void eliminarVentaConceptosPorIdOrdenVenta(Long idOrdenVenta) {
        List<VentaConceptos> ventas = findByIdOrdenVenta(idOrdenVenta);
        for (VentaConceptos temporal : ventas) {
            em.remove(em.merge(temporal));
        }
    }

    @Override
    public Long esCandidatoParaEliminarConceptosDeOrden(Long idOrdenVenta) {
        Long result = 0l;
        try {
            Query query = em.createQuery("select count(v.idVc) from VentaConceptos v where v.idOrdenVenta.idOv = :idOrdenVenta and (v.estado = :pasar or v.estado = :tomado or v.estado = :interpretando or v.estado = :interpretado)");
            query.setParameter("idOrdenVenta", idOrdenVenta);
            query.setParameter("pasar", "PASAR");
            query.setParameter("tomado", "TOMADO");
            query.setParameter("interpretando", "INTERPRETANDO");
            query.setParameter("interpretado", "INTERPRETADO");
            result = (Long) query.getSingleResult();
        } catch (Exception e) {
        }
        //Si hay cero estudios en esa orden de venta que van a pasar, han sido tomados o se est??n interpretando se dice que es candidato para eliminaci??n
        //Si hay por lo menos un estudio que ha sido "tomado", entonces no se puede cancelar la ??rden de venta
        return result;

    }

    @Override
    public List<Object[]> findCortesiasVesperinas(String fecha) {
        Iterator iter = null;
        Object[] tupla = null;
        List<Object[]> lista = new ArrayList<Object[]>();
        Query nativeQuery = em.createQuery("SELECT "
                + "p.nombreCompletoP, "
                + "c.conceptoTo, "
                + "o.totalEl, "
                + "x.cantidad "
                + "from VentaConceptos v "
                + "join v.idOrdenVenta o "
                + "join v.idPacienteVc p "
                + "join v.idConceptoEs c "
                + "join fetch o.pagoOrdenVentaList x "
                + "where o.pagado = true and v.fechaVentaVc between :fechaInicio and :fechaFin and x.idFormaPago.formaPagoFp = :formaPago "
                + "group by o.idOv");
        nativeQuery.setParameter("fechaInicio", fecha + " 13:00:00");
        nativeQuery.setParameter("fechaFin", fecha + " 23:59:59");
        nativeQuery.setParameter("formaPago", "CORTESIA");

        iter = nativeQuery.getResultList().iterator();

        while (iter.hasNext()) {
            tupla = (Object[]) iter.next();
            String paciente = (String) tupla[0];
            String concepto = (String) tupla[1];
            float totalD = (float) tupla[2];
            double cantidad = (double) tupla[3];

            lista.add(new Object[]{paciente, concepto, totalD, cantidad});
            //log.debug("nombre:" + nombre + ", apellido:" + apellido + ", email:" + email) ;
        }

        return lista;

    }

    @Override
    public List<Object[]> findCortesiasMatutinas(String fecha) {
        Iterator iter = null;
        Object[] tupla = null;
        List<Object[]> lista = new ArrayList<Object[]>();
        Query nativeQuery = em.createQuery("SELECT "
                + "p.nombreCompletoP, "
                + "c.conceptoTo, "
                + "o.totalEl, "
                + "x.cantidad "
                + "from VentaConceptos v "
                + "join v.idOrdenVenta o "
                + "join v.idPacienteVc p "
                + "join v.idConceptoEs c "
                + "join fetch o.pagoOrdenVentaList x "
                + "where o.pagado = true and v.fechaVentaVc between :fechaInicio and :fechaFin and x.idFormaPago.formaPagoFp = :formaPago "
                + "group by o.idOv");
        nativeQuery.setParameter("fechaInicio", fecha + " 07:00:00");
        nativeQuery.setParameter("fechaFin", fecha + " 12:59:59");
        nativeQuery.setParameter("formaPago", "CORTESIA");

        iter = nativeQuery.getResultList().iterator();

        while (iter.hasNext()) {
            tupla = (Object[]) iter.next();
            String paciente = (String) tupla[0];
            String concepto = (String) tupla[1];
            float totalD = (float) tupla[2];
            double cantidad = (double) tupla[3];

            lista.add(new Object[]{paciente, concepto, totalD, cantidad});
            //log.debug("nombre:" + nombre + ", apellido:" + apellido + ", email:" + email) ;
        }

        return lista;

    }

    @Override
    public void actualizarEstadoVentaConceptosPorIdOrdenVenta(Long idOrdenVenta, String estado) {
        findByIdOrdenVenta(idOrdenVenta).forEach(v -> {
            v.setEstado(estado);
            em.merge(v);
        });
    }

}
