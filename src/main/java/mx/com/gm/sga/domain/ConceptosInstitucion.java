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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
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
    @NamedQuery(name = "ConceptosInstitucion.findByLimiteDiario", query = "SELECT c FROM ConceptosInstitucion c WHERE c.limiteDiario = :limiteDiario")})
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

    public ConceptosInstitucion() {
    }

    public ConceptosInstitucion(Long id) {
        this.id = id;
    }

    public ConceptosInstitucion(Long id, int limiteDiario) {
        this.id = id;
        this.limiteDiario = limiteDiario;
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
