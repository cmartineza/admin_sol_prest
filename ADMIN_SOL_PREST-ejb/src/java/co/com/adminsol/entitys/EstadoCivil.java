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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "ESTADO_CIVIL", catalog = "", schema = "ADM_ARCHIVOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoCivil.findAll", query = "SELECT e FROM EstadoCivil e"),
    @NamedQuery(name = "EstadoCivil.findByEstadoCivilId", query = "SELECT e FROM EstadoCivil e WHERE e.estadoCivilId = :estadoCivilId"),
    @NamedQuery(name = "EstadoCivil.findByDescripcionEstado", query = "SELECT e FROM EstadoCivil e WHERE e.descripcionEstado = :descripcionEstado")})
public class EstadoCivil implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO_CIVIL_ID")
    private Short estadoCivilId;
    @Size(max = 100)
    @Column(name = "DESCRIPCION_ESTADO")
    private String descripcionEstado;
    @OneToMany(mappedBy = "estadoCivil")
    private List<Cliente> clienteList;

    public EstadoCivil() {
    }

    public EstadoCivil(Short estadoCivilId) {
        this.estadoCivilId = estadoCivilId;
    }

    public Short getEstadoCivilId() {
        return estadoCivilId;
    }

    public void setEstadoCivilId(Short estadoCivilId) {
        this.estadoCivilId = estadoCivilId;
    }

    public String getDescripcionEstado() {
        return descripcionEstado;
    }

    public void setDescripcionEstado(String descripcionEstado) {
        this.descripcionEstado = descripcionEstado;
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
        hash += (estadoCivilId != null ? estadoCivilId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoCivil)) {
            return false;
        }
        EstadoCivil other = (EstadoCivil) object;
        if ((this.estadoCivilId == null && other.estadoCivilId != null) || (this.estadoCivilId != null && !this.estadoCivilId.equals(other.estadoCivilId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.adminsol.entitys.EstadoCivil[ estadoCivilId=" + estadoCivilId + " ]";
    }
    
}
