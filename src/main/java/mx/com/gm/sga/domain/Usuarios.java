/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alanm
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findByIdU", query = "SELECT u FROM Usuarios u WHERE u.idU = :idU"),
    @NamedQuery(name = "Usuarios.findByNombreU", query = "SELECT u FROM Usuarios u WHERE u.nombreU = :nombreU"),
    @NamedQuery(name = "Usuarios.findByApaternoU", query = "SELECT u FROM Usuarios u WHERE u.apaternoU = :apaternoU"),
    @NamedQuery(name = "Usuarios.findByAmaternoU", query = "SELECT u FROM Usuarios u WHERE u.amaternoU = :amaternoU"),
    @NamedQuery(name = "Usuarios.findByCedulaProfesionalEu", query = "SELECT u FROM Usuarios u WHERE u.cedulaProfesionalEu = :cedulaProfesionalEu"),
    @NamedQuery(name = "Usuarios.findByEspecialidadU", query = "SELECT u FROM Usuarios u WHERE u.especialidadU = :especialidadU"),
    @NamedQuery(name = "Usuarios.findByCedulaProfesionalu", query = "SELECT u FROM Usuarios u WHERE u.cedulaProfesionalu = :cedulaProfesionalu"),
    @NamedQuery(name = "Usuarios.findByCurpU", query = "SELECT u FROM Usuarios u WHERE u.curpU = :curpU"),
    @NamedQuery(name = "Usuarios.findByTCelularu", query = "SELECT u FROM Usuarios u WHERE u.tCelularu = :tCelularu"),
    @NamedQuery(name = "Usuarios.findByTParticularu", query = "SELECT u FROM Usuarios u WHERE u.tParticularu = :tParticularu"),
    @NamedQuery(name = "Usuarios.findByTTrabajou", query = "SELECT u FROM Usuarios u WHERE u.tTrabajou = :tTrabajou"),
    @NamedQuery(name = "Usuarios.findByExtensionTtu", query = "SELECT u FROM Usuarios u WHERE u.extensionTtu = :extensionTtu"),
    @NamedQuery(name = "Usuarios.findByTEmergenciau", query = "SELECT u FROM Usuarios u WHERE u.tEmergenciau = :tEmergenciau"),
    @NamedQuery(name = "Usuarios.findByContactoEmergenciau", query = "SELECT u FROM Usuarios u WHERE u.contactoEmergenciau = :contactoEmergenciau"),
    @NamedQuery(name = "Usuarios.findByRfcU", query = "SELECT u FROM Usuarios u WHERE u.rfcU = :rfcU"),
    @NamedQuery(name = "Usuarios.findByIdSucursalu", query = "SELECT u FROM Usuarios u WHERE u.idSucursalu = :idSucursalu"),
    @NamedQuery(name = "Usuarios.findByNoIDu", query = "SELECT u FROM Usuarios u WHERE u.noIDu = :noIDu"),
    @NamedQuery(name = "Usuarios.findByEmailU", query = "SELECT u FROM Usuarios u WHERE u.emailU = :emailU"),
    @NamedQuery(name = "Usuarios.findBySexoU", query = "SELECT u FROM Usuarios u WHERE u.sexoU = :sexoU"),
    @NamedQuery(name = "Usuarios.findByFNacu", query = "SELECT u FROM Usuarios u WHERE u.fNacu = :fNacu"),
    @NamedQuery(name = "Usuarios.findByActivoU", query = "SELECT u FROM Usuarios u WHERE u.activoU = :activoU"),
    @NamedQuery(name = "Usuarios.findByValidadoU", query = "SELECT u FROM Usuarios u WHERE u.validadoU = :validadoU"),
    @NamedQuery(name = "Usuarios.findByNotasU", query = "SELECT u FROM Usuarios u WHERE u.notasU = :notasU"),
    @NamedQuery(name = "Usuarios.findByIdEscolaridadu", query = "SELECT u FROM Usuarios u WHERE u.idEscolaridadu = :idEscolaridadu"),
    @NamedQuery(name = "Usuarios.findByUsuarioU", query = "SELECT u FROM Usuarios u WHERE u.usuarioU = :usuarioU"),
    @NamedQuery(name = "Usuarios.findByContrasenaU", query = "SELECT u FROM Usuarios u WHERE u.contrasenaU = :contrasenaU"),
    @NamedQuery(name = "Usuarios.findByContrasena1U", query = "SELECT u FROM Usuarios u WHERE u.contrasena1U = :contrasena1U"),
    @NamedQuery(name = "Usuarios.findByAccesoU", query = "SELECT u FROM Usuarios u WHERE u.accesoU = :accesoU"),
    @NamedQuery(name = "Usuarios.findByIdDepartamentou", query = "SELECT u FROM Usuarios u WHERE u.idDepartamentou = :idDepartamentou"),
    @NamedQuery(name = "Usuarios.findByIdAreau", query = "SELECT u FROM Usuarios u WHERE u.idAreau = :idAreau"),
    @NamedQuery(name = "Usuarios.findByIdProfesionu", query = "SELECT u FROM Usuarios u WHERE u.idProfesionu = :idProfesionu"),
    @NamedQuery(name = "Usuarios.findByFechaIngresoU", query = "SELECT u FROM Usuarios u WHERE u.fechaIngresoU = :fechaIngresoU"),
    @NamedQuery(name = "Usuarios.findByIdUsuarioRu", query = "SELECT u FROM Usuarios u WHERE u.idUsuarioRu = :idUsuarioRu"),
    @NamedQuery(name = "Usuarios.findByNacionalidadU", query = "SELECT u FROM Usuarios u WHERE u.nacionalidadU = :nacionalidadU"),
    @NamedQuery(name = "Usuarios.findByIdPuestou", query = "SELECT u FROM Usuarios u WHERE u.idPuestou = :idPuestou"),
    @NamedQuery(name = "Usuarios.findByCalleU", query = "SELECT u FROM Usuarios u WHERE u.calleU = :calleU"),
    @NamedQuery(name = "Usuarios.findByEntidadFederativau", query = "SELECT u FROM Usuarios u WHERE u.entidadFederativau = :entidadFederativau"),
    @NamedQuery(name = "Usuarios.findByMunicipioU", query = "SELECT u FROM Usuarios u WHERE u.municipioU = :municipioU"),
    @NamedQuery(name = "Usuarios.findByColoniaU", query = "SELECT u FROM Usuarios u WHERE u.coloniaU = :coloniaU"),
    @NamedQuery(name = "Usuarios.findByCpU", query = "SELECT u FROM Usuarios u WHERE u.cpU = :cpU"),
    @NamedQuery(name = "Usuarios.findByTSanguineou", query = "SELECT u FROM Usuarios u WHERE u.tSanguineou = :tSanguineou"),
    @NamedQuery(name = "Usuarios.findByIdOcupacionu", query = "SELECT u FROM Usuarios u WHERE u.idOcupacionu = :idOcupacionu"),
    @NamedQuery(name = "Usuarios.findByFotoU", query = "SELECT u FROM Usuarios u WHERE u.fotoU = :fotoU"),
    @NamedQuery(name = "Usuarios.findByNombreFotou", query = "SELECT u FROM Usuarios u WHERE u.nombreFotou = :nombreFotou"),
    @NamedQuery(name = "Usuarios.findByUsuarioNuevou", query = "SELECT u FROM Usuarios u WHERE u.usuarioNuevou = :usuarioNuevou"),
    @NamedQuery(name = "Usuarios.findByPromotorU", query = "SELECT u FROM Usuarios u WHERE u.promotorU = :promotorU"),
    @NamedQuery(name = "Usuarios.findByTituloU", query = "SELECT u FROM Usuarios u WHERE u.tituloU = :tituloU"),
    @NamedQuery(name = "Usuarios.findByIdTituloU", query = "SELECT u FROM Usuarios u WHERE u.idTituloU = :idTituloU"),
    @NamedQuery(name = "Usuarios.findByMultisucursalU", query = "SELECT u FROM Usuarios u WHERE u.multisucursalU = :multisucursalU"),
    @NamedQuery(name = "Usuarios.findByTemporalU", query = "SELECT u FROM Usuarios u WHERE u.temporalU = :temporalU"),
    @NamedQuery(name = "Usuarios.findByFirmaU", query = "SELECT u FROM Usuarios u WHERE u.firmaU = :firmaU"),
    @NamedQuery(name = "Usuarios.findByHorarioELu", query = "SELECT u FROM Usuarios u WHERE u.horarioELu = :horarioELu"),
    @NamedQuery(name = "Usuarios.findByHorarioSLu", query = "SELECT u FROM Usuarios u WHERE u.horarioSLu = :horarioSLu"),
    @NamedQuery(name = "Usuarios.findByHorarioEMa", query = "SELECT u FROM Usuarios u WHERE u.horarioEMa = :horarioEMa"),
    @NamedQuery(name = "Usuarios.findByHorarioSMa", query = "SELECT u FROM Usuarios u WHERE u.horarioSMa = :horarioSMa"),
    @NamedQuery(name = "Usuarios.findByHorarioEMi", query = "SELECT u FROM Usuarios u WHERE u.horarioEMi = :horarioEMi"),
    @NamedQuery(name = "Usuarios.findByHorarioSMi", query = "SELECT u FROM Usuarios u WHERE u.horarioSMi = :horarioSMi"),
    @NamedQuery(name = "Usuarios.findByHorarioEJu", query = "SELECT u FROM Usuarios u WHERE u.horarioEJu = :horarioEJu"),
    @NamedQuery(name = "Usuarios.findByHorarioSJu", query = "SELECT u FROM Usuarios u WHERE u.horarioSJu = :horarioSJu"),
    @NamedQuery(name = "Usuarios.findByHorarioEVi", query = "SELECT u FROM Usuarios u WHERE u.horarioEVi = :horarioEVi"),
    @NamedQuery(name = "Usuarios.findByHorarioSVi", query = "SELECT u FROM Usuarios u WHERE u.horarioSVi = :horarioSVi"),
    @NamedQuery(name = "Usuarios.findByHorarioESa", query = "SELECT u FROM Usuarios u WHERE u.horarioESa = :horarioESa"),
    @NamedQuery(name = "Usuarios.findByHorarioSSa", query = "SELECT u FROM Usuarios u WHERE u.horarioSSa = :horarioSSa"),
    @NamedQuery(name = "Usuarios.findByHorarioEDo", query = "SELECT u FROM Usuarios u WHERE u.horarioEDo = :horarioEDo"),
    @NamedQuery(name = "Usuarios.findByHorarioSDo", query = "SELECT u FROM Usuarios u WHERE u.horarioSDo = :horarioSDo"),
    @NamedQuery(name = "Usuarios.findByUniversidadU", query = "SELECT u FROM Usuarios u WHERE u.universidadU = :universidadU"),
    @NamedQuery(name = "Usuarios.findByEstatusLaboralU", query = "SELECT u FROM Usuarios u WHERE u.estatusLaboralU = :estatusLaboralU"),
    @NamedQuery(name = "Usuarios.findByEstatusEscolarU", query = "SELECT u FROM Usuarios u WHERE u.estatusEscolarU = :estatusEscolarU"),
    @NamedQuery(name = "Usuarios.findByPermisosU", query = "SELECT u FROM Usuarios u WHERE u.permisosU = :permisosU"),
    @NamedQuery(name = "Usuarios.findByUniversidadEU", query = "SELECT u FROM Usuarios u WHERE u.universidadEU = :universidadEU")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_u")
    private Integer idU;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_u")
    private String nombreU;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "apaterno_u")
    private String apaternoU;
    @Size(max = 100)
    @Column(name = "amaterno_u")
    private String amaternoU;
    @Size(max = 50)
    @Column(name = "cedulaProfesionalE_u")
    private String cedulaProfesionalEu;
    @Column(name = "especialidad_u")
    private Short especialidadU;
    @Size(max = 50)
    @Column(name = "cedulaProfesional_u")
    private String cedulaProfesionalu;
    @Size(max = 18)
    @Column(name = "curp_u")
    private String curpU;
    @Size(max = 17)
    @Column(name = "tCelular_u")
    private String tCelularu;
    @Size(max = 17)
    @Column(name = "tParticular_u")
    private String tParticularu;
    @Size(max = 17)
    @Column(name = "tTrabajo_u")
    private String tTrabajou;
    @Size(max = 20)
    @Column(name = "extensionTt_u")
    private String extensionTtu;
    @Size(max = 17)
    @Column(name = "tEmergencia_u")
    private String tEmergenciau;
    @Size(max = 150)
    @Column(name = "contactoEmergencia_u")
    private String contactoEmergenciau;
    @Size(max = 15)
    @Column(name = "rfc_u")
    private String rfcU;
    @Column(name = "idSucursal_u")
    private Integer idSucursalu;
    @Size(max = 100)
    @Column(name = "noID_u")
    private String noIDu;
    @Size(max = 100)
    @Column(name = "email_u")
    private String emailU;
    @Column(name = "sexo_u")
    private Short sexoU;
    @Column(name = "fNac_u")
    @Temporal(TemporalType.DATE)
    private Date fNacu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo_u")
    private short activoU;
    @Basic(optional = false)
    @NotNull
    @Column(name = "validado_u")
    private short validadoU;
    @Size(max = 200)
    @Column(name = "notas_u")
    private String notasU;
    @Column(name = "idEscolaridad_u")
    private Short idEscolaridadu;
    @Size(max = 30)
    @Column(name = "usuario_u")
    private String usuarioU;
    @Size(max = 255)
    @Column(name = "contrasena_u")
    private String contrasenaU;
    @Size(max = 30)
    @Column(name = "contrasena1_u")
    private String contrasena1U;
    @Basic(optional = false)
    @NotNull
    @Column(name = "acceso_u")
    private short accesoU;
    @Column(name = "idDepartamento_u")
    private Short idDepartamentou;
    @Column(name = "idArea_u")
    private Short idAreau;
    @Column(name = "idProfesion_u")
    private Integer idProfesionu;
    @Column(name = "fecha_ingreso_u")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngresoU;
    @Column(name = "idUsuarioR_u")
    private Integer idUsuarioRu;
    @Size(max = 100)
    @Column(name = "nacionalidad_u")
    private String nacionalidadU;
    @Column(name = "idPuesto_u")
    private Integer idPuestou;
    @Size(max = 200)
    @Column(name = "calle_u")
    private String calleU;
    @Column(name = "entidadFederativa_u")
    private Integer entidadFederativau;
    @Column(name = "municipio_u")
    private Integer municipioU;
    @Column(name = "colonia_u")
    private Integer coloniaU;
    @Size(max = 10)
    @Column(name = "cp_u")
    private String cpU;
    @Column(name = "tSanguineo_u")
    private Short tSanguineou;
    @Column(name = "idOcupacion_u")
    private Integer idOcupacionu;
    @Column(name = "foto_u")
    private Short fotoU;
    @Size(max = 30)
    @Column(name = "nombreFoto_u")
    private String nombreFotou;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuarioNuevo_u")
    private short usuarioNuevou;
    @Column(name = "promotor_u")
    private Integer promotorU;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "titulo_u")
    private String tituloU;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_titulo_u")
    private short idTituloU;
    @Basic(optional = false)
    @NotNull
    @Column(name = "multisucursal_u")
    private short multisucursalU;
    @Size(max = 100)
    @Column(name = "temporal_u")
    private String temporalU;
    @Basic(optional = false)
    @NotNull
    @Column(name = "firma_u")
    private short firmaU;
    @Lob
    @Column(name = "coordenadas_u")
    private byte[] coordenadasU;
    @Column(name = "horario_e_lu")
    @Temporal(TemporalType.TIME)
    private Date horarioELu;
    @Column(name = "horario_s_lu")
    @Temporal(TemporalType.TIME)
    private Date horarioSLu;
    @Column(name = "horario_e_ma")
    @Temporal(TemporalType.TIME)
    private Date horarioEMa;
    @Column(name = "horario_s_ma")
    @Temporal(TemporalType.TIME)
    private Date horarioSMa;
    @Column(name = "horario_e_mi")
    @Temporal(TemporalType.TIME)
    private Date horarioEMi;
    @Column(name = "horario_s_mi")
    @Temporal(TemporalType.TIME)
    private Date horarioSMi;
    @Column(name = "horario_e_ju")
    @Temporal(TemporalType.TIME)
    private Date horarioEJu;
    @Column(name = "horario_s_ju")
    @Temporal(TemporalType.TIME)
    private Date horarioSJu;
    @Column(name = "horario_e_vi")
    @Temporal(TemporalType.TIME)
    private Date horarioEVi;
    @Column(name = "horario_s_vi")
    @Temporal(TemporalType.TIME)
    private Date horarioSVi;
    @Column(name = "horario_e_sa")
    @Temporal(TemporalType.TIME)
    private Date horarioESa;
    @Column(name = "horario_s_sa")
    @Temporal(TemporalType.TIME)
    private Date horarioSSa;
    @Column(name = "horario_e_do")
    @Temporal(TemporalType.TIME)
    private Date horarioEDo;
    @Column(name = "horario_s_do")
    @Temporal(TemporalType.TIME)
    private Date horarioSDo;
    @Lob
    @Size(max = 65535)
    @Column(name = "variable_temporal_u")
    private String variableTemporalU;
    @Lob
    @Size(max = 65535)
    @Column(name = "variable_temporal1_u")
    private String variableTemporal1U;
    @Lob
    @Size(max = 65535)
    @Column(name = "variable_temporal2_u")
    private String variableTemporal2U;
    @Lob
    @Size(max = 65535)
    @Column(name = "variable_temporal3_u")
    private String variableTemporal3U;
    @Lob
    @Size(max = 65535)
    @Column(name = "variable_temporal4_u")
    private String variableTemporal4U;
    @Column(name = "universidad_u")
    private Integer universidadU;
    @Column(name = "estatus_laboral_u")
    private Short estatusLaboralU;
    @Column(name = "estatus_escolar_u")
    private Short estatusEscolarU;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "permisos_u")
    private String permisosU;
    @Column(name = "universidad_e_u")
    private Integer universidadEU;

    public Usuarios() {
    }

    public Usuarios(Integer idU) {
        this.idU = idU;
    }

    public Usuarios(Integer idU, String nombreU, String apaternoU, short activoU, short validadoU, short accesoU, short usuarioNuevou, String tituloU, short idTituloU, short multisucursalU, short firmaU, String permisosU) {
        this.idU = idU;
        this.nombreU = nombreU;
        this.apaternoU = apaternoU;
        this.activoU = activoU;
        this.validadoU = validadoU;
        this.accesoU = accesoU;
        this.usuarioNuevou = usuarioNuevou;
        this.tituloU = tituloU;
        this.idTituloU = idTituloU;
        this.multisucursalU = multisucursalU;
        this.firmaU = firmaU;
        this.permisosU = permisosU;
    }

    public Integer getIdU() {
        return idU;
    }

    public void setIdU(Integer idU) {
        this.idU = idU;
    }

    public String getNombreU() {
        return nombreU;
    }

    public void setNombreU(String nombreU) {
        this.nombreU = nombreU;
    }

    public String getApaternoU() {
        return apaternoU;
    }

    public void setApaternoU(String apaternoU) {
        this.apaternoU = apaternoU;
    }

    public String getAmaternoU() {
        return amaternoU;
    }

    public void setAmaternoU(String amaternoU) {
        this.amaternoU = amaternoU;
    }

    public String getCedulaProfesionalEu() {
        return cedulaProfesionalEu;
    }

    public void setCedulaProfesionalEu(String cedulaProfesionalEu) {
        this.cedulaProfesionalEu = cedulaProfesionalEu;
    }

    public Short getEspecialidadU() {
        return especialidadU;
    }

    public void setEspecialidadU(Short especialidadU) {
        this.especialidadU = especialidadU;
    }

    public String getCedulaProfesionalu() {
        return cedulaProfesionalu;
    }

    public void setCedulaProfesionalu(String cedulaProfesionalu) {
        this.cedulaProfesionalu = cedulaProfesionalu;
    }

    public String getCurpU() {
        return curpU;
    }

    public void setCurpU(String curpU) {
        this.curpU = curpU;
    }

    public String getTCelularu() {
        return tCelularu;
    }

    public void setTCelularu(String tCelularu) {
        this.tCelularu = tCelularu;
    }

    public String getTParticularu() {
        return tParticularu;
    }

    public void setTParticularu(String tParticularu) {
        this.tParticularu = tParticularu;
    }

    public String getTTrabajou() {
        return tTrabajou;
    }

    public void setTTrabajou(String tTrabajou) {
        this.tTrabajou = tTrabajou;
    }

    public String getExtensionTtu() {
        return extensionTtu;
    }

    public void setExtensionTtu(String extensionTtu) {
        this.extensionTtu = extensionTtu;
    }

    public String getTEmergenciau() {
        return tEmergenciau;
    }

    public void setTEmergenciau(String tEmergenciau) {
        this.tEmergenciau = tEmergenciau;
    }

    public String getContactoEmergenciau() {
        return contactoEmergenciau;
    }

    public void setContactoEmergenciau(String contactoEmergenciau) {
        this.contactoEmergenciau = contactoEmergenciau;
    }

    public String getRfcU() {
        return rfcU;
    }

    public void setRfcU(String rfcU) {
        this.rfcU = rfcU;
    }

    public Integer getIdSucursalu() {
        return idSucursalu;
    }

    public void setIdSucursalu(Integer idSucursalu) {
        this.idSucursalu = idSucursalu;
    }

    public String getNoIDu() {
        return noIDu;
    }

    public void setNoIDu(String noIDu) {
        this.noIDu = noIDu;
    }

    public String getEmailU() {
        return emailU;
    }

    public void setEmailU(String emailU) {
        this.emailU = emailU;
    }

    public Short getSexoU() {
        return sexoU;
    }

    public void setSexoU(Short sexoU) {
        this.sexoU = sexoU;
    }

    public Date getFNacu() {
        return fNacu;
    }

    public void setFNacu(Date fNacu) {
        this.fNacu = fNacu;
    }

    public short getActivoU() {
        return activoU;
    }

    public void setActivoU(short activoU) {
        this.activoU = activoU;
    }

    public short getValidadoU() {
        return validadoU;
    }

    public void setValidadoU(short validadoU) {
        this.validadoU = validadoU;
    }

    public String getNotasU() {
        return notasU;
    }

    public void setNotasU(String notasU) {
        this.notasU = notasU;
    }

    public Short getIdEscolaridadu() {
        return idEscolaridadu;
    }

    public void setIdEscolaridadu(Short idEscolaridadu) {
        this.idEscolaridadu = idEscolaridadu;
    }

    public String getUsuarioU() {
        return usuarioU;
    }

    public void setUsuarioU(String usuarioU) {
        this.usuarioU = usuarioU;
    }

    public String getContrasenaU() {
        return contrasenaU;
    }

    public void setContrasenaU(String contrasenaU) {
        this.contrasenaU = contrasenaU;
    }

    public String getContrasena1U() {
        return contrasena1U;
    }

    public void setContrasena1U(String contrasena1U) {
        this.contrasena1U = contrasena1U;
    }

    public short getAccesoU() {
        return accesoU;
    }

    public void setAccesoU(short accesoU) {
        this.accesoU = accesoU;
    }

    public Short getIdDepartamentou() {
        return idDepartamentou;
    }

    public void setIdDepartamentou(Short idDepartamentou) {
        this.idDepartamentou = idDepartamentou;
    }

    public Short getIdAreau() {
        return idAreau;
    }

    public void setIdAreau(Short idAreau) {
        this.idAreau = idAreau;
    }

    public Integer getIdProfesionu() {
        return idProfesionu;
    }

    public void setIdProfesionu(Integer idProfesionu) {
        this.idProfesionu = idProfesionu;
    }

    public Date getFechaIngresoU() {
        return fechaIngresoU;
    }

    public void setFechaIngresoU(Date fechaIngresoU) {
        this.fechaIngresoU = fechaIngresoU;
    }

    public Integer getIdUsuarioRu() {
        return idUsuarioRu;
    }

    public void setIdUsuarioRu(Integer idUsuarioRu) {
        this.idUsuarioRu = idUsuarioRu;
    }

    public String getNacionalidadU() {
        return nacionalidadU;
    }

    public void setNacionalidadU(String nacionalidadU) {
        this.nacionalidadU = nacionalidadU;
    }

    public Integer getIdPuestou() {
        return idPuestou;
    }

    public void setIdPuestou(Integer idPuestou) {
        this.idPuestou = idPuestou;
    }

    public String getCalleU() {
        return calleU;
    }

    public void setCalleU(String calleU) {
        this.calleU = calleU;
    }

    public Integer getEntidadFederativau() {
        return entidadFederativau;
    }

    public void setEntidadFederativau(Integer entidadFederativau) {
        this.entidadFederativau = entidadFederativau;
    }

    public Integer getMunicipioU() {
        return municipioU;
    }

    public void setMunicipioU(Integer municipioU) {
        this.municipioU = municipioU;
    }

    public Integer getColoniaU() {
        return coloniaU;
    }

    public void setColoniaU(Integer coloniaU) {
        this.coloniaU = coloniaU;
    }

    public String getCpU() {
        return cpU;
    }

    public void setCpU(String cpU) {
        this.cpU = cpU;
    }

    public Short getTSanguineou() {
        return tSanguineou;
    }

    public void setTSanguineou(Short tSanguineou) {
        this.tSanguineou = tSanguineou;
    }

    public Integer getIdOcupacionu() {
        return idOcupacionu;
    }

    public void setIdOcupacionu(Integer idOcupacionu) {
        this.idOcupacionu = idOcupacionu;
    }

    public Short getFotoU() {
        return fotoU;
    }

    public void setFotoU(Short fotoU) {
        this.fotoU = fotoU;
    }

    public String getNombreFotou() {
        return nombreFotou;
    }

    public void setNombreFotou(String nombreFotou) {
        this.nombreFotou = nombreFotou;
    }

    public short getUsuarioNuevou() {
        return usuarioNuevou;
    }

    public void setUsuarioNuevou(short usuarioNuevou) {
        this.usuarioNuevou = usuarioNuevou;
    }

    public Integer getPromotorU() {
        return promotorU;
    }

    public void setPromotorU(Integer promotorU) {
        this.promotorU = promotorU;
    }

    public String getTituloU() {
        return tituloU;
    }

    public void setTituloU(String tituloU) {
        this.tituloU = tituloU;
    }

    public short getIdTituloU() {
        return idTituloU;
    }

    public void setIdTituloU(short idTituloU) {
        this.idTituloU = idTituloU;
    }

    public short getMultisucursalU() {
        return multisucursalU;
    }

    public void setMultisucursalU(short multisucursalU) {
        this.multisucursalU = multisucursalU;
    }

    public String getTemporalU() {
        return temporalU;
    }

    public void setTemporalU(String temporalU) {
        this.temporalU = temporalU;
    }

    public short getFirmaU() {
        return firmaU;
    }

    public void setFirmaU(short firmaU) {
        this.firmaU = firmaU;
    }

    public byte[] getCoordenadasU() {
        return coordenadasU;
    }

    public void setCoordenadasU(byte[] coordenadasU) {
        this.coordenadasU = coordenadasU;
    }

    public Date getHorarioELu() {
        return horarioELu;
    }

    public void setHorarioELu(Date horarioELu) {
        this.horarioELu = horarioELu;
    }

    public Date getHorarioSLu() {
        return horarioSLu;
    }

    public void setHorarioSLu(Date horarioSLu) {
        this.horarioSLu = horarioSLu;
    }

    public Date getHorarioEMa() {
        return horarioEMa;
    }

    public void setHorarioEMa(Date horarioEMa) {
        this.horarioEMa = horarioEMa;
    }

    public Date getHorarioSMa() {
        return horarioSMa;
    }

    public void setHorarioSMa(Date horarioSMa) {
        this.horarioSMa = horarioSMa;
    }

    public Date getHorarioEMi() {
        return horarioEMi;
    }

    public void setHorarioEMi(Date horarioEMi) {
        this.horarioEMi = horarioEMi;
    }

    public Date getHorarioSMi() {
        return horarioSMi;
    }

    public void setHorarioSMi(Date horarioSMi) {
        this.horarioSMi = horarioSMi;
    }

    public Date getHorarioEJu() {
        return horarioEJu;
    }

    public void setHorarioEJu(Date horarioEJu) {
        this.horarioEJu = horarioEJu;
    }

    public Date getHorarioSJu() {
        return horarioSJu;
    }

    public void setHorarioSJu(Date horarioSJu) {
        this.horarioSJu = horarioSJu;
    }

    public Date getHorarioEVi() {
        return horarioEVi;
    }

    public void setHorarioEVi(Date horarioEVi) {
        this.horarioEVi = horarioEVi;
    }

    public Date getHorarioSVi() {
        return horarioSVi;
    }

    public void setHorarioSVi(Date horarioSVi) {
        this.horarioSVi = horarioSVi;
    }

    public Date getHorarioESa() {
        return horarioESa;
    }

    public void setHorarioESa(Date horarioESa) {
        this.horarioESa = horarioESa;
    }

    public Date getHorarioSSa() {
        return horarioSSa;
    }

    public void setHorarioSSa(Date horarioSSa) {
        this.horarioSSa = horarioSSa;
    }

    public Date getHorarioEDo() {
        return horarioEDo;
    }

    public void setHorarioEDo(Date horarioEDo) {
        this.horarioEDo = horarioEDo;
    }

    public Date getHorarioSDo() {
        return horarioSDo;
    }

    public void setHorarioSDo(Date horarioSDo) {
        this.horarioSDo = horarioSDo;
    }

    public String getVariableTemporalU() {
        return variableTemporalU;
    }

    public void setVariableTemporalU(String variableTemporalU) {
        this.variableTemporalU = variableTemporalU;
    }

    public String getVariableTemporal1U() {
        return variableTemporal1U;
    }

    public void setVariableTemporal1U(String variableTemporal1U) {
        this.variableTemporal1U = variableTemporal1U;
    }

    public String getVariableTemporal2U() {
        return variableTemporal2U;
    }

    public void setVariableTemporal2U(String variableTemporal2U) {
        this.variableTemporal2U = variableTemporal2U;
    }

    public String getVariableTemporal3U() {
        return variableTemporal3U;
    }

    public void setVariableTemporal3U(String variableTemporal3U) {
        this.variableTemporal3U = variableTemporal3U;
    }

    public String getVariableTemporal4U() {
        return variableTemporal4U;
    }

    public void setVariableTemporal4U(String variableTemporal4U) {
        this.variableTemporal4U = variableTemporal4U;
    }

    public Integer getUniversidadU() {
        return universidadU;
    }

    public void setUniversidadU(Integer universidadU) {
        this.universidadU = universidadU;
    }

    public Short getEstatusLaboralU() {
        return estatusLaboralU;
    }

    public void setEstatusLaboralU(Short estatusLaboralU) {
        this.estatusLaboralU = estatusLaboralU;
    }

    public Short getEstatusEscolarU() {
        return estatusEscolarU;
    }

    public void setEstatusEscolarU(Short estatusEscolarU) {
        this.estatusEscolarU = estatusEscolarU;
    }

    public String getPermisosU() {
        return permisosU;
    }

    public void setPermisosU(String permisosU) {
        this.permisosU = permisosU;
    }

    public Integer getUniversidadEU() {
        return universidadEU;
    }

    public void setUniversidadEU(Integer universidadEU) {
        this.universidadEU = universidadEU;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idU != null ? idU.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.idU == null && other.idU != null) || (this.idU != null && !this.idU.equals(other.idU))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.gm.sga.domain.Usuarios[ idU=" + idU + " ]";
    }
    
}
