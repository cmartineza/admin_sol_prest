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
@Table(name = "TIPO_VIVIENDA", catalog = "", schema = "ADM_ARCHIVOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoVivienda.findAll", query = "SELECT t FROM TipoVivienda t"),
    @NamedQuery(name = "TipoVivienda.findByTipoViviendaId", query = "SELECT t FROM TipoVivienda t WHERE t.tipoViviendaId = :tipoViviendaId"),
    @NamedQuery(name = "TipoVivienda.findByDescripcionVivienda", query = "SELECT t FROM TipoVivienda t WHERE t.descripcionVivienda = :descripcionVivienda")})
public class TipoVivienda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPO_VIVIENDA_ID")
    private Short tipoViviendaId;
    @Size(max = 100)
    @Column(name = "DESCRIPCION_VIVIENDA")
    private String descripcionVivienda;
    @OneToMany(mappedBy = "tipoVivienda")
    private List<Cliente> clienteList;

    public TipoVivienda() {
    }

    public TipoVivienda(Short tipoViviendaId) {
        this.tipoViviendaId = tipoViviendaId;
    }

    public Short getTipoViviendaId() {
        return tipoViviendaId;
    }

    public void setTipoViviendaId(Short tipoViviendaId) {
        this.tipoViviendaId = tipoViviendaId;
    }

    public String getDescripcionVivienda() {
        return descripcionVivienda;
    }

    public void setDescripcionVivienda(String descripcionVivienda) {
        this.descripcionVivienda = descripcionVivienda;
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
        hash += (tipoViviendaId != null ? tipoViviendaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoVivienda)) {
            return false;
        }
        TipoVivienda other = (TipoVivienda) object;
        if ((this.tipoViviendaId == null && other.tipoViviendaId != null) || (this.tipoViviendaId != null && !this.tipoViviendaId.equals(other.tipoViviendaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.adminsol.entitys.TipoVivienda[ tipoViviendaId=" + tipoViviendaId + " ]";
    }
    
}
