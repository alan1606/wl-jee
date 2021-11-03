/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.persistence.Table;
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
@Table(name = "venta_conceptos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VentaConceptos.findAll", query = "SELECT v FROM VentaConceptos v"),
    @NamedQuery(name = "VentaConceptos.findByIdVc", query = "SELECT v FROM VentaConceptos v WHERE v.idVc = :idVc"),
    @NamedQuery(name = "VentaConceptos.findByIdPersonalMedicoVc", query = "SELECT v FROM VentaConceptos v WHERE v.idPersonalMedicoVc = :idPersonalMedicoVc"),
    @NamedQuery(name = "VentaConceptos.findByPrecioVc", query = "SELECT v FROM VentaConceptos v WHERE v.precioVc = :precioVc"),
    @NamedQuery(name = "VentaConceptos.findByIdConvenioVc", query = "SELECT v FROM VentaConceptos v WHERE v.idConvenioVc = :idConvenioVc"),
    @NamedQuery(name = "VentaConceptos.findByIdUsuarioVc", query = "SELECT v FROM VentaConceptos v WHERE v.idUsuarioVc = :idUsuarioVc"),
    @NamedQuery(name = "VentaConceptos.findByFechaVentaVc", query = "SELECT v FROM VentaConceptos v WHERE v.fechaVentaVc = :fechaVentaVc"),
    @NamedQuery(name = "VentaConceptos.findByEstatusVc", query = "SELECT v FROM VentaConceptos v WHERE v.estatusVc = :estatusVc"),
    @NamedQuery(name = "VentaConceptos.findByUrgenteVc", query = "SELECT v FROM VentaConceptos v WHERE v.urgenteVc = :urgenteVc"),
    @NamedQuery(name = "VentaConceptos.findByUsuarioEdo1e", query = "SELECT v FROM VentaConceptos v WHERE v.usuarioEdo1e = :usuarioEdo1e"),
    @NamedQuery(name = "VentaConceptos.findByFechaEdo1e", query = "SELECT v FROM VentaConceptos v WHERE v.fechaEdo1e = :fechaEdo1e"),
    @NamedQuery(name = "VentaConceptos.findByUsuarioEdo2e", query = "SELECT v FROM VentaConceptos v WHERE v.usuarioEdo2e = :usuarioEdo2e"),
    @NamedQuery(name = "VentaConceptos.findByFechaEdo2e", query = "SELECT v FROM VentaConceptos v WHERE v.fechaEdo2e = :fechaEdo2e"),
    @NamedQuery(name = "VentaConceptos.findByUsuarioEdo3e", query = "SELECT v FROM VentaConceptos v WHERE v.usuarioEdo3e = :usuarioEdo3e"),
    @NamedQuery(name = "VentaConceptos.findByFechaEdo3e", query = "SELECT v FROM VentaConceptos v WHERE v.fechaEdo3e = :fechaEdo3e"),
    @NamedQuery(name = "VentaConceptos.findByUsuarioEdo4e", query = "SELECT v FROM VentaConceptos v WHERE v.usuarioEdo4e = :usuarioEdo4e"),
    @NamedQuery(name = "VentaConceptos.findByFechaEdo4e", query = "SELECT v FROM VentaConceptos v WHERE v.fechaEdo4e = :fechaEdo4e"),
    @NamedQuery(name = "VentaConceptos.findByUsuarioEdo5e", query = "SELECT v FROM VentaConceptos v WHERE v.usuarioEdo5e = :usuarioEdo5e"),
    @NamedQuery(name = "VentaConceptos.findByFechaEdo5e", query = "SELECT v FROM VentaConceptos v WHERE v.fechaEdo5e = :fechaEdo5e"),
    @NamedQuery(name = "VentaConceptos.findByUsuarioEdo6e", query = "SELECT v FROM VentaConceptos v WHERE v.usuarioEdo6e = :usuarioEdo6e"),
    @NamedQuery(name = "VentaConceptos.findByFechaEdo6e", query = "SELECT v FROM VentaConceptos v WHERE v.fechaEdo6e = :fechaEdo6e"),
    @NamedQuery(name = "VentaConceptos.findByReferenciaVc", query = "SELECT v FROM VentaConceptos v WHERE v.referenciaVc = :referenciaVc"),
    @NamedQuery(name = "VentaConceptos.findByContadorVc", query = "SELECT v FROM VentaConceptos v WHERE v.contadorVc = :contadorVc"),
    @NamedQuery(name = "VentaConceptos.findByBiradVc", query = "SELECT v FROM VentaConceptos v WHERE v.biradVc = :biradVc"),
    @NamedQuery(name = "VentaConceptos.findByNoTempVc", query = "SELECT v FROM VentaConceptos v WHERE v.noTempVc = :noTempVc"),
    @NamedQuery(name = "VentaConceptos.findByTemporalVc", query = "SELECT v FROM VentaConceptos v WHERE v.temporalVc = :temporalVc"),
    @NamedQuery(name = "VentaConceptos.findByIdSignosvVc", query = "SELECT v FROM VentaConceptos v WHERE v.idSignosvVc = :idSignosvVc"),
    @NamedQuery(name = "VentaConceptos.findByIdConceptosBeneficios", query = "SELECT v FROM VentaConceptos v WHERE v.idConceptosBeneficios = :idConceptosBeneficios"),
    @NamedQuery(name = "VentaConceptos.findByEsBeneficioVc", query = "SELECT v FROM VentaConceptos v WHERE v.esBeneficioVc = :esBeneficioVc"),
    @NamedQuery(name = "VentaConceptos.findByIdAnesteciologoVc", query = "SELECT v FROM VentaConceptos v WHERE v.idAnesteciologoVc = :idAnesteciologoVc"),
    @NamedQuery(name = "VentaConceptos.findByIdRadiologoExterno", query = "SELECT v FROM VentaConceptos v WHERE v.idRadiologoExterno = :idRadiologoExterno"),
    @NamedQuery(name = "VentaConceptos.findByIdPacs", query = "SELECT v FROM VentaConceptos v WHERE v.idPacs = :idPacs"),
    @NamedQuery(name = "VentaConceptos.findByUsuarioTransfiereVc", query = "SELECT v FROM VentaConceptos v WHERE v.usuarioTransfiereVc = :usuarioTransfiereVc"),
    @NamedQuery(name = "VentaConceptos.findByFechaTransfiereVc", query = "SELECT v FROM VentaConceptos v WHERE v.fechaTransfiereVc = :fechaTransfiereVc"),
    @NamedQuery(name = "VentaConceptos.findBySalvadoVc", query = "SELECT v FROM VentaConceptos v WHERE v.salvadoVc = :salvadoVc"),
    @NamedQuery(name = "VentaConceptos.findByFechaAsignado", query = "SELECT v FROM VentaConceptos v WHERE v.fechaAsignado = :fechaAsignado"),
    @NamedQuery(name = "VentaConceptos.findByHoraAsignado", query = "SELECT v FROM VentaConceptos v WHERE v.horaAsignado = :horaAsignado"),
    @NamedQuery(name = "VentaConceptos.findByEnWorklist", query = "SELECT v FROM VentaConceptos v WHERE v.enWorklist = :enWorklist"),
    @NamedQuery(name = "VentaConceptos.findByEstado", query = "SELECT v FROM VentaConceptos v WHERE v.estado = :estado")})
