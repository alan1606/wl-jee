/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alanm
 */
@Entity
@Table(name = "conceptos_institucion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConceptosInstitucion.findAll", query = "SELECT c FROM ConceptosInstitucion c"),
    @NamedQuery(name = "ConceptosInstitucion.findById", query = "SELECT c FROM ConceptosInstitucion c WHERE c.id = :id"),
    @NamedQuery(name = "ConceptosInstitucion.findByLimiteDiario", query = "SELECT c FROM ConceptosInstitucion c WHERE c.limiteDiario = :limiteDiario"),
    @NamedQuery(name = "ConceptosInstitucion.findByPrecio", query = "SELECT c FROM ConceptosInstitucion c WHERE c.precio = :precio"),
    @NamedQuery(name = "ConceptosInstitucion.findByPrecioPublico", query = "SELECT c FROM ConceptosInstitucion c WHERE c.precioPublico = :precioPublico"),
    @NamedQuery(name = "ConceptosInstitucion.findByActivo", query = "SELECT c FROM ConceptosInstitucion c WHERE c.activo = :activo"),
    @NamedQuery(name = "ConceptosInstitucion.findByIdInternoInstitucion", query = "SELECT c FROM ConceptosInstitucion c WHERE c.idInternoInstitucion = :idInternoInstitucion"),
    @NamedQuery(name = "ConceptosInstitucion.findByPensionesClaveAnterior", query = "SELECT c FROM ConceptosInstitucion c WHERE c.pensionesClaveAnterior = :pensionesClaveAnterior")})
public class ConceptosInstitucion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "limite_diario")
    private int limiteDiario;
    @Basic(optional = false)
    @NotNull
    private double precio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_publico")
    private double precioPublico;
    @Basic(optional = false)
    @NotNull
    private boolean activo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "id_interno_institucion")
    private String idInternoInstitucion;
    @Size(max = 10)
    @Column(name = "pensiones_clave_anterior")
    private String pensionesClaveAnterior;
    @JoinColumn(name = "id_concepto", referencedColumnName = "id_to")
    @ManyToOne(optional = false)
    private Conceptos idConcepto;
    @JoinColumn(name = "id_institucion", referencedColumnName = "id_institucion")
    @ManyToOne(optional = false)
    private Institucion idInstitucion;

    public ConceptosInstitucion() {
    }

    public ConceptosInstitucion(Long id) {
        this.id = id;
    }

    public ConceptosInstitucion(Long id, int limiteDiario, double precio, double precioPublico, boolean activo, String idInternoInstitucion) {
        this.id = id;
        this.limiteDiario = limiteDiario;
        this.precio = precio;
        this.precioPublico = precioPublico;
        this.activo = activo;
        this.idInternoInstitucion = idInternoInstitucion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getLimiteDiario() {
        return limiteDiario;
    }

    public void setLimiteDiario(int limiteDiario) {
        this.limiteDiario = limiteDiario;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPrecioPublico() {
        return precioPublico;
    }

    public void setPrecioPublico(double precioPublico) {
        this.precioPublico = precioPublico;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getIdInternoInstitucion() {
        return idInternoInstitucion;
    }

    public void setIdInternoInstitucion(String idInternoInstitucion) {
        this.idInternoInstitucion = idInternoInstitucion;
    }

    public String getPensionesClaveAnterior() {
        return pensionesClaveAnterior;
    }

    public void setPensionesClaveAnterior(String pensionesClaveAnterior) {
        this.pensionesClaveAnterior = pensionesClaveAnterior;
    }

    public Conceptos getIdConcepto() {
        return idConcepto;
    }

    public void setIdConcepto(Conceptos idConcepto) {
        this.idConcepto = idConcepto;
    }

    public Institucion getIdInstitucion() {
        return idInstitucion;
    }

    public void setIdInstitucion(Institucion idInstitucion) {
        this.idInstitucion = idInstitucion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConceptosInstitucion)) {
            return false;
        }
        ConceptosInstitucion other = (ConceptosInstitucion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.gm.sga.domain.ConceptosInstitucion[ id=" + id + " ]";
    }
    
}
