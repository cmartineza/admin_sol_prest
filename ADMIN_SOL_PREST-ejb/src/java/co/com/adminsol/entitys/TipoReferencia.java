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
@Table(name = "TIPO_REFERENCIA", catalog = "", schema = "ADM_ARCHIVOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoReferencia.findAll", query = "SELECT t FROM TipoReferencia t"),
    @NamedQuery(name = "TipoReferencia.findByTipoReferenciaId", query = "SELECT t FROM TipoReferencia t WHERE t.tipoReferenciaId = :tipoReferenciaId"),
    @NamedQuery(name = "TipoReferencia.findByDescTipoReferencia", query = "SELECT t FROM TipoReferencia t WHERE t.descTipoReferencia = :descTipoReferencia")})
public class TipoReferencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPO_REFERENCIA_ID")
    private Short tipoReferenciaId;
    @Size(max = 200)
    @Column(name = "DESC_TIPO_REFERENCIA")
    private String descTipoReferencia;
    @OneToMany(mappedBy = "tipoReferencia")
    private List<ReferenciasClientes> referenciasClientesList;

    public TipoReferencia() {
    }

    public TipoReferencia(Short tipoReferenciaId) {
        this.tipoReferenciaId = tipoReferenciaId;
    }

    public Short getTipoReferenciaId() {
        return tipoReferenciaId;
    }

    public void setTipoReferenciaId(Short tipoReferenciaId) {
        this.tipoReferenciaId = tipoReferenciaId;
    }

    public String getDescTipoReferencia() {
        return descTipoReferencia;
    }

    public void setDescTipoReferencia(String descTipoReferencia) {
        this.descTipoReferencia = descTipoReferencia;
    }

    @XmlTransient
    public List<ReferenciasClientes> getReferenciasClientesList() {
        return referenciasClientesList;
    }

    public void setReferenciasClientesList(List<ReferenciasClientes> referenciasClientesList) {
        this.referenciasClientesList = referenciasClientesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoReferenciaId != null ? tipoReferenciaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoReferencia)) {
            return false;
        }
        TipoReferencia other = (TipoReferencia) object;
        if ((this.tipoReferenciaId == null && other.tipoReferenciaId != null) || (this.tipoReferenciaId != null && !this.tipoReferenciaId.equals(other.tipoReferenciaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.adminsol.entitys.TipoReferencia[ tipoReferenciaId=" + tipoReferenciaId + " ]";
    }
    
}
