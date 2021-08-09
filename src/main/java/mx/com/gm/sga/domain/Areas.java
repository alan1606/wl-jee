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
    @NamedQuery(name = "Areas.findAll", query = "SELECT a FROM Areas a"),
    @NamedQuery(name = "Areas.findByIdA", query = "SELECT a FROM Areas a WHERE a.idA = :idA"),
    @NamedQuery(name = "Areas.findByDepartamentoA", query = "SELECT a FROM Areas a WHERE a.departamentoA = :departamentoA"),
    @NamedQuery(name = "Areas.findByClaveA", query = "SELECT a FROM Areas a WHERE a.claveA = :claveA"),
    @NamedQuery(name = "Areas.findByNombreA", query = "SELECT a FROM Areas a WHERE a.nombreA = :nombreA"),
    @NamedQuery(name = "Areas.findByUsuarioA", query = "SELECT a FROM Areas a WHERE a.usuarioA = :usuarioA"),
    @NamedQuery(name = "Areas.findByFechaA", query = "SELECT a FROM Areas a WHERE a.fechaA = :fechaA"),
    @NamedQuery(name = "Areas.findByHoraInicio", query = "SELECT a FROM Areas a WHERE a.horaInicio = :horaInicio"),
    @NamedQuery(name = "Areas.findByHoraFin", query = "SELECT a FROM Areas a WHERE a.horaFin = :horaFin"),
    @NamedQuery(name = "Areas.findByDuracionMinutos", query = "SELECT a FROM Areas a WHERE a.duracionMinutos = :duracionMinutos")})
public class Areas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_a")
    private Integer idA;
    @Basic(optional = false)
    @NotNull
    @Column(name = "departamento_a")
    private int departamentoA;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "clave_a")
    private String claveA;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_a")
    private String nombreA;
    @Column(name = "usuario_a")
    private Integer usuarioA;
    @Column(name = "fecha_a")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaA;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora_inicio")
    @Temporal(TemporalType.TIME)
    private Date horaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora_fin")
    @Temporal(TemporalType.TIME)
    private Date horaFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "duracion_minutos")
    private int duracionMinutos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "areas")
    private List<EquipoDicom> equipoDicomList;

    public Areas() {
    }

    public Areas(Integer idA) {
        this.idA = idA;
    }

    public Areas(Integer idA, int departamentoA, String claveA, String nombreA, Date horaInicio, Date horaFin, int duracionMinutos) {
        this.idA = idA;
        this.departamentoA = departamentoA;
        this.claveA = claveA;
        this.nombreA = nombreA;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.duracionMinutos = duracionMinutos;
    }

    public Integer getIdA() {
        return idA;
    }

    public void setIdA(Integer idA) {
        this.idA = idA;
    }

    public int getDepartamentoA() {
        return departamentoA;
    }

    public void setDepartamentoA(int departamentoA) {
        this.departamentoA = departamentoA;
    }

    public String getClaveA() {
        return claveA;
    }

    public void setClaveA(String claveA) {
        this.claveA = claveA;
    }

    public String getNombreA() {
        return nombreA;
    }

    public void setNombreA(String nombreA) {
        this.nombreA = nombreA;
    }

    public Integer getUsuarioA() {
        return usuarioA;
    }

    public void setUsuarioA(Integer usuarioA) {
        this.usuarioA = usuarioA;
    }

    public Date getFechaA() {
        return fechaA;
    }

    public void setFechaA(Date fechaA) {
        this.fechaA = fechaA;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    @XmlTransient
    public List<EquipoDicom> getEquipoDicomList() {
        return equipoDicomList;
    }

    public void setEquipoDicomList(List<EquipoDicom> equipoDicomList) {
        this.equipoDicomList = equipoDicomList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idA != null ? idA.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Areas)) {
            return false;
        }
        Areas other = (Areas) object;
        if ((this.idA == null && other.idA != null) || (this.idA != null && !this.idA.equals(other.idA))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.gm.sga.domain.Areas[ idA=" + idA + " ]";
    }
    
}
