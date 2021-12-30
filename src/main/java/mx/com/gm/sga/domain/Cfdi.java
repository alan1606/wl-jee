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
    @NamedQuery(name = "Cfdi.findAll", query = "SELECT c FROM Cfdi c"),
    @NamedQuery(name = "Cfdi.findByClave", query = "SELECT c FROM Cfdi c WHERE c.clave = :clave"),
    @NamedQuery(name = "Cfdi.findByDescripcion", query = "SELECT c FROM Cfdi c WHERE c.descripcion = :descripcion")})
public class Cfdi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    private String clave;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCfdi")
    private List<DatosFacturacion> datosFacturacionList;

    public Cfdi() {
    }

    public Cfdi(String clave) {
        this.clave = clave;
    }

    public Cfdi(String clave, String descripcion) {
        this.clave = clave;
        this.descripcion = descripcion;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<DatosFacturacion> getDatosFacturacionList() {
        return datosFacturacionList;
    }

    public void setDatosFacturacionList(List<DatosFacturacion> datosFacturacionList) {
        this.datosFacturacionList = datosFacturacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clave != null ? clave.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cfdi)) {
            return false;
        }
        Cfdi other = (Cfdi) object;
        if ((this.clave == null && other.clave != null) || (this.clave != null && !this.clave.equals(other.clave))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.gm.sga.domain.Cfdi[ clave=" + clave + " ]";
    }
    
}
