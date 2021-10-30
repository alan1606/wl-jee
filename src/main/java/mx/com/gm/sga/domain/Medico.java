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
    @NamedQuery(name = "Medico.findAll", query = "SELECT m FROM Medico m"),
    @NamedQuery(name = "Medico.findById", query = "SELECT m FROM Medico m WHERE m.id = :id"),
    @NamedQuery(name = "Medico.findByNombres", query = "SELECT m FROM Medico m WHERE m.nombres = :nombres"),
    @NamedQuery(name = "Medico.findByApellidos", query = "SELECT m FROM Medico m WHERE m.apellidos = :apellidos"),
    @NamedQuery(name = "Medico.findByEspecialidad", query = "SELECT m FROM Medico m WHERE m.especialidad = :especialidad"),
    @NamedQuery(name = "Medico.findByTelefono", query = "SELECT m FROM Medico m WHERE m.telefono = :telefono"),
    @NamedQuery(name = "Medico.findByCorreo", query = "SELECT m FROM Medico m WHERE m.correo = :correo"),
    @NamedQuery(name = "Medico.findByDireccion", query = "SELECT m FROM Medico m WHERE m.direccion = :direccion"),
    @NamedQuery(name = "Medico.findByFechaNacimiento", query = "SELECT m FROM Medico m WHERE m.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Medico.findByWhatsapp", query = "SELECT m FROM Medico m WHERE m.whatsapp = :whatsapp"),
    @NamedQuery(name = "Medico.findByToken", query = "SELECT m FROM Medico m WHERE m.token = :token"),
    @NamedQuery(name = "Medico.findByRadiologo", query = "SELECT m FROM Medico m WHERE m.radiologo = :radiologo")})
public class Medico implements Serializable {

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
    private String especialidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_nacimiento")
    private String fechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    private String whatsapp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    private String token;
    @Basic(optional = false)
    @NotNull
    private boolean radiologo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMedicoRadiologo")
    private List<VentaConceptos> ventaConceptosList;

    public Medico() {
    }

    public Medico(Integer id) {
        this.id = id;
    }

    public Medico(Integer id, String nombres, String apellidos, String especialidad, String telefono, String correo, String direccion, String fechaNacimiento, String whatsapp, String token, boolean radiologo) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.especialidad = especialidad;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.whatsapp = whatsapp;
        this.token = token;
        this.radiologo = radiologo;
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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean getRadiologo() {
        return radiologo;
    }

    public void setRadiologo(boolean radiologo) {
        this.radiologo = radiologo;
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
        if (!(object instanceof Medico)) {
            return false;
        }
        Medico other = (Medico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.gm.sga.domain.Medico[ id=" + id + " ]";
    }
    
}
