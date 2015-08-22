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
@Table(name = "PARENTESCO", catalog = "", schema = "ADM_ARCHIVOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parentesco.findAll", query = "SELECT p FROM Parentesco p"),
    @NamedQuery(name = "Parentesco.findByParentescoId", query = "SELECT p FROM Parentesco p WHERE p.parentescoId = :parentescoId"),
    @NamedQuery(name = "Parentesco.findByDescParentesco", query = "SELECT p FROM Parentesco p WHERE p.descParentesco = :descParentesco")})
public class Parentesco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PARENTESCO_ID")
    private Short parentescoId;
    @Size(max = 120)
    @Column(name = "DESC_PARENTESCO")
    private String descParentesco;
    @OneToMany(mappedBy = "parentesco")
    private List<ReferenciasClientes> referenciasClientesList;

    public Parentesco() {
    }

    public Parentesco(Short parentescoId) {
        this.parentescoId = parentescoId;
    }

    public Short getParentescoId() {
        return parentescoId;
    }

    public void setParentescoId(Short parentescoId) {
        this.parentescoId = parentescoId;
    }

    public String getDescParentesco() {
        return descParentesco;
    }

    public void setDescParentesco(String descParentesco) {
        this.descParentesco = descParentesco;
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
        hash += (parentescoId != null ? parentescoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parentesco)) {
            return false;
        }
        Parentesco other = (Parentesco) object;
        if ((this.parentescoId == null && other.parentescoId != null) || (this.parentescoId != null && !this.parentescoId.equals(other.parentescoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.adminsol.entitys.Parentesco[ parentescoId=" + parentescoId + " ]";
    }
    
}
