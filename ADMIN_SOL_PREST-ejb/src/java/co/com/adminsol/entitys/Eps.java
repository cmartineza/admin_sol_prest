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
@Table(name = "EPS", catalog = "", schema = "ADM_ARCHIVOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Eps.findAll", query = "SELECT e FROM Eps e"),
    @NamedQuery(name = "Eps.findByEpsId", query = "SELECT e FROM Eps e WHERE e.epsId = :epsId"),
    @NamedQuery(name = "Eps.findByDescEps", query = "SELECT e FROM Eps e WHERE e.descEps = :descEps")})
public class Eps implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EPS_ID")
    private Short epsId;
    @Size(max = 110)
    @Column(name = "DESC_EPS")
    private String descEps;
    @OneToMany(mappedBy = "eps")
    private List<Cliente> clienteList;

    public Eps() {
    }

    public Eps(Short epsId) {
        this.epsId = epsId;
    }

    public Short getEpsId() {
        return epsId;
    }

    public void setEpsId(Short epsId) {
        this.epsId = epsId;
    }

    public String getDescEps() {
        return descEps;
    }

    public void setDescEps(String descEps) {
        this.descEps = descEps;
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
        hash += (epsId != null ? epsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Eps)) {
            return false;
        }
        Eps other = (Eps) object;
        if ((this.epsId == null && other.epsId != null) || (this.epsId != null && !this.epsId.equals(other.epsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.adminsol.entitys.Eps[ epsId=" + epsId + " ]";
    }
    
}
