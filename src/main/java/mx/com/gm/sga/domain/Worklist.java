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
        private String patientId ; //MAX 250 va a ser la curp
        private String nombrePaciente; //MAX 250
        private String birthday; //MAX 26
        private String sex; //MALE, FEMALE, AMBIGUOUS, NOT APPLICABLE, OTHER, UKNOW
        
        //ORC
        private String control; //NW = NUEVO, 2 DÍGITOS, 
        private String iDNIfOptional; //MAX 22
        
        //TQ1
        private String dateTime; //26 HORA INICIO Y FECHA
        private String priority; //De rutina MAX 250
        
        //OBR
        private String proveedor; //Creo que es opcional MAX 250 //Es el medico que refiere
        private String procedure; //PROCEDIMIENTO MAX 250
        
        //IPC
        private String accessionNumber; //MAX 80
        private String solProcedure; //MAX 22 //este es el nombre como aparece en el pacs requested
        private String uidIdStudyInstance; //MAX 70
        private String idStepProcedure; //MAX 22
        private String modality; //MAX 16
        private String stationName; //MAX 22
        private String scheduledAE ; //MAX 16

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

    @Override
    public String toString() {
        return "Worklist{" + "host=" + host + ", port=" + port + ", aplicacionEnvia=" + aplicacionEnvia + ", sendingFacility=" + sendingFacility + ", receivingApplication=" + receivingApplication + ", receivingFacility=" + receivingFacility + ", idMessageControl=" + idMessageControl + ", patientId=" + patientId + ", nombrePaciente=" + nombrePaciente + ", birthday=" + birthday + ", sex=" + sex + ", control=" + control + ", iDNIfOptional=" + iDNIfOptional + ", dateTime=" + dateTime + ", priority=" + priority + ", proveedor=" + proveedor + ", procedure=" + procedure + ", accessionNumber=" + accessionNumber + ", solProcedure=" + solProcedure + ", uidIdStudyInstance=" + uidIdStudyInstance + ", idStepProcedure=" + idStepProcedure + ", modality=" + modality + ", stationName=" + stationName + ", scheduledAE=" + scheduledAE + '}';
    }
        
        
        
}