public class VentaConceptos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_vc")
    private Long idVc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_personal_medico_vc")
    private int idPersonalMedicoVc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_vc")
    private float precioVc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_convenio_vc")
    private int idConvenioVc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario_vc")
    private int idUsuarioVc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_venta_vc")
    private String fechaVentaVc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estatus_vc")
    private short estatusVc;
    @Column(name = "urgente_vc")
    private Short urgenteVc;
    @Column(name = "usuarioEdo1_e")
    private Integer usuarioEdo1e;
    @Column(name = "fechaEdo1_e")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEdo1e;
    @Column(name = "usuarioEdo2_e")
    private Integer usuarioEdo2e;
    @Column(name = "fechaEdo2_e")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEdo2e;
    @Column(name = "usuarioEdo3_e")
    private Integer usuarioEdo3e;
    @Column(name = "fechaEdo3_e")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEdo3e;
    @Column(name = "usuarioEdo4_e")
    private Integer usuarioEdo4e;
    @Column(name = "fechaEdo4_e")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEdo4e;
    @Size(max = 10)
    @Column(name = "usuarioEdo5_e")
    private String usuarioEdo5e;
    @Column(name = "fechaEdo5_e")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEdo5e;
    @Size(max = 10)
    @Column(name = "usuarioEdo6_e")
    private String usuarioEdo6e;
    @Column(name = "fechaEdo6_e")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEdo6e;
    @Size(max = 20)
    @Column(name = "referencia_vc")
    private String referenciaVc;
    @Lob
    @Size(max = 65535)
    @Column(name = "interpretacion_vc")
    private String interpretacionVc;
    @Lob
    @Size(max = 65535)
    @Column(name = "nota_interpretacion")
    private String notaInterpretacion;
    @Lob
    @Size(max = 65535)
    @Column(name = "otras_indicaciones")
    private String otrasIndicaciones;
    @Lob
    @Size(max = 65535)
    @Column(name = "nota_receta")
    private String notaReceta;
    @Column(name = "contador_vc")
    private Integer contadorVc;
    @Lob
    @Size(max = 65535)
    @Column(name = "nota_radiologo_vc")
    private String notaRadiologoVc;
    @Column(name = "birad_vc")
    private Short biradVc;
    @Size(max = 100)
    @Column(name = "no_temp_vc")
    private String noTempVc;
    @Lob
    @Size(max = 65535)
    @Column(name = "motivo_visita_vc")
    private String motivoVisitaVc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "temporal_vc")
    private short temporalVc;
    @Lob
    @Size(max = 65535)
    @Column(name = "observaciones_vc")
    private String observacionesVc;
    @Column(name = "id_signosv_vc")
    private BigInteger idSignosvVc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_conceptos_beneficios")
    private long idConceptosBeneficios;
    @Basic(optional = false)
    @NotNull
    @Column(name = "es_beneficio_vc")
    private short esBeneficioVc;
    @Column(name = "id_anesteciologo_vc")
    private Integer idAnesteciologoVc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_radiologo_externo")
    private int idRadiologoExterno;
    @Size(max = 15)
    @Column(name = "id_pacs")
    private String idPacs;
    @Column(name = "usuario_transfiere_vc")
    private Integer usuarioTransfiereVc;
    @Column(name = "fecha_transfiere_vc")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaTransfiereVc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "salvado_vc")
    private short salvadoVc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_asignado")
    private String fechaAsignado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora_asignado")
    private String horaAsignado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "en_worklist")
    private boolean enWorklist;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 22)
    private String estado;
    @JoinColumn(name = "id_concepto_es", referencedColumnName = "id_to")
    @ManyToOne(optional = false)
    private Conceptos idConceptoEs;
    @JoinColumn(name = "id_equipo_dicom", referencedColumnName = "id_equipo")
    @ManyToOne(optional = false)
    private EquipoDicom idEquipoDicom;
    @JoinColumn(name = "id_institucion", referencedColumnName = "id_institucion")
    @ManyToOne(optional = false)
    private Institucion idInstitucion;
    @JoinColumn(name = "id_orden_venta", referencedColumnName = "id_ov")
    @ManyToOne(optional = false)
    private OrdenVenta idOrdenVenta;
    @JoinColumn(name = "id_paciente_vc", referencedColumnName = "id_p")
    @ManyToOne(optional = false)
    private Pacientes idPacienteVc;

    public VentaConceptos() {
    }

    public VentaConceptos(Long idVc) {
        this.idVc = idVc;
    }

    public VentaConceptos(Long idVc, int idPersonalMedicoVc, float precioVc, int idConvenioVc, int idUsuarioVc, String fechaVentaVc, short estatusVc, short temporalVc, long idConceptosBeneficios, short esBeneficioVc, int idRadiologoExterno, short salvadoVc, String fechaAsignado, String horaAsignado, boolean enWorklist, String estado) {
        this.idVc = idVc;
        this.idPersonalMedicoVc = idPersonalMedicoVc;
        this.precioVc = precioVc;
        this.idConvenioVc = idConvenioVc;
        this.idUsuarioVc = idUsuarioVc;
        this.fechaVentaVc = fechaVentaVc;
        this.estatusVc = estatusVc;
        this.temporalVc = temporalVc;
        this.idConceptosBeneficios = idConceptosBeneficios;
        this.esBeneficioVc = esBeneficioVc;
        this.idRadiologoExterno = idRadiologoExterno;
        this.salvadoVc = salvadoVc;
        this.fechaAsignado = fechaAsignado;
        this.horaAsignado = horaAsignado;
        this.enWorklist = enWorklist;
        this.estado = estado;
    }

    public Long getIdVc() {
        return idVc;
    }

    public void setIdVc(Long idVc) {
        this.idVc = idVc;
    }

    public int getIdPersonalMedicoVc() {
        return idPersonalMedicoVc;
    }

    public void setIdPersonalMedicoVc(int idPersonalMedicoVc) {
        this.idPersonalMedicoVc = idPersonalMedicoVc;
    }

    public float getPrecioVc() {
        return precioVc;
    }

    public void setPrecioVc(float precioVc) {
        this.precioVc = precioVc;
    }

    public int getIdConvenioVc() {
        return idConvenioVc;
    }

    public void setIdConvenioVc(int idConvenioVc) {
        this.idConvenioVc = idConvenioVc;
    }

    public int getIdUsuarioVc() {
        return idUsuarioVc;
    }

    public void setIdUsuarioVc(int idUsuarioVc) {
        this.idUsuarioVc = idUsuarioVc;
    }

    public String getFechaVentaVc() {
        return fechaVentaVc;
    }

    public void setFechaVentaVc(String fechaVentaVc) {
        this.fechaVentaVc = fechaVentaVc;
    }

    public short getEstatusVc() {
        return estatusVc;
    }

    public void setEstatusVc(short estatusVc) {
        this.estatusVc = estatusVc;
    }

    public Short getUrgenteVc() {
        return urgenteVc;
    }

    public void setUrgenteVc(Short urgenteVc) {
        this.urgenteVc = urgenteVc;
    }

    public Integer getUsuarioEdo1e() {
        return usuarioEdo1e;
    }

    public void setUsuarioEdo1e(Integer usuarioEdo1e) {
        this.usuarioEdo1e = usuarioEdo1e;
    }

    public Date getFechaEdo1e() {
        return fechaEdo1e;
    }

    public void setFechaEdo1e(Date fechaEdo1e) {
        this.fechaEdo1e = fechaEdo1e;
    }

    public Integer getUsuarioEdo2e() {
        return usuarioEdo2e;
    }

    public void setUsuarioEdo2e(Integer usuarioEdo2e) {
        this.usuarioEdo2e = usuarioEdo2e;
    }

    public Date getFechaEdo2e() {
        return fechaEdo2e;
    }

    public void setFechaEdo2e(Date fechaEdo2e) {
        this.fechaEdo2e = fechaEdo2e;
    }

    public Integer getUsuarioEdo3e() {
        return usuarioEdo3e;
    }

    public void setUsuarioEdo3e(Integer usuarioEdo3e) {
        this.usuarioEdo3e = usuarioEdo3e;
    }

    public Date getFechaEdo3e() {
        return fechaEdo3e;
    }

    public void setFechaEdo3e(Date fechaEdo3e) {
        this.fechaEdo3e = fechaEdo3e;
    }

    public Integer getUsuarioEdo4e() {
        return usuarioEdo4e;
    }

    public void setUsuarioEdo4e(Integer usuarioEdo4e) {
        this.usuarioEdo4e = usuarioEdo4e;
    }

    public Date getFechaEdo4e() {
        return fechaEdo4e;
    }

    public void setFechaEdo4e(Date fechaEdo4e) {
        this.fechaEdo4e = fechaEdo4e;
    }

    public String getUsuarioEdo5e() {
        return usuarioEdo5e;
    }

    public void setUsuarioEdo5e(String usuarioEdo5e) {
        this.usuarioEdo5e = usuarioEdo5e;
    }

    public Date getFechaEdo5e() {
        return fechaEdo5e;
    }

    public void setFechaEdo5e(Date fechaEdo5e) {
        this.fechaEdo5e = fechaEdo5e;
    }

    public String getUsuarioEdo6e() {
        return usuarioEdo6e;
    }

    public void setUsuarioEdo6e(String usuarioEdo6e) {
        this.usuarioEdo6e = usuarioEdo6e;
    }

    public Date getFechaEdo6e() {
        return fechaEdo6e;
    }

    public void setFechaEdo6e(Date fechaEdo6e) {
        this.fechaEdo6e = fechaEdo6e;
    }

    public String getReferenciaVc() {
        return referenciaVc;
    }

    public void setReferenciaVc(String referenciaVc) {
        this.referenciaVc = referenciaVc;
    }

    public String getInterpretacionVc() {
        return interpretacionVc;
    }

    public void setInterpretacionVc(String interpretacionVc) {
        this.interpretacionVc = interpretacionVc;
    }

    public String getNotaInterpretacion() {
        return notaInterpretacion;
    }

    public void setNotaInterpretacion(String notaInterpretacion) {
        this.notaInterpretacion = notaInterpretacion;
    }

    public String getOtrasIndicaciones() {
        return otrasIndicaciones;
    }

    public void setOtrasIndicaciones(String otrasIndicaciones) {
        this.otrasIndicaciones = otrasIndicaciones;
    }

    public String getNotaReceta() {
        return notaReceta;
    }

    public void setNotaReceta(String notaReceta) {
        this.notaReceta = notaReceta;
    }

    public Integer getContadorVc() {
        return contadorVc;
    }

    public void setContadorVc(Integer contadorVc) {
        this.contadorVc = contadorVc;
    }

    public String getNotaRadiologoVc() {
        return notaRadiologoVc;
    }

    public void setNotaRadiologoVc(String notaRadiologoVc) {
        this.notaRadiologoVc = notaRadiologoVc;
    }

    public Short getBiradVc() {
        return biradVc;
    }

    public void setBiradVc(Short biradVc) {
        this.biradVc = biradVc;
    }

    public String getNoTempVc() {
        return noTempVc;
    }

    public void setNoTempVc(String noTempVc) {
        this.noTempVc = noTempVc;
    }

    public String getMotivoVisitaVc() {
        return motivoVisitaVc;
    }

    public void setMotivoVisitaVc(String motivoVisitaVc) {
        this.motivoVisitaVc = motivoVisitaVc;
    }

    public short getTemporalVc() {
        return temporalVc;
    }

    public void setTemporalVc(short temporalVc) {
        this.temporalVc = temporalVc;
    }

    public String getObservacionesVc() {
        return observacionesVc;
    }

    public void setObservacionesVc(String observacionesVc) {
        this.observacionesVc = observacionesVc;
    }

    public BigInteger getIdSignosvVc() {
        return idSignosvVc;
    }

    public void setIdSignosvVc(BigInteger idSignosvVc) {
        this.idSignosvVc = idSignosvVc;
    }

    public long getIdConceptosBeneficios() {
        return idConceptosBeneficios;
    }

    public void setIdConceptosBeneficios(long idConceptosBeneficios) {
        this.idConceptosBeneficios = idConceptosBeneficios;
    }

    public short getEsBeneficioVc() {
        return esBeneficioVc;
    }

    public void setEsBeneficioVc(short esBeneficioVc) {
        this.esBeneficioVc = esBeneficioVc;
    }

    public Integer getIdAnesteciologoVc() {
        return idAnesteciologoVc;
    }

    public void setIdAnesteciologoVc(Integer idAnesteciologoVc) {
        this.idAnesteciologoVc = idAnesteciologoVc;
    }

    public int getIdRadiologoExterno() {
        return idRadiologoExterno;
    }

    public void setIdRadiologoExterno(int idRadiologoExterno) {
        this.idRadiologoExterno = idRadiologoExterno;
    }

    public String getIdPacs() {
        return idPacs;
    }

    public void setIdPacs(String idPacs) {
        this.idPacs = idPacs;
    }

    public Integer getUsuarioTransfiereVc() {
        return usuarioTransfiereVc;
    }

    public void setUsuarioTransfiereVc(Integer usuarioTransfiereVc) {
        this.usuarioTransfiereVc = usuarioTransfiereVc;
    }

    public Date getFechaTransfiereVc() {
        return fechaTransfiereVc;
    }

    public void setFechaTransfiereVc(Date fechaTransfiereVc) {
        this.fechaTransfiereVc = fechaTransfiereVc;
    }

    public short getSalvadoVc() {
        return salvadoVc;
    }

    public void setSalvadoVc(short salvadoVc) {
        this.salvadoVc = salvadoVc;
    }

    public String getFechaAsignado() {
        return fechaAsignado;
    }

    public void setFechaAsignado(String fechaAsignado) {
        this.fechaAsignado = fechaAsignado;
    }

    public String getHoraAsignado() {
        return horaAsignado;
    }

    public void setHoraAsignado(String horaAsignado) {
        this.horaAsignado = horaAsignado;
    }

    public boolean getEnWorklist() {
        return enWorklist;
    }

    public void setEnWorklist(boolean enWorklist) {
        this.enWorklist = enWorklist;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Conceptos getIdConceptoEs() {
        return idConceptoEs;
    }

    public void setIdConceptoEs(Conceptos idConceptoEs) {
        this.idConceptoEs = idConceptoEs;
    }

    public EquipoDicom getIdEquipoDicom() {
        return idEquipoDicom;
    }

    public void setIdEquipoDicom(EquipoDicom idEquipoDicom) {
        this.idEquipoDicom = idEquipoDicom;
    }

    public Institucion getIdInstitucion() {
        return idInstitucion;
    }

    public void setIdInstitucion(Institucion idInstitucion) {
        this.idInstitucion = idInstitucion;
    }

  

    public OrdenVenta getIdOrdenVenta() {
        return idOrdenVenta;
    }

    public void setIdOrdenVenta(OrdenVenta idOrdenVenta) {
        this.idOrdenVenta = idOrdenVenta;
    }

    public Pacientes getIdPacienteVc() {
        return idPacienteVc;
    }

    public void setIdPacienteVc(Pacientes idPacienteVc) {
        this.idPacienteVc = idPacienteVc;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVc != null ? idVc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentaConceptos)) {
            return false;
        }
        VentaConceptos other = (VentaConceptos) object;
        if ((this.idVc == null && other.idVc != null) || (this.idVc != null && !this.idVc.equals(other.idVc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.gm.sga.domain.VentaConceptos[ idVc=" + idVc + " ]";
    }
    
}
