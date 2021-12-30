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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alanm
 */
@Entity
@Table(name = "pago_orden_venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PagoOrdenVenta.findAll", query = "SELECT p FROM PagoOrdenVenta p"),
    @NamedQuery(name = "PagoOrdenVenta.findById", query = "SELECT p FROM PagoOrdenVenta p WHERE p.id = :id"),
    @NamedQuery(name = "PagoOrdenVenta.findByCantidad", query = "SELECT p FROM PagoOrdenVenta p WHERE p.cantidad = :cantidad")})
public class PagoOrdenVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    private double cantidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPagoOrdenVenta")
    private List<DatosFacturacion> datosFacturacionList;
    @JoinColumn(name = "id_forma_pago", referencedColumnName = "id_fp")
    @ManyToOne(optional = false)
    private CatalogoFormaPago idFormaPago;
    @JoinColumn(name = "id_orden_venta", referencedColumnName = "id_ov")
    @ManyToOne(optional = false)
    private OrdenVenta idOrdenVenta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPagoOrdenVenta")
    private List<Devolucion> devolucionList;

    public PagoOrdenVenta() {
    }

    public PagoOrdenVenta(Long id) {
        this.id = id;
    }

    public PagoOrdenVenta(Long id, double cantidad) {
        this.id = id;
        this.cantidad = cantidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    @XmlTransient
    public List<DatosFacturacion> getDatosFacturacionList() {
        return datosFacturacionList;
    }

    public void setDatosFacturacionList(List<DatosFacturacion> datosFacturacionList) {
        this.datosFacturacionList = datosFacturacionList;
    }

    public CatalogoFormaPago getIdFormaPago() {
        return idFormaPago;
    }

    public void setIdFormaPago(CatalogoFormaPago idFormaPago) {
        this.idFormaPago = idFormaPago;
    }

    public OrdenVenta getIdOrdenVenta() {
        return idOrdenVenta;
    }

    public void setIdOrdenVenta(OrdenVenta idOrdenVenta) {
        this.idOrdenVenta = idOrdenVenta;
    }

    @XmlTransient
    public List<Devolucion> getDevolucionList() {
        return devolucionList;
    }

    public void setDevolucionList(List<Devolucion> devolucionList) {
        this.devolucionList = devolucionList;
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
        if (!(object instanceof PagoOrdenVenta)) {
            return false;
        }
        PagoOrdenVenta other = (PagoOrdenVenta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.gm.sga.domain.PagoOrdenVenta[ id=" + id + " ]";
    }
    
}
