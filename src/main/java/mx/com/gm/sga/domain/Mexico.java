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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alanm
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mexico.findAll", query = "SELECT m FROM Mexico m"),
    @NamedQuery(name = "Mexico.findByIdMx", query = "SELECT m FROM Mexico m WHERE m.idMx = :idMx"),
    @NamedQuery(name = "Mexico.findByDCodigo", query = "SELECT m FROM Mexico m WHERE m.dCodigo = :dCodigo"),
    @NamedQuery(name = "Mexico.findByDAsenta", query = "SELECT m FROM Mexico m WHERE m.dAsenta = :dAsenta"),
    @NamedQuery(name = "Mexico.findByDTipoAsenta", query = "SELECT m FROM Mexico m WHERE m.dTipoAsenta = :dTipoAsenta"),
    @NamedQuery(name = "Mexico.findByDMunicipio", query = "SELECT m FROM Mexico m WHERE m.dMunicipio = :dMunicipio"),
    @NamedQuery(name = "Mexico.findByDEstado", query = "SELECT m FROM Mexico m WHERE m.dEstado = :dEstado"),
    @NamedQuery(name = "Mexico.findByDCiudad", query = "SELECT m FROM Mexico m WHERE m.dCiudad = :dCiudad"),
    @NamedQuery(name = "Mexico.findByDCp", query = "SELECT m FROM Mexico m WHERE m.dCp = :dCp"),
    @NamedQuery(name = "Mexico.findByCEstado", query = "SELECT m FROM Mexico m WHERE m.cEstado = :cEstado"),
    @NamedQuery(name = "Mexico.findByCOficina", query = "SELECT m FROM Mexico m WHERE m.cOficina = :cOficina"),
    @NamedQuery(name = "Mexico.findByCCp", query = "SELECT m FROM Mexico m WHERE m.cCp = :cCp"),
    @NamedQuery(name = "Mexico.findByCTipoAsenta", query = "SELECT m FROM Mexico m WHERE m.cTipoAsenta = :cTipoAsenta"),
    @NamedQuery(name = "Mexico.findByCMunicipio", query = "SELECT m FROM Mexico m WHERE m.cMunicipio = :cMunicipio"),
    @NamedQuery(name = "Mexico.findByIdAsentaCpcons", query = "SELECT m FROM Mexico m WHERE m.idAsentaCpcons = :idAsentaCpcons"),
    @NamedQuery(name = "Mexico.findByDZona", query = "SELECT m FROM Mexico m WHERE m.dZona = :dZona"),
    @NamedQuery(name = "Mexico.findByCClaveCiudad", query = "SELECT m FROM Mexico m WHERE m.cClaveCiudad = :cClaveCiudad")})
public class Mexico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_mx")
    private Integer idMx;
    @Column(name = "d_codigo")
    private Integer dCodigo;
    @Size(max = 250)
    @Column(name = "d_asenta")
    private String dAsenta;
    @Size(max = 250)
    @Column(name = "d_tipo_asenta")
    private String dTipoAsenta;
    @Size(max = 250)
    @Column(name = "d_municipio")
    private String dMunicipio;
    @Size(max = 100)
    @Column(name = "d_estado")
    private String dEstado;
    @Size(max = 250)
    @Column(name = "d_ciudad")
    private String dCiudad;
    @Column(name = "d_cp")
    private Integer dCp;
    @Column(name = "c_estado")
    private Short cEstado;
    @Column(name = "c_oficina")
    private Integer cOficina;
    @Column(name = "c_cp")
    private Integer cCp;
    @Column(name = "c_tipo_asenta")
    private Integer cTipoAsenta;
    @Column(name = "c_municipio")
    private Integer cMunicipio;
    @Column(name = "id_asenta_cpcons")
    private Integer idAsentaCpcons;
    @Size(max = 200)
    @Column(name = "d_zona")
    private String dZona;
    @Column(name = "c_clave_ciudad")
    private Integer cClaveCiudad;

    public Mexico() {
    }

    public Mexico(Integer idMx) {
        this.idMx = idMx;
    }

    public Integer getIdMx() {
        return idMx;
    }

    public void setIdMx(Integer idMx) {
        this.idMx = idMx;
    }

    public Integer getDCodigo() {
        return dCodigo;
    }

    public void setDCodigo(Integer dCodigo) {
        this.dCodigo = dCodigo;
    }

    public String getDAsenta() {
        return dAsenta;
    }

    public void setDAsenta(String dAsenta) {
        this.dAsenta = dAsenta;
    }

    public String getDTipoAsenta() {
        return dTipoAsenta;
    }

    public void setDTipoAsenta(String dTipoAsenta) {
        this.dTipoAsenta = dTipoAsenta;
    }

    public String getDMunicipio() {
        return dMunicipio;
    }

    public void setDMunicipio(String dMunicipio) {
        this.dMunicipio = dMunicipio;
    }

    public String getDEstado() {
        return dEstado;
    }

    public void setDEstado(String dEstado) {
        this.dEstado = dEstado;
    }

    public String getDCiudad() {
        return dCiudad;
    }

    public void setDCiudad(String dCiudad) {
        this.dCiudad = dCiudad;
    }

    public Integer getDCp() {
        return dCp;
    }

    public void setDCp(Integer dCp) {
        this.dCp = dCp;
    }

    public Short getCEstado() {
        return cEstado;
    }

    public void setCEstado(Short cEstado) {
        this.cEstado = cEstado;
    }

    public Integer getCOficina() {
        return cOficina;
    }

    public void setCOficina(Integer cOficina) {
        this.cOficina = cOficina;
    }

    public Integer getCCp() {
        return cCp;
    }

    public void setCCp(Integer cCp) {
        this.cCp = cCp;
    }

    public Integer getCTipoAsenta() {
        return cTipoAsenta;
    }

    public void setCTipoAsenta(Integer cTipoAsenta) {
        this.cTipoAsenta = cTipoAsenta;
    }

    public Integer getCMunicipio() {
        return cMunicipio;
    }

    public void setCMunicipio(Integer cMunicipio) {
        this.cMunicipio = cMunicipio;
    }

    public Integer getIdAsentaCpcons() {
        return idAsentaCpcons;
    }

    public void setIdAsentaCpcons(Integer idAsentaCpcons) {
        this.idAsentaCpcons = idAsentaCpcons;
    }

    public String getDZona() {
        return dZona;
    }

    public void setDZona(String dZona) {
        this.dZona = dZona;
    }

    public Integer getCClaveCiudad() {
        return cClaveCiudad;
    }

    public void setCClaveCiudad(Integer cClaveCiudad) {
        this.cClaveCiudad = cClaveCiudad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMx != null ? idMx.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mexico)) {
            return false;
        }
        Mexico other = (Mexico) object;
        if ((this.idMx == null && other.idMx != null) || (this.idMx != null && !this.idMx.equals(other.idMx))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.gm.sga.domain.Mexico[ idMx=" + idMx + " ]";
    }
    
}
