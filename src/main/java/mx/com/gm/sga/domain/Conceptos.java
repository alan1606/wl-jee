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
    @NamedQuery(name = "Conceptos.findAll", query = "SELECT c FROM Conceptos c"),
    @NamedQuery(name = "Conceptos.findByIdTo", query = "SELECT c FROM Conceptos c WHERE c.idTo = :idTo"),
    @NamedQuery(name = "Conceptos.findByConceptoTo", query = "SELECT c FROM Conceptos c WHERE c.conceptoTo = :conceptoTo"),
    @NamedQuery(name = "Conceptos.findByIdDepartamentoTo", query = "SELECT c FROM Conceptos c WHERE c.idDepartamentoTo = :idDepartamentoTo"),
    @NamedQuery(name = "Conceptos.findByIdTipoConceptoTo", query = "SELECT c FROM Conceptos c WHERE c.idTipoConceptoTo = :idTipoConceptoTo"),
    @NamedQuery(name = "Conceptos.findByPrecioTo", query = "SELECT c FROM Conceptos c WHERE c.precioTo = :precioTo"),
    @NamedQuery(name = "Conceptos.findByPrecioUrgenciaTo", query = "SELECT c FROM Conceptos c WHERE c.precioUrgenciaTo = :precioUrgenciaTo"),
    @NamedQuery(name = "Conceptos.findByUsuarioTo", query = "SELECT c FROM Conceptos c WHERE c.usuarioTo = :usuarioTo"),
    @NamedQuery(name = "Conceptos.findByFechaTo", query = "SELECT c FROM Conceptos c WHERE c.fechaTo = :fechaTo"),
    @NamedQuery(name = "Conceptos.findByIdConvenioTo", query = "SELECT c FROM Conceptos c WHERE c.idConvenioTo = :idConvenioTo"),
    @NamedQuery(name = "Conceptos.findByPrecioM", query = "SELECT c FROM Conceptos c WHERE c.precioM = :precioM"),
    @NamedQuery(name = "Conceptos.findByPrecioMu", query = "SELECT c FROM Conceptos c WHERE c.precioMu = :precioMu"),
    @NamedQuery(name = "Conceptos.findByIdBeneficioTo", query = "SELECT c FROM Conceptos c WHERE c.idBeneficioTo = :idBeneficioTo"),
    @NamedQuery(name = "Conceptos.findByDiasEntregaTo", query = "SELECT c FROM Conceptos c WHERE c.diasEntregaTo = :diasEntregaTo"),
    @NamedQuery(name = "Conceptos.findByAleatorioC", query = "SELECT c FROM Conceptos c WHERE c.aleatorioC = :aleatorioC"),
    @NamedQuery(name = "Conceptos.findByCostoTo", query = "SELECT c FROM Conceptos c WHERE c.costoTo = :costoTo"),
    @NamedQuery(name = "Conceptos.findByIdMedicamentoG", query = "SELECT c FROM Conceptos c WHERE c.idMedicamentoG = :idMedicamentoG"),
    @NamedQuery(name = "Conceptos.findByCodigoBarrasTo", query = "SELECT c FROM Conceptos c WHERE c.codigoBarrasTo = :codigoBarrasTo"),
    @NamedQuery(name = "Conceptos.findByLinkPlmTo", query = "SELECT c FROM Conceptos c WHERE c.linkPlmTo = :linkPlmTo"),
    @NamedQuery(name = "Conceptos.findByNivelMedTo", query = "SELECT c FROM Conceptos c WHERE c.nivelMedTo = :nivelMedTo"),
    @NamedQuery(name = "Conceptos.findByCategoriaTo", query = "SELECT c FROM Conceptos c WHERE c.categoriaTo = :categoriaTo"),
    @NamedQuery(name = "Conceptos.findByDicom", query = "SELECT c FROM Conceptos c WHERE c.dicom = :dicom"),
    @NamedQuery(name = "Conceptos.findByIdGrupoTo", query = "SELECT c FROM Conceptos c WHERE c.idGrupoTo = :idGrupoTo"),
    @NamedQuery(name = "Conceptos.findByIdCategoriaTo", query = "SELECT c FROM Conceptos c WHERE c.idCategoriaTo = :idCategoriaTo"),
    @NamedQuery(name = "Conceptos.findByIdUmedidaTo", query = "SELECT c FROM Conceptos c WHERE c.idUmedidaTo = :idUmedidaTo"),
    @NamedQuery(name = "Conceptos.findByIdMarcaTo", query = "SELECT c FROM Conceptos c WHERE c.idMarcaTo = :idMarcaTo"),
    @NamedQuery(name = "Conceptos.findByIdModeloTo", query = "SELECT c FROM Conceptos c WHERE c.idModeloTo = :idModeloTo"),
    @NamedQuery(name = "Conceptos.findByIdPresentacionTo", query = "SELECT c FROM Conceptos c WHERE c.idPresentacionTo = :idPresentacionTo")})
