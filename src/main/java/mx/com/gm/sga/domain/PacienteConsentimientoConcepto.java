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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alanm
 */
@Entity
@Table(name = "paciente_consentimiento_concepto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PacienteConsentimientoConcepto.findAll", query = "SELECT p FROM PacienteConsentimientoConcepto p"),
    @NamedQuery(name = "PacienteConsentimientoConcepto.findById", query = "SELECT p FROM PacienteConsentimientoConcepto p WHERE p.id = :id"),
    @NamedQuery(name = "PacienteConsentimientoConcepto.findByFecha", query = "SELECT p FROM PacienteConsentimientoConcepto p WHERE p.fecha = :fecha")})
public class PacienteConsentimientoConcepto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "id_consentimiento_concepto", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ConsentimientoConcepto idConsentimientoConcepto;
    @JoinColumn(name = "id_paciente", referencedColumnName = "id_p")
    @ManyToOne(optional = false)
    private Pacientes idPaciente;

    public PacienteConsentimientoConcepto() {
    }

    public PacienteConsentimientoConcepto(Long id) {
        this.id = id;
    }

    public PacienteConsentimientoConcepto(Long id, Date fecha) {
        this.id = id;
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ConsentimientoConcepto getIdConsentimientoConcepto() {
        return idConsentimientoConcepto;
    }

    public void setIdConsentimientoConcepto(ConsentimientoConcepto idConsentimientoConcepto) {
        this.idConsentimientoConcepto = idConsentimientoConcepto;
    }

    public Pacientes getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Pacientes idPaciente) {
        this.idPaciente = idPaciente;
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
        if (!(object instanceof PacienteConsentimientoConcepto)) {
            return false;
        }
        PacienteConsentimientoConcepto other = (PacienteConsentimientoConcepto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.gm.sga.domain.PacienteConsentimientoConcepto[ id=" + id + " ]";
    }
    
}
