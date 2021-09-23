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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alanm
 */
@Entity
@Table(name = "movimiento_corte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MovimientoCorte.findAll", query = "SELECT m FROM MovimientoCorte m"),
    @NamedQuery(name = "MovimientoCorte.findById", query = "SELECT m FROM MovimientoCorte m WHERE m.id = :id"),
    @NamedQuery(name = "MovimientoCorte.findByDescripcion", query = "SELECT m FROM MovimientoCorte m WHERE m.descripcion = :descripcion"),
    @NamedQuery(name = "MovimientoCorte.findByEntrada", query = "SELECT m FROM MovimientoCorte m WHERE m.entrada = :entrada"),
    @NamedQuery(name = "MovimientoCorte.findByFecha", query = "SELECT m FROM MovimientoCorte m WHERE m.fecha = :fecha"),
    @NamedQuery(name = "MovimientoCorte.findByCantidad", query = "SELECT m FROM MovimientoCorte m WHERE m.cantidad = :cantidad")})
public class MovimientoCorte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    private boolean entrada;
    @Basic(optional = false)
    @NotNull
    private String fecha;
    @Basic(optional = false)
    @NotNull
    private double cantidad;

    public MovimientoCorte() {
    }

    public MovimientoCorte(Long id) {
        this.id = id;
    }

    public MovimientoCorte(Long id, String descripcion, boolean entrada, String fecha, double cantidad) {
        this.id = id;
        this.descripcion = descripcion;
        this.entrada = entrada;
        this.fecha = fecha;
        this.cantidad = cantidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean getEntrada() {
        return entrada;
    }

    public void setEntrada(boolean entrada) {
        this.entrada = entrada;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
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
        if (!(object instanceof MovimientoCorte)) {
            return false;
        }
        MovimientoCorte other = (MovimientoCorte) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.gm.sga.domain.MovimientoCorte[ id=" + id + " ]";
    }
    
}
