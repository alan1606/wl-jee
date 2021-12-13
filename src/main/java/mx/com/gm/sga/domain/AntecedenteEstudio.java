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
@Table(name = "antecedente_estudio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AntecedenteEstudio.findAll", query = "SELECT a FROM AntecedenteEstudio a"),
    @NamedQuery(name = "AntecedenteEstudio.findById", query = "SELECT a FROM AntecedenteEstudio a WHERE a.id = :id")})
public class AntecedenteEstudio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;
    @JoinColumn(name = "id_antecedente", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Antecedentes idAntecedente;

    public AntecedenteEstudio() {
    }

    public AntecedenteEstudio(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Antecedentes getIdAntecedente() {
        return idAntecedente;
    }

    public void setIdAntecedente(Antecedentes idAntecedente) {
        this.idAntecedente = idAntecedente;
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
        if (!(object instanceof AntecedenteEstudio)) {
            return false;
        }
        AntecedenteEstudio other = (AntecedenteEstudio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.gm.sga.domain.AntecedenteEstudio[ id=" + id + " ]";
    }
    
}
