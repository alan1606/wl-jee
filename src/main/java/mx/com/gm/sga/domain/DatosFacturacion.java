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
@Table(name = "datos_facturacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DatosFacturacion.findAll", query = "SELECT d FROM DatosFacturacion d"),
    @NamedQuery(name = "DatosFacturacion.findById", query = "SELECT d FROM DatosFacturacion d WHERE d.id = :id"),
    @NamedQuery(name = "DatosFacturacion.findByNombreORazon", query = "SELECT d FROM DatosFacturacion d WHERE d.nombreORazon = :nombreORazon"),
    @NamedQuery(name = "DatosFacturacion.findByRfc", query = "SELECT d FROM DatosFacturacion d WHERE d.rfc = :rfc"),
    @NamedQuery(name = "DatosFacturacion.findByCalle", query = "SELECT d FROM DatosFacturacion d WHERE d.calle = :calle"),
    @NamedQuery(name = "DatosFacturacion.findByColonia", query = "SELECT d FROM DatosFacturacion d WHERE d.colonia = :colonia"),
    @NamedQuery(name = "DatosFacturacion.findByCp", query = "SELECT d FROM DatosFacturacion d WHERE d.cp = :cp"),
    @NamedQuery(name = "DatosFacturacion.findByCiudad", query = "SELECT d FROM DatosFacturacion d WHERE d.ciudad = :ciudad"),
    @NamedQuery(name = "DatosFacturacion.findByCorreo", query = "SELECT d FROM DatosFacturacion d WHERE d.correo = :correo")})
public class DatosFacturacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nombre_o_razon")
    private String nombreORazon;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    private String rfc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    private String calle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    private String colonia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    private String cp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    private String ciudad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    private String correo;
    @JoinColumn(name = "id_cfdi", referencedColumnName = "clave")
    @ManyToOne(optional = false)
    private Cfdi idCfdi;
    @JoinColumn(name = "id_pago_orden_venta", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PagoOrdenVenta idPagoOrdenVenta;

    public DatosFacturacion() {
    }

    public DatosFacturacion(Long id) {
        this.id = id;
    }

    public DatosFacturacion(Long id, String nombreORazon, String rfc, String calle, String colonia, String cp, String ciudad, String correo) {
        this.id = id;
        this.nombreORazon = nombreORazon;
        this.rfc = rfc;
        this.calle = calle;
        this.colonia = colonia;
        this.cp = cp;
        this.ciudad = ciudad;
        this.correo = correo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreORazon() {
        return nombreORazon;
    }

    public void setNombreORazon(String nombreORazon) {
        this.nombreORazon = nombreORazon;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Cfdi getIdCfdi() {
        return idCfdi;
    }

    public void setIdCfdi(Cfdi idCfdi) {
        this.idCfdi = idCfdi;
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
        if (!(object instanceof DatosFacturacion)) {
            return false;
        }
        DatosFacturacion other = (DatosFacturacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.gm.sga.domain.DatosFacturacion[ id=" + id + " ]";
    }
    
}
