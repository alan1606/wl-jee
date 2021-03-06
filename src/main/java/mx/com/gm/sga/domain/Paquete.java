/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alanm
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paquete.findAll", query = "SELECT p FROM Paquete p"),
    @NamedQuery(name = "Paquete.findById", query = "SELECT p FROM Paquete p WHERE p.id = :id"),
    @NamedQuery(name = "Paquete.findByFechaInicio", query = "SELECT p FROM Paquete p WHERE p.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Paquete.findByFechaFin", query = "SELECT p FROM Paquete p WHERE p.fechaFin = :fechaFin"),
    @NamedQuery(name = "Paquete.findByPrecio", query = "SELECT p FROM Paquete p WHERE p.precio = :precio"),
    @NamedQuery(name = "Paquete.findByPorcentajeDescuento", query = "SELECT p FROM Paquete p WHERE p.porcentajeDescuento = :porcentajeDescuento"),
    @NamedQuery(name = "Paquete.findByPrecioSinDescuento", query = "SELECT p FROM Paquete p WHERE p.precioSinDescuento = :precioSinDescuento")})
public class Paquete implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio")
    private String fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_fin")
    private String fechaFin;
    @Basic(optional = false)
    @NotNull
    private double precio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "porcentaje_descuento")
    private short porcentajeDescuento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_sin_descuento")
    private double precioSinDescuento;
    @JoinColumn(name = "id_concepto", referencedColumnName = "id_to")
    @ManyToOne(optional = false)
    private Conceptos idConcepto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPaquete")
    private List<ConceptoPaquete> conceptoPaqueteList;

    public Paquete() {
    }

    public Paquete(Long id) {
        this.id = id;
    }

    public Paquete(Long id, String fechaInicio, String fechaFin, double precio, short porcentajeDescuento, double precioSinDescuento) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precio = precio;
        this.porcentajeDescuento = porcentajeDescuento;
        this.precioSinDescuento = precioSinDescuento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public short getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(short porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public double getPrecioSinDescuento() {
        return precioSinDescuento;
    }

    public void setPrecioSinDescuento(double precioSinDescuento) {
        this.precioSinDescuento = precioSinDescuento;
    }

    public Conceptos getIdConcepto() {
        return idConcepto;
    }

    public void setIdConcepto(Conceptos idConcepto) {
        this.idConcepto = idConcepto;
    }

    @XmlTransient
    public List<ConceptoPaquete> getConceptoPaqueteList() {
        return conceptoPaqueteList;
    }

    public void setConceptoPaqueteList(List<ConceptoPaquete> conceptoPaqueteList) {
        this.conceptoPaqueteList = conceptoPaqueteList;
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
        if (!(object instanceof Paquete)) {
            return false;
        }
        Paquete other = (Paquete) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.gm.sga.domain.Paquete[ id=" + id + " ]";
    }
    
}
