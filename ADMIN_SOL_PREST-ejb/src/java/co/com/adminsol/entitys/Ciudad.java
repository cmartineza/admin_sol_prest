/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminsol.entitys;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MARA
 */
@Entity
@Table(name = "CIUDAD", catalog = "", schema = "ADM_ARCHIVOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciudad.findAll", query = "SELECT c FROM Ciudad c"),
    @NamedQuery(name = "Ciudad.findByCiudadId", query = "SELECT c FROM Ciudad c WHERE c.ciudadId = :ciudadId"),
    @NamedQuery(name = "Ciudad.findByNombreCiudad", query = "SELECT c FROM Ciudad c WHERE c.nombreCiudad = :nombreCiudad")})
public class Ciudad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CIUDAD_ID")
    @SequenceGenerator(name = "CiudadSeq", sequenceName = "CIUDAD_SEQ",initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CiudadSeq")
    private Short ciudadId;
    @Size(max = 120)
    @Column(name = "NOMBRE_CIUDAD")
    private String nombreCiudad;
    @OneToMany(mappedBy = "ciudadResidencia")
    private List<Cliente> clienteList;

    public Ciudad() {
    }

    public Ciudad(Short ciudadId) {
        this.ciudadId = ciudadId;
    }

    public Short getCiudadId() {
        return ciudadId;
    }

    public void setCiudadId(Short ciudadId) {
        this.ciudadId = ciudadId;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    @XmlTransient
    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ciudadId != null ? ciudadId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciudad)) {
            return false;
        }
        Ciudad other = (Ciudad) object;
        if ((this.ciudadId == null && other.ciudadId != null) || (this.ciudadId != null && !this.ciudadId.equals(other.ciudadId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.adminsol.entitys.Ciudad[ ciudadId=" + ciudadId + " ]";
    }
    
}
