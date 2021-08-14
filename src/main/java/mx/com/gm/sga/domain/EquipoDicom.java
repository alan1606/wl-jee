/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alanm
 */
@Entity
@Table(name = "equipo_dicom")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EquipoDicom.findAll", query = "SELECT e FROM EquipoDicom e"),
    @NamedQuery(name = "EquipoDicom.findByIdEquipo", query = "SELECT e FROM EquipoDicom e WHERE e.idEquipo = :idEquipo"),
    @NamedQuery(name = "EquipoDicom.findByModalidad", query = "SELECT e FROM EquipoDicom e WHERE e.modalidad = :modalidad"),
    @NamedQuery(name = "EquipoDicom.findByNombre", query = "SELECT e FROM EquipoDicom e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "EquipoDicom.findByAeTitle", query = "SELECT e FROM EquipoDicom e WHERE e.aeTitle = :aeTitle")})
@XmlAccessorType(XmlAccessType.FIELD)
public class EquipoDicom implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_equipo")
    private Long idEquipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    private String modalidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ae_title")
    private String aeTitle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEquipoDicom")
    private List<VentaConceptos> ventaConceptosList;
    @JoinColumn(name = "id_area", referencedColumnName = "id_a")
    @ManyToOne(optional = false)
    private Areas idArea;

    public EquipoDicom() {
    }

    public EquipoDicom(Long idEquipo) {
        this.idEquipo = idEquipo;
    }

    public EquipoDicom(Long idEquipo, String modalidad, String nombre, String aeTitle) {
        this.idEquipo = idEquipo;
        this.modalidad = modalidad;
        this.nombre = nombre;
        this.aeTitle = aeTitle;
    }

    public Long getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Long idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAeTitle() {
        return aeTitle;
    }

    public void setAeTitle(String aeTitle) {
        this.aeTitle = aeTitle;
    }

    @XmlTransient
    public List<VentaConceptos> getVentaConceptosList() {
        return ventaConceptosList;
    }

    public void setVentaConceptosList(List<VentaConceptos> ventaConceptosList) {
        this.ventaConceptosList = ventaConceptosList;
    }

    public Areas getIdArea() {
        return idArea;
    }

    public void setIdArea(Areas idArea) {
        this.idArea = idArea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEquipo != null ? idEquipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EquipoDicom)) {
            return false;
        }
        EquipoDicom other = (EquipoDicom) object;
        if ((this.idEquipo == null && other.idEquipo != null) || (this.idEquipo != null && !this.idEquipo.equals(other.idEquipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.gm.sga.domain.EquipoDicom[ idEquipo=" + idEquipo + " ]";
    }
    
}