public class Conceptos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_to")
    private Long idTo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "concepto_to")
    private String conceptoTo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_departamento_to")
    private short idDepartamentoTo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_concepto_to")
    private short idTipoConceptoTo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_to")
    private float precioTo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_urgencia_to")
    private float precioUrgenciaTo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_to")
    private int usuarioTo;
    @Column(name = "fecha_to")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaTo;
    @Lob
    @Size(max = 65535)
    private String formato;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_convenio_to")
    private int idConvenioTo;
    @Lob
    @Size(max = 65535)
    @Column(name = "descripcion_to")
    private String descripcionTo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_m")
    private float precioM;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_mu")
    private float precioMu;
    @Column(name = "id_beneficio_to")
    private Short idBeneficioTo;
    @Column(name = "dias_entrega_to")
    private Short diasEntregaTo;
    @Size(max = 100)
    @Column(name = "aleatorio_c")
    private String aleatorioC;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "costo_to")
    private Float costoTo;
    @Column(name = "id_medicamento_g")
    private Integer idMedicamentoG;
    @Size(max = 100)
    @Column(name = "codigo_barras_to")
    private String codigoBarrasTo;
    @Size(max = 100)
    @Column(name = "link_plm_to")
    private String linkPlmTo;
    @Size(max = 20)
    @Column(name = "nivel_med_to")
    private String nivelMedTo;
    @Column(name = "categoria_to")
    private Short categoriaTo;
    private Short dicom;
    @Column(name = "id_grupo_to")
    private Integer idGrupoTo;
    @Column(name = "id_categoria_to")
    private Integer idCategoriaTo;
    @Column(name = "id_umedida_to")
    private Integer idUmedidaTo;
    @Column(name = "id_marca_to")
    private Integer idMarcaTo;
    @Column(name = "id_modelo_to")
    private Integer idModeloTo;
    @Column(name = "id_presentacion_to")
    private Integer idPresentacionTo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConceptoEs")
    private List<VentaConceptos> ventaConceptosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConcepto")
    private List<Paquete> paqueteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConcepto")
    private List<ConsentimientoConcepto> consentimientoConceptoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConcepto")
    private List<ConceptoPaquete> conceptoPaqueteList;
    @JoinColumn(name = "id_area_to", referencedColumnName = "id_a")
    @ManyToOne(optional = false)
    private Areas idAreaTo;
    @JoinColumn(name = "id_instrucciones", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Instrucciones idInstrucciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConcepto")
    private List<ConceptosInstitucion> conceptosInstitucionList;

    public Conceptos() {
    }

    public Conceptos(Long idTo) {
        this.idTo = idTo;
    }

    public Conceptos(Long idTo, String conceptoTo, short idDepartamentoTo, short idTipoConceptoTo, float precioTo, float precioUrgenciaTo, int usuarioTo, int idConvenioTo, float precioM, float precioMu) {
        this.idTo = idTo;
        this.conceptoTo = conceptoTo;
        this.idDepartamentoTo = idDepartamentoTo;
        this.idTipoConceptoTo = idTipoConceptoTo;
        this.precioTo = precioTo;
        this.precioUrgenciaTo = precioUrgenciaTo;
        this.usuarioTo = usuarioTo;
        this.idConvenioTo = idConvenioTo;
        this.precioM = precioM;
        this.precioMu = precioMu;
    }

    public Long getIdTo() {
        return idTo;
    }

    public void setIdTo(Long idTo) {
        this.idTo = idTo;
    }

    public String getConceptoTo() {
        return conceptoTo;
    }

    public void setConceptoTo(String conceptoTo) {
        this.conceptoTo = conceptoTo;
    }

    public short getIdDepartamentoTo() {
        return idDepartamentoTo;
    }

    public void setIdDepartamentoTo(short idDepartamentoTo) {
        this.idDepartamentoTo = idDepartamentoTo;
    }

    public short getIdTipoConceptoTo() {
        return idTipoConceptoTo;
    }

    public void setIdTipoConceptoTo(short idTipoConceptoTo) {
        this.idTipoConceptoTo = idTipoConceptoTo;
    }

    public float getPrecioTo() {
        return precioTo;
    }

    public void setPrecioTo(float precioTo) {
        this.precioTo = precioTo;
    }

    public float getPrecioUrgenciaTo() {
        return precioUrgenciaTo;
    }

    public void setPrecioUrgenciaTo(float precioUrgenciaTo) {
        this.precioUrgenciaTo = precioUrgenciaTo;
    }

    public int getUsuarioTo() {
        return usuarioTo;
    }

    public void setUsuarioTo(int usuarioTo) {
        this.usuarioTo = usuarioTo;
    }

    public Date getFechaTo() {
        return fechaTo;
    }

    public void setFechaTo(Date fechaTo) {
        this.fechaTo = fechaTo;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public int getIdConvenioTo() {
        return idConvenioTo;
    }

    public void setIdConvenioTo(int idConvenioTo) {
        this.idConvenioTo = idConvenioTo;
    }

    public String getDescripcionTo() {
        return descripcionTo;
    }

    public void setDescripcionTo(String descripcionTo) {
        this.descripcionTo = descripcionTo;
    }

    public float getPrecioM() {
        return precioM;
    }

    public void setPrecioM(float precioM) {
        this.precioM = precioM;
    }

    public float getPrecioMu() {
        return precioMu;
    }

    public void setPrecioMu(float precioMu) {
        this.precioMu = precioMu;
    }

    public Short getIdBeneficioTo() {
        return idBeneficioTo;
    }

    public void setIdBeneficioTo(Short idBeneficioTo) {
        this.idBeneficioTo = idBeneficioTo;
    }

    public Short getDiasEntregaTo() {
        return diasEntregaTo;
    }

    public void setDiasEntregaTo(Short diasEntregaTo) {
        this.diasEntregaTo = diasEntregaTo;
    }

    public String getAleatorioC() {
        return aleatorioC;
    }

    public void setAleatorioC(String aleatorioC) {
        this.aleatorioC = aleatorioC;
    }

    public Float getCostoTo() {
        return costoTo;
    }

    public void setCostoTo(Float costoTo) {
        this.costoTo = costoTo;
    }

    public Integer getIdMedicamentoG() {
        return idMedicamentoG;
    }

    public void setIdMedicamentoG(Integer idMedicamentoG) {
        this.idMedicamentoG = idMedicamentoG;
    }

    public String getCodigoBarrasTo() {
        return codigoBarrasTo;
    }

    public void setCodigoBarrasTo(String codigoBarrasTo) {
        this.codigoBarrasTo = codigoBarrasTo;
    }

    public String getLinkPlmTo() {
        return linkPlmTo;
    }

    public void setLinkPlmTo(String linkPlmTo) {
        this.linkPlmTo = linkPlmTo;
    }

    public String getNivelMedTo() {
        return nivelMedTo;
    }

    public void setNivelMedTo(String nivelMedTo) {
        this.nivelMedTo = nivelMedTo;
    }

    public Short getCategoriaTo() {
        return categoriaTo;
    }

    public void setCategoriaTo(Short categoriaTo) {
        this.categoriaTo = categoriaTo;
    }

    public Short getDicom() {
        return dicom;
    }

    public void setDicom(Short dicom) {
        this.dicom = dicom;
    }

    public Integer getIdGrupoTo() {
        return idGrupoTo;
    }

    public void setIdGrupoTo(Integer idGrupoTo) {
        this.idGrupoTo = idGrupoTo;
    }

    public Integer getIdCategoriaTo() {
        return idCategoriaTo;
    }

    public void setIdCategoriaTo(Integer idCategoriaTo) {
        this.idCategoriaTo = idCategoriaTo;
    }

    public Integer getIdUmedidaTo() {
        return idUmedidaTo;
    }

    public void setIdUmedidaTo(Integer idUmedidaTo) {
        this.idUmedidaTo = idUmedidaTo;
    }

    public Integer getIdMarcaTo() {
        return idMarcaTo;
    }

    public void setIdMarcaTo(Integer idMarcaTo) {
        this.idMarcaTo = idMarcaTo;
    }

    public Integer getIdModeloTo() {
        return idModeloTo;
    }

    public void setIdModeloTo(Integer idModeloTo) {
        this.idModeloTo = idModeloTo;
    }

    public Integer getIdPresentacionTo() {
        return idPresentacionTo;
    }

    public void setIdPresentacionTo(Integer idPresentacionTo) {
        this.idPresentacionTo = idPresentacionTo;
    }

    @XmlTransient
    public List<VentaConceptos> getVentaConceptosList() {
        return ventaConceptosList;
    }

    public void setVentaConceptosList(List<VentaConceptos> ventaConceptosList) {
        this.ventaConceptosList = ventaConceptosList;
    }

    @XmlTransient
    public List<Paquete> getPaqueteList() {
        return paqueteList;
    }

    public void setPaqueteList(List<Paquete> paqueteList) {
        this.paqueteList = paqueteList;
    }

    @XmlTransient
    public List<ConsentimientoConcepto> getConsentimientoConceptoList() {
        return consentimientoConceptoList;
    }

    public void setConsentimientoConceptoList(List<ConsentimientoConcepto> consentimientoConceptoList) {
        this.consentimientoConceptoList = consentimientoConceptoList;
    }

    @XmlTransient
    public List<ConceptoPaquete> getConceptoPaqueteList() {
        return conceptoPaqueteList;
    }

    public void setConceptoPaqueteList(List<ConceptoPaquete> conceptoPaqueteList) {
        this.conceptoPaqueteList = conceptoPaqueteList;
    }

    public Areas getIdAreaTo() {
        return idAreaTo;
    }

    public void setIdAreaTo(Areas idAreaTo) {
        this.idAreaTo = idAreaTo;
    }

    public Instrucciones getIdInstrucciones() {
        return idInstrucciones;
    }

    public void setIdInstrucciones(Instrucciones idInstrucciones) {
        this.idInstrucciones = idInstrucciones;
    }

    @XmlTransient
    public List<ConceptosInstitucion> getConceptosInstitucionList() {
        return conceptosInstitucionList;
    }

    public void setConceptosInstitucionList(List<ConceptosInstitucion> conceptosInstitucionList) {
        this.conceptosInstitucionList = conceptosInstitucionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTo != null ? idTo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conceptos)) {
            return false;
        }
        Conceptos other = (Conceptos) object;
        if ((this.idTo == null && other.idTo != null) || (this.idTo != null && !this.idTo.equals(other.idTo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.gm.sga.domain.Conceptos[ idTo=" + idTo + " ]";
    }
    
}
