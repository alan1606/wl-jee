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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    @NamedQuery(name = "Tecnico.findAll", query = "SELECT t FROM Tecnico t"),
    @NamedQuery(name = "Tecnico.findById", query = "SELECT t FROM Tecnico t WHERE t.id = :id"),
    @NamedQuery(name = "Tecnico.findByNombres", query = "SELECT t FROM Tecnico t WHERE t.nombres = :nombres"),
    @NamedQuery(name = "Tecnico.findByApellidos", query = "SELECT t FROM Tecnico t WHERE t.apellidos = :apellidos"),
    @NamedQuery(name = "Tecnico.findByCorreo", query = "SELECT t FROM Tecnico t WHERE t.correo = :correo"),
    @NamedQuery(name = "Tecnico.findByTelefono", query = "SELECT t FROM Tecnico t WHERE t.telefono = :telefono"),
    @NamedQuery(name = "Tecnico.findByFechaNacimiento", query = "SELECT t FROM Tecnico t WHERE t.fechaNacimiento = :fechaNacimiento")})
public class Tecnico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_nacimiento")
    private String  fechaNacimiento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTecnico")
    private List<VentaConceptos> ventaConceptosList;

    public Tecnico() {
    }

    public Tecnico(Integer id) {
        this.id = id;
    }

    public Tecnico(Integer id, String nombres, String apellidos, String correo, String telefono, String fechaNacimiento) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @XmlTransient
    public List<VentaConceptos> getVentaConceptosList() {
        return ventaConceptosList;
    }

    public void setVentaConceptosList(List<VentaConceptos> ventaConceptosList) {
        this.ventaConceptosList = ventaConceptosList;
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
        if (!(object instanceof Tecnico)) {
            return false;
        }
        Tecnico other = (Tecnico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.gm.sga.domain.Tecnico[ id=" + id + " ]";
    }
    
}
