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
@Table(name = "ESTADO_PRESTAMO", catalog = "", schema = "ADM_ARCHIVOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoPrestamo.findAll", query = "SELECT e FROM EstadoPrestamo e"),
    @NamedQuery(name = "EstadoPrestamo.findByEstadoId", query = "SELECT e FROM EstadoPrestamo e WHERE e.estadoId = :estadoId"),
    @NamedQuery(name = "EstadoPrestamo.findByDescripcion", query = "SELECT e FROM EstadoPrestamo e WHERE e.descripcion = :descripcion")})
public class EstadoPrestamo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO_ID")
    private Short estadoId;
    @Size(max = 120)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(mappedBy = "estadoPrestamo")
    private List<Prestamo> prestamoList;

    public EstadoPrestamo() {
    }

    public EstadoPrestamo(Short estadoId) {
        this.estadoId = estadoId;
    }

    public Short getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Short estadoId) {
        this.estadoId = estadoId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Prestamo> getPrestamoList() {
        return prestamoList;
    }

    public void setPrestamoList(List<Prestamo> prestamoList) {
        this.prestamoList = prestamoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estadoId != null ? estadoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoPrestamo)) {
            return false;
        }
        EstadoPrestamo other = (EstadoPrestamo) object;
        if ((this.estadoId == null && other.estadoId != null) || (this.estadoId != null && !this.estadoId.equals(other.estadoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.adminsol.entitys.EstadoPrestamo[ estadoId=" + estadoId + " ]";
    }
    
}
