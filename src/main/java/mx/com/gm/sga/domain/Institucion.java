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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
    @NamedQuery(name = "Institucion.findAll", query = "SELECT i FROM Institucion i"),
    @NamedQuery(name = "Institucion.findByIdInstitucion", query = "SELECT i FROM Institucion i WHERE i.idInstitucion = :idInstitucion"),
    @NamedQuery(name = "Institucion.findByNombreInstitucion", query = "SELECT i FROM Institucion i WHERE i.nombreInstitucion = :nombreInstitucion")})
public class Institucion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_institucion")
    private Long idInstitucion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre_institucion")
    private String nombreInstitucion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInstitucion")
    private List<VentaConceptos> ventaConceptosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInstitucion")
    private List<ConceptosInstitucion> conceptosInstitucionList;
    @Column(name = "limite")
    private Integer limite;
        
    public Institucion() {
    }

    public Integer getLimite() {
        return limite;
    }

    public void setLimite(Integer limite) {
        this.limite = limite;
    }

    
    
    public Institucion(Long idInstitucion) {
        this.idInstitucion = idInstitucion;
    }

    public Institucion(Long idInstitucion, String nombreInstitucion) {
        this.idInstitucion = idInstitucion;
        this.nombreInstitucion = nombreInstitucion;
    }

    public Long getIdInstitucion() {
        return idInstitucion;
    }

    public void setIdInstitucion(Long idInstitucion) {
        this.idInstitucion = idInstitucion;
    }

    public String getNombreInstitucion() {
        return nombreInstitucion;
    }

    public void setNombreInstitucion(String nombreInstitucion) {
        this.nombreInstitucion = nombreInstitucion;
    }

    @XmlTransient
    public List<VentaConceptos> getVentaConceptosList() {
        return ventaConceptosList;
    }

    public void setVentaConceptosList(List<VentaConceptos> ventaConceptosList) {
        this.ventaConceptosList = ventaConceptosList;
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
        hash += (idInstitucion != null ? idInstitucion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Institucion)) {
            return false;
        }
        Institucion other = (Institucion) object;
        if ((this.idInstitucion == null && other.idInstitucion != null) || (this.idInstitucion != null && !this.idInstitucion.equals(other.idInstitucion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.gm.sga.domain.Institucion[ idInstitucion=" + idInstitucion + " ]";
    }
    
}
