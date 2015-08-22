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
@Table(name = "TENENCIA_VIVIENDA", catalog = "", schema = "ADM_ARCHIVOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TenenciaVivienda.findAll", query = "SELECT t FROM TenenciaVivienda t"),
    @NamedQuery(name = "TenenciaVivienda.findByTenenciaViviendaId", query = "SELECT t FROM TenenciaVivienda t WHERE t.tenenciaViviendaId = :tenenciaViviendaId"),
    @NamedQuery(name = "TenenciaVivienda.findByDescripcionTenencia", query = "SELECT t FROM TenenciaVivienda t WHERE t.descripcionTenencia = :descripcionTenencia")})
public class TenenciaVivienda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TENENCIA_VIVIENDA_ID")
    private Short tenenciaViviendaId;
    @Size(max = 100)
    @Column(name = "DESCRIPCION_TENENCIA")
    private String descripcionTenencia;
    @OneToMany(mappedBy = "tenenciaVivienda")
    private List<Cliente> clienteList;

    public TenenciaVivienda() {
    }

    public TenenciaVivienda(Short tenenciaViviendaId) {
        this.tenenciaViviendaId = tenenciaViviendaId;
    }

    public Short getTenenciaViviendaId() {
        return tenenciaViviendaId;
    }

    public void setTenenciaViviendaId(Short tenenciaViviendaId) {
        this.tenenciaViviendaId = tenenciaViviendaId;
    }

    public String getDescripcionTenencia() {
        return descripcionTenencia;
    }

    public void setDescripcionTenencia(String descripcionTenencia) {
        this.descripcionTenencia = descripcionTenencia;
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
        hash += (tenenciaViviendaId != null ? tenenciaViviendaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TenenciaVivienda)) {
            return false;
        }
        TenenciaVivienda other = (TenenciaVivienda) object;
        if ((this.tenenciaViviendaId == null && other.tenenciaViviendaId != null) || (this.tenenciaViviendaId != null && !this.tenenciaViviendaId.equals(other.tenenciaViviendaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.adminsol.entitys.TenenciaVivienda[ tenenciaViviendaId=" + tenenciaViviendaId + " ]";
    }
    
}
