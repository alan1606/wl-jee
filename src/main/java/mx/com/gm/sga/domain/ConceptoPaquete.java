/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alanm
 */
@Entity
@Table(name = "concepto_paquete")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConceptoPaquete.findAll", query = "SELECT c FROM ConceptoPaquete c"),
    @NamedQuery(name = "ConceptoPaquete.findById", query = "SELECT c FROM ConceptoPaquete c WHERE c.id = :id")})
public class ConceptoPaquete implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;
    @JoinColumn(name = "id_concepto", referencedColumnName = "id_to")
    @ManyToOne(optional = false)
    private Conceptos idConcepto;
    @JoinColumn(name = "id_paquete", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Paquete idPaquete;

    public ConceptoPaquete() {
    }

    public ConceptoPaquete(Long id) {
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

    public Paquete getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(Paquete idPaquete) {
        this.idPaquete = idPaquete;
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
        if (!(object instanceof ConceptoPaquete)) {
            return false;
        }
        ConceptoPaquete other = (ConceptoPaquete) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.gm.sga.domain.ConceptoPaquete[ id=" + id + " ]";
    }
    
}
