/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alanm
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pacientes.findAll", query = "SELECT p FROM Pacientes p"),
    @NamedQuery(name = "Pacientes.findByIdP", query = "SELECT p FROM Pacientes p WHERE p.idP = :idP"),
    @NamedQuery(name = "Pacientes.findByCurpP", query = "SELECT p FROM Pacientes p WHERE p.curpP = :curpP"),
    @NamedQuery(name = "Pacientes.findByNombreP", query = "SELECT p FROM Pacientes p WHERE p.nombreP = :nombreP"),
    @NamedQuery(name = "Pacientes.findByApaternoP", query = "SELECT p FROM Pacientes p WHERE p.apaternoP = :apaternoP"),
    @NamedQuery(name = "Pacientes.findByAmaternoP", query = "SELECT p FROM Pacientes p WHERE p.amaternoP = :amaternoP"),
    @NamedQuery(name = "Pacientes.findByNSocioeconomicop", query = "SELECT p FROM Pacientes p WHERE p.nSocioeconomicop = :nSocioeconomicop"),
    @NamedQuery(name = "Pacientes.findByTViviendap", query = "SELECT p FROM Pacientes p WHERE p.tViviendap = :tViviendap"),
    @NamedQuery(name = "Pacientes.findByTSanguineop", query = "SELECT p FROM Pacientes p WHERE p.tSanguineop = :tSanguineop"),
    @NamedQuery(name = "Pacientes.findByIdDiscapacidadp", query = "SELECT p FROM Pacientes p WHERE p.idDiscapacidadp = :idDiscapacidadp"),
    @NamedQuery(name = "Pacientes.findByGrupoEtnicop", query = "SELECT p FROM Pacientes p WHERE p.grupoEtnicop = :grupoEtnicop"),
    @NamedQuery(name = "Pacientes.findByIdReligionp", query = "SELECT p FROM Pacientes p WHERE p.idReligionp = :idReligionp"),
    @NamedQuery(name = "Pacientes.findByTCelularp", query = "SELECT p FROM Pacientes p WHERE p.tCelularp = :tCelularp"),
    @NamedQuery(name = "Pacientes.findByTParticularp", query = "SELECT p FROM Pacientes p WHERE p.tParticularp = :tParticularp"),
    @NamedQuery(name = "Pacientes.findByTTrabajop", query = "SELECT p FROM Pacientes p WHERE p.tTrabajop = :tTrabajop"),
    @NamedQuery(name = "Pacientes.findByExtensionTtp", query = "SELECT p FROM Pacientes p WHERE p.extensionTtp = :extensionTtp"),
    @NamedQuery(name = "Pacientes.findByRfcP", query = "SELECT p FROM Pacientes p WHERE p.rfcP = :rfcP"),
    @NamedQuery(name = "Pacientes.findByContactoEmergenciap", query = "SELECT p FROM Pacientes p WHERE p.contactoEmergenciap = :contactoEmergenciap"),
    @NamedQuery(name = "Pacientes.findByParentescoContactoP", query = "SELECT p FROM Pacientes p WHERE p.parentescoContactoP = :parentescoContactoP"),
    @NamedQuery(name = "Pacientes.findByTEmergenciap", query = "SELECT p FROM Pacientes p WHERE p.tEmergenciap = :tEmergenciap"),
    @NamedQuery(name = "Pacientes.findByIdSucursalp", query = "SELECT p FROM Pacientes p WHERE p.idSucursalp = :idSucursalp"),
    @NamedQuery(name = "Pacientes.findByEmailP", query = "SELECT p FROM Pacientes p WHERE p.emailP = :emailP"),
    @NamedQuery(name = "Pacientes.findBySexoP", query = "SELECT p FROM Pacientes p WHERE p.sexoP = :sexoP"),
    @NamedQuery(name = "Pacientes.findByFNacp", query = "SELECT p FROM Pacientes p WHERE p.fNacp = :fNacp"),
    @NamedQuery(name = "Pacientes.findByActivoP", query = "SELECT p FROM Pacientes p WHERE p.activoP = :activoP"),
    @NamedQuery(name = "Pacientes.findByEscolaridadP", query = "SELECT p FROM Pacientes p WHERE p.escolaridadP = :escolaridadP"),
    @NamedQuery(name = "Pacientes.findByIdOcupacionp", query = "SELECT p FROM Pacientes p WHERE p.idOcupacionp = :idOcupacionp"),
    @NamedQuery(name = "Pacientes.findByIdUsuarioRp", query = "SELECT p FROM Pacientes p WHERE p.idUsuarioRp = :idUsuarioRp"),
    @NamedQuery(name = "Pacientes.findByFechaRp", query = "SELECT p FROM Pacientes p WHERE p.fechaRp = :fechaRp"),
    @NamedQuery(name = "Pacientes.findByNacionalidadP", query = "SELECT p FROM Pacientes p WHERE p.nacionalidadP = :nacionalidadP"),
    @NamedQuery(name = "Pacientes.findByCalleP", query = "SELECT p FROM Pacientes p WHERE p.calleP = :calleP"),
    @NamedQuery(name = "Pacientes.findByEntidadFederativap", query = "SELECT p FROM Pacientes p WHERE p.entidadFederativap = :entidadFederativap"),
    @NamedQuery(name = "Pacientes.findByMunicipioP", query = "SELECT p FROM Pacientes p WHERE p.municipioP = :municipioP"),
    @NamedQuery(name = "Pacientes.findByCiudadP", query = "SELECT p FROM Pacientes p WHERE p.ciudadP = :ciudadP"),
    @NamedQuery(name = "Pacientes.findByColoniaP", query = "SELECT p FROM Pacientes p WHERE p.coloniaP = :coloniaP"),
    @NamedQuery(name = "Pacientes.findByCpP", query = "SELECT p FROM Pacientes p WHERE p.cpP = :cpP"),
    @NamedQuery(name = "Pacientes.findByEntidadNacimientoP", query = "SELECT p FROM Pacientes p WHERE p.entidadNacimientoP = :entidadNacimientoP"),
    @NamedQuery(name = "Pacientes.findByRazonSocialP", query = "SELECT p FROM Pacientes p WHERE p.razonSocialP = :razonSocialP"),
    @NamedQuery(name = "Pacientes.findByCallePf", query = "SELECT p FROM Pacientes p WHERE p.callePf = :callePf"),
    @NamedQuery(name = "Pacientes.findByEntidadFederativapf", query = "SELECT p FROM Pacientes p WHERE p.entidadFederativapf = :entidadFederativapf"),
    @NamedQuery(name = "Pacientes.findByMunicipioPf", query = "SELECT p FROM Pacientes p WHERE p.municipioPf = :municipioPf"),
    @NamedQuery(name = "Pacientes.findByCiudadPf", query = "SELECT p FROM Pacientes p WHERE p.ciudadPf = :ciudadPf"),
    @NamedQuery(name = "Pacientes.findByColoniaPf", query = "SELECT p FROM Pacientes p WHERE p.coloniaPf = :coloniaPf"),
    @NamedQuery(name = "Pacientes.findByCpPf", query = "SELECT p FROM Pacientes p WHERE p.cpPf = :cpPf"),
    @NamedQuery(name = "Pacientes.findByRfcFP", query = "SELECT p FROM Pacientes p WHERE p.rfcFP = :rfcFP"),
    @NamedQuery(name = "Pacientes.findByCentroSaludP", query = "SELECT p FROM Pacientes p WHERE p.centroSaludP = :centroSaludP"),
    @NamedQuery(name = "Pacientes.findByNombreCompletoP", query = "SELECT p FROM Pacientes p WHERE p.nombreCompletoP = :nombreCompletoP"),
    @NamedQuery(name = "Pacientes.findByEdoCivilP", query = "SELECT p FROM Pacientes p WHERE p.edoCivilP = :edoCivilP"),
    @NamedQuery(name = "Pacientes.findByNoSeguridadSocialP", query = "SELECT p FROM Pacientes p WHERE p.noSeguridadSocialP = :noSeguridadSocialP"),
    @NamedQuery(name = "Pacientes.findByEmailPf", query = "SELECT p FROM Pacientes p WHERE p.emailPf = :emailPf"),
    @NamedQuery(name = "Pacientes.findByApgarP", query = "SELECT p FROM Pacientes p WHERE p.apgarP = :apgarP"),
    @NamedQuery(name = "Pacientes.findByTamizP", query = "SELECT p FROM Pacientes p WHERE p.tamizP = :tamizP")})
