/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminsol.entitys;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "TIPO_IDENTIFICACION", catalog = "", schema = "ADM_ARCHIVOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoIdentificacion.findAll", query = "SELECT t FROM TipoIdentificacion t"),
    @NamedQuery(name = "TipoIdentificacion.findByTipoDocumentoId", query = "SELECT t FROM TipoIdentificacion t WHERE t.tipoDocumentoId = :tipoDocumentoId"),
    @NamedQuery(name = "TipoIdentificacion.findByDescCorta", query = "SELECT t FROM TipoIdentificacion t WHERE t.descCorta = :descCorta"),
    @NamedQuery(name = "TipoIdentificacion.findByDescLarga", query = "SELECT t FROM TipoIdentificacion t WHERE t.descLarga = :descLarga")})
public class TipoIdentificacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPO_DOCUMENTO_ID")
    private Short tipoDocumentoId;
    @Size(max = 10)
    @Column(name = "DESC_CORTA")
    private String descCorta;
    @Size(max = 100)
    @Column(name = "DESC_LARGA")
    private String descLarga;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoIdentificacion1")
    private List<Cliente> clienteList;

    public TipoIdentificacion() {
    }

    public TipoIdentificacion(Short tipoDocumentoId) {
        this.tipoDocumentoId = tipoDocumentoId;
    }

    public Short getTipoDocumentoId() {
        return tipoDocumentoId;
    }

    public void setTipoDocumentoId(Short tipoDocumentoId) {
        this.tipoDocumentoId = tipoDocumentoId;
    }

    public String getDescCorta() {
        return descCorta;
    }

    public void setDescCorta(String descCorta) {
        this.descCorta = descCorta;
    }

    public String getDescLarga() {
        return descLarga;
    }

    public void setDescLarga(String descLarga) {
        this.descLarga = descLarga;
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
        hash += (tipoDocumentoId != null ? tipoDocumentoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoIdentificacion)) {
            return false;
        }
        TipoIdentificacion other = (TipoIdentificacion) object;
        if ((this.tipoDocumentoId == null && other.tipoDocumentoId != null) || (this.tipoDocumentoId != null && !this.tipoDocumentoId.equals(other.tipoDocumentoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.adminsol.entitys.TipoIdentificacion[ tipoDocumentoId=" + tipoDocumentoId + " ]";
    }
    
}
