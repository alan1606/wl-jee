/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alanm
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Devolucion.findAll", query = "SELECT d FROM Devolucion d"),
    @NamedQuery(name = "Devolucion.findById", query = "SELECT d FROM Devolucion d WHERE d.id = :id"),
    @NamedQuery(name = "Devolucion.findByFecha", query = "SELECT d FROM Devolucion d WHERE d.fecha = :fecha")})
public class Devolucion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    private String fecha;
    @JoinColumn(name = "id_forma_pago", referencedColumnName = "id_fp")
    @ManyToOne(optional = false)
    private CatalogoFormaPago idFormaPago;
    @JoinColumn(name = "id_orden_venta", referencedColumnName = "id_ov")
    @ManyToOne(optional = false)
    private OrdenVenta idOrdenVenta;
    @JoinColumn(name = "id_pago_orden_venta", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PagoOrdenVenta idPagoOrdenVenta;

    public Devolucion() {
    }

    public Devolucion(Long id) {
        this.id = id;
    }

    public Devolucion(Long id, String fecha) {
        this.id = id;
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
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

    public PagoOrdenVenta getIdPagoOrdenVenta() {
        return idPagoOrdenVenta;
    }

    public void setIdPagoOrdenVenta(PagoOrdenVenta idPagoOrdenVenta) {
        this.idPagoOrdenVenta = idPagoOrdenVenta;
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
        if (!(object instanceof Devolucion)) {
            return false;
        }
        Devolucion other = (Devolucion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.gm.sga.domain.Devolucion[ id=" + id + " ]";
    }
    
}
