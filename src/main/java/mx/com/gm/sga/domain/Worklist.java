/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.domain;

/**
 *
 * @author alanm
 */
public class Worklist {

    private String host;
    private int port; // The port to listen on

    //MSH
    private String aplicacionEnvia; //MAX 227
    private String sendingFacility; //MAX 227
    private String receivingApplication; //MAX 227
    private String receivingFacility; //SAME
    private String idMessageControl; //MAX 20

    //PID
    private String patientId; //MAX 250 va a ser la curp
    private String nombrePaciente; //MAX 250
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String birthday; //MAX 26 YYYYMMDD
    private String sex; //MALE, FEMALE, AMBIGUOUS, NOT APPLICABLE, OTHER, UKNOW

    //ORC
    private String control; //NW = NUEVO, 2 DÍGITOS, 
    private String iDNIfOptional; //MAX 22 estático 1, aún no sabemos

    //TQ1
    private String dateTime; //26 HORA INICIO Y FECHA YYYYMMDDHHMM
    private String priority; //De rutina MAX 250 Es un caracter que la especificación quiere R = routine T = urgencia

    //OBR
    private String motivo;
    private String proveedor; //Creo que es opcional MAX 250 //Es el medico que refiere
    private String procedure; //PROCEDIMIENTO MAX 250 //Es el concepto de venta_concepto, descripcion

    //IPC
    private String accessionNumber; //MAX 80  Es el id de venta concepto
    private String solProcedure; //MAX 22 //es el id pacs
    private String uidIdStudyInstance; //MAX 70 "1.2.250." + dTime + "." + accessionNumber;
    private String idStepProcedure; //MAX 22 Es el id del protocolo, en dx es el que nos cambia la parte del cuerpo
    private String modality; //MAX 16
    private String stationName; //MAX 22 Viene de la db de equipodicom
    private String scheduledAE; //MAX 16 Viene de la db de equipodicom

    private String mensaje;

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    
    
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getAplicacionEnvia() {
        return aplicacionEnvia;
    }

    public void setAplicacionEnvia(String aplicacionEnvia) {
        this.aplicacionEnvia = aplicacionEnvia;
    }

    public String getSendingFacility() {
        return sendingFacility;
    }

    public void setSendingFacility(String sendingFacility) {
        this.sendingFacility = sendingFacility;
    }

    public String getReceivingApplication() {
        return receivingApplication;
    }

    public void setReceivingApplication(String receivingApplication) {
        this.receivingApplication = receivingApplication;
    }

    public String getReceivingFacility() {
        return receivingFacility;
    }

    public void setReceivingFacility(String receivingFacility) {
        this.receivingFacility = receivingFacility;
    }

    public String getIdMessageControl() {
        return idMessageControl;
    }

    public void setIdMessageControl(String idMessageControl) {
        this.idMessageControl = idMessageControl;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getControl() {
        return control;
    }

    public void setControl(String control) {
        this.control = control;
    }

    public String getiDNIfOptional() {
        return iDNIfOptional;
    }

    public void setiDNIfOptional(String iDNIfOptional) {
        this.iDNIfOptional = iDNIfOptional;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public String getAccessionNumber() {
        return accessionNumber;
    }

    public void setAccessionNumber(String accessionNumber) {
        this.accessionNumber = accessionNumber;
    }

    public String getSolProcedure() {
        return solProcedure;
    }

    public void setSolProcedure(String solProcedure) {
        this.solProcedure = solProcedure;
    }

    public String getUidIdStudyInstance() {
        return uidIdStudyInstance;
    }

    public void setUidIdStudyInstance(String uidIdStudyInstance) {
        this.uidIdStudyInstance = uidIdStudyInstance;
    }

    public String getIdStepProcedure() {
        return idStepProcedure;
    }

    public void setIdStepProcedure(String idStepProcedure) {
        this.idStepProcedure = idStepProcedure;
    }

    public String getModality() {
        return modality;
    }

    public void setModality(String modality) {
        this.modality = modality;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getScheduledAE() {
        return scheduledAE;
    }

    public void setScheduledAE(String scheduledAE) {
        this.scheduledAE = scheduledAE;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getMotivo() {
        return motivo;
    }

    public String getMensaje() {

        String msg = "MSH|^~\\&|" + aplicacionEnvia + "|" + sendingFacility + "|" + receivingApplication + "|" + receivingFacility + "|||OMI^O23|" + idMessageControl + "|P|2.5.1\r"
                + "PID|||" + patientId + "||" + apellidoPaterno + " " + apellidoMaterno +  "^" + nombrePaciente + "|" + apellidoMaterno + "|" + birthday + "|" + sex + "\r"
                //+ "PV1||||||2359||1234^CMP123|||||||A0||||908831\r"
                + "NTE|||" + motivo + "|1R\r"
                + "ORC|" + control + "|" + iDNIfOptional + "|" + iDNIfOptional + "||SC\r"
                + "TQ1|||||||" + dateTime + "||" + priority + "||\r"
                + "OBR|||||||||||||" + motivo + "ORB|||" + proveedor + "||||||||||||||||||||||||||||" + procedure + "\r"
                + "IPC|" + accessionNumber + "|" + solProcedure + "|" + uidIdStudyInstance + "|" + idStepProcedure + "|" + modality + "||" + stationName + "||" + scheduledAE + "\r";
        return msg;
    }

    @Override
    public String toString() {
        return "Worklist{" + "host=" + host + ", port=" + port + ", aplicacionEnvia=" + aplicacionEnvia + ", sendingFacility=" + sendingFacility + ", receivingApplication=" + receivingApplication + ", receivingFacility=" + receivingFacility + ", idMessageControl=" + idMessageControl + ", patientId=" + patientId + ", nombrePaciente=" + nombrePaciente + ", birthday=" + birthday + ", sex=" + sex + ", control=" + control + ", iDNIfOptional=" + iDNIfOptional + ", dateTime=" + dateTime + ", priority=" + priority + ", proveedor=" + proveedor + ", procedure=" + procedure + ", accessionNumber=" + accessionNumber + ", solProcedure=" + solProcedure + ", uidIdStudyInstance=" + uidIdStudyInstance + ", idStepProcedure=" + idStepProcedure + ", modality=" + modality + ", stationName=" + stationName + ", scheduledAE=" + scheduledAE + '}';
    }

}
