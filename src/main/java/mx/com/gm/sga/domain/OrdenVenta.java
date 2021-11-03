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
import javax.persistence.Table;
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
@Table(name = "orden_venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenVenta.findAll", query = "SELECT o FROM OrdenVenta o"),
    @NamedQuery(name = "OrdenVenta.findByIdOv", query = "SELECT o FROM OrdenVenta o WHERE o.idOv = :idOv"),
    @NamedQuery(name = "OrdenVenta.findByTotalEi", query = "SELECT o FROM OrdenVenta o WHERE o.totalEi = :totalEi"),
    @NamedQuery(name = "OrdenVenta.findByTotalEl", query = "SELECT o FROM OrdenVenta o WHERE o.totalEl = :totalEl"),
    @NamedQuery(name = "OrdenVenta.findByTotalP", query = "SELECT o FROM OrdenVenta o WHERE o.totalP = :totalP"),
    @NamedQuery(name = "OrdenVenta.findByTotalC", query = "SELECT o FROM OrdenVenta o WHERE o.totalC = :totalC"),
    @NamedQuery(name = "OrdenVenta.findByTotalS", query = "SELECT o FROM OrdenVenta o WHERE o.totalS = :totalS"),
    @NamedQuery(name = "OrdenVenta.findBySubtotalOv", query = "SELECT o FROM OrdenVenta o WHERE o.subtotalOv = :subtotalOv"),
    @NamedQuery(name = "OrdenVenta.findByIvaOv", query = "SELECT o FROM OrdenVenta o WHERE o.ivaOv = :ivaOv"),
    @NamedQuery(name = "OrdenVenta.findByGranTotalOv", query = "SELECT o FROM OrdenVenta o WHERE o.granTotalOv = :granTotalOv"),
    @NamedQuery(name = "OrdenVenta.findBySubTotalC", query = "SELECT o FROM OrdenVenta o WHERE o.subTotalC = :subTotalC"),
    @NamedQuery(name = "OrdenVenta.findBySubTotalI", query = "SELECT o FROM OrdenVenta o WHERE o.subTotalI = :subTotalI"),
    @NamedQuery(name = "OrdenVenta.findBySubTotalL", query = "SELECT o FROM OrdenVenta o WHERE o.subTotalL = :subTotalL"),
    @NamedQuery(name = "OrdenVenta.findBySubTotalP", query = "SELECT o FROM OrdenVenta o WHERE o.subTotalP = :subTotalP"),
    @NamedQuery(name = "OrdenVenta.findBySubTotalS", query = "SELECT o FROM OrdenVenta o WHERE o.subTotalS = :subTotalS"),
    @NamedQuery(name = "OrdenVenta.findByUsuarioOv", query = "SELECT o FROM OrdenVenta o WHERE o.usuarioOv = :usuarioOv"),
    @NamedQuery(name = "OrdenVenta.findByFechaVentaOv", query = "SELECT o FROM OrdenVenta o WHERE o.fechaVentaOv = :fechaVentaOv"),
    @NamedQuery(name = "OrdenVenta.findByAdicionalesCOv", query = "SELECT o FROM OrdenVenta o WHERE o.adicionalesCOv = :adicionalesCOv"),
    @NamedQuery(name = "OrdenVenta.findByAdicionalesPOv", query = "SELECT o FROM OrdenVenta o WHERE o.adicionalesPOv = :adicionalesPOv"),
    @NamedQuery(name = "OrdenVenta.findByAdicionalesEiOv", query = "SELECT o FROM OrdenVenta o WHERE o.adicionalesEiOv = :adicionalesEiOv"),
    @NamedQuery(name = "OrdenVenta.findByAdicionalesElOv", query = "SELECT o FROM OrdenVenta o WHERE o.adicionalesElOv = :adicionalesElOv"),
    @NamedQuery(name = "OrdenVenta.findByAdicionalesSOv", query = "SELECT o FROM OrdenVenta o WHERE o.adicionalesSOv = :adicionalesSOv"),
    @NamedQuery(name = "OrdenVenta.findByPDescCta", query = "SELECT o FROM OrdenVenta o WHERE o.pDescCta = :pDescCta"),
    @NamedQuery(name = "OrdenVenta.findByDescDCta", query = "SELECT o FROM OrdenVenta o WHERE o.descDCta = :descDCta"),
    @NamedQuery(name = "OrdenVenta.findByTDescCta", query = "SELECT o FROM OrdenVenta o WHERE o.tDescCta = :tDescCta"),
    @NamedQuery(name = "OrdenVenta.findByPDescImg", query = "SELECT o FROM OrdenVenta o WHERE o.pDescImg = :pDescImg"),
    @NamedQuery(name = "OrdenVenta.findByDescDImg", query = "SELECT o FROM OrdenVenta o WHERE o.descDImg = :descDImg"),
    @NamedQuery(name = "OrdenVenta.findByTDescImg", query = "SELECT o FROM OrdenVenta o WHERE o.tDescImg = :tDescImg"),
    @NamedQuery(name = "OrdenVenta.findByPDescLab", query = "SELECT o FROM OrdenVenta o WHERE o.pDescLab = :pDescLab"),
    @NamedQuery(name = "OrdenVenta.findByDescDLab", query = "SELECT o FROM OrdenVenta o WHERE o.descDLab = :descDLab"),
    @NamedQuery(name = "OrdenVenta.findByTDescLab", query = "SELECT o FROM OrdenVenta o WHERE o.tDescLab = :tDescLab"),
    @NamedQuery(name = "OrdenVenta.findByPDescServ", query = "SELECT o FROM OrdenVenta o WHERE o.pDescServ = :pDescServ"),
    @NamedQuery(name = "OrdenVenta.findByDescDServ", query = "SELECT o FROM OrdenVenta o WHERE o.descDServ = :descDServ"),
    @NamedQuery(name = "OrdenVenta.findByTDescServ", query = "SELECT o FROM OrdenVenta o WHERE o.tDescServ = :tDescServ"),
    @NamedQuery(name = "OrdenVenta.findByPDescPro", query = "SELECT o FROM OrdenVenta o WHERE o.pDescPro = :pDescPro"),
    @NamedQuery(name = "OrdenVenta.findByDescDPro", query = "SELECT o FROM OrdenVenta o WHERE o.descDPro = :descDPro"),
    @NamedQuery(name = "OrdenVenta.findByTDescPro", query = "SELECT o FROM OrdenVenta o WHERE o.tDescPro = :tDescPro"),
    @NamedQuery(name = "OrdenVenta.findByMedicoCOv", query = "SELECT o FROM OrdenVenta o WHERE o.medicoCOv = :medicoCOv"),
    @NamedQuery(name = "OrdenVenta.findByMedicoEiOv", query = "SELECT o FROM OrdenVenta o WHERE o.medicoEiOv = :medicoEiOv"),
    @NamedQuery(name = "OrdenVenta.findByMedicoElOv", query = "SELECT o FROM OrdenVenta o WHERE o.medicoElOv = :medicoElOv"),
    @NamedQuery(name = "OrdenVenta.findByPersonalSOv", query = "SELECT o FROM OrdenVenta o WHERE o.personalSOv = :personalSOv"),
    @NamedQuery(name = "OrdenVenta.findByReferenciaOv", query = "SELECT o FROM OrdenVenta o WHERE o.referenciaOv = :referenciaOv"),
    @NamedQuery(name = "OrdenVenta.findByContadorOv", query = "SELECT o FROM OrdenVenta o WHERE o.contadorOv = :contadorOv"),
    @NamedQuery(name = "OrdenVenta.findBySucursalOv", query = "SELECT o FROM OrdenVenta o WHERE o.sucursalOv = :sucursalOv"),
    @NamedQuery(name = "OrdenVenta.findByNoTempOv", query = "SELECT o FROM OrdenVenta o WHERE o.noTempOv = :noTempOv"),
    @NamedQuery(name = "OrdenVenta.findByFacturadaOv", query = "SELECT o FROM OrdenVenta o WHERE o.facturadaOv = :facturadaOv"),
    @NamedQuery(name = "OrdenVenta.findByEstatusOv", query = "SELECT o FROM OrdenVenta o WHERE o.estatusOv = :estatusOv"),
    @NamedQuery(name = "OrdenVenta.findByProcedenciaOv", query = "SELECT o FROM OrdenVenta o WHERE o.procedenciaOv = :procedenciaOv"),
    @NamedQuery(name = "OrdenVenta.findByMotivoDescCOv", query = "SELECT o FROM OrdenVenta o WHERE o.motivoDescCOv = :motivoDescCOv"),
    @NamedQuery(name = "OrdenVenta.findByMotivoDescIOv", query = "SELECT o FROM OrdenVenta o WHERE o.motivoDescIOv = :motivoDescIOv"),
    @NamedQuery(name = "OrdenVenta.findByMotivoDescLOv", query = "SELECT o FROM OrdenVenta o WHERE o.motivoDescLOv = :motivoDescLOv"),
    @NamedQuery(name = "OrdenVenta.findByMotivoDescSOv", query = "SELECT o FROM OrdenVenta o WHERE o.motivoDescSOv = :motivoDescSOv"),
    @NamedQuery(name = "OrdenVenta.findByMotivoDescFOv", query = "SELECT o FROM OrdenVenta o WHERE o.motivoDescFOv = :motivoDescFOv"),
    @NamedQuery(name = "OrdenVenta.findByRequiereFactura", query = "SELECT o FROM OrdenVenta o WHERE o.requiereFactura = :requiereFactura"),
    @NamedQuery(name = "OrdenVenta.findByPagado", query = "SELECT o FROM OrdenVenta o WHERE o.pagado = :pagado")})
