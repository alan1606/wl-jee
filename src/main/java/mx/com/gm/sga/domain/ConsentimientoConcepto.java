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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alanm
 */
@Entity
@Table(name = "consentimiento_concepto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConsentimientoConcepto.findAll", query = "SELECT c FROM ConsentimientoConcepto c"),
    @NamedQuery(name = "ConsentimientoConcepto.findById", query = "SELECT c FROM ConsentimientoConcepto c WHERE c.id = :id")})
public class ConsentimientoConcepto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;
    @JoinColumn(name = "id_concepto", referencedColumnName = "id_to")
    @ManyToOne(optional = false)
    private Conceptos idConcepto;
    @JoinColumn(name = "id_consentimiento", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Consentimiento idConsentimiento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConsentimientoConcepto")
    private List<PacienteConsentimientoConcepto> pacienteConsentimientoConceptoList;

    public ConsentimientoConcepto() {
    }

    public ConsentimientoConcepto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Conceptos getIdConcepto() {
        return idConcepto;
    }

    public void setIdConcepto(Conceptos idConcepto) {
        this.idConcepto = idConcepto;
    }

    public Consentimiento getIdConsentimiento() {
        return idConsentimiento;
    }

    public void setIdConsentimiento(Consentimiento idConsentimiento) {
        this.idConsentimiento = idConsentimiento;
    }

    @XmlTransient
    public List<PacienteConsentimientoConcepto> getPacienteConsentimientoConceptoList() {
        return pacienteConsentimientoConceptoList;
    }

    public void setPacienteConsentimientoConceptoList(List<PacienteConsentimientoConcepto> pacienteConsentimientoConceptoList) {
        this.pacienteConsentimientoConceptoList = pacienteConsentimientoConceptoList;
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
        if (!(object instanceof ConsentimientoConcepto)) {
            return false;
        }
        ConsentimientoConcepto other = (ConsentimientoConcepto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.gm.sga.domain.ConsentimientoConcepto[ id=" + id + " ]";
    }
    
}
