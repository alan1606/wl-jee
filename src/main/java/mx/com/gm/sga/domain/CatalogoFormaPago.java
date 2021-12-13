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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alanm
 */
@Entity
@Table(name = "catalogo_forma_pago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatalogoFormaPago.findAll", query = "SELECT c FROM CatalogoFormaPago c"),
    @NamedQuery(name = "CatalogoFormaPago.findByIdFp", query = "SELECT c FROM CatalogoFormaPago c WHERE c.idFp = :idFp"),
    @NamedQuery(name = "CatalogoFormaPago.findByFormaPagoFp", query = "SELECT c FROM CatalogoFormaPago c WHERE c.formaPagoFp = :formaPagoFp")})
public class CatalogoFormaPago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_fp")
    private Short idFp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "forma_pago_fp")
    private String formaPagoFp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFormaPago")
    private List<Devolucion> devolucionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFormaPago")
    private List<PagoOrdenVenta> pagoOrdenVentaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFormaPago")
    private List<OrdenVenta> ordenVentaList;

    public CatalogoFormaPago() {
    }

    public CatalogoFormaPago(Short idFp) {
        this.idFp = idFp;
    }

    public CatalogoFormaPago(Short idFp, String formaPagoFp) {
        this.idFp = idFp;
        this.formaPagoFp = formaPagoFp;
    }

    public Short getIdFp() {
        return idFp;
    }

    public void setIdFp(Short idFp) {
        this.idFp = idFp;
    }

    public String getFormaPagoFp() {
        return formaPagoFp;
    }

    public void setFormaPagoFp(String formaPagoFp) {
        this.formaPagoFp = formaPagoFp;
    }

    @XmlTransient
    public List<Devolucion> getDevolucionList() {
        return devolucionList;
    }

    public void setDevolucionList(List<Devolucion> devolucionList) {
        this.devolucionList = devolucionList;
    }

    @XmlTransient
    public List<PagoOrdenVenta> getPagoOrdenVentaList() {
        return pagoOrdenVentaList;
    }

    public void setPagoOrdenVentaList(List<PagoOrdenVenta> pagoOrdenVentaList) {
        this.pagoOrdenVentaList = pagoOrdenVentaList;
    }

    @XmlTransient
    public List<OrdenVenta> getOrdenVentaList() {
        return ordenVentaList;
    }

    public void setOrdenVentaList(List<OrdenVenta> ordenVentaList) {
        this.ordenVentaList = ordenVentaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFp != null ? idFp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatalogoFormaPago)) {
            return false;
        }
        CatalogoFormaPago other = (CatalogoFormaPago) object;
        if ((this.idFp == null && other.idFp != null) || (this.idFp != null && !this.idFp.equals(other.idFp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.gm.sga.domain.CatalogoFormaPago[ idFp=" + idFp + " ]";
    }
    
}
