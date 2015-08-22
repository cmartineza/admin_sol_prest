/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminsol.entitys;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MARA
 */
@Entity
@Table(name = "TIPO_PRESTAMO", catalog = "", schema = "ADM_ARCHIVOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPrestamo.findAll", query = "SELECT t FROM TipoPrestamo t"),
    @NamedQuery(name = "TipoPrestamo.findByTipoPrestamoId", query = "SELECT t FROM TipoPrestamo t WHERE t.tipoPrestamoId = :tipoPrestamoId"),
    @NamedQuery(name = "TipoPrestamo.findByDescripcionPrestamo", query = "SELECT t FROM TipoPrestamo t WHERE t.descripcionPrestamo = :descripcionPrestamo")})
public class TipoPrestamo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPO_PRESTAMO_ID")
    private Short tipoPrestamoId;
    @Size(max = 100)
    @Column(name = "DESCRIPCION_PRESTAMO")
    private String descripcionPrestamo;

    public TipoPrestamo() {
    }

    public TipoPrestamo(Short tipoPrestamoId) {
        this.tipoPrestamoId = tipoPrestamoId;
    }

    public Short getTipoPrestamoId() {
        return tipoPrestamoId;
    }

    public void setTipoPrestamoId(Short tipoPrestamoId) {
        this.tipoPrestamoId = tipoPrestamoId;
    }

    public String getDescripcionPrestamo() {
        return descripcionPrestamo;
    }

    public void setDescripcionPrestamo(String descripcionPrestamo) {
        this.descripcionPrestamo = descripcionPrestamo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoPrestamoId != null ? tipoPrestamoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPrestamo)) {
            return false;
        }
        TipoPrestamo other = (TipoPrestamo) object;
        if ((this.tipoPrestamoId == null && other.tipoPrestamoId != null) || (this.tipoPrestamoId != null && !this.tipoPrestamoId.equals(other.tipoPrestamoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.adminsol.entitys.TipoPrestamo[ tipoPrestamoId=" + tipoPrestamoId + " ]";
    }
    
}