public class Pacientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_p")
    private Long idP;
    @Size(max = 18)
    @Column(name = "curp_p")
    private String curpP;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "nombre_p")
    private String nombreP;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "apaterno_p")
    private String apaternoP;
    @Size(max = 150)
    @Column(name = "amaterno_p")
    private String amaternoP;
    @Column(name = "nSocioeconomico_p")
    private Short nSocioeconomicop;
    @Column(name = "tVivienda_p")
    private Short tViviendap;
    @Column(name = "tSanguineo_p")
    private Short tSanguineop;
    @Column(name = "idDiscapacidad_p")
    private Short idDiscapacidadp;
    @Column(name = "grupoEtnico_p")
    private Short grupoEtnicop;
    @Column(name = "idReligion_p")
    private Short idReligionp;
    @Size(max = 17)
    @Column(name = "tCelular_p")
    private String tCelularp;
    @Size(max = 17)
    @Column(name = "tParticular_p")
    private String tParticularp;
    @Size(max = 17)
    @Column(name = "tTrabajo_p")
    private String tTrabajop;
    @Size(max = 6)
    @Column(name = "extensionTt_p")
    private String extensionTtp;
    @Size(max = 15)
    @Column(name = "rfc_p")
    private String rfcP;
    @Size(max = 150)
    @Column(name = "contactoEmergencia_p")
    private String contactoEmergenciap;
    @Column(name = "parentesco_contacto_p")
    private Short parentescoContactoP;
    @Size(max = 17)
    @Column(name = "tEmergencia_p")
    private String tEmergenciap;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idSucursal_p")
    private short idSucursalp;
    @Size(max = 100)
    @Column(name = "email_p")
    private String emailP;
    @Column(name = "sexo_p")
    private Short sexoP;
    @Column(name = "fNac_p")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fNacp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo_p")
    private short activoP;
    @Lob
    @Size(max = 65535)
    @Column(name = "notas_p")
    private String notasP;
    @Column(name = "escolaridad_p")
    private Short escolaridadP;
    @Column(name = "idOcupacion_p")
    private Integer idOcupacionp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idUsuarioR_p")
    private int idUsuarioRp;
    @Column(name = "fechaR_p")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nacionalidad_p")
    private short nacionalidadP;
    @Size(max = 200)
    @Column(name = "calle_p")
    private String calleP;
    @Column(name = "entidadFederativa_p")
    private Integer entidadFederativap;
    @Column(name = "municipio_p")
    private Integer municipioP;
    @Size(max = 100)
    @Column(name = "ciudad_p")
    private String ciudadP;
    @Size(max = 150)
    @Column(name = "colonia_p")
    private String coloniaP;
    @Size(max = 10)
    @Column(name = "cp_p")
    private String cpP;
    @Column(name = "entidad_nacimiento_p")
    private Integer entidadNacimientoP;
    @Size(max = 250)
    @Column(name = "razon_social_p")
    private String razonSocialP;
    @Size(max = 200)
    @Column(name = "calle_pf")
    private String callePf;
    @Column(name = "entidadFederativa_pf")
    private Integer entidadFederativapf;
    @Column(name = "municipio_pf")
    private Integer municipioPf;
    @Size(max = 100)
    @Column(name = "ciudad_pf")
    private String ciudadPf;
    @Size(max = 150)
    @Column(name = "colonia_pf")
    private String coloniaPf;
    @Size(max = 10)
    @Column(name = "cp_pf")
    private String cpPf;
    @Size(max = 15)
    @Column(name = "rfc_f_p")
    private String rfcFP;
    @Column(name = "centro_salud_p")
    private Integer centroSaludP;
    @Size(max = 255)
    @Column(name = "nombre_completo_p")
    private String nombreCompletoP;
    @Column(name = "edo_civil_p")
    private Short edoCivilP;
    @Lob
    @Column(name = "coordenadas_p")
    private byte[] coordenadasP;
    @Size(max = 60)
    @Column(name = "no_seguridad_social_p")
    private String noSeguridadSocialP;
    @Size(max = 100)
    @Column(name = "email_pf")
    private String emailPf;
    @Column(name = "apgar_p")
    private Short apgarP;
    @Column(name = "tamiz_p")
    private Short tamizP;
    @Lob
    @Size(max = 65535)
    @Column(name = "alergias_p")
    private String alergiasP;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPacienteVc")
    private List<VentaConceptos> ventaConceptosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPaciente")
    private List<PacienteConsentimientoConcepto> pacienteConsentimientoConceptoList;
    @JoinColumn(name = "id_firma", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Firma idFirma;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPacienteOv")
    private List<OrdenVenta> ordenVentaList;

    public Pacientes() {
    }

    public Pacientes(Long idP) {
        this.idP = idP;
    }

    public Pacientes(Long idP, String nombreP, String apaternoP, short idSucursalp, short activoP, int idUsuarioRp, short nacionalidadP) {
        this.idP = idP;
        this.nombreP = nombreP;
        this.apaternoP = apaternoP;
        this.idSucursalp = idSucursalp;
        this.activoP = activoP;
        this.idUsuarioRp = idUsuarioRp;
        this.nacionalidadP = nacionalidadP;
    }

    public Long getIdP() {
        return idP;
    }

    public void setIdP(Long idP) {
        this.idP = idP;
    }

    public String getCurpP() {
        return curpP;
    }

    public void setCurpP(String curpP) {
        this.curpP = curpP;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getApaternoP() {
        return apaternoP;
    }

    public void setApaternoP(String apaternoP) {
        this.apaternoP = apaternoP;
    }

    public String getAmaternoP() {
        return amaternoP;
    }

    public void setAmaternoP(String amaternoP) {
        this.amaternoP = amaternoP;
    }

    public Short getNSocioeconomicop() {
        return nSocioeconomicop;
    }

    public void setNSocioeconomicop(Short nSocioeconomicop) {
        this.nSocioeconomicop = nSocioeconomicop;
    }

    public Short getTViviendap() {
        return tViviendap;
    }

    public void setTViviendap(Short tViviendap) {
        this.tViviendap = tViviendap;
    }

    public Short getTSanguineop() {
        return tSanguineop;
    }

    public void setTSanguineop(Short tSanguineop) {
        this.tSanguineop = tSanguineop;
    }

    public Short getIdDiscapacidadp() {
        return idDiscapacidadp;
    }

    public void setIdDiscapacidadp(Short idDiscapacidadp) {
        this.idDiscapacidadp = idDiscapacidadp;
    }

    public Short getGrupoEtnicop() {
        return grupoEtnicop;
    }

    public void setGrupoEtnicop(Short grupoEtnicop) {
        this.grupoEtnicop = grupoEtnicop;
    }

    public Short getIdReligionp() {
        return idReligionp;
    }

    public void setIdReligionp(Short idReligionp) {
        this.idReligionp = idReligionp;
    }

    public String getTCelularp() {
        return tCelularp;
    }

    public void setTCelularp(String tCelularp) {
        this.tCelularp = tCelularp;
    }

    public String getTParticularp() {
        return tParticularp;
    }

    public void setTParticularp(String tParticularp) {
        this.tParticularp = tParticularp;
    }

    public String getTTrabajop() {
        return tTrabajop;
    }

    public void setTTrabajop(String tTrabajop) {
        this.tTrabajop = tTrabajop;
    }

    public String getExtensionTtp() {
        return extensionTtp;
    }

    public void setExtensionTtp(String extensionTtp) {
        this.extensionTtp = extensionTtp;
    }

    public String getRfcP() {
        return rfcP;
    }

    public void setRfcP(String rfcP) {
        this.rfcP = rfcP;
    }

    public String getContactoEmergenciap() {
        return contactoEmergenciap;
    }

    public void setContactoEmergenciap(String contactoEmergenciap) {
        this.contactoEmergenciap = contactoEmergenciap;
    }

    public Short getParentescoContactoP() {
        return parentescoContactoP;
    }

    public void setParentescoContactoP(Short parentescoContactoP) {
        this.parentescoContactoP = parentescoContactoP;
    }

    public String getTEmergenciap() {
        return tEmergenciap;
    }

    public void setTEmergenciap(String tEmergenciap) {
        this.tEmergenciap = tEmergenciap;
    }

    public short getIdSucursalp() {
        return idSucursalp;
    }

    public void setIdSucursalp(short idSucursalp) {
        this.idSucursalp = idSucursalp;
    }

    public String getEmailP() {
        return emailP;
    }

    public void setEmailP(String emailP) {
        this.emailP = emailP;
    }

    public Short getSexoP() {
        return sexoP;
    }

    public void setSexoP(Short sexoP) {
        this.sexoP = sexoP;
    }

    public Date getFNacp() {
        return fNacp;
    }

    public void setFNacp(Date fNacp) {
        this.fNacp = fNacp;
    }

    public short getActivoP() {
        return activoP;
    }

    public void setActivoP(short activoP) {
        this.activoP = activoP;
    }

    public String getNotasP() {
        return notasP;
    }

    public void setNotasP(String notasP) {
        this.notasP = notasP;
    }

    public Short getEscolaridadP() {
        return escolaridadP;
    }

    public void setEscolaridadP(Short escolaridadP) {
        this.escolaridadP = escolaridadP;
    }

    public Integer getIdOcupacionp() {
        return idOcupacionp;
    }

    public void setIdOcupacionp(Integer idOcupacionp) {
        this.idOcupacionp = idOcupacionp;
    }

    public int getIdUsuarioRp() {
        return idUsuarioRp;
    }

    public void setIdUsuarioRp(int idUsuarioRp) {
        this.idUsuarioRp = idUsuarioRp;
    }

    public Date getFechaRp() {
        return fechaRp;
    }

    public void setFechaRp(Date fechaRp) {
        this.fechaRp = fechaRp;
    }

    public short getNacionalidadP() {
        return nacionalidadP;
    }

    public void setNacionalidadP(short nacionalidadP) {
        this.nacionalidadP = nacionalidadP;
    }

    public String getCalleP() {
        return calleP;
    }

    public void setCalleP(String calleP) {
        this.calleP = calleP;
    }

    public Integer getEntidadFederativap() {
        return entidadFederativap;
    }

    public void setEntidadFederativap(Integer entidadFederativap) {
        this.entidadFederativap = entidadFederativap;
    }

    public Integer getMunicipioP() {
        return municipioP;
    }

    public void setMunicipioP(Integer municipioP) {
        this.municipioP = municipioP;
    }

    public String getCiudadP() {
        return ciudadP;
    }

    public void setCiudadP(String ciudadP) {
        this.ciudadP = ciudadP;
    }

    public String getColoniaP() {
        return coloniaP;
    }

    public void setColoniaP(String coloniaP) {
        this.coloniaP = coloniaP;
    }

    public String getCpP() {
        return cpP;
    }

    public void setCpP(String cpP) {
        this.cpP = cpP;
    }

    public Integer getEntidadNacimientoP() {
        return entidadNacimientoP;
    }

    public void setEntidadNacimientoP(Integer entidadNacimientoP) {
        this.entidadNacimientoP = entidadNacimientoP;
    }

    public String getRazonSocialP() {
        return razonSocialP;
    }

    public void setRazonSocialP(String razonSocialP) {
        this.razonSocialP = razonSocialP;
    }

    public String getCallePf() {
        return callePf;
    }

    public void setCallePf(String callePf) {
        this.callePf = callePf;
    }

    public Integer getEntidadFederativapf() {
        return entidadFederativapf;
    }

    public void setEntidadFederativapf(Integer entidadFederativapf) {
        this.entidadFederativapf = entidadFederativapf;
    }

    public Integer getMunicipioPf() {
        return municipioPf;
    }

    public void setMunicipioPf(Integer municipioPf) {
        this.municipioPf = municipioPf;
    }

    public String getCiudadPf() {
        return ciudadPf;
    }

    public void setCiudadPf(String ciudadPf) {
        this.ciudadPf = ciudadPf;
    }

    public String getColoniaPf() {
        return coloniaPf;
    }

    public void setColoniaPf(String coloniaPf) {
        this.coloniaPf = coloniaPf;
    }

    public String getCpPf() {
        return cpPf;
    }

    public void setCpPf(String cpPf) {
        this.cpPf = cpPf;
    }

    public String getRfcFP() {
        return rfcFP;
    }

    public void setRfcFP(String rfcFP) {
        this.rfcFP = rfcFP;
    }

    public Integer getCentroSaludP() {
        return centroSaludP;
    }

    public void setCentroSaludP(Integer centroSaludP) {
        this.centroSaludP = centroSaludP;
    }

    public String getNombreCompletoP() {
        return nombreCompletoP;
    }

    public void setNombreCompletoP(String nombreCompletoP) {
        this.nombreCompletoP = nombreCompletoP;
    }

    public Short getEdoCivilP() {
        return edoCivilP;
    }

    public void setEdoCivilP(Short edoCivilP) {
        this.edoCivilP = edoCivilP;
    }

    public byte[] getCoordenadasP() {
        return coordenadasP;
    }

    public void setCoordenadasP(byte[] coordenadasP) {
        this.coordenadasP = coordenadasP;
    }

    public String getNoSeguridadSocialP() {
        return noSeguridadSocialP;
    }

    public void setNoSeguridadSocialP(String noSeguridadSocialP) {
        this.noSeguridadSocialP = noSeguridadSocialP;
    }

    public String getEmailPf() {
        return emailPf;
    }

    public void setEmailPf(String emailPf) {
        this.emailPf = emailPf;
    }

    public Short getApgarP() {
        return apgarP;
    }

    public void setApgarP(Short apgarP) {
        this.apgarP = apgarP;
    }

    public Short getTamizP() {
        return tamizP;
    }

    public void setTamizP(Short tamizP) {
        this.tamizP = tamizP;
    }

    public String getAlergiasP() {
        return alergiasP;
    }

    public void setAlergiasP(String alergiasP) {
        this.alergiasP = alergiasP;
    }

    @XmlTransient
    public List<VentaConceptos> getVentaConceptosList() {
        return ventaConceptosList;
    }

    public void setVentaConceptosList(List<VentaConceptos> ventaConceptosList) {
        this.ventaConceptosList = ventaConceptosList;
    }

    @XmlTransient
    public List<PacienteConsentimientoConcepto> getPacienteConsentimientoConceptoList() {
        return pacienteConsentimientoConceptoList;
    }

    public void setPacienteConsentimientoConceptoList(List<PacienteConsentimientoConcepto> pacienteConsentimientoConceptoList) {
        this.pacienteConsentimientoConceptoList = pacienteConsentimientoConceptoList;
    }

    public Firma getIdFirma() {
        return idFirma;
    }

    public void setIdFirma(Firma idFirma) {
        this.idFirma = idFirma;
    }

    @XmlTransient
    public List<OrdenVenta> getOrdenVentaList() {
        return ordenVentaList;
    }

    public void setOrdenVentaList(List<OrdenVenta> ordenVentaList) {
        this.ordenVentaList = ordenVentaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idP != null ? idP.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pacientes)) {
            return false;
        }
        Pacientes other = (Pacientes) object;
        if ((this.idP == null && other.idP != null) || (this.idP != null && !this.idP.equals(other.idP))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.gm.sga.domain.Pacientes[ idP=" + idP + " ]";
    }
    
}
