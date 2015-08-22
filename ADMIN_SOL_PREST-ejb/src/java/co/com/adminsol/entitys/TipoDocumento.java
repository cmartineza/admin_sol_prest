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
@Table(name = "TIPO_DOCUMENTO", catalog = "", schema = "ADM_ARCHIVOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDocumento.findAll", query = "SELECT t FROM TipoDocumento t"),
    @NamedQuery(name = "TipoDocumento.findByTipoDocumentoId", query = "SELECT t FROM TipoDocumento t WHERE t.tipoDocumentoId = :tipoDocumentoId"),
    @NamedQuery(name = "TipoDocumento.findByDescDocumento", query = "SELECT t FROM TipoDocumento t WHERE t.descDocumento = :descDocumento"),
    @NamedQuery(name = "TipoDocumento.findLikeDocumento", query = "SELECT t FROM TipoDocumento t WHERE t.descDocumento LIKE :descDocumento")
})
public class TipoDocumento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPO_DOCUMENTO_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipoDocumentoSEQ")
    @SequenceGenerator(name = "tipoDocumentoSEQ",sequenceName = "TIPO_DOCUMENTO_SEQ",initialValue = 1,allocationSize = 1)
    private Short tipoDocumentoId;
    @Size(max = 100)
    @Column(name = "DESC_DOCUMENTO")
    private String descDocumento;
    @OneToMany(mappedBy = "tipoDocumento")
    private List<DocumentoUsuario> documentoUsuarioList;

    public TipoDocumento() {
    }

    public TipoDocumento(Short tipoDocumentoId) {
        this.tipoDocumentoId = tipoDocumentoId;
    }

    public Short getTipoDocumentoId() {
        return tipoDocumentoId;
    }

    public void setTipoDocumentoId(Short tipoDocumentoId) {
        this.tipoDocumentoId = tipoDocumentoId;
    }

    public String getDescDocumento() {
        return descDocumento;
    }

    public void setDescDocumento(String descDocumento) {
        this.descDocumento = descDocumento;
    }

    @XmlTransient
    public List<DocumentoUsuario> getDocumentoUsuarioList() {
        return documentoUsuarioList;
    }

    public void setDocumentoUsuarioList(List<DocumentoUsuario> documentoUsuarioList) {
        this.documentoUsuarioList = documentoUsuarioList;
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
        if (!(object instanceof TipoDocumento)) {
            return false;
        }
        TipoDocumento other = (TipoDocumento) object;
        if ((this.tipoDocumentoId == null && other.tipoDocumentoId != null) || (this.tipoDocumentoId != null && !this.tipoDocumentoId.equals(other.tipoDocumentoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.adminsol.entitys.TipoDocumento[ tipoDocumentoId=" + tipoDocumentoId + " ]";
    }
    
}
