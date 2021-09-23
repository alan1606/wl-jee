/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.datos;

import ca.uhn.hl7v2.*;
import ca.uhn.hl7v2.app.*;
import ca.uhn.hl7v2.llp.LLPException;
import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.parser.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import mx.com.gm.sga.domain.VentaConceptos;
import mx.com.gm.sga.domain.Worklist;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author alanm
 */
public class WorklistDaoImpl implements WorklistDao {

    static Logger log = LogManager.getRootLogger();

    @PersistenceContext(unitName = "SgaPU")
    EntityManager em;

    @Override
    public void registrarEnWorklist(long idVentaConceptos) {
        VentaConceptos estudio = obtenerVentaConceptos(idVentaConceptos);
        Worklist worklist = crearObjeto(estudio);

        boolean useTls = false; // Should we use TLS/SSL?
        HapiContext context = new DefaultHapiContext();
        context.getParserConfiguration().setValidating(false);

        Parser p = context.getPipeParser();
        Message adt = null;
        Connection connection = null;
        try {
            adt = p.parse(worklist.getMensaje()); //el otro usa p.enconde
            // Remember, we created our HAPI Context above like so:
            // HapiContext context = new DefaultHapiContext();
            // A connection object represents a socket attached to an HL7 server
            connection = context.newClient(worklist.getHost(), worklist.getPort(), useTls);

            // The initiator is used to transmit unsolicited messages
            Initiator initiator = connection.getInitiator();
            Message response = null;

            response = initiator.sendAndReceive(adt);
            String responseString = p.encode(response);
            System.out.println(worklist.getMensaje());
            System.out.println("Received response:\n" + responseString);

        } catch (HL7Exception | LLPException | IOException ex) {
            log.debug(ex.getMessage());
        } finally {
            connection.close();
        }
    }

    private Worklist crearObjeto(VentaConceptos estudio) {
        Worklist worklist = new Worklist();
        worklist.setHost("172.17.200.23"); //Server IP
        worklist.setPort(2575); // The port to listen on

        //MSH
        worklist.setAplicacionEnvia("MWLJAVA");
        worklist.setSendingFacility("API");
        worklist.setReceivingApplication("DCM4CHEE");
        worklist.setReceivingFacility("API");
        worklist.setIdMessageControl(estudio.getIdVc() + ""); //El id de venta concepto 

        //PID
        worklist.setPatientId(estudio.getIdPacienteVc().getIdP() + "");
        worklist.setNombrePaciente(estudio.getIdPacienteVc().getNombreP());
        worklist.setApellidoMaterno(estudio.getIdPacienteVc().getAmaternoP());
        worklist.setApellidoPaterno(estudio.getIdPacienteVc().getApaternoP());
        worklist.setBirthday(anioMesDia(dateToString(estudio.getIdPacienteVc().getFNacp().getTime())));
        if (estudio.getIdPacienteVc().getSexoP() == 2) { //MASCULINO
            worklist.setSex("M"); //Male
        } else {
            worklist.setSex("F"); //Female
        }

        //ORC
        worklist.setControl("NW");
        worklist.setiDNIfOptional("1");

        //TQ1
        worklist.setDateTime(dateTime(estudio.getFechaAsignado(), estudio.getHoraAsignado()));
        worklist.setPriority("R");

        //OBR
        worklist.setMotivo(estudio.getMotivoVisitaVc());
        worklist.setProveedor("MEDICO REFERENTE");
        worklist.setProcedure(estudio.getIdConceptoEs().getDescripcionTo());

        //IPC
        worklist.setAccessionNumber(estudio.getIdVc() + "");
        worklist.setSolProcedure(estudio.getIdPacs());
        worklist.setUidIdStudyInstance(generarUid(worklist.getDateTime(), worklist.getAccessionNumber()));
        worklist.setIdStepProcedure("");
        worklist.setModality(estudio.getIdEquipoDicom().getModalidad());
        worklist.setStationName(estudio.getIdEquipoDicom().getNombre());
        worklist.setScheduledAE(estudio.getIdEquipoDicom().getAeTitle());

        return worklist;
    }

    private String anioMesDia(String fecha) {
        String anio = "";
        String mes = "";
        String dia = "";
        for (int i = 0; i < 4; i++) {
            anio += fecha.charAt(i);
        }
        for (int i = 5; i < 7; i++) {
            mes += fecha.charAt(i);
        }
        for (int i = 8; i < 10; i++) {
            dia += fecha.charAt(i);
        }
        return anio + mes + dia;
    }

    public static String dateToString(Long date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(date);
        return strDate;
    }

    private String dateTime(String fechaAsignado, String horaAsignado) {
        String fecha = anioMesDia(fechaAsignado);
        String hora = hora(horaAsignado);
        return fecha + hora;
    }

    private String generarUid(String dateTime, String accessionNumber) {
        return ("1.2.250." + dateTime + "." + accessionNumber);
    }

    private String hora(String horaAsignado) {
        String hora = "";
        for (int i = 0; i < 2; i++) {
            hora += horaAsignado.charAt(i);
        }
        for (int i = 3; i < 5; i++) {
            hora += horaAsignado.charAt(i);
        }
        return hora;
    }

    private VentaConceptos obtenerVentaConceptos(long idVentaConceptos) {
        return em.find(VentaConceptos.class, idVentaConceptos);
    }

    @Override
    public void registrarEnWorklistPorOrdenVenta(long idOrdenVenta) {
        Query query = em.createQuery("from VentaConceptos v where v.idOrdenVenta.idOv = :idOrdenVenta and v.idConceptoEs.dicom = 1");
        query.setParameter("idOrdenVenta", idOrdenVenta);
        List<VentaConceptos> estudios = query.getResultList();
        for(VentaConceptos venta : estudios){
            registrarEnWorklist(venta.getIdVc());
        }
    }

}