public class OrdenVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ov")
    private Long idOv;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total_ei")
    private Float totalEi;
    @Column(name = "total_el")
    private Float totalEl;
    @Column(name = "total_p")
    private Float totalP;
    @Column(name = "total_c")
    private Float totalC;
    @Column(name = "total_s")
    private Float totalS;
    @Basic(optional = false)
    @NotNull
    @Column(name = "subtotal_ov")
    private float subtotalOv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iva_ov")
    private float ivaOv;
    @Column(name = "gran_total_ov")
    private Float granTotalOv;
    @Column(name = "sub_total_c")
    private Float subTotalC;
    @Column(name = "sub_total_i")
    private Float subTotalI;
    @Column(name = "sub_total_l")
    private Float subTotalL;
    @Column(name = "sub_total_p")
    private Float subTotalP;
    @Column(name = "sub_total_s")
    private Float subTotalS;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_ov")
    private int usuarioOv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_venta_ov")
    private String fechaVentaOv;
    @Column(name = "adicionales_c_ov")
    private Float adicionalesCOv;
    @Column(name = "adicionales_p_ov")
    private Float adicionalesPOv;
    @Column(name = "adicionales_ei_ov")
    private Float adicionalesEiOv;
    @Column(name = "adicionales_el_ov")
    private Float adicionalesElOv;
    @Column(name = "adicionales_s_ov")
    private Float adicionalesSOv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "p_desc_cta")
    private short pDescCta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "desc_d_cta")
    private float descDCta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "t_desc_cta")
    private float tDescCta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "p_desc_img")
    private short pDescImg;
    @Basic(optional = false)
    @NotNull
    @Column(name = "desc_d_img")
    private float descDImg;
    @Basic(optional = false)
    @NotNull
    @Column(name = "t_desc_img")
    private float tDescImg;
    @Basic(optional = false)
    @NotNull
    @Column(name = "p_desc_lab")
    private short pDescLab;
    @Basic(optional = false)
    @NotNull
    @Column(name = "desc_d_lab")
    private float descDLab;
    @Basic(optional = false)
    @NotNull
    @Column(name = "t_desc_lab")
    private float tDescLab;
    @Basic(optional = false)
    @NotNull
    @Column(name = "p_desc_serv")
    private short pDescServ;
    @Basic(optional = false)
    @NotNull
    @Column(name = "desc_d_serv")
    private float descDServ;
    @Basic(optional = false)
    @NotNull
    @Column(name = "t_desc_serv")
    private float tDescServ;
    @Basic(optional = false)
    @NotNull
    @Column(name = "p_desc_pro")
    private short pDescPro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "desc_d_pro")
    private float descDPro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "t_desc_pro")
    private float tDescPro;
    @Lob
    @Size(max = 65535)
    @Column(name = "motivo_c_ov")
    private String motivoCOv;
    @Lob
    @Size(max = 65535)
    @Column(name = "observaciones_i_ov")
    private String observacionesIOv;
    @Lob
    @Size(max = 65535)
    @Column(name = "observaciones_l_ov")
    private String observacionesLOv;
    @Lob
    @Size(max = 65535)
    @Column(name = "observaciones_s_ov")
    private String observacionesSOv;
    @Column(name = "medico_c_ov")
    private Integer medicoCOv;
    @Column(name = "medico_ei_ov")
    private Integer medicoEiOv;
    @Column(name = "medico_el_ov")
    private Integer medicoElOv;
    @Column(name = "personal_s_ov")
    private Integer personalSOv;
    @Size(max = 15)
    @Column(name = "referencia_ov")
    private String referenciaOv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "contador_ov")
    private int contadorOv;
    @Column(name = "sucursal_ov")
    private Integer sucursalOv;
    @Size(max = 100)
    @Column(name = "no_temp_ov")
    private String noTempOv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "facturada_ov")
    private short facturadaOv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estatus_ov")
    private short estatusOv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "procedencia_ov")
    private short procedenciaOv;
    @Lob
    @Size(max = 65535)
    @Column(name = "muestras_ov")
    private String muestrasOv;
    @Size(max = 200)
    @Column(name = "motivo_desc_c_ov")
    private String motivoDescCOv;
    @Size(max = 200)
    @Column(name = "motivo_desc_i_ov")
    private String motivoDescIOv;
    @Size(max = 200)
    @Column(name = "motivo_desc_l_ov")
    private String motivoDescLOv;
    @Size(max = 200)
    @Column(name = "motivo_desc_s_ov")
    private String motivoDescSOv;
    @Size(max = 200)
    @Column(name = "motivo_desc_f_ov")
    private String motivoDescFOv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "requiere_factura")
    private boolean requiereFactura;
    @Basic(optional = false)
    @NotNull
    private boolean pagado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOrdenVenta")
    private List<VentaConceptos> ventaConceptosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOrdenVenta")
    private List<PagoOrdenVenta> pagoOrdenVentaList;
    @JoinColumn(name = "id_forma_pago", referencedColumnName = "id_fp")
    @ManyToOne(optional = false)
    private CatalogoFormaPago idFormaPago;
    @JoinColumn(name = "id_paciente_ov", referencedColumnName = "id_p")
    @ManyToOne(optional = false)
    private Pacientes idPacienteOv;

    public OrdenVenta() {
    }

    public OrdenVenta(Long idOv) {
        this.idOv = idOv;
    }

    public OrdenVenta(Long idOv, float subtotalOv, float ivaOv, int usuarioOv, String fechaVentaOv, short pDescCta, float descDCta, float tDescCta, short pDescImg, float descDImg, float tDescImg, short pDescLab, float descDLab, float tDescLab, short pDescServ, float descDServ, float tDescServ, short pDescPro, float descDPro, float tDescPro, int contadorOv, short facturadaOv, short estatusOv, short procedenciaOv, boolean requiereFactura, boolean pagado) {
        this.idOv = idOv;
        this.subtotalOv = subtotalOv;
        this.ivaOv = ivaOv;
        this.usuarioOv = usuarioOv;
        this.fechaVentaOv = fechaVentaOv;
        this.pDescCta = pDescCta;
        this.descDCta = descDCta;
        this.tDescCta = tDescCta;
        this.pDescImg = pDescImg;
        this.descDImg = descDImg;
        this.tDescImg = tDescImg;
        this.pDescLab = pDescLab;
        this.descDLab = descDLab;
        this.tDescLab = tDescLab;
        this.pDescServ = pDescServ;
        this.descDServ = descDServ;
        this.tDescServ = tDescServ;
        this.pDescPro = pDescPro;
        this.descDPro = descDPro;
        this.tDescPro = tDescPro;
        this.contadorOv = contadorOv;
        this.facturadaOv = facturadaOv;
        this.estatusOv = estatusOv;
        this.procedenciaOv = procedenciaOv;
        this.requiereFactura = requiereFactura;
        this.pagado = pagado;
    }

    public Long getIdOv() {
        return idOv;
    }

    public void setIdOv(Long idOv) {
        this.idOv = idOv;
    }

    public Float getTotalEi() {
        return totalEi;
    }

    public void setTotalEi(Float totalEi) {
        this.totalEi = totalEi;
    }

    public Float getTotalEl() {
        return totalEl;
    }

    public void setTotalEl(Float totalEl) {
        this.totalEl = totalEl;
    }

    public Float getTotalP() {
        return totalP;
    }

    public void setTotalP(Float totalP) {
        this.totalP = totalP;
    }

    public Float getTotalC() {
        return totalC;
    }

    public void setTotalC(Float totalC) {
        this.totalC = totalC;
    }

    public Float getTotalS() {
        return totalS;
    }

    public void setTotalS(Float totalS) {
        this.totalS = totalS;
    }

    public float getSubtotalOv() {
        return subtotalOv;
    }

    public void setSubtotalOv(float subtotalOv) {
        this.subtotalOv = subtotalOv;
    }

    public float getIvaOv() {
        return ivaOv;
    }

    public void setIvaOv(float ivaOv) {
        this.ivaOv = ivaOv;
    }

    public Float getGranTotalOv() {
        return granTotalOv;
    }

    public void setGranTotalOv(Float granTotalOv) {
        this.granTotalOv = granTotalOv;
    }

    public Float getSubTotalC() {
        return subTotalC;
    }

    public void setSubTotalC(Float subTotalC) {
        this.subTotalC = subTotalC;
    }

    public Float getSubTotalI() {
        return subTotalI;
    }

    public void setSubTotalI(Float subTotalI) {
        this.subTotalI = subTotalI;
    }

    public Float getSubTotalL() {
        return subTotalL;
    }

    public void setSubTotalL(Float subTotalL) {
        this.subTotalL = subTotalL;
    }

    public Float getSubTotalP() {
        return subTotalP;
    }

    public void setSubTotalP(Float subTotalP) {
        this.subTotalP = subTotalP;
    }

    public Float getSubTotalS() {
        return subTotalS;
    }

    public void setSubTotalS(Float subTotalS) {
        this.subTotalS = subTotalS;
    }

    public int getUsuarioOv() {
        return usuarioOv;
    }

    public void setUsuarioOv(int usuarioOv) {
        this.usuarioOv = usuarioOv;
    }

    public String getFechaVentaOv() {
        return fechaVentaOv;
    }

    public void setFechaVentaOv(String fechaVentaOv) {
        this.fechaVentaOv = fechaVentaOv;
    }

    public Float getAdicionalesCOv() {
        return adicionalesCOv;
    }

    public void setAdicionalesCOv(Float adicionalesCOv) {
        this.adicionalesCOv = adicionalesCOv;
    }

    public Float getAdicionalesPOv() {
        return adicionalesPOv;
    }

    public void setAdicionalesPOv(Float adicionalesPOv) {
        this.adicionalesPOv = adicionalesPOv;
    }

    public Float getAdicionalesEiOv() {
        return adicionalesEiOv;
    }

    public void setAdicionalesEiOv(Float adicionalesEiOv) {
        this.adicionalesEiOv = adicionalesEiOv;
    }

    public Float getAdicionalesElOv() {
        return adicionalesElOv;
    }

    public void setAdicionalesElOv(Float adicionalesElOv) {
        this.adicionalesElOv = adicionalesElOv;
    }

    public Float getAdicionalesSOv() {
        return adicionalesSOv;
    }

    public void setAdicionalesSOv(Float adicionalesSOv) {
        this.adicionalesSOv = adicionalesSOv;
    }

    public short getPDescCta() {
        return pDescCta;
    }

    public void setPDescCta(short pDescCta) {
        this.pDescCta = pDescCta;
    }

    public float getDescDCta() {
        return descDCta;
    }

    public void setDescDCta(float descDCta) {
        this.descDCta = descDCta;
    }

    public float getTDescCta() {
        return tDescCta;
    }

    public void setTDescCta(float tDescCta) {
        this.tDescCta = tDescCta;
    }

    public short getPDescImg() {
        return pDescImg;
    }

    public void setPDescImg(short pDescImg) {
        this.pDescImg = pDescImg;
    }

    public float getDescDImg() {
        return descDImg;
    }

    public void setDescDImg(float descDImg) {
        this.descDImg = descDImg;
    }

    public float getTDescImg() {
        return tDescImg;
    }

    public void setTDescImg(float tDescImg) {
        this.tDescImg = tDescImg;
    }

    public short getPDescLab() {
        return pDescLab;
    }

    public void setPDescLab(short pDescLab) {
        this.pDescLab = pDescLab;
    }

    public float getDescDLab() {
        return descDLab;
    }

    public void setDescDLab(float descDLab) {
        this.descDLab = descDLab;
    }

    public float getTDescLab() {
        return tDescLab;
    }

    public void setTDescLab(float tDescLab) {
        this.tDescLab = tDescLab;
    }

    public short getPDescServ() {
        return pDescServ;
    }

    public void setPDescServ(short pDescServ) {
        this.pDescServ = pDescServ;
    }

    public float getDescDServ() {
        return descDServ;
    }

    public void setDescDServ(float descDServ) {
        this.descDServ = descDServ;
    }

    public float getTDescServ() {
        return tDescServ;
    }

    public void setTDescServ(float tDescServ) {
        this.tDescServ = tDescServ;
    }

    public short getPDescPro() {
        return pDescPro;
    }

    public void setPDescPro(short pDescPro) {
        this.pDescPro = pDescPro;
    }

    public float getDescDPro() {
        return descDPro;
    }

    public void setDescDPro(float descDPro) {
        this.descDPro = descDPro;
    }

    public float getTDescPro() {
        return tDescPro;
    }

    public void setTDescPro(float tDescPro) {
        this.tDescPro = tDescPro;
    }

    public String getMotivoCOv() {
        return motivoCOv;
    }

    public void setMotivoCOv(String motivoCOv) {
        this.motivoCOv = motivoCOv;
    }

    public String getObservacionesIOv() {
        return observacionesIOv;
    }

    public void setObservacionesIOv(String observacionesIOv) {
        this.observacionesIOv = observacionesIOv;
    }

    public String getObservacionesLOv() {
        return observacionesLOv;
    }

    public void setObservacionesLOv(String observacionesLOv) {
        this.observacionesLOv = observacionesLOv;
    }

    public String getObservacionesSOv() {
        return observacionesSOv;
    }

    public void setObservacionesSOv(String observacionesSOv) {
        this.observacionesSOv = observacionesSOv;
    }

    public Integer getMedicoCOv() {
        return medicoCOv;
    }

    public void setMedicoCOv(Integer medicoCOv) {
        this.medicoCOv = medicoCOv;
    }

    public Integer getMedicoEiOv() {
        return medicoEiOv;
    }

    public void setMedicoEiOv(Integer medicoEiOv) {
        this.medicoEiOv = medicoEiOv;
    }

    public Integer getMedicoElOv() {
        return medicoElOv;
    }

    public void setMedicoElOv(Integer medicoElOv) {
        this.medicoElOv = medicoElOv;
    }

    public Integer getPersonalSOv() {
        return personalSOv;
    }

    public void setPersonalSOv(Integer personalSOv) {
        this.personalSOv = personalSOv;
    }

    public String getReferenciaOv() {
        return referenciaOv;
    }

    public void setReferenciaOv(String referenciaOv) {
        this.referenciaOv = referenciaOv;
    }

    public int getContadorOv() {
        return contadorOv;
    }

    public void setContadorOv(int contadorOv) {
        this.contadorOv = contadorOv;
    }

    public Integer getSucursalOv() {
        return sucursalOv;
    }

    public void setSucursalOv(Integer sucursalOv) {
        this.sucursalOv = sucursalOv;
    }

    public String getNoTempOv() {
        return noTempOv;
    }

    public void setNoTempOv(String noTempOv) {
        this.noTempOv = noTempOv;
    }

    public short getFacturadaOv() {
        return facturadaOv;
    }

    public void setFacturadaOv(short facturadaOv) {
        this.facturadaOv = facturadaOv;
    }

    public short getEstatusOv() {
        return estatusOv;
    }

    public void setEstatusOv(short estatusOv) {
        this.estatusOv = estatusOv;
    }

    public short getProcedenciaOv() {
        return procedenciaOv;
    }

    public void setProcedenciaOv(short procedenciaOv) {
        this.procedenciaOv = procedenciaOv;
    }

    public String getMuestrasOv() {
        return muestrasOv;
    }

    public void setMuestrasOv(String muestrasOv) {
        this.muestrasOv = muestrasOv;
    }

    public String getMotivoDescCOv() {
        return motivoDescCOv;
    }

    public void setMotivoDescCOv(String motivoDescCOv) {
        this.motivoDescCOv = motivoDescCOv;
    }

    public String getMotivoDescIOv() {
        return motivoDescIOv;
    }

    public void setMotivoDescIOv(String motivoDescIOv) {
        this.motivoDescIOv = motivoDescIOv;
    }

    public String getMotivoDescLOv() {
        return motivoDescLOv;
    }

    public void setMotivoDescLOv(String motivoDescLOv) {
        this.motivoDescLOv = motivoDescLOv;
    }

    public String getMotivoDescSOv() {
        return motivoDescSOv;
    }

    public void setMotivoDescSOv(String motivoDescSOv) {
        this.motivoDescSOv = motivoDescSOv;
    }

    public String getMotivoDescFOv() {
        return motivoDescFOv;
    }

    public void setMotivoDescFOv(String motivoDescFOv) {
        this.motivoDescFOv = motivoDescFOv;
    }

    public boolean getRequiereFactura() {
        return requiereFactura;
    }

    public void setRequiereFactura(boolean requiereFactura) {
        this.requiereFactura = requiereFactura;
    }

    public boolean getPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    @XmlTransient
    public List<VentaConceptos> getVentaConceptosList() {
        return ventaConceptosList;
    }

    public void setVentaConceptosList(List<VentaConceptos> ventaConceptosList) {
        this.ventaConceptosList = ventaConceptosList;
    }

    @XmlTransient
    public List<PagoOrdenVenta> getPagoOrdenVentaList() {
        return pagoOrdenVentaList;
    }

    public void setPagoOrdenVentaList(List<PagoOrdenVenta> pagoOrdenVentaList) {
        this.pagoOrdenVentaList = pagoOrdenVentaList;
    }

    public CatalogoFormaPago getIdFormaPago() {
        return idFormaPago;
    }

    public void setIdFormaPago(CatalogoFormaPago idFormaPago) {
        this.idFormaPago = idFormaPago;
    }

    public Pacientes getIdPacienteOv() {
        return idPacienteOv;
    }

    public void setIdPacienteOv(Pacientes idPacienteOv) {
        this.idPacienteOv = idPacienteOv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOv != null ? idOv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenVenta)) {
            return false;
        }
        OrdenVenta other = (OrdenVenta) object;
        if ((this.idOv == null && other.idOv != null) || (this.idOv != null && !this.idOv.equals(other.idOv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.gm.sga.domain.OrdenVenta[ idOv=" + idOv + " ]";
    }
    
}
