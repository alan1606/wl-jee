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
import javax.persistence.Lob;
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
    @NamedQuery(name = "Instrucciones.findAll", query = "SELECT i FROM Instrucciones i order by i.nombre"),
    @NamedQuery(name = "Instrucciones.findById", query = "SELECT i FROM Instrucciones i WHERE i.id = :id"),
    @NamedQuery(name = "Instrucciones.findByNombre", query = "SELECT i FROM Instrucciones i WHERE i.nombre = :nombre")})
public class Instrucciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 16777215)
    private String texto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInstrucciones")
    private List<Conceptos> conceptosList;

    public Instrucciones() {
    }

    public Instrucciones(Long id) {
        this.id = id;
    }

    public Instrucciones(Long id, String texto, String nombre) {
        this.id = id;
        this.texto = texto;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Conceptos> getConceptosList() {
        return conceptosList;
    }

    public void setConceptosList(List<Conceptos> conceptosList) {
        this.conceptosList = conceptosList;
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
        if (!(object instanceof Instrucciones)) {
            return false;
        }
        Instrucciones other = (Instrucciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.gm.sga.domain.Instrucciones[ id=" + id + " ]";
    }
    
}
